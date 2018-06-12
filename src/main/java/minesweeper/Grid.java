/*
 * Grid.java
 */
package minesweeper;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import org.apache.logging.log4j.*;

/** DESCRIBE {@link Grid} HERE.
 * 
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author David C. Petty // https://github.com/wps-dpetty
 */
public class Grid extends JPanel {

    //////////////////////////////// FIELDS ////////////////////////////////

    /** log4j {@link Logger}. */
    private static Logger logger = LogManager.getFormatterLogger(Minesweeper.SHORT);
    public static int INITIAL_SIDE = 20;
    public static int NUMBER_ROWS = 16;
    public static int NUMBER_COLS = 16;

    ///////////////////////////// CONSTRUCTORS /////////////////////////////

    public Grid(int rows, int cols, int side) {
        super(new GridLayout(rows, cols, 0, 0));
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                 add(new Button(row, col, side));
        //final int width = side * rows;    // no need to set preferred size
        //final int height = side * cols;   // no need to set preferred size
        setBackground(Color.BLACK);
        setVisible(true);
    }

    public Grid(int rows, int cols) {
        this(rows, cols, INITIAL_SIDE);
    }

    public Grid() {
        this(NUMBER_ROWS, NUMBER_COLS);
    }

    //////////////////////////////// METHODS ///////////////////////////////

    public Button findButton(int x, int y) {
        Component[] components = getComponents();
        for (Component component : components)
            if (component instanceof AbstractButton) {
                String ac = ((Button) component).getActionCommand();
                // RED_FLAG: put this in a static method somewhere
                assert ac.indexOf(",") >= 0 : "bad button: " + ac;
                int buttonX = new Integer(ac.substring(0, ac.indexOf(",")));
                int buttonY = new Integer(ac.substring(ac.indexOf(",") + 1));
                if (buttonX == x && buttonY == y)
                    return (Button) component;
        }
        return null;
    }

    /**
     * Paint the component using a {@link Graphics} rendering object.
     *
     * @param g the Graphics rendering object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void setSize(int width, int height) {
        logger.info("{}.setSize(): {}, {}", getClass(), width, height);
    }

    @Override
    public void setSize(Dimension size) {
        // RED_FLAG: setSize(Dimension) calls setSize(int, int) else infinite
        // recursion
        logger.info("setSize: (from) {} (to) {}", getSize(), size);
        setSize(size.width, size.height);
    }
/*
    @Override
    public Dimension getSize() {
        return size;
    }

    @Override
    public Dimension getPreferredSize() {
        return preferredSize;
    }

    @Override
    public Dimension getPreferredSize() {
        return ((JFrame) SwingUtilities.getWindowAncestor(this)).getPreferredSize();
    }
*/
}