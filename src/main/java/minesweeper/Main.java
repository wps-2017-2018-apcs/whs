/*
 * Main.java
 */
package minesweeper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import java.util.*;
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

    static int row = 16, col = 30;
    static int mines = 99;

    static JPanel topPanel = new JPanel();

    static JLabel labelTimer = new JLabel("00:00");
    static javax.swing.Timer mainTimer;
    static Stopwatch sw;
    static JLabel mineCount = new JLabel("0" + mines);
    static ImageIcon smileicon = new ImageIcon("smile.gif");
    static JButton smile = new JButton(smileicon);

    private static final SimpleDateFormat sdfTimer  = new SimpleDateFormat("mm:ss");
    private static int currentSecond;
    private static Calendar calendar;

    GridLayout experimentLayout = new GridLayout(row, col);

    public Main(String name) {
        super(name);
        logger.info("{}: {}", getClass(), name);
        setResizable(false);
    }

    public void createGrid(final Container pane) {
        final JPanel addTiles = new JPanel();
        addTiles.setLayout(experimentLayout);
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {   
                Tile tile = new Tile(i, j);
                tile.setPreferredSize(new Dimension(20, 20));
                addTiles.add(tile);
            }
        }

        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(addTiles, BorderLayout.SOUTH);
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        Main frame = new Main("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelTimer.setFont(new Font("Verdana", 1, 20));
        mineCount.setFont(new Font("Verdana", 1, 20));
        smile.setPreferredSize(new Dimension(24, 24)); 

        topPanel.setLayout(new BorderLayout((col * 10), 0));
        topPanel.add(mineCount, BorderLayout.WEST);
        topPanel.add(smile);
        topPanel.add(labelTimer, BorderLayout.EAST);

        topPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EmptyBorder(0, 0, 0, 0)));

        sw = new Stopwatch();

        frame.getContentPane().add(topPanel, BorderLayout.NORTH);  
        //Set up the content pane.
        frame.createGrid(frame.getContentPane());       
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void startTimer(boolean resetTimer) {
        //resetTimer();
        if (resetTimer || (!sw.isStopWatchRunning())) 
        {
            sw.startStopWatch();
            mainTimer = new javax.swing.Timer(100, new ActionListener(){
                public void actionPerformed( ActionEvent e ) {
                    labelTimer.setText(sw.getFormattedElapsedTime());
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
