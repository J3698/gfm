package gfm.gamestate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GameStateManager {
   private String myCurrentGameState;

   private ArrayList<GameState> myGameStatesArray;
	private HashMap<String, GameState> myGameStatesHash;

   public GameStateManager() {
      this(null);
   }

	public GameStateManager(String startGameState) {
      myCurrentGameState = startGameState;
	   myGameStatesArray = new ArrayList<GameState>();
      myGameStatesHash = new HashMap<String, GameState>();
	}

   public ArrayListProtector<GameState> getStates() {
	   return new ArrayListProtector<GameState>(myGameStatesArray);
   }

   public void add(GameState gameState) {
      add(gameState.getGameMode(), gameState);
   }

   public void add(String name, GameState gameState) {
      if ( myGameStatesHash.containsKey(name) || 
           myGameStatesHash.containsValue(gameState) ) {
         return;
      }

      myGameStatesArray.add(gameState);
      myGameStatesHash.put(name, gameState);
   }

   public void remove(String toRemove) {
      if ( !myGameStatesHash.containsKey(toRemove) ) { return; }

      GameState fromToRemove = myGameStatesHash.get(toRemove);
		myGameStatesHash.remove(toRemove);
		myGameStatesArray.remove(fromToRemove);
	}

	public void remove(GameState toRemove) {
	   for ( String key : myGameStatesHash.keySet() ) {
	      if ( myGameStatesHash.get(key) == toRemove ) {
	         remove(key);
	         return;
	      }
	   }
	}

	public String getGameState() {
	   return myCurrentGameState;
	}

	public void setGameState(String gameState) {
	   myCurrentGameState = gameState;
	}


	public class ArrayListProtector<T> implements Iterable<T> {
	   private ArrayList<T> myArrayList;

	   public ArrayListProtector(ArrayList<T> arrayList) {
	      myArrayList = arrayList;
	   }

	   public Iterator<T> iterator() {
	      return myArrayList.iterator();
	   }
	}
}
