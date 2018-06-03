/*
 * Minesweeper.java
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package whs;

public class Minesweeper {
    private enum gameState {RUNNING, OVER_WON, OVER_LOST};
    private gameState stateOfGame;
    private int numberFlags, flagsNecessary;
    
    /**
     * No-args constructor: game is running, do not start with any flags.
     */
    public Minesweeper() {
        stateOfGame = gameState.RUNNING;
        numberFlags = 0;
        flagsNecessary = 12;
    }
    
    /**
     * Adds to a flag when a flag tile is uncovered. Invoked by {@link Tile}.
     * Tile class. Currently private.
     */
    private void addFlag() {
        numberFlags++;
    }
    
    /**
     * A tile has been triggered - this method will handle it (WORK IN PROGRESS)
     */
    public void tileHandled(Tile other) {
        Tile.State handling = other.getState();
        if (Tile.State.BOMB.equals(handling)) {
            //TODO: handle bomb-hit
        }
        else if (Tile.State.FLAG.equals(handling)) {
            addFlag();
        }
        else {
            //TODO: handle showing of tile
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
        //else if () { /* I've mentioned bombs plenty now */
            //stateOfGame = gameState.OVER_LOST;
        //}
        if (stateOfGame.equals(gameState.OVER_LOST)) {
            //yeah
        }
    }
}