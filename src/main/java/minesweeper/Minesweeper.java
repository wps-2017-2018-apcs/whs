/*
 * Minesweeper.java
 */
package minesweeper;

import org.apache.logging.log4j.*;

/**
 * DESCRIBE {@link Minesweeper} HERE.
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author David C. Petty // https://github.com/wps-dpetty
 */
public class Minesweeper {
    /** LONG name of this project. */
    public static final String LONG = "Minesweeper";
    /** SHORT name of this project. */
    public static final String SHORT = "MS";
    /** log4j {@link Logger}. */
    private static Logger logger = LogManager.getLogger(SHORT);

    private enum gameState {RUNNING, OVER_WON, OVER_LOST};
    private gameState stateOfGame;
    private int numberFlags;
    private static Tile[][] gameArray;

    /**
     * No-args constructor: game is running, do not start with any flags.
     */
    public Minesweeper() {
        logger.info("{}:", getClass().getName());
        stateOfGame = gameState.RUNNING;
        numberFlags = 0;
        gameArray = this.getMines();
    }
    
    /**
     * Adds to a flag when a flag tile is uncovered. Invoked by {@link Tile}.
     * Tile class. Currently private.
     */
    private void addFlag() {
        numberFlags++;
    }

    public static Tile[][] getGameArray() {
        return gameArray;
    }

    public static Tile[][] getMines()    {
        boolean[][] bombSpots = (new RandPlace(16,30,99)).generate2D();
        Tile[][] tileArray = new Tile[0][0];
        for (int i = 0; i < 16; i++)    
            for (int k = 0; k < 30; k++)    {
               tileArray[i][k] = new  Tile(i, k, bombSpots[i][k]);
                
            }
        return tileArray;
    }
    /**
     * A tile has been triggered - this method will handle it (WORK IN PROGRESS)
     * @param other NOT SURE WHAT OTHER IS
     */
    public void tileHandled(Tile other) {
/*
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
*/
        winCondition();
    }

    /**
     * Has the state of the game changed yet?
     */
    public void winCondition() {
        // if (numberFlags >= flagsNecessary) {
        //      stateOfGame = gameState.OVER_WON;
        //}
        //else if () { /* I've mentioned bombs plenty now */
            //stateOfGame = gameState.OVER_LOST;
        //}
        if (stateOfGame.equals(gameState.OVER_LOST)) {
            //yeah
        }
    }
}
