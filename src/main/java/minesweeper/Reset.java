/*
 * Reset.java
 */
package minesweeper;

//import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import org.apache.logging.log4j.*;

/**
 * DESCRIBE {@link Reset} HERE.
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author David C. Petty // https://github.com/wps-dpetty
 */
public class Reset extends JButton implements ActionListener {  // Need to ensure it completely wipes game State. Especially because if you win or lose, You don't want that condition dogging you
    /**
     * log4j {@link Logger}.
     */
    private static Logger logger = LogManager.getLogger(Minesweeper.SHORT);

    public Reset(ImageIcon ico) {
        logger.info(this);
        this.setIcon(ico);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        //System.out.print(row + " " + column);
        //Main.stopTimer();
    }
}
