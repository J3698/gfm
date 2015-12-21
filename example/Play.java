package gfm.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;
import java.io.File;

import javax.swing.JOptionPane;

import gfm.GamePanel;
import gfm.gamestate.GameState;
import gfm.util.Vector2;

public class Play extends GameState {
   private static Color[] colorScheme = new Color[]
               { Color.black, Color.gray, Color.blue, Color.green,
                 Color.orange, Color.red                          };

   private Paddle myPaddle;
   private Ball myBall;
   private LinkedList<Block> myBlocks;

   public Play(GamePanel gamePanel) {
      super(gamePanel);
      myPaddle = new Paddle(new Vector2(320, 465), new Vector2(90, 10), 0,
                            getGamePanel().getGameWidth());
      myBall = new Ball(new Vector2(30 + new Random().nextInt(610), 470));
      myBlocks = new LinkedList<Block>();
      String filename = JOptionPane.showInputDialog("ToLoad: ");
      if ( filename != null ) {
         configBlocksFromFile("./example/Levels/"+filename);
      }
   }

   public Play(GamePanel gamePanel, String gameMode) {
      super(gamePanel, gameMode);
      myPaddle = new Paddle(new Vector2(320, 465), new Vector2(90, 10), 0,
                            getGamePanel().getGameWidth());
      myBlocks = new LinkedList<Block>();
   }

   public void draw(Graphics pen) {
      myPaddle.draw(pen);
      for ( Block block : myBlocks) {
         block.draw(pen, colorScheme[block.getLives()]);
      }
      myBall.draw(pen);
      getGUIManager().draw(pen);
   }
   public void update() {
      myPaddle.update();
      myBall.update();

      if ( myBall.getPos().getX() - myBall.getSize().getX() / 2 < 0 &&
                                       myBall.getVelocity().getX() < 0) {
         myBall.getVelocity().multiplyX(-1);
      } else if ( myBall.getPos().getX() + myBall.getSize().getX() / 2 > getGamePanel().getGameWidth() &&
                                                                  myBall.getVelocity().getX() > 0) {
         myBall.getVelocity().multiplyX(-1);
      }

      if ( myBall.getPos().getY() - myBall.getSize().getY() / 2 < 0 &&
            myBall.getVelocity().getY() < 0) {
         myBall.getVelocity().multiplyY(-1);
      } else if ( myBall.getPos().getY() + myBall.getSize().getY() / 2 > getGamePanel().getGameHeight() &&
            myBall.getVelocity().getY() > 0) {
         myBall.getVelocity().multiplyY(-1);
      }


      Block toRemove = null;
      for ( Block block : myBlocks ) {
         if ( Collider.collide(block, myBall) ) {
            myBall.getVelocity().multiply(1.08);
            if ( new Random().nextBoolean() ) {
               myBall.getVelocity().multiplyX(-1);
            } else {
               myBall.getVelocity().multiplyY(-1);
            }

            block.loseLife(1);
            if ( block.isDead() ) {
               toRemove = block;
            }
            continue;
         }
      }
      
      if ( toRemove != null ) {
         myBlocks.remove(toRemove);
      }

      if ( Collider.collide(myBall, myPaddle) ) {
         myBall.getVelocity().multiplyY(-1);         
      }
   }
   public void initUI() {
   }

   public void configBlocksFromFile(String filename) {
      // save copy just in case load fails
      LinkedList<Block> temp = myBlocks;
      myBlocks = new LinkedList<Block>();

      File toRead = new File(filename);
      Scanner inFile = null;
      try {
         inFile = new Scanner(toRead);

         while ( inFile.hasNextDouble() ) {
            myBlocks.add(new Block(
                           new Vector2(inFile.nextDouble(), inFile.nextDouble()),
                           new Vector2(inFile.nextDouble(), inFile.nextDouble()),
                           inFile.nextInt()));
            if ( myBlocks.getLast().isDead() ) {
               myBlocks.removeLast();
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if ( inFile != null ) {
            try {
               inFile.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }
   }

   public void keyPressed(KeyEvent event) {
      myPaddle.getControls().keyPressed(event);
   }
   public void keyReleased(KeyEvent event) {
      myPaddle.getControls().keyReleased(event);
   }
   public void mouseClicked(MouseEvent event) {
   }
   public void mouseMoved(MouseEvent event) {
   }
}
// class LevelCreator extends 