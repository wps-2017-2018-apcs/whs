/*
 * Button.java
 */
package minesweeper;

import java.awt.*;
import java.awt.event.*;
//import java.awt.image.*;
//import java.io.*;
//import java.nio.file.*;
//import javax.imageio.*;
import javax.swing.*;
//import java.util.*;
import org.apache.logging.log4j.*;

/**
 * {@link Button} is a {@link JButton} for spaces / flags / bombs.
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author David C. Petty // https://github.com/wps-dpetty
 */
public class Button extends JButton implements ActionListener {

    //////////////////////////////// FIELDS ////////////////////////////////

    /** log4j {@link Logger}. */
    private static Logger logger = LogManager.getLogger(Minesweeper.SHORT);
    /** This {@link Button}'s row. */
    private int row;
    /** This {@link Button}'s column. */
    private int col;

    private static Button test;
    ///////////////////////////// CONSTRUCTORS /////////////////////////////

    public Button(int row, int col, int side) {
        super();
        this.row = row;
        this.col = col;
        Dimension initialSize = new Dimension(side, side);
        setPreferredSize(initialSize);
        setSize(initialSize);
        setActionCommand(row + "," + col);
        addActionListener(this);
        setBorderPainted(false);
        setOpaque(true);
        setVisible(true);
        logger.info("{}:{}:({})", getClass(), initialSize, paramString());
    }

    //////////////////////////////// METHODS ///////////////////////////////

    /** Return logger for this {@link Button}.
     * @return logger for this {@link Button}
     */
    public Logger getLogger() { return logger; }

    public void actionPerformed(ActionEvent e) {
        logger.info("{}:{}:\"{}\"", getClass(), e, e.getActionCommand());
        String ac = e.getActionCommand();
        // RED_FLAG: put this in a static method somewhere
        assert ac.indexOf(",") >= 0 : "bad button: " + ac;
        int x = new Integer(ac.substring(0, ac.indexOf(",")));
        int y = new Integer(ac.substring(ac.indexOf(",") + 1));
        // RED_FLAG: simply something to do when the mouse is clicked
        Button button = Main.getGrid().findButton(x, y);
        if (button != null)
            button.setBackground(Color.RED);
    }

    /**
     * Paint the component using a {@link Graphics} rendering object.
     *
     * @param g the Graphics rendering object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Images.getBombImage(), 0, 0, getWidth(), getHeight(), null);
    }

    @Override
    public void setSize(int width, int height) {
        logger.info("setSize: (from) {} (to) {}", getSize(), new Dimension(width, height));
        int side = Math.min(width, height);
        super.setSize(side, side);  // keep Button square
    }

    @Override
    public void setSize(Dimension size) {
        // RED_FLAG: setSize(Dimension) calls setSize(int, int) else infinite
        // recursion
        setSize(size.width, size.height);
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append(getClass().getName()).append(":")
            .append(getLocation()).append(":").append(getSize()).append(":")
            .append("(").append(getActionCommand()).append(")")
            .toString();
    }
}
