package minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.logging.log4j.*;

/**
 * DESCRIBE {@link Tile} HERE.
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author David C. Petty // https://github.com/wps-dpetty
 */
public class Tile extends JButton implements ActionListener {
    /** log4j {@link Logger}. */
    private static Logger logger = LogManager.getLogger(Minesweeper.SHORT);

    private int row;
    private int column;
    private boolean isMine;
    
    public Tile(int r, int c) {
        logger.info(this);
        addActionListener(this);
        row = r;
        column = c;
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
}
