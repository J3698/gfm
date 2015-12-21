package gfm;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JOptionPane;

/**
 * GFM
 * @version 1.0
 * @author Antioch John Sanders
 */

import gfm.gamestate.GameState;
import gfm.gui.MenuButton;
import gfm.templates.FileFactory;
import gfm.util.Vector2;
import gfm.Game;

public class Main {
   public static int gameWidth = 640;
   public static int gameHeight = 480;
   public static int drawWidth = 770;
   public static int drawHeight = 580;

   public static void main(String[] args) {
      Game game = new Game("GFM", gameWidth, gameHeight);

      game.getGamePanel().getGameStateManager().setGameState("templates");
      game.getGamePanel().getGameStateManager().add(
         "templates", new PlayGround(game.getGamePanel(), "templates"));

      game.start();
   }
}

class PlayGround extends GameState {
   private KeyAdapter myKeyListener;
   private MouseAdapter myMouseListener;

   public PlayGround (GamePanel gamePanel, String gameMode) {
      super(gamePanel, gameMode);
      myKeyListener = new KeyListener();
      myMouseListener = new MouseListener();
   }

   public void draw(Graphics pen) {
      pen.clearRect(0, 0, getGamePanel().getWidth(), getGamePanel().getHeight());
      getGUIManager().draw(pen);
   }
   public void update() {
   }

   public void initUI() {
      // some args (last 2) redundant
      getGUIManager().addButton(
            new MenuButton(
                  new AddGameStateListener(), "New G S", new Vector2(50, 50), new Vector2(90, 90),
                  getGamePanel().getGameWidth(), getGamePanel().getGameHeight()));

      getGUIManager().addButton(
            new MenuButton(
                  new AddMainListener(), "New Main", new Vector2(150, 50), new Vector2(90, 90),
                  getGamePanel().getGameWidth(), getGamePanel().getGameHeight()));
   }

   private class AddGameStateListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         getGUIManager().disable();
         String name = JOptionPane.showInputDialog("Game State Name: ");
         if ( name != null ) {
            FileFactory.newGameState(name);
         }
         getGUIManager().enable();
      }
   }

   private class AddMainListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         getGUIManager().disable();
         String name = JOptionPane.showInputDialog("Name: ");
         if ( name != null ) {
            FileFactory.newMain(name);
         }
         getGUIManager().enable();
      }
   }

   private class KeyListener extends KeyAdapter {
      public void keyPressed(KeyEvent event) {
      }
      public void keyReleased(KeyEvent event) {
      }
      public void keyTyped(KeyEvent event) {
      }
   }

   private class MouseListener extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         getGUIManager().mousePressed(event);
      }
      public void mouseDragged(MouseEvent event) {
      }
      public void mouseEntered(MouseEvent event) {
      }
      public void mouseExited(MouseEvent event) {
      }
      public void mouseMoved(MouseEvent event) {
         getGUIManager().mouseMoved(event);
      }
      public void mousePressed(MouseEvent event) {
      }
      public void mouseReleased(MouseEvent event) {
      }
      public void mouseWheelMoved(MouseWheelEvent event) {
      }
   }

   public KeyAdapter getKeyListener() { return myKeyListener; }
   public MouseAdapter getMouseListener() { return myMouseListener; }
}