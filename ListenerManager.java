package gfm;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import gfm.gamestate.GameState;
import gfm.util.EventUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ListenerManager.
 */
public class ListenerManager {

   /** The my game panel. */
   private GamePanel myGamePanel;

   /**
    * Instantiates a new listener manager.
    *
    * @param gamePanel the game panel
    */
   public ListenerManager(GamePanel gamePanel) {
      myGamePanel = gamePanel;
   }

   /**
    * Adds the listeners.
    */
   public void addListeners() {
      myGamePanel.addKeyListener(new KeyListener());
      myGamePanel.addMouseListener(new MouseListener());
      myGamePanel.addMouseMotionListener(new MouseListener());
      myGamePanel.addFocusListener(new FocusListener());
   }

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

      /* (non-Javadoc)
       * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
       */
      @Override
      public void keyPressed(KeyEvent event) {
         for ( Macro macro : myGamePanel.iterMacros() ) {
            macro.keyPressed(event);
         }
         myGamePanel.getGameStateManager().getCurrentGameState().keyPressed(event);
      }

      /* (non-Javadoc)
       * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
       */
      @Override
      public void keyReleased(KeyEvent event) {
         for ( Macro macro : myGamePanel.iterMacros() ) {
            macro.keyReleased(event);
         }
         myGamePanel.getGameStateManager().getCurrentGameState().keyReleased(event);
      }

      /* (non-Javadoc)
       * @see java.awt.event.KeyAdapter#keyTyped(java.awt.event.KeyEvent)
       */
      @Override
      public void keyTyped(KeyEvent event) {
         for ( Macro macro : myGamePanel.iterMacros() ) {
            macro.keyTyped(event);
         }
         myGamePanel.getGameStateManager().getCurrentGameState().keyTyped(event);
      }
   }

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

      /* (non-Javadoc)
       * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseClicked(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for ( Macro macro : myGamePanel.iterMacros() ) {
            macro.mouseClicked(event);
         }
         myGamePanel.getGameStateManager().getCurrentGameState().mouseClicked(event);
      }

      /* (non-Javadoc)
       * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseDragged(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for ( Macro macro : myGamePanel.iterMacros() ) {
            macro.mouseDragged(event);
         }
         myGamePanel.getGameStateManager().getCurrentGameState().mouseDragged(event);
      }

      /* (non-Javadoc)
       * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseEntered(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for ( Macro macro : myGamePanel.iterMacros() ) {
            macro.mouseEntered(event);
         }
         myGamePanel.getGameStateManager().getCurrentGameState().mouseEntered(event);
      }

      /* (non-Javadoc)
       * @see java.awt.event.MouseAdapter#mouseExited(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseExited(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for ( Macro macro : myGamePanel.iterMacros() ) {
            macro.mouseExited(event);
         }
         myGamePanel.getGameStateManager().getCurrentGameState().mouseExited(event);
      }

      /* (non-Javadoc)
       * @see java.awt.event.MouseAdapter#mouseMoved(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseMoved(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for ( Macro macro : myGamePanel.iterMacros() ) {
            macro.mouseMoved(event);
         }
         myGamePanel.getGameStateManager().getCurrentGameState().mouseMoved(event);
      }

      /* (non-Javadoc)
       * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
       */
      @Override
      public void mousePressed(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for ( Macro macro : myGamePanel.iterMacros() ) {
            macro.mousePressed(event);
         }
         myGamePanel.getGameStateManager().getCurrentGameState().mousePressed(event);
      }

      /* (non-Javadoc)
       * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseReleased(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for ( Macro macro : myGamePanel.iterMacros() ) {
            macro.mouseReleased(event);
         }
         myGamePanel.getGameStateManager().getCurrentGameState().mouseReleased(event);
      }

      /* (non-Javadoc)
       * @see java.awt.event.MouseAdapter#mouseWheelMoved(java.awt.event.MouseWheelEvent)
       */
      @Override
      public void mouseWheelMoved(MouseWheelEvent event) {
         EventUtil.scaleEvent(event);
         for ( Macro macro : myGamePanel.iterMacros() ) {
            macro.mouseWheelMoved(event);
         }
         myGamePanel.getGameStateManager().getCurrentGameState().mouseWheelMoved(event);
      }
   }

   /**
    * The listener interface for receiving focus events.
    * The class that is interested in processing a focus
    * event implements this interface, and the object created
    * with that class is registered with a component using the
    * component's <code>addFocusListener<code> method. When
    * the focus event occurs, that object's appropriate
    * method is invoked.
    *
    * @see FocusEvent
    */
   private class FocusListener extends FocusAdapter {

      /* (non-Javadoc)
       * @see java.awt.event.FocusAdapter#focusLost(java.awt.event.FocusEvent)
       */
      @Override
      public void focusLost(FocusEvent e) {
         for (GameState state : myGamePanel.getGameStateManager().getStates() ) {
            state.getGUIManager().resetInputs();
         }
      }
   }
}





