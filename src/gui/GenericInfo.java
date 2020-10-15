package gui;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 * Class implementing a <b>GenericInfo window</b> as part of the GUI for
 * displaying game events
 */
public class GenericInfo extends JFrame {

    /**
     * Creates a GenericInfo object
     *
     * <p>As part of the larger interface of the game, this window is not always visible;
     * it is called on top of the main screen as needed.</p>
     *
     * @param message message to be displayed on the window
     * @param title name used for the title bar of the window
     * @param imgPath relative path of the image added to the window
     */
    public GenericInfo (String message, String title, String imgPath) {

        /* init() is called to initialize the elements of the window */
        init(message, title, setImage(imgPath));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initializes the elements of the GenericInfo object
     *
     * <p>The object contains a message emphasizing a game event and an associated image.</p>
     *
     * @param message message to be displayed on the window
     * @param title name used for the title bar of the window
     * @param img image added to the window
     */
    private void init(String message, String title, ImageIcon img) {
        /* The object is created as a JOptionPane */
        JOptionPane.showMessageDialog(this, message, title, INFORMATION_MESSAGE, img);
    }

    /**
     * Helper method that adds images to the window
     *
     * @param imgPath relative path of the image added to the window
     * @return scaled version of the image
     */
    private ImageIcon setImage (String imgPath) {
        /* Stores the original image */
        ImageIcon imageOrig;
        /* Stored a scaled version of the image */
        Image imageScaled;
        /* Stores a converted version of the scaled image */
        ImageIcon finalImage;

        /* The original image is retrieved, scaled, converted back into an ImageIcon object, and returned */
        imageOrig = new ImageIcon(getClass().getResource(imgPath));
        imageScaled = imageOrig.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        finalImage = new ImageIcon(imageScaled);

        return finalImage;
    }
}
