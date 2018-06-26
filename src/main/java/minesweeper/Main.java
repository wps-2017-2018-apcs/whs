/*
 * Main.java
 */
package minesweeper;

import java.awt.*;
import java.awt.event.*;
//import java.awt.image.*;
//import javax.imageio.*;
import javax.swing.*;
//import javax.swing.border.*;
//import java.text.*;
//import java.io.*;
import java.util.*;

import org.apache.logging.log4j.*;

/**
 * DESCRIBE {@link Main} HERE.
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author <a href="https://github.com/wps-dpetty">David C. Petty</a>
 */
public class Main extends JFrame {

    //////////////////////////////// FIELDS ////////////////////////////////

    /**
     * log4j {@link Logger}.
     */
    private static Logger logger = LogManager.getLogger(Minesweeper.SHORT);
    /**
     * Number of rows in grid.
     */
    private static int rows;
    /**
     * Number of cols in grid.
     */
    private static int cols;
    /**
     * Number of mines in grid.
     */
    private static int mines;

    /**
     * {@link Stopwatch} <strong>FOR WHAT?</strong>
     */
    private static Stopwatch sw;

    /**
     * Single {@link JPanel} in main {@link JFrame} so as to accurately
     * calculate drawing area.
     */
    private static JPanel panel;
    /**
     * {@link JLabel} to display timer.
     */
    private static JLabel timerLabel;
    /**
     * {@link Grid} of {@link Button}s.
     */
    private static Grid grid;

    ///////////////////////////// CONSTRUCTORS /////////////////////////////

    /**
     * Construct a {@link Main} frame.
     *
     * @param name  frame title
     * @param rows  number of rows in grid
     * @param cols  number of columns in grid
     * @param mines number of mines in grid
     */
    public Main(String name, int rows, int cols, int mines) {
        super(name);
        Main.rows = rows;
        Main.cols = cols;
        Main.mines = mines;
        logger.info("{}: {} ({}x{}) {}",
                getClass().getName(), name, rows, cols, mines);
    }

    //////////////////////////////// CLASSES ///////////////////////////////

    /**
     * PanelListener listens for resize events and adjusts grid accordingly.
     */
    private static class PanelListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            // Log layoutDimensions from GridBagLayout to help calculate resize.
            GridBagLayout layout = (GridBagLayout) panel.getLayout();
            int[][] dims = layout.getLayoutDimensions();
            int xSum = 0, ySum = 0;
            for (int i = 0; i < dims[0].length; i++) xSum += dims[0][i];
            for (int j = 0; j < dims[1].length; j++) ySum += dims[1][j];
            int igw = grid.getCols() * grid.getSide();  // initial grid width
            int igh = grid.getRows() * grid.getSide();  // initial grid height
            double rgw = xSum;                          // reset grid width
            double rgh = dims[1][2] + panel.getHeight() - ySum; // reset grid height
            logger.info("{} {} ({},{}) [{}x{} {}x{}: {} {}]",
                    e, Arrays.deepToString(dims), xSum, ySum, igw, igh, rgw, rgh,
                    rgw / grid.getCols(), rgh / grid.getRows());
            // Calculate minimum square button size & set grid size accordingly.
            int side = (int) Math.min(rgw / grid.getCols(), rgh / grid.getRows());
            grid.setSize(side * grid.getCols(), side * grid.getRows());
        }
    }

    //////////////////////////////// METHODS ///////////////////////////////

    /**
     * Return {@link Grid} component.
     *
     * @return grid component
     */
    public static Grid getGrid() {
        return grid;
    }

    /**
     * Create and show main graphical user interface.
     */
    private static void createAndShowGUI() {
        // Create and set up the window frame.
        // REDFLAG: mines should be a function of level, rows, and cols
        Main frame = new Main("Minesweeper", 16, 30, 99);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use single JPanel in frame to get full width & height.
        panel = new JPanel();
        panel.addComponentListener(new PanelListener());

        // Initialize panel layout.
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        // Display mineCount.
        JLabel mineCount = new JLabel("0" + mines, SwingConstants.CENTER);
        mineCount.setFont(new Font("Verdana", 1, 20));
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 10;
        c.weightx = 0.5;
        panel.add(mineCount, c);

        // Display smile.
        Image image = Images.getImage("/images/smiley1.jpeg");
        ImageIcon icon = new ImageIcon(image);
        Dimension size = new Dimension(icon.getIconWidth(), icon.getIconHeight());
        JButton smile = new JButton(icon);
        smile.setPreferredSize(size);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 10;
        c.weightx = 0.5;
        panel.add(smile, c);

        sw = new Stopwatch();// initialize sw

        // Display timerLabel.
        timerLabel = new JLabel("00:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Verdana", 1, 20));
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.ipadx = 10;
        c.weightx = 0.5;
        panel.add(timerLabel, c);

        // Display separator.
        JSeparator separator = new JSeparator();
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 0;
        c.gridwidth = 3;
        c.weightx = 0.5;
        panel.add(separator, c);

        // Display grid.
        grid = new Grid(rows, cols);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.SOUTH;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 0;
        c.gridwidth = 3;
        c.weightx = 0.5;
        panel.add(grid, c);

        // Display frame.
        frame.add(panel);
        frame.pack();
        frame.setMinimumSize(frame.getSize());  // layout will not get smaller
        frame.setVisible(true);
    }

    public static void startTimer(boolean resetTimer) {
        //resetTimer();
        if (resetTimer || (!sw.isStopWatchRunning())) {
            sw.startStopWatch();// Traditionally Stopwatch is only started after the first click on the grid...
            javax.swing.Timer mainTimer = new javax.swing.Timer(100, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    timerLabel.setText(sw.getFormattedElapsedTime());
                }
            });
            mainTimer.start();
        }
    }

    public  static void youDied() {
        Main frame = new Main("Minesweeper", 16, 30, 99);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use single JPanel in frame to get full width & height.
        panel = new JPanel();
        panel.addComponentListener(new PanelListener());

        // Initialize panel layout.
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        // Display dead emoticon.
        Image image = Images.getImage("/images/youLost1.jpeg");
        ImageIcon icon = new ImageIcon(image);
        Dimension size = new Dimension(icon.getIconWidth(), icon.getIconHeight());
        JButton smile = new JButton(icon);
        smile.setPreferredSize(size);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 10;
        c.weightx = 0.5;
        panel.add(smile, c);
    }

    /**
     * Minesweeper main method.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
