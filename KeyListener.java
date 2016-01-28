package gfm;

import gfm.gamestate.GameState;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving key events.
 * The class that is interested in processing a key
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addKeyListener<code> method. When
 * the key event occurs, that object's appropriate
 * method is invoked.
 *
 * @see KeyEvent
 */
public class KeyListener extends KeyAdapter {
   
   /** The my game state. */
   private GameState myGameState;

   /**
    * Instantiates a new key listener.
    *
    * @param gameState the game state
    */
   public KeyListener(GameState gameState) {
      myGameState = gameState;
   }

   /* (non-Javadoc)
    * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
    */
   public void keyPressed(KeyEvent event) {
      myGameState.keyPressed(event);
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
    */
   public void keyReleased(KeyEvent event) {
      myGameState.keyReleased(event);
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.KeyAdapter#keyTyped(java.awt.event.KeyEvent)
    */
   public void keyTyped(KeyEvent event) {
      myGameState.keyTyped(event);
   }
}