package gfm.gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import gfm.GamePanel;
import gfm.gui.GUIManager;
import gfm.KeyListener;
import gfm.MouseListener;

public abstract class GameState {
   public static Color bg = new Color(0, 0, 0);
   private GamePanel myGamePanel;
   private String myGameMode;
   private GUIManager myGUIManager;

   private KeyListener myKeyListener;
   private MouseListener myMouseListener;

   public GameState(GamePanel gamePanel) {
      this(gamePanel, "");
      myGameMode = getClass().getName().toLowerCase();
   }

   public GameState(GamePanel gamePanel, String gameMode) {
      myGamePanel = gamePanel;
      myGameMode = gameMode;
      myGUIManager = new GUIManager(gamePanel);
      myKeyListener = new KeyListener(this);
      myMouseListener = new MouseListener(this);
      initUI();
   }

   public abstract void draw(Graphics pen);
   public abstract void update();

   public void initUI() {}

   public String getGameMode() { return myGameMode; }
   public GamePanel getGamePanel() { return myGamePanel; }
   public void setGamePanel(GamePanel gamePanel) { myGamePanel = gamePanel; }
   public GUIManager getGUIManager() { return myGUIManager; }
   // protected? make class that can allow protected mesthods to be accessed from super-package?
   public KeyAdapter getKeyListener() { return myKeyListener; }
   public MouseAdapter getMouseListener() { return myMouseListener; }

   public void keyPressed(KeyEvent event) {}
   public void keyReleased(KeyEvent event) {}
   public void keyTyped(KeyEvent event) {}

   public void mouseClicked(MouseEvent event) {}
   public void mouseDragged(MouseEvent event) {}
   public void mouseEntered(MouseEvent event) {}
   public void mouseExited(MouseEvent event) {}
   public void mouseMoved(MouseEvent event) {}
   public void mousePressed(MouseEvent event) {}
   public void mouseReleased(MouseEvent event) {}
   public void mouseWheelMoved(MouseWheelEvent event) {}
}