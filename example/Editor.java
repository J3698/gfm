package gfm.example;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.PrintStream;
import java.io.FileOutputStream;


import javax.swing.JOptionPane;

import gfm.gamestate.GameState;
import gfm.GamePanel;
import gfm.util.Vector2;
import gfm.gui.MenuButton;

public class Editor extends GameState {
   private static Color[] colorScheme = new Color[]
               { Color.black, Color.gray, Color.blue, Color.green,
                 Color.orange, Color.red                          };
   private static int minX = 10;
   private static int minY = 30;
   private static int maxX = 630;
   private static int maxY = 290;
   private static int padX = 3;
   private static int padY = 2;

   private int incX;
   private int incY;
   private int spaceX;
   private int correctX;

   private Block[][] myBlocks;

   public Editor(GamePanel gamePanel) {
      super(gamePanel);
      init();
   }
   public Editor(GamePanel gamePanel, String stateName) {
      super(gamePanel, stateName);
      init();
   }

   public void init() {
      myBlocks = new Block[ 20 ][ 20 ];

      incX = (maxX - minX) / myBlocks[0].length;
      incY = (maxY - minY) / myBlocks.length;
      correctX = (minX + maxX - ( (myBlocks[0].length - 1) * incX + padX - 2 * padX)) / 2;
      Vector2 size = new Vector2(incX - 2 * padX, incY - 2 * padY);

      for ( int row = 0; row < myBlocks.length; row++ ) {
         for ( int col = 0; col < myBlocks[0].length; col++ ) {

            Vector2 pos = new Vector2(col * incX + padX + correctX, row * incY + padY);
            myBlocks[ row ][ col ] = new Block(pos, size.copy(), 0);
         }
      }
   }

   public void update() {

   }

   public void draw(Graphics pen) {
      pen.setColor(Color.white);

      for ( int row = 0; row < myBlocks.length; row++ ) {
         for ( int col = 0; col < myBlocks[0].length; col++ ) {
            Block block = myBlocks[ row ][ col ];
            block.draw(pen, colorScheme[block.getLives()]);
         }
      }

      getGUIManager().draw(pen);
   }

   public void initUI() {
      getGUIManager().addButton(
         new MenuButton(new ExitListener(), "EXIT", new Vector2(640 / 3, 420), new Vector2(70, 30), 640, 480));
      getGUIManager().addButton(
         new MenuButton(new SaveListener(), "SAVE", new Vector2(640 * 2 / 3, 420), new Vector2(70, 30), 640, 480));
   }

   public void mouseMoved(MouseEvent event) {
      getGUIManager().mouseMoved(event);
   }

   public void mousePressed(MouseEvent event) {
      getGUIManager().mousePressed(event);
      for ( int row = 0; row < myBlocks.length; row++ ) {
         for ( int col = 0; col < myBlocks[0].length; col++ ) {
            Rect mouse = new RectAdapter(event);
            Block block = myBlocks[ row ][ col ];
            if ( Collider.collide(block, mouse) ) {
               if ( block.getLives() < 5 ) {
                  block.setLives(block.getLives() + 1);
               } else {
                  block.setLives(0);
               }
            }
         }
      }
   }

   private class ExitListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         System.exit(0);
      }
   }

   private class SaveListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         getGUIManager().disable();
         String filename = JOptionPane.showInputDialog("To Save As: ");
         PrintStream printer = null;
         try {
            printer = new PrintStream(new FileOutputStream(new File("./example/Levels/"+filename)));

            for ( int row = 0; row < myBlocks.length; row++ ) {
               for ( int col = 0; col < myBlocks[0].length; col++ ) {
                  Block block = myBlocks[ row ][ col ];
                  if ( !block.isDead() ) {
                     printer.print(block.getPos().getX() + " " + block.getPos().getY() + " ");
                     printer.print(block.getSize().getX() + " " + block.getSize().getY() + " ");
                     printer.print(block.getLives());
                     printer.println();
                  }
               }
            }
         } catch(Exception e) {
            e.printStackTrace();
         } finally {
            if ( printer != null ) {
               try {
                  printer.close();
               } catch(Exception e) {
                  e.printStackTrace();
               }
            }
         }
         getGUIManager().enable();
      }
   }
}