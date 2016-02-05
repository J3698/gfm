package gfm.gamestate;

import java.util.ArrayList;
import java.util.HashMap;

import gfm.Game;
import gfm.util.ArrayUtils.IterableProtector;

// TODO: Auto-generated Javadoc
/**
 * The Class GameStateManager.
 */
public class GameStateManager {

   /** The my current game state. */
   private String myCurrentGameState;

   /** The game. */
   private Game myGame;

   /** Whether gamestate is transitioning. */
   private boolean myIsTransitioning;

   /** The transition. */
   private Transition myTransition;

   /** The game states array. */
   private ArrayList<GameState> myGameStatesArray;

   /** The game states hash. */
   private HashMap<String, GameState> myGameStatesHash;

   /** The uncharted territory gamestate */
   private UnchartedTerritory myUnchartedTerritory;

   /**
    * Instantiates a new game state manager.
    *
    * @param game the game
    */
   public GameStateManager(Game game) {
      this(null, game);
   }

   /**
    * Instantiates a new game state manager.
    *
    * @param startGameState the start game state
    * @param game the game
    */
   public GameStateManager(String startGameState, Game game) {
      myCurrentGameState = startGameState;
      myGame = game;

      myIsTransitioning = false;
      myTransition = null;

      myGameStatesArray = new ArrayList<GameState>();
      myGameStatesHash = new HashMap<String, GameState>();

      myUnchartedTerritory = new UnchartedTerritory(myGame);
   }

   /**
    * Gets the states.
    *
    * @return the states
    */
   public IterableProtector<GameState> getStates() {
      return new IterableProtector<GameState>(myGameStatesArray);
   }

   /**
    * Adds the game state.
    *
    * @param gameState the game state
    */
   public void add(GameState gameState) {
      add(gameState.getGameMode(), gameState);
   }

   /**
    * Adds the.
    *
    * @param name the name
    * @param gameState the game state
    */
   public void add(String name, GameState gameState) {
      if ( myGameStatesHash.containsKey(name) ||
            myGameStatesHash.containsValue(gameState) ) {
         return;
      }

      myGameStatesArray.add(gameState);
      myGameStatesHash.put(name, gameState);
   }

   /**
    * Removes the.
    *
    * @param toRemove the to remove
    */
   public void remove(String toRemove) {
      if ( !myGameStatesHash.containsKey(toRemove) ) { return; }

      GameState fromToRemove = myGameStatesHash.get(toRemove);
      myGameStatesHash.remove(toRemove);
      myGameStatesArray.remove(fromToRemove);
   }

   /**
    * Removes the.
    *
    * @param toRemove the to remove
    */
   public void remove(GameState toRemove) {
      for ( String key : myGameStatesHash.keySet() ) {
         if ( myGameStatesHash.get(key) == toRemove ) {
            remove(key);
            return;
         }
      }
   }

   /**
    * Gets the game state.
    *
    * @param name the name
    * @return the game state
    */
   public GameState getGameState(String name) {
      return myGameStatesHash.get(name);
   }

   /**
    * Gets the game state.
    *
    * @return the game state
    */
   public String getGameState() {
      return myCurrentGameState;
   }

   /**
    * Gets the current game state.
    *
    * @return the current game state
    */
   public GameState getCurrentGameState() {
      if ( myIsTransitioning ) {
         return myTransition;
      } else if ( myGameStatesHash.get(myCurrentGameState) != null ) {
         return myGameStatesHash.get(myCurrentGameState);
      } else {
         return myUnchartedTerritory;
      }
   }

   /**
    * Sets the game state.
    *
    * @param gameState the new game state
    */
   public void setGameState(String gameState) {
      myCurrentGameState = gameState;
      myIsTransitioning = false;
      myTransition = null;
   }

   /**
    * Sets the game state.
    *
    * @param transition the new game state
    */
   public void setGameState(Transition transition) {
      myIsTransitioning = true;
      myTransition = transition;
   }

   /**
    * Checks if is transitioning.
    *
    * @return true, if is transitioning
    */
   public boolean isTransitioning() {
      return myIsTransitioning;
   }

   /**
    * Sets the checks if is transitioning.
    *
    * @param isTransitioning the new checks if is transitioning
    */
   public void setIsTransitioning(boolean isTransitioning) {
      myIsTransitioning = isTransitioning;
   }
}