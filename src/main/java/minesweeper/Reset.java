/*
 * Reset.java
 */
package minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.apache.logging.log4j.*;

/**
 * DESCRIBE {@link Reset} HERE.
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author David C. Petty <dpetty@winchesterps.org>
 */
public class Reset extends JButton implements ActionListener {
    /** log4j {@link Logger}. */
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
