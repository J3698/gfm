package gfm.gamestate;

import gfm.Game;

// TODO: Auto-generated Javadoc
/**
 * The Class Transition.
 */
public abstract class Transition extends GameState {
   
   /** The my first game state. */
   private GameState myFirstGameState;
   
   /** The my second game state. */
   private GameState mySecondGameState;

   /**
    * Instantiates a new transition.
    *
    * @param game the game
    * @param first the first
    * @param second the second
    */
   public Transition(Game game, String first, String second) {
      super(game);

      myFirstGameState = getGame().getGameState(first);
      mySecondGameState = getGame().getGameState(second);

      if ( getGame() != myFirstGameState.getGame() ||
            getGame() != mySecondGameState.getGame() ) {
         throw new IllegalArgumentException("Game State GamePanels Mismatch");
      }
   }

   /**
    * Finish.
    */
   public final void finish() {
      getGame().setGameState(mySecondGameState.getGameMode());
      getGame().getGamePanel().getGameStateManager().setIsTransitioning(false);
   }

   /**
    * Gets the first game state.
    *
    * @return the first game state
    */
   public final GameState getFirstGameState() { return myFirstGameState; }
   
   /**
    * Gets the second game state.
    *
    * @return the second game state
    */
   public final GameState getSecondGameState() { return mySecondGameState; }
}