package gfm;

import gfm.gamestate.GameState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving mouse events.
 * The class that is interested in processing a mouse
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addMouseListener<code> method. When
 * the mouse event occurs, that object's appropriate
 * method is invoked.
 *
 * @see MouseEvent
 */
public class MouseListener extends MouseAdapter {
   
   /** The my game state. */
   private GameState myGameState;

   /**
    * Instantiates a new mouse listener.
    *
    * @param gameState the game state
    */
   public MouseListener(GameState gameState) {
      myGameState = gameState;
   }

   /* (non-Javadoc)
    * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
    */
   public void mouseClicked(MouseEvent event) {
      myGameState.mouseClicked(event);
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
    */
   public void mouseDragged(MouseEvent event) {
      myGameState.mouseDragged(event);
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.MouseEvent)
    */
   public void mouseEntered(MouseEvent event) {
      myGameState.mouseEntered(event);
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.MouseAdapter#mouseExited(java.awt.event.MouseEvent)
    */
   public void mouseExited(MouseEvent event) {
      myGameState.mouseExited(event);
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.MouseAdapter#mouseMoved(java.awt.event.MouseEvent)
    */
   public void mouseMoved(MouseEvent event) {
      myGameState.mouseMoved(event);
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
    */
   public void mousePressed(MouseEvent event) {
      myGameState.mousePressed(event);
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
    */
   public void mouseReleased(MouseEvent event) {
      myGameState.mouseReleased(event);
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.MouseAdapter#mouseWheelMoved(java.awt.event.MouseWheelEvent)
    */
   public void mouseWheelMoved(MouseWheelEvent event) {
      myGameState.mouseWheelMoved(event);
   }
}