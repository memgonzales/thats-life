package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class implementing a <b>SpinWheel window</b> as part of the GUI for
 * asking the player to spin the number wheel
 */
public class SpinWheel extends JFrame {
    /**
     * Prompt instructing the player to spin the wheel
     */
    private JLabel lblMessage;
    /**
     * Button for spinning the wheel
     */
    private JButton btnSpin;

    /**
     * Creates a SpinWheel object
     *
     * <p>As part of the larger interface of the game, this window cannot be closed without proper player input;
     * it remains visible until the player presses the spin button.</p>
     *
     * @param title title of the window
     * @param message message to be displayed on the window
     */
    public SpinWheel (String title, String message) {
        /* The passed parameter title is passed as the label for the title bar */
        super(title);
        setLayout(new BorderLayout());

        /* init() is called to initialize the elements of the window */
        init(message);

        /* Additional formatting methods for the window are executed */
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(139, 0, 139), 8));

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Initializes the elements of the SpinWheel object
     *
     * <p>The object contains a text prompt for the player and a button for spinning the wheel.</p>
     *
     * @param message message to be displayed on the window
     */
    private void init(String message) {
        /* JPanel for arranging the elements of the window */
        JPanel pMain;

        /* The pMain panel is formatted */
        pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.X_AXIS));
        pMain.setBackground(new Color(142, 229, 238));

        /* The passed message is stored as a JLabel */
        lblMessage = new JLabel("<html><center>" + message + "</html></center>");
        lblMessage.setBorder(new EmptyBorder(10, 10, 10, 10));

        /* A wheel image and the passed message are added to the window */
        pMain.add(setImage());
        pMain.add(lblMessage);

        add(pMain, BorderLayout.CENTER);

        /* A button for spinning the wheel is added to the window */
        btnSpin = new JButton("Spin Wheel");
        add(btnSpin, BorderLayout.SOUTH);
    }

    /**
     * Helper method that adds images to the window
     *
     * @return formatted version of the image
     */
    private JLabel setImage () {
        /* Stores the original image */
        ImageIcon imageOrig;
        /* Stores a scaled version of the image */
        Image imageScaled;
        /* Stores a formatted version of the image to be displayed on the window */
        JLabel lblImage;

        /* The original image (that of a spinning wheel) is retrieved and scaled */
        imageOrig = new ImageIcon(getClass().getResource("/assets/wheel.png"));
        imageScaled = imageOrig.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);

        /* The scaled image is converted to a JLabel, further formatted, and returned */
        lblImage = new JLabel(new ImageIcon(imageScaled));
        lblImage.setBackground(Color.white);
        lblImage.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        lblImage.setBorder(new EmptyBorder(10, 10, 10, 10));

        return lblImage;
    }

    /**
     * Sets action listeners for the window
     *
     * <p>One action listener is added to the window.</p>
     *
     * @param listener action listener for the window buttons
     */
    public void setActionListener(ActionListener listener) {
        btnSpin.addActionListener(listener);
    }
}
