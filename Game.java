package gfm;

import java.awt.event.WindowEvent;
import java.awt.Toolkit;//getDefaultToolkit().getScreenSize()
import java.awt.Point;

import gfm.GamePanel;
import gfm.GameFrame;
import gfm.gamestate.GameState;

public class Game {
   private String myName;

   private GamePanel myGamePanel;
   private GameFrame myGameFrame;

   public Game(String name, int gameWidth, int gameHeight) {
      myName = name;
      myGamePanel = new GamePanel(gameWidth, gameHeight, "");
      myGameFrame = new GameFrame(name, myGamePanel);
      myGameFrame.setVisible(true);
   }

   public void setGameState(String gameState) {
      myGamePanel.getGameStateManager().setGameState(gameState);
   }

   public void addGameState(GameState toAdd) {
      addGameState(toAdd.getGameMode(), toAdd);
   }

   public void addGameState(String name, GameState toAdd) {
      toAdd.setGamePanel(myGamePanel);
      myGamePanel.getGameStateManager().add(name, toAdd);
   }

   public void setFullScreen() {
      myGameFrame.getContentPane().remove(myGamePanel);
      myGameFrame.setVisible(false);
      myGameFrame.dispose();
      myGameFrame = new GameFrame(myName, myGamePanel);
      myGameFrame.setUndecorated(true);
      myGameFrame.getContentPane().add(myGamePanel);
      myGameFrame.setSize(
         Toolkit.getDefaultToolkit().getScreenSize().width, 
         Toolkit.getDefaultToolkit().getScreenSize().height);
      myGameFrame.setLocation(new Point(0, 0));
      myGameFrame.setVisible(true);
   }

   public void start() {
      myGamePanel.start();
   }

   public String getName() {
      return myName;
   }

   public GamePanel getGamePanel() {
      return myGamePanel;
   }

   public GameFrame getGameFrame() {
      return myGameFrame;
   }
}