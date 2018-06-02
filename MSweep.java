public class MSweep {
	private enum gameState {RUNNING, OVER_WON, OVER_LOST};
	private gameState stateOfGame;
	private int numberFlags, flagsNecessary;
	
	/**
	 * No-args constructor: game is running, you do not start with any flags
	 */
	public MSweep() {
		stateOfGame = gameState.RUNNING;
		numberFlags = 0;
		flagsNecessary = 12;
	}
	
	/**
	 * Adds to a flag when a flag tile is uncovered- called by the Tile class. Currently private.
	 */
	private void addFlag() {
		numberFlags++;
	}
	
	/**
	 * A tile has been triggered- this method will handle it (WORK IN PROGRESS)
	 */
	public void tileHandled(Tile other) {
		Tile.State handling = other.getState();
		if (Tile.State.BOMB.equals(handling)) {
			//TODO handle bomb-hit
		} else if (Tile.State.FLAG.equals(handling)) {
			addFlag();
		} else {
			//TODO handle showing of tile
		}
		winCondition();
	}
	
	/**
	 * Has the state of the game changed yet?
	 */
	public void winCondition() {
		if (numberFlags >= flagsNecessary) {
			stateOfGame = gameState.OVER_WON;
		} 
//		else if () { /* I've mentioned bombs plenty now */
//			stateOfGame = gameState.OVER_LOST;
//		}
		if (stateOfGame.equals(gameState.OVER_LOST)) {
			//yeah
		}
	}
	
	/**
	 * Instantiate the game
	 */
	public static void main(String[] args) {
		//TODO instantiate the game
	}

}
