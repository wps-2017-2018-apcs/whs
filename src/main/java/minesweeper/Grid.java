/*
 * Grid.java
 */
package minesweeper;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

import org.apache.logging.log4j.*;

/**
 * DESCRIBE {@link Grid} HERE.
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author <a href="https://github.com/wps-dpetty">David C. Petty</a>
 */
public class Grid extends JPanel {

	//////////////////////////////// FIELDS ////////////////////////////////

	/**
	 * log4j {@link Logger}.
	 */
	private static Logger logger = LogManager.getLogger(Minesweeper.SHORT);
	/**
	 * Constant minimum size of square buttons.
	 */
	public static final int MINIMUM_SIDE = 20;
	/**
	 * Default number of rows in grid.
	 */
	public static final int DEFAULT_ROWS = 16;
	/**
	 * Default number of columns in grid.
	 */
	public static final int DEFAULT_COLS = 30;

	/**
	 * Actual number of rows in grid.
	 */
	private int rows;
	/**
	 * Actual number of columns in grid.
	 */
	private int cols;
	/**
	 * Actual size of square buttons.
	 */
	private int side;

	///////////////////////////// CONSTRUCTORS /////////////////////////////

	/**
	 * Create {@link Grid} of square {@link Button}s.
	 *
	 * @param rows number of rows in grid
	 * @param cols number of columns in grid
	 * @param side minimum size of square buttons
	 */
	public Grid(int rows, int cols, int side) {
		super(new GridLayout(rows, cols, 0, 0));
		this.rows = rows;
		this.cols = cols;
		this.side = side;
		for (int row = 0; row < rows; row++)
			for (int col = 0; col < cols; col++)
				add(new Button(row, col, side));
		//final int width = side * rows;    // no need to set preferred size
		//final int height = side * cols;   // no need to set preferred size
		setBackground(Color.BLACK);
		setVisible(true);
		logger.info(this);
	}

	/**
	 * Create {@link Grid} of square {@link Button}s with {@link MINIMUM_SIDE}
	 * size of square buttons.
	 *
	 * @param rows number of rows in grid
	 * @param cols number of columns in grid
	 */
	public Grid(int rows, int cols) {
		this(rows, cols, MINIMUM_SIDE);
	}

	/**
	 * Create {@link Grid} of square {@link Button}s with {@link DEFAULT_ROWS}
	 * number of rows, {@link DEFAULT_COLS} number of columns, and
	 * {@link MINIMUM_SIDE} size of square buttons.
	 */
	public Grid() {
		this(DEFAULT_ROWS, DEFAULT_COLS);
	}

	//////////////////////////////// METHODS ///////////////////////////////

	/**
	 * Return number of rows in {@link Grid}.
	 *
	 * @return number of rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Return number of columns in {@link Grid}.
	 *
	 * @return number of columns
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Return side of square {@link Button}s in {@link Grid}.
	 *
	 * @return side of square {@link Button}s
	 */
	public int getSide() {
		return side;
	}

	/**
	 * Return {@link Button} at column row <tt>row</tt> and <tt>col</tt>.
	 *
	 * @param row row of {@link Button} to find
	 * @param col column of {@link Button} to find
	 * @return {@link Button} at column <tt>col</tt> and row <tt>row</tt>,
	 * or null if no button matches "<tt>col</tt>,<tt>row</tt>"
	 */
	public Button findButton(int row, int col) {
		Component[] components = getComponents();
		for (Component component : components)
			if (component instanceof AbstractButton) {
				String ac = ((Button) component).getActionCommand();
				Point point = Button.parseActionCommand(ac);
				// Note: actionCommand is "row,col", but parsed point is (x,y).
				if (row == point.x && col == point.y)
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
		logger.info("{}.setSize: (from) {} (to) {}",
				getClass().getName(), getSize(), new Dimension(width, height));
		logger.info("({},{}) ({},{}) {} == {}?",
				width, height, rows, cols, width * rows, height * cols);
		assert width * rows == height * cols : "bad aspect ratio";
		int side = Math.max(width / cols, MINIMUM_SIDE);// side = height / rows;
		Component[] components = getComponents();
		for (Component component : components)
			if (component instanceof AbstractButton)
				component.setSize(side, side);
		validate();
		repaint();
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
		// TODO: setSize(Dimension) calls setSize(int, int) else infinite recursion
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

	/**
	 * Return {@link String} representation of <tt>this</tt>.
	 *
	 * @return {@link String} representation of <tt>this</tt>
	 */
	@Override
	public String toString() {
		return new StringBuilder()
				.append(getClass().getName()).append(":")
				.append(getSize()).append(":").append("[")
				.append(rows).append(",").append(cols).append(",")
				.append(side).append("]")
				.toString();
	}
}