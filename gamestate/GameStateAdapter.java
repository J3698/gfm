package gfm.gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import gfm.Game;

// TODO: Auto-generated Javadoc
/**
 * The Class GameStateAdapter.
 */
public class GameStateAdapter extends GameState {


   /**
    * Instantiates a new game state adapter.
    *
    * @param game the game
    */
   public GameStateAdapter(Game game) {
      super(game);
   }

   /**
    * Instantiates a new game state adapter.
    *
    * @param game the game
    * @param stateName the state name
    */
   public GameStateAdapter(Game game, String stateName) {
      super(game, stateName);
   }

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#draw(java.awt.Graphics)
    */
   @Override
   public void draw(Graphics pen) { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#update()
    */
   @Override
   public void update() { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#initGUI()
    */
   @Override
   public void initGUI() { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#init()
    */
   @Override
   public void init() { }

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#keyPressed(java.awt.event.KeyEvent)
    */
   @Override
   public void keyPressed(KeyEvent event) { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#keyReleased(java.awt.event.KeyEvent)
    */
   @Override
   public void keyReleased(KeyEvent event) { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#keyTyped(java.awt.event.KeyEvent)
    */
   @Override
   public void keyTyped(KeyEvent event) { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseClicked(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseClicked(MouseEvent event) { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseDragged(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseDragged(MouseEvent event) { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseEntered(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseEntered(MouseEvent event) { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseExited(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseExited(MouseEvent event) { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseMoved(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseMoved(MouseEvent event) { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mousePressed(java.awt.event.MouseEvent)
    */
   @Override
   public void mousePressed(MouseEvent event) { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseReleased(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseReleased(MouseEvent event) { }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseWheelMoved(java.awt.event.MouseWheelEvent)
    */
   @Override
   public void mouseWheelMoved(MouseWheelEvent event) { }
}
