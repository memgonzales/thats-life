package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Class implementing a <b>JPanelWithBG</b>, used to set the background for the
 * board of the game
 */
public class JPanelWithBG extends JPanel {
    /* Attribute holding the image to be used as the background */
    private Image background;

    /**
     * Creates a JPanelWithBG object
     *
     * <p>The given image icon to be used as the background is scaled according
     * to the width and height passed as parameters.</p>
     *
     * @param background the image icon to be used as the background
     * @param imageWidth the width with which the image is to be scaled
     * @param imageHeight the height with which the image is to be scaled
     */
    public JPanelWithBG(ImageIcon background, int imageWidth, int imageHeight) {
        /* A scaled instance of the passed image icon is used as the background */
        this.background = background.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
    }

    /**
     * Draws the passed background image onto the panel
     *
     * @param g graphics object used to draw the image
     */
    @Override
    public void paintComponent(Graphics g) {
        /* paintComponent() and drawImage() are used to draw the background image
        onto the JPanel
        */
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
    }
}
