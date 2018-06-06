/*
 * Minesweeper.java
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package minesweeper;

public class Tile {
    public enum State {BOMB, FLAG, DEFAULT};
    //State is currently public to allow MSweep to access - consider revising.
    private State currentState;

    /**
     * No-args constructor: a default tile
     */
    public Tile() {
        currentState = State.DEFAULT;
    }

    /**
     * Constructor with one (State) argument: a non-default tile
     */
    public Tile(State other) {
        currentState = other;
    }

    /**
     * Returns the state of the selected tile
     */
    public State getState() {
        return this.currentState;
    }
}