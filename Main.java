package gfm;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

/**
 * GFM
 * @version 1.0
 * @author Antioch John Sanders
 */

import gfm.gamestate.GameStateAdapter;
import gfm.gui.Button;
import gfm.gui.MenuButton;
import gfm.templates.FileFactory;
import gfm.util.Vec2;

/**
 * The Main Class. This is used
 * to generate shell codes, such
 * as an empty game state.
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
      game.addGameState(new TemplateMaker(game, "templates"));

      game.start();
   }
}

class TemplateMaker extends GameStateAdapter {

   public TemplateMaker(Game game) {
      super(game);
   }
   public TemplateMaker(Game game, String gameMode) {
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
   public void mouseClicked(MouseEvent event) {
      getGUIManager().mousePressed(event);
   }
   @Override
   public void mouseMoved(MouseEvent event) {
      getGUIManager().mouseMoved(event);
   }
}
