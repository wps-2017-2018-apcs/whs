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
    /** log4j {@link Logger}. */
    private static Logger logger = LogManager.getLogger(Minesweeper.SHORT);

    private int row;
    private int column;
    private boolean isMine;
    private int tileValue;
    
    public Tile(int r, int c) {
        logger.info(this);
        addActionListener(this);
        row = r;
        column = c;
        tileValue = 0;
    }

    public void actionPerformed(ActionEvent e) {
        //System.out.print(row + " " + column);
        Main.startTimer(false);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return column;
    }
    
    /**
     * Method for Main to use to read the value of the tile and, in turn, display it on the eventual board
     * @return the value on the tile
     */
    public int getTileValue() { //for now, if it's 0, no bombs around, do NOT display 0- display a blank tile.
  	  return tileValue;
    }
    /**
     * Allows Main (or wherever the board is initialized) to modify the value based on nearby bombs
     * @param a = the value to which tileValue will be set
     */
    public void setTileValue(int a) {
  	  tileValue = a;
    }
    /**
     * Another way to modify the tileValue, incrementing by one- use this instead of the other if it suits the board-init code better
     */
    public void incrementTile() {
  	  tileValue++;
    }
}
