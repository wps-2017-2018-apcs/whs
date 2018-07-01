/*
 * Image.java
 */
package minesweeper;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import org.apache.logging.log4j.*;

/**
 * {@link Images} is an <code>enum</code> that encodes 12 {@link Minesweeper}
 * images.
 *
 * @author 2017-2018 APCS
 * @author <a href="https://github.com/wps-dpetty">David C. Petty</a>
 */
public enum Images {

    /** The enum associated with a covered square. */
    COVER("/images/minesweeper-cover.svg-600x600.png"),
    /** The enum associated with a blank square. */
    BLANK("/images/minesweeper-blank.svg-600x600.png"),
    /** The enum associated with a flagged square. */
    FLAG("/images/minesweeper-flag.svg-600x600.png"),
    /** The enum associated with a mined square. */
    MINE("/images/minesweeper-mine.svg-600x600.png"),
    /** The enum associated with a square with 1 mine touching it. */
    NUMBER1("/images/1.svg-600x600.png"),
    /** The enum associated with a square with 2 mines touching it. */
    NUMBER2("/images/2.svg-600x600.png"),
    /** The enum associated with a square with 3 mines touching it. */
    NUMBER3("/images/3.svg-600x600.png"),
    /** The enum associated with a square with 4 mines touching it. */
    NUMBER4("/images/4.svg-600x600.png"),
    /** The enum associated with a square with 5 mines touching it. */
    NUMBER5("/images/5.svg-600x600.png"),
    /** The enum associated with a square with 6 mines touching it. */
    NUMBER6("/images/6.svg-600x600.png"),
    /** The enum associated with a square with 7 mines touching it. */
    NUMBER7("/images/7.svg-600x600.png"),
    /** The enum associated with a square with 8 mines touching it. */
    NUMBER8("/images/8.svg-600x600.png");

    //////////////////////////////// FIELDS ////////////////////////////////

    /**
     * The pathname for {@link Image} to be displayed.
     */
    private final String path;
    /**
     * The {@link Image} to be displayed.
     */
    private final Image image;

    ///////////////////////////// CONSTRUCTORS /////////////////////////////

    /**
     * Construct enum and {@link Image} to be displayed associated with
     * <code>path</code>.
     *
     * @param path pathname for {@link Image} to be displayed
     * @pre.cond <code>path</code> is not <code>null</code>
     * @pre.cond <code>path</code> is a valid pathname for an image file
     */
    private Images(String path) {
        this.path = path;
        this.image = getImage(path);
    }

    //////////////////////////////// METHODS ///////////////////////////////

    /**
     * Return pathname for {@link Image} to be displayed.
     *
     * @return pathname for {@link Image} to be displayed
     */
    public String path() {
        return path;
    }

    /**
     * Return {@link Image} to be displayed.
     *
     * @return {@link Image} to be displayed
     */
    public Image image() {
        return image;
    }

    /**
     * Return {@link Image} associated with <code>path</code>.
     *
     * @param path pathname for {@link Image}
     * @return {@link Image} associated with <code>path</code>
     * @pre.cond <code>path</code> is not <code>null</code>
     * @pre.cond <code>path</code> is a valid pathname for an image file
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
