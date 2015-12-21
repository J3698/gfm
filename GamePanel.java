package gfm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import gfm.gamestate.GameState;
import gfm.gamestate.GameStateManager;
import gfm.util.Camera;

public class GamePanel extends JPanel {
   private static final long serialVersionUID = 1069592807236812370L;

   private Camera myCamera;

   private ListenerManager myListenerManager;

   private GameStateManager myGameStateManager;

   private Timer timer;

   private int myGameWidth;
   private int myGameHeight;

   public GamePanel(int gameWidth, int gameHeight, String startGameState) {
      myGameWidth = gameWidth;
      myGameHeight = gameHeight;
      myGameStateManager = new GameStateManager(startGameState);
      myCamera = new Camera(this);
      myListenerManager = new ListenerManager(this);
      myListenerManager.addListeners();
      setFocusable(true);
      timer = new Timer(20, new UpdateListener());
   }

   public void start() {
      timer.start();
   }

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
      pen.drawString("v broke", 5, 20);
   }

   public void draw(Graphics pen) {
      String currentGameState = myGameStateManager.getGameState();
      for (GameState gameState : myGameStateManager.getStates()) {
         if (gameState.getGameMode().equals(currentGameState)) {
            gameState.draw(pen);
            break;
         }
      }
   }

   public void update() {
      myCamera.update();
      String currentGameState = myGameStateManager.getGameState();
      for (GameState gameState : myGameStateManager.getStates()) {
         if (gameState.getGameMode().equals(currentGameState)) {
            gameState.update();
            break;
         }
      }
   }

   public class UpdateListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent event) {
         update();
         repaint();
      }
   }

   public int getGameWidth() { return myGameWidth; }
   public int getGameHeight() { return myGameHeight; }
   public void setGameWidth(int gameWidth) { myGameWidth = gameWidth; }
   public void setGameHeight(int gameHeight) { myGameHeight = gameHeight; }

   public GameStateManager getGameStateManager() { return myGameStateManager; }

   public Camera getCamera() { return myCamera; }
}