package gfm;

import java.awt.Point;
import java.awt.Toolkit;
import java.util.HashMap;

import gfm.gamestate.GameState;
import gfm.gamestate.Transition;
import gfm.sound.SoundManager;

// TODO: Auto-generated Javadoc
/**
 * The Class Game.
 */
public class Game {
   
   /** The my name. */
   private String myName;

   /** The my game panel. */
   private GamePanel myGamePanel;
   
   /** The my game frame. */
   private GameFrame myGameFrame;
   
   /** The my launcher. */
   private Launcher myLauncher;
   
   /** The my sound manager. */
   private SoundManager mySoundManager;
   
   /** The my singletons. */
   private HashMap<String, Object> mySingletons;

   /**
    * Instantiates a new game.
    *
    * @param name the name
    * @param gameWidth the game width
    * @param gameHeight the game height
    * @param drawWidth the draw width
    * @param drawHeight the draw height
    */
   public Game(String name, int gameWidth, int gameHeight, int drawWidth, int drawHeight) {
      myName = name;
      myGamePanel = new GamePanel(this, gameWidth, gameHeight, "");
      myGameFrame = new GameFrame(name, myGamePanel, drawWidth, drawHeight);
      myLauncher = new Launcher(this);
      mySoundManager = new SoundManager();
      mySingletons = new HashMap<String, Object>();
   }

   /**
    * Sets the game state.
    *
    * @param gameState the new game state
    */
   public void setGameState(String gameState) {
      myGamePanel.getGameStateManager().setGameState(gameState);
   }

   /**
    * Sets the game state.
    *
    * @param transition the new game state
    */
   public void setGameState(Transition transition) {
      myGamePanel.getGameStateManager().setGameState(transition);
   }

   /**
    * Gets the game state.
    *
    * @param string the string
    * @return the game state
    */
   public GameState getGameState(String string) {
      return myGamePanel.getGameStateManager().getGameState(string);
   }


   /**
    * Adds the game state.
    *
    * @param toAdd the to add
    */
   public void addGameState(GameState toAdd) {
      addGameState(toAdd.getGameMode(), toAdd);
   }

   /**
    * Adds the game state.
    *
    * @param name the name
    * @param toAdd the to add
    */
   public void addGameState(String name, GameState toAdd) {
      toAdd.setGame(this);
      myGamePanel.getGameStateManager().add(name, toAdd);
   }

   /**
    * Adds the macro.
    *
    * @param toAdd the to add
    */
   public void addMacro(Macro toAdd) {
      myGamePanel.addMacro(toAdd);
   }

   /**
    * Sets the full screen.
    */
   public void setFullScreen() {
      myGameFrame.getContentPane().remove(myGamePanel);
      myGameFrame.setVisible(false);
      myGameFrame.dispose();
      myGameFrame = new GameFrame(myName, myGamePanel, 0, 0);
      myGameFrame.setUndecorated(true);
      myGameFrame.getContentPane().add(myGamePanel);
      myGameFrame.setSize(
            Toolkit.getDefaultToolkit().getScreenSize().width,
            Toolkit.getDefaultToolkit().getScreenSize().height);
      myGameFrame.setLocation(new Point(0, 0));
      myGameFrame.setVisible(true);
   }

   /**
    * Start.
    */
   public void start() {
      myGamePanel.start();
      myGameFrame.setVisible(true);
   }

   /**
    * Removes the singleton.
    *
    * @param name the name
    */
   public void removeSingleton(String name) {
      mySingletons.remove(name);
   }
   
   /**
    * Put singleton.
    *
    * @param name the name
    * @param toPut the to put
    */
   public void putSingleton(String name, Object toPut) {
      mySingletons.put(name, toPut);
   }
   
   /**
    * Gets the singleton.
    *
    * @param name the name
    * @return the singleton
    */
   public Object getSingleton(String name) { return mySingletons.get(name); }

   /**
    * Gets the width.
    *
    * @return the width
    */
   public int getWidth() { return myGamePanel.getGameWidth(); }
   
   /**
    * Sets the width.
    *
    * @param width the new width
    */
   public void setWidth(int width) { myGamePanel.setGameWidth(width); }

   /**
    * Gets the height.
    *
    * @return the height
    */
   public int getHeight() { return myGamePanel.getGameHeight(); }
   
   /**
    * Sets the height.
    *
    * @param height the new height
    */
   public void setHeight(int height) { myGamePanel.setGameHeight(height); }

   /**
    * Gets the name.
    *
    * @return the name
    */
   public String getName() { return myName; }
   
   /**
    * Gets the game panel.
    *
    * @return the game panel
    */
   public GamePanel getGamePanel() { return myGamePanel; }
   
   /**
    * Gets the game frame.
    *
    * @return the game frame
    */
   public GameFrame getGameFrame() { return myGameFrame; }
   
   /**
    * Gets the launcher.
    *
    * @return the launcher
    */
   public Launcher getLauncher() { return myLauncher; }
   
   /**
    * Gets the sound manager.
    *
    * @return the sound manager
    */
   public SoundManager getSoundManager() { return mySoundManager; }
}