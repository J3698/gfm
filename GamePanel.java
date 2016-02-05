package gfm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.Timer;

import gfm.gamestate.GameStateManager;
import gfm.util.ArrayUtils.IterableProtector;
import gfm.util.Camera;

// TODO: Auto-generated Javadoc
/**
 * The Class GamePanel.
 */
public class GamePanel extends JPanel {

   /** The Constant serialVersionUID. */
   private static final long serialVersionUID = 1069592807236812370L;

   /** The my game. */
   private Game myGame;

   /** The my camera. */
   private Camera myCamera;

   /** The my listener manager. */
   private ListenerManager myListenerManager;

   /** The my game state manager. */
   private GameStateManager myGameStateManager;

   /** The my macros. */
   private LinkedList<Macro> myMacros;

   /** The timer. */
   private Timer timer;

   /** The my game width. */
   private int myGameWidth;

   /** The my game height. */
   private int myGameHeight;

   /**
    * Instantiates a new game panel.
    *
    * @param game the game
    * @param gameWidth the game width
    * @param gameHeight the game height
    * @param startGameState the start game state
    */
   public GamePanel(Game game, int gameWidth, int gameHeight, String startGameState) {
      myGame = game;
      myGameWidth = gameWidth;
      myGameHeight = gameHeight;
      myGameStateManager = new GameStateManager(startGameState, myGame);
      myCamera = new Camera(this);
      myListenerManager = new ListenerManager(this);
      myMacros = new LinkedList<Macro>();
      setFocusable(true);
      timer = new Timer(20, new UpdateListener());
   }

   /**
    * Start.
    */
   public void start() {
      myListenerManager.addListeners();
      timer.start();
   }

   /* (non-Javadoc)
    * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
    */
   @Override
   public void paintComponent(Graphics pen) {
      //Clear painting spaces
      pen.clearRect(0, 0, getWidth(), getHeight());
      myCamera.clearImage();
      //Draw painting spaces
      draw(myCamera.getPen());
      //Draw camera view to screen
      int x0 = (int) myCamera.getScaledPos1().getX();
      int y0 = (int) myCamera.getScaledPos1().getY();
      int x1 = (int) myCamera.getScaledPos2().getX();
      int y1 = (int) myCamera.getScaledPos2().getY();
      pen.drawImage(myCamera.getImage(), x0, y0, x1, y1, null);
      //Draw version information
      //pen.setFont(StringDraw.versionFont());

      pen.setColor(new Color(200, 255, 200, 150));
      String version = myGame.getLauncher().getCurrentVersion();
      if ( version != null ) {
         pen.drawString("v " + version, 5, 20);
      }
   }

   /**
    * Draw.
    *
    * @param pen the pen
    */
   public void draw(Graphics pen) {
      myCamera.update();
      myGameStateManager.getCurrentGameState().draw(pen);
      for ( Macro macro : myMacros ) {
         macro.draw(pen);
      }
      // need better system for drawing over certain things...
      myGameStateManager.getCurrentGameState().drawOverMacro(pen);
   }

   /**
    * Update.
    */
   public void update() {
      myCamera.update();
      for ( Macro macro : myMacros ) {
         macro.update();
      }
      myGameStateManager.getCurrentGameState().update();
   }

   /**
    * The listener interface for receiving update events.
    * The class that is interested in processing a update
    * event implements this interface, and the object created
    * with that class is registered with a component using the
    * component's <code>addUpdateListener<code> method. When
    * the update event occurs, that object's appropriate
    * method is invoked.
    *
    * @see UpdateEvent
    */
   public class UpdateListener implements ActionListener {

      /* (non-Javadoc)
       * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
       */
      @Override
      public void actionPerformed(ActionEvent event) {
         update();
         repaint();
      }
   }

   /**
    * Return an Iterable Protector to iterate through macros
    *
    * @return the iterable protector
    */
   public IterableProtector<Macro> iterMacros() {
      return new IterableProtector<Macro>(myMacros);
   }

   /**
    * Adds the macro.
    *
    * @param toAdd the to add
    */
   public void addMacro(Macro toAdd) {
      myMacros.add(toAdd);
   }

   /**
    * Removes the macro.
    *
    * @param toRemove the to remove
    */
   public void removeMacro(Macro toRemove) {
      myMacros.remove(toRemove);
   }

   /**
    * Gets the game width.
    *
    * @return the game width
    */
   public int getGameWidth() { return myGameWidth; }

   /**
    * Gets the game height.
    *
    * @return the game height
    */
   public int getGameHeight() { return myGameHeight; }

   /**
    * Sets the game width.
    *
    * @param gameWidth the new game width
    */
   public void setGameWidth(int gameWidth) { myGameWidth = gameWidth; }

   /**
    * Sets the game height.
    *
    * @param gameHeight the new game height
    */
   public void setGameHeight(int gameHeight) { myGameHeight = gameHeight; }

   /**
    * Gets the game state manager.
    *
    * @return the game state manager
    */
   public GameStateManager getGameStateManager() { return myGameStateManager; }

   /**
    * Gets the camera.
    *
    * @return the camera
    */
   public Camera getCamera() { return myCamera; }
}