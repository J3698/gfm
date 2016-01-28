package gfm;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JOptionPane;

/**
 * GFM
 * @version 1.0
 * @author Antioch John Sanders
 */

import gfm.gamestate.GameState;
import gfm.gui.Button;
import gfm.gui.MenuButton;
import gfm.templates.FileFactory;
import gfm.util.Vec2;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
   
   /** The game width. */
   public static int gameWidth = 640;
   
   /** The game height. */
   public static int gameHeight = 480;
   
   /** The draw width. */
   public static int drawWidth = (int) (1.2 * gameWidth);
   
   /** The draw height. */
   public static int drawHeight = (int) (1.2 * gameHeight);

   /**
    * The main method.
    *
    * @param args the arguments
    */
   public static void main(String[] args) {
      Game game = new Game("GFM", gameWidth, gameHeight,
            drawWidth, drawHeight);

      game.setGameState("templates");
      game.addGameState(new PlayGround(game, "templates"));

      game.start();
   }
}

class PlayGround extends GameState {

   public PlayGround(Game game) {
      super(game);
   }
   public PlayGround (Game game, String gameMode) {
      super(game, gameMode);
   }

   @Override
   public void draw(Graphics pen) {
      pen.clearRect(0, 0, getWidth(), getHeight());
      getGUIManager().draw(pen);
   }
   @Override
   public void update() {
   }

   @Override
   public void init() {}

   @Override
   public void initGUI() {
      Button gsButton = new MenuButton(
            new AddGameStateListener(), "New G S",
            new Vec2(50, 50), new Vec2(90, 90));
      Button mainButton = new MenuButton(
            new AddMainListener(), "New Main",
            new Vec2(150, 50), new Vec2(90, 90));

      getGUIManager().addButton(gsButton);
      getGUIManager().addButton(mainButton);
   }

   private class AddGameStateListener implements ActionListener {
      @Override
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
      @Override
      public void actionPerformed(ActionEvent event) {
         getGUIManager().disable();
         String name = JOptionPane.showInputDialog("Name: ");
         if ( name != null ) {
            FileFactory.newMain(name);
         }
         getGUIManager().enable();
      }
   }

   @Override
   public void keyPressed(KeyEvent event) {
   }
   @Override
   public void keyReleased(KeyEvent event) {
   }
   @Override
   public void keyTyped(KeyEvent event) {
   }

   @Override
   public void mouseClicked(MouseEvent event) {
      getGUIManager().mousePressed(event);
   }
   @Override
   public void mouseDragged(MouseEvent event) {
   }
   @Override
   public void mouseEntered(MouseEvent event) {
   }
   @Override
   public void mouseExited(MouseEvent event) {
   }
   @Override
   public void mouseMoved(MouseEvent event) {
      getGUIManager().mouseMoved(event);
   }
   @Override
   public void mousePressed(MouseEvent event) {
   }
   @Override
   public void mouseReleased(MouseEvent event) {
   }
   @Override
   public void mouseWheelMoved(MouseWheelEvent event) {
   }
}