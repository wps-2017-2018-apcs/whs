/*
 * Main.java
 */
package minesweeper;

import java.awt.*;
import java.awt.event.*;
//import java.awt.image.*;
import javax.swing.*;
//import javax.swing.border.*;
//import java.text.*;
//import java.util.*;
import org.apache.logging.log4j.*;

/**
 * DESCRIBE {@link Main} HERE.
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author David C. Petty // https://github.com/wps-dpetty
 */
public class Main extends JFrame {
    /** log4j {@link Logger}. */
    private static Logger logger = LogManager.getLogger(Minesweeper.SHORT);

    private static int row = 16, col = 30;
    private static int mines = 99;

    private static Stopwatch sw;
    private static JLabel timerLabel;
    private static Grid grid;

    // RED_FLAG: these fields are not used
    // private static final SimpleDateFormat sdfTimer  = new SimpleDateFormat("mm:ss");
    // private static int currentSecond;
    // private static Calendar calendar;

    //GridLayout experimentLayout = new GridLayout(row, col);

    public Main(String name) {
        super(name);
        sw = new Stopwatch();
        logger.info("{}: {}", getClass(), name);
    }

    public static Grid getGrid() { return grid; }

    private static void createAndShowGUI() {
        //Create and set up the window.
        Main frame = new Main("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridBagLayout());
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
        frame.getContentPane().add(mineCount, c);
  
        // Display smile.
        Image image = Images.getImage("/images/felix.gif");
        ImageIcon smileicon = new ImageIcon(image);
        JButton smile = new JButton(smileicon);
        //smile.setPreferredSize(new Dimension(35, 35));
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 10;
        c.weightx = 0.5;
        frame.getContentPane().add(smile, c);

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
        frame.getContentPane().add(timerLabel, c);

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
        frame.getContentPane().add(separator, c);  

        // Display grid.
        grid = new Grid(row, col);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.SOUTH;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 0;
        c.gridwidth = 3;
        c.weightx = 0.5;
        frame.getContentPane().add(grid, c);  

        //Display the window.
        frame.pack();
        frame.setMinimumSize(frame.getSize());  // layout will not get smaller
        frame.setVisible(true);
    }

    public static void startTimer(boolean resetTimer) {
        //resetTimer();
        if (resetTimer || (!sw.isStopWatchRunning())) 
        {
            sw.startStopWatch();// Traditionally Stopwatch is only started after the first click on the grid...
            javax.swing.Timer mainTimer = new javax.swing.Timer(100, new ActionListener(){
                public void actionPerformed( ActionEvent e ) {
                    timerLabel.setText(sw.getFormattedElapsedTime());
                }
            });
            mainTimer.start();
        }      
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
