package gfm.gamestate;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import gfm.Game;
import gfm.KeyListener;
import gfm.MouseListener;
import gfm.gui.GUIManager;
import gfm.sound.SoundManager;

// TODO: Auto-generated Javadoc
/**
 * The Class GameState.
 */
public abstract class GameState {
   
   /** The my game. */
   private Game myGame;
   
   /** The my game mode. */
   private String myGameMode;
   
   /** The my gui manager. */
   private GUIManager myGUIManager;

   /** The my key listener. */
   private KeyListener myKeyListener;
   
   /** The my mouse listener. */
   private MouseListener myMouseListener;

   /**
    * Instantiates a new game state.
    *
    * @param game the game
    */
   public GameState(Game game) {
      this(game, "");
      myGameMode = getClass().getName().toLowerCase();
      myGameMode = myGameMode.substring(myGameMode.lastIndexOf(".") + 1);
   }

   /**
    * Instantiates a new game state.
    *
    * @param game the game
    * @param gameMode the game mode
    */
   public GameState(Game game, String gameMode) {
      myGame = game;
      myGameMode = gameMode;
      myGUIManager = new GUIManager(game);
      myKeyListener = new KeyListener(this);
      myMouseListener = new MouseListener(this);
      init();
      initGUI();
   }

   /**
    * Gets the game mode.
    *
    * @return the game mode
    */
   public String getGameMode() { return myGameMode; }
   
   /**
    * Gets the game.
    *
    * @return the game
    */
   public Game getGame() { return myGame; }
   
   /**
    * Sets the game.
    *
    * @param game the new game
    */
   public void setGame(Game game) { myGame = game; }
   
   /**
    * Gets the GUI manager.
    *
    * @return the GUI manager
    */
   public GUIManager getGUIManager() { return myGUIManager; }
   
   /**
    * Gets the key listener.
    *
    * @return the key listener
    */
   public KeyAdapter getKeyListener() { return myKeyListener; }
   
   /**
    * Gets the mouse listener.
    *
    * @return the mouse listener
    */
   public MouseAdapter getMouseListener() { return myMouseListener; }
   
   /**
    * Gets the sound manager.
    *
    * @return the sound manager
    */
   public SoundManager getSoundManager() { return myGame.getSoundManager(); }
   
   /**
    * Gets the width.
    *
    * @return the width
    */
   public int getWidth() { return myGame.getWidth(); }
   
   /**
    * Gets the height.
    *
    * @return the height
    */
   public int getHeight() { return myGame.getHeight(); }

   /**
    * Draw over macro.
    *
    * @param pen the pen
    */
   public void drawOverMacro(Graphics pen) {};

   /**
    * Draw.
    *
    * @param pen the pen
    */
   public abstract void draw(Graphics pen);
   
   /**
    * Update.
    */
   public abstract void update();

   /**
    * Inits the gui.
    */
   public abstract void initGUI();
   
   /**
    * Inits the.
    */
   public abstract void init();

   /**
    * Key pressed.
    *
    * @param event the event
    */
   public abstract void keyPressed(KeyEvent event);
   
   /**
    * Key released.
    *
    * @param event the event
    */
   public abstract void keyReleased(KeyEvent event);
   
   /**
    * Key typed.
    *
    * @param event the event
    */
   public abstract void keyTyped(KeyEvent event);

   /**
    * Mouse clicked.
    *
    * @param event the event
    */
   public abstract void mouseClicked(MouseEvent event);
   
   /**
    * Mouse dragged.
    *
    * @param event the event
    */
   public abstract void mouseDragged(MouseEvent event);
   
   /**
    * Mouse entered.
    *
    * @param event the event
    */
   public abstract void mouseEntered(MouseEvent event);
   
   /**
    * Mouse exited.
    *
    * @param event the event
    */
   public abstract void mouseExited(MouseEvent event);
   
   /**
    * Mouse moved.
    *
    * @param event the event
    */
   public abstract void mouseMoved(MouseEvent event);
   
   /**
    * Mouse pressed.
    *
    * @param event the event
    */
   public abstract void mousePressed(MouseEvent event);
   
   /**
    * Mouse released.
    *
    * @param event the event
    */
   public abstract void mouseReleased(MouseEvent event);
   
   /**
    * Mouse wheel moved.
    *
    * @param event the event
    */
   public abstract void mouseWheelMoved(MouseWheelEvent event);
}