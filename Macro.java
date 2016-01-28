package gfm;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

// TODO: Auto-generated Javadoc
/**
 * The Interface Macro.
 */
public interface Macro {
   
   /**
    * Draw.
    *
    * @param pen the pen
    */
   void draw(Graphics pen);
   
   /**
    * Update.
    */
   void update();

   /**
    * Key pressed.
    *
    * @param event the event
    */
   void keyPressed(KeyEvent event);
   
   /**
    * Key released.
    *
    * @param event the event
    */
   void keyReleased(KeyEvent event);
   
   /**
    * Key typed.
    *
    * @param event the event
    */
   void keyTyped(KeyEvent event);

   /**
    * Mouse clicked.
    *
    * @param event the event
    */
   void mouseClicked(MouseEvent event);
   
   /**
    * Mouse dragged.
    *
    * @param event the event
    */
   void mouseDragged(MouseEvent event);
   
   /**
    * Mouse entered.
    *
    * @param event the event
    */
   void mouseEntered(MouseEvent event);
   
   /**
    * Mouse exited.
    *
    * @param event the event
    */
   void mouseExited(MouseEvent event);
   
   /**
    * Mouse moved.
    *
    * @param event the event
    */
   void mouseMoved(MouseEvent event);
   
   /**
    * Mouse pressed.
    *
    * @param event the event
    */
   void mousePressed(MouseEvent event);
   
   /**
    * Mouse released.
    *
    * @param event the event
    */
   void mouseReleased(MouseEvent event);
   
   /**
    * Mouse wheel moved.
    *
    * @param event the event
    */
   void mouseWheelMoved(MouseWheelEvent event);
}