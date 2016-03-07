package gfm;

import gfm.gamestate.GameState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * Extends to MouseAdapter class for receiving mouse 
 * events. Allows a game state to process a mouse event.
 * When the mouse event occurs, that object's appropriate
 * method is invoked.
 *
 * @see MouseAdapter
 * @see MouseEvent
 */
public class MouseListener extends MouseAdapter {
   
   /** The game state. */
   private GameState myGameState;

   /**
    * Instantiates a new mouse listener.
    *
    * @param gameState the game state
    */
   public MouseListener(GameState gameState) {
      myGameState = gameState;
   }

   /**
    * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
    */
   public void mouseClicked(MouseEvent event) {
      myGameState.mouseClicked(event);
   }
   
   /**
    * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
    */
   public void mouseDragged(MouseEvent event) {
      myGameState.mouseDragged(event);
   }
   
   /**
    * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.MouseEvent)
    */
   public void mouseEntered(MouseEvent event) {
      myGameState.mouseEntered(event);
   }
   
   /**
    * @see java.awt.event.MouseAdapter#mouseExited(java.awt.event.MouseEvent)
    */
   public void mouseExited(MouseEvent event) {
      myGameState.mouseExited(event);
   }
   
   /**
    * @see java.awt.event.MouseAdapter#mouseMoved(java.awt.event.MouseEvent)
    */
   public void mouseMoved(MouseEvent event) {
      myGameState.mouseMoved(event);
   }
   
   /**
    * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
    */
   public void mousePressed(MouseEvent event) {
      myGameState.mousePressed(event);
   }
   
   /**
    * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
    */
   public void mouseReleased(MouseEvent event) {
      myGameState.mouseReleased(event);
   }
   
   /**
    * @see java.awt.event.MouseAdapter#mouseWheelMoved(java.awt.event.MouseWheelEvent)
    */
   public void mouseWheelMoved(MouseWheelEvent event) {
      myGameState.mouseWheelMoved(event);
   }
}
