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

public class ListenerManager {
   private GamePanel myGamePanel;

   public ListenerManager(GamePanel gamePanel) {
      myGamePanel = gamePanel;
   }

   public void addListeners() {
      myGamePanel.addKeyListener(new KeyListener());
      myGamePanel.addMouseListener(new MouseListener());
      myGamePanel.addMouseMotionListener(new MouseListener());
      myGamePanel.addFocusListener(new FocusListener());
   }

   public class KeyListener extends KeyAdapter {
      @Override
      public void keyPressed(KeyEvent event) {
         for (GameState gameState : myGamePanel.getGameStateManager().getStates() ) {
            if (gameState.getGameMode().equals(myGamePanel.getGameStateManager().getGameState())) {
               gameState.getKeyListener().keyPressed(event);
               break;
            }
         }
      }
      @Override
      public void keyReleased(KeyEvent event) {
         for (GameState gameState : myGamePanel.getGameStateManager().getStates() ) {
            if (gameState.getGameMode().equals(myGamePanel.getGameStateManager().getGameState())) {
               gameState.getKeyListener().keyReleased(event);
               break;
            }
         }
      }
      @Override
      public void keyTyped(KeyEvent event) {
         for (GameState gameState : myGamePanel.getGameStateManager().getStates() ) {
            if (gameState.getGameMode().equals(myGamePanel.getGameStateManager().getGameState())) {
               gameState.getKeyListener().keyTyped(event);
               break;
            }
         }
      }
   }
   public class MouseListener extends MouseAdapter {
      @Override
      public void mouseClicked(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for (GameState gameState : myGamePanel.getGameStateManager().getStates() ) {
            if (gameState.getGameMode().equals(myGamePanel.getGameStateManager().getGameState())) {
               gameState.getMouseListener().mouseClicked(event);
               break;
            }
         }
      }
      @Override
      public void mouseDragged(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for (GameState gameState : myGamePanel.getGameStateManager().getStates() ) {
            if (gameState.getGameMode().equals(myGamePanel.getGameStateManager().getGameState())) {
               gameState.getMouseListener().mouseDragged(event);
               break;
            }
         }
      }
      @Override
      public void mouseEntered(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for (GameState gameState : myGamePanel.getGameStateManager().getStates() ) {
            if (gameState.getGameMode().equals(myGamePanel.getGameStateManager().getGameState())) {
               gameState.getMouseListener().mouseEntered(event);
               break;
            }
         }
      }
      @Override
      public void mouseExited(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for (GameState gameState : myGamePanel.getGameStateManager().getStates() ) {
            if (gameState.getGameMode().equals(myGamePanel.getGameStateManager().getGameState())) {
               gameState.getMouseListener().mouseExited(event);
               break;
            }
         }
      }
      @Override
      public void mouseMoved(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for (GameState gameState : myGamePanel.getGameStateManager().getStates() ) {
            if (gameState.getGameMode().equals(myGamePanel.getGameStateManager().getGameState())) {
               gameState.getMouseListener().mouseMoved(event);
               break;
            }
         }
      }
      @Override
      public void mousePressed(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for (GameState gameState : myGamePanel.getGameStateManager().getStates() ) {
            if (gameState.getGameMode().equals(myGamePanel.getGameStateManager().getGameState())) {
               gameState.getMouseListener().mousePressed(event);
               break;
            }
         }
      }
      @Override
      public void mouseReleased(MouseEvent event) {
         EventUtil.scaleEvent(event);
         for (GameState gameState : myGamePanel.getGameStateManager().getStates() ) {
            if (gameState.getGameMode().equals(myGamePanel.getGameStateManager().getGameState())) {
               gameState.getMouseListener().mouseReleased(event);
               break;
            }
         }
      }
      @Override
      public void mouseWheelMoved(MouseWheelEvent event) {
         EventUtil.scaleEvent(event);
         for (GameState gameState : myGamePanel.getGameStateManager().getStates() ) {
            if (gameState.getGameMode().equals(myGamePanel.getGameStateManager().getGameState())) {
               gameState.getMouseListener().mouseWheelMoved(event);
               break;
            }
         }
      }
   }
   private class FocusListener extends FocusAdapter {
      @Override
      public void focusLost(FocusEvent e) {
         for (GameState state : myGamePanel.getGameStateManager().getStates() ) {
            state.getGUIManager().resetInputs();
         }
      }
   }
}





