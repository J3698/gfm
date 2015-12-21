package gfm.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import gfm.GamePanel;
import gfm.gui.GUIManager;
import gfm.gamestate.GameState;

public class GameOver extends GameState {
   private KeyAdapter myKeyListener;
   private MouseAdapter myMouseListener;

   public GameOver (GamePanel gamePanel, String gameMode) {
      super(gamePanel, gameMode);
      myKeyListener = new KeyListener();
      myMouseListener = new MouseListener();
      initUI();
   }

   public void draw(Graphics pen) {
      getGUIManager().draw(pen);
   }
   public void update() {
   }
   public void initUI() {
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