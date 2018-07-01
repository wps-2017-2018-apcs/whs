package minesweeper;

//import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import org.apache.logging.log4j.*;

/**
 * DESCRIBE {@link Tile} HERE.
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author Kevin Khaghani // 1907024@wpsstudent.com
 * @author David C. Petty // https://github.com/wps-dpetty
 */
public class Tile extends JButton implements ActionListener {
    /**
     * log4j {@link Logger}.
     */
    private static Logger logger = LogManager.getLogger(Minesweeper.SHORT);

    private int row;
    private int column;
    private boolean isMine, isClicked;
    private int tileValue;

    public Tile(int r, int c, boolean m) {
        logger.info(this);
        addActionListener(this);
        row = r;
        column = c;
        tileValue = 0;
        isMine = m;
        isClicked = false;
    }

    public void actionPerformed(ActionEvent e) {
        //System.out.print(row + " " + column);
        Main.startTimer(false);
    }

    public boolean getIsClicked() {
        return isClicked;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return column;
    }

    public boolean getIsMine() {
        return isMine;
    }

    /**
     * Method for Main to use to read the value of the tile and, in turn, display it on the eventual board
     *
     * @return the value on the tile
     */
    public int getTileValue() { //for now, if it's 0, no mines around, do NOT display 0- display a blank tile.
        return tileValue;
    }

    /**
     * Allows Main (or wherever the board is initialized) to modify the value based on nearby mines
     *
     * @param a = the value to which tileValue will be set
     */
    public void setTileValue(int a) {
        tileValue = a;
    }

    /**
     * Allows getMines() class in Minesweeper to assign correct tile value after all the mines are created
     * to all the non-mine tiles
     */
    public void setTileValue() {
        int count = 0;
        Tile[][] gameArray = Minesweeper.getGameArray();
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = column - 1; j < column + 2; column++) {
                if (i >= 0 && i < 16 && j >= 0 && j < 16 && i != row && j != column && gameArray[i][j].getIsMine()) {
                    count++;
                }
            }
        }
        tileValue = count;
    }

    /**
     * Another way to modify the tileValue, incrementing by one- use this instead of the other if it suits the board-init code better
     */
    public void incrementTile() {
        tileValue++;
    }

    public String toString() {
        return "Tile: mine=" + isMine + ", value=" + tileValue;
    }
}
