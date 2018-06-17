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
 * @author <a href="https://github.com/wps-dpetty">David C. Petty</a>
 */
public class Button extends JButton implements ActionListener {

    //////////////////////////////// FIELDS ////////////////////////////////

    /**
     * log4j {@link Logger}.
     */
    private static Logger logger = LogManager.getLogger(Minesweeper.SHORT);
    /**
     * This {@link Button}'s row.
     */
    private int row;
    /**
     * This {@link Button}'s column.
     */
    private int col;

    ///////////////////////////// CONSTRUCTORS /////////////////////////////

    /**
     * Create square {@link Button}.
     *
     * @param row  number of row
     * @param col  number of column
     * @param side minimum size of square button
     */
    public Button(int row, int col, int side) {
        super();
        this.row = row;
        this.col = col;
        Dimension initialSize = new Dimension(side, side);
        setPreferredSize(initialSize);
        setSize(initialSize);
        setActionCommand(row, col);
        addActionListener(this);
        setBorderPainted(false);
        setOpaque(true);
        setVisible(true);
        logger.info("{}:{}:\"{}\":({})",
                getClass(), initialSize, getActionCommand(), paramString());
    }

    //////////////////////////////// METHODS ///////////////////////////////

    /**
     * Invoked when an action occurs.
     *
     * @param e event triggering action
     */
    public void actionPerformed(ActionEvent e) {
        logger.info("{}:{}", getClass(), e);
        Point point = parseActionCommand(e.getActionCommand());
        // RED_FLAG: simply something to do when the mouse is clicked
        Button button = Main.getGrid().findButton(point.x, point.y);
        if (button != null) // RED_FLAG: what to do if button not found?
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
        // TODO: this paints all the images randomly... which is not correct
        Images[] images = {Images.COVER, Images.MINE, Images.FLAG,
                Images.NUMBER1, Images.NUMBER2, Images.NUMBER3, Images.NUMBER4,
                Images.NUMBER5, Images.NUMBER6, Images.NUMBER7, Images.NUMBER8,};
        Images image = images[(int) (Math.random() * images.length)];
        g.drawImage(image.image(), 0, 0, getWidth(), getHeight(), null);
    }

    /**
     * Resizes this component so that it has width <tt>width</tt> and
     * height <tt>height</tt>. This method changes layout-related
     * information, and therefore, invalidates the component hierarchy.
     *
     * @param width  new width of this component in pixels
     * @param height new height of this component in pixels
     */
    @Override
    public void setSize(int width, int height) {
        logger.trace("{}.setSize: (from) {} (to) {}",
                getClass(), getSize(), new Dimension(width, height));
        int side = Math.min(width, height);
        Dimension size = new Dimension(side, side);
        super.setSize(side, side);
        setPreferredSize(size);
    }

    /**
     * Resizes this component so that it has width <tt>size.width</tt> and
     * height <tt>size.height</tt>. This method changes layout-related
     * information, and therefore, invalidates the component hierarchy.
     *
     * @param size dimension specifying the new size of this component
     */
    @Override
    public void setSize(Dimension size) {
        // RED_FLAG: setSize(Dimension) calls setSize(int, int) else infinite
        // recursion
        setSize(size.width, size.height);
    }

    /**
     * Return {@link String} representation of <tt>this</tt>.
     *
     * @return {@link String} representation of <tt>this</tt>
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append(getClass().getName()).append(":")
                .append(getLocation()).append(":").append(getSize()).append(":")
                .append("\"").append(getActionCommand()).append("\"")
                .toString();
    }

    /**
     * {@link JButton#setActionCommand(java.lang.String)
     * setActionCommand}("<tt>row</tt>,<tt>col</tt>").
     *
     * @param row row of this {@link Button}
     * @param col column of this {@link Button}
     */
    public void setActionCommand(int row, int col) {
        setActionCommand(row + "," + col);
    }

    /**
     * Return (<tt>row</tt>,<tt>col</tt>) {@link Point} parsed from
     * <tt>actionCommand</tt>.
     *
     * @param actionCommand "<tt>row</tt>,<tt>col</tt>" {@link String}
     * @return (< tt > row < / tt >, < tt > col < / tt >) {@link Point}
     */
    public static Point parseActionCommand(String actionCommand) {
        int comma = actionCommand.indexOf(",");
        assert comma > 0 && comma < actionCommand.length()
                : "bad button command: \"" + actionCommand + "\"";
        return new Point(
                new Integer(actionCommand.substring(0, comma)),
                new Integer(actionCommand.substring(comma + 1)));
    }
}
