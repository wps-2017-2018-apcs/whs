/*
 * Image.java
 */
package minesweeper;

import java.awt.*;
//import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
//import java.nio.file.*;
import javax.imageio.*;
//import javax.swing.*;
//import java.util.*;
import org.apache.logging.log4j.*;

/**
 * DESCRIBE {@link Images} HERE.
 *
 * @author 2017-2018 APCS
 * @author ADD @author TAG FOR EVERYONE WHO CONTRIBUTED TO THIS FILE
 * @author David C. Petty // https://github.com/wps-dpetty
 */
public class Images {

    //////////////////////////////// FIELDS ////////////////////////////////

    /** log4j {@link Logger}. */
    private static Logger logger = LogManager.getLogger(Minesweeper.SHORT);
    /** Path to the flag image file.*/
    private static final String FLAG_PATH = "/images/Minesweeper_bomb-600x600.svg.png";
    /** Path to the bomb image file.*/
    private static final String BOMB_PATH = "/images/Minesweeper_bomb-600x600.svg.png";       
    /** The {@link BufferedImage} to be displayed when a flag. */
    private static Image flagImage;
    /** The {@link BufferedImage} to be displayed when a flag. */
    private static Image bombImage;

    static {
        flagImage = getImage(FLAG_PATH);
        bombImage = getImage(BOMB_PATH);        
    }
    ///////////////////////////// CONSTRUCTORS /////////////////////////////

    public static Image getImage(String path) {
        BufferedImage image = null;
        try {
            InputStream is = Images.class.getResourceAsStream(path);
            image = ImageIO.read(is);
        } catch (IOException e) {
            logger.error("{}: {}", Images.class, e);
        }
        if (image != null)
            logger.info("{}: {} ({},{})",
                Images.class, path, image.getWidth(), image.getHeight());
        return image;
    }

    //////////////////////////////// METHODS ///////////////////////////////

    /** Return logger for this {@link Image}.
     * @return logger for this {@link Image}
     */
    public static Logger getLogger() { return logger; }
    /** Return {@link Image} for flag.
     * @return Return {@link Image} for flag
     */
    public static Image getFlagImage() { return flagImage; }
    /** Return Return {@link Image} for bomb.
     * @return Return {@link Image} for flag
     */
    public static Image getBombImage() { return bombImage; }
}
