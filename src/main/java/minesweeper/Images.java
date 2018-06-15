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
public enum Images {

    COVER("/images/minesweeper-cover.svg-600x600.png"),
    FLAG("/images/minesweeper-flag.svg-600x600.png"),
    MINE("/images/minesweeper-mine.svg-600x600.png"),
    NUMBER1("/images/1.svg-600x600.png"),
    NUMBER2("/images/2.svg-600x600.png"),
    NUMBER3("/images/3.svg-600x600.png"),
    NUMBER4("/images/4.svg-600x600.png"),
    NUMBER5("/images/5.svg-600x600.png"),
    NUMBER6("/images/6.svg-600x600.png"),
    NUMBER7("/images/7.svg-600x600.png"),
    NUMBER8("/images/8.svg-600x600.png");

    //////////////////////////////// FIELDS ////////////////////////////////

    /** The pathname for {@link BufferedImage} to be displayed. */
    private final String path;
    /** The {@link BufferedImage} to be displayed. */
    private final Image image;

    ///////////////////////////// CONSTRUCTORS /////////////////////////////

    private Images(String path) {
        this.path = path;
        this.image = getImage(path);
    }

    //////////////////////////////// METHODS ///////////////////////////////

    /** Return pathname for {@link BufferedImage} to be displayed.
     * @return pathname for {@link BufferedImage} to be displayed
     */
    public String path() { return path; }
    /** Return pathname for {@link BufferedImage} to be displayed.
     * @return pathname for {@link BufferedImage} to be displayed
     */
    public Image image() { return image; }

    /** Return {@link Image} associated with path.
     * @param path pathname for {@link BufferedImage}
     * @return {@link Image} associated with path
     */
    public static Image getImage(String path) {
        // log4j Logger cannot be a field of this enum.
        Logger logger = LogManager.getLogger(Minesweeper.SHORT);
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
}
