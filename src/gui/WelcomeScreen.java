package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class implementing the <b>graphical user interface</b> for the <b>welcome screen</b>
 * at the start of the game
 */
public class WelcomeScreen extends JFrame {
    /**
     * Button for the two-player mode
     */
    private JButton btnTwoPlayers;
    /**
     * Button for the three-player mode
     */
    private JButton btnThreePlayers;

    /**
     * Left image (design)
     */
    private ImageIcon leftImage;
    /**
     * Right image (design)
     */
    private ImageIcon rightImage;
    /**
     * Logo of That's Life!
     */
    private ImageIcon logo;


    /**
     * JLabel containing the scaled version of the right image
     */
    private JLabel lblRightImage;
    /**
     * JLabel containing the scaled version of the logo
     */
    private JLabel lblLogoScaled;
    /**
     * JLabel containing the scaled version of the left image
     */
    private JLabel lblLeftImage;
    /**
     * JLabel containing the text (main prompts) displayed at the center of the screen
     */
    private JLabel lblCenterText;

    /**
     * Constructor for the graphical user interface of the welcome screen at the start of the game
     */
    public WelcomeScreen() {
        super("That's Life!");

        /* Use Border layout. */
        setLayout(new BorderLayout());
        init();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 210);
        setLocationRelativeTo(null);
        setVisible(true);           // The welcome screen is visible right from the start.
        setResizable(false);
    }

    /**
     * Initializes the contents and layout of this graphical user interface
     */
    private void init () {
        JPanel pSouth;              // South panel for the buttons
        JPanel pCenter;             // Center panel for the text (main prompt)


        /* CONSTRUCT THE SOUTH PANEL (for the buttons). */
        pSouth = new JPanel();

        /* The south panel uses Flow layout to position the buttons. */
        pSouth.setLayout(new FlowLayout());
        pSouth.setBackground(Color.pink);

        /* Create the buttons for choosing the number of players. */
        btnTwoPlayers = new JButton("2 Players");
        btnThreePlayers = new JButton("3 Players");

        /* Add the buttons to the south panel. */
        pSouth.add(btnTwoPlayers);
        pSouth.add(btnThreePlayers);

        /* Position the south panel in the overall Border layout. */
        add(pSouth, BorderLayout.SOUTH);


        /* ADD THE LEFT IMAGE (design). */
        Image leftImageScaled;       // Scaled version of the left image

        leftImage = new ImageIcon(getClass().getResource("/assets/board1.png"));
        leftImageScaled = leftImage.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        /* Create the JLabel to contain the scaled version of the image. */
        lblLeftImage = new JLabel(new ImageIcon(leftImageScaled));
        lblLeftImage.setBackground(Color.white);

        /* Add some left padding for the left image. */
        lblLeftImage.setBorder(new EmptyBorder(0, 20, 0, 0));

        /* Position in the overall Border layout. */
        add(lblLeftImage, BorderLayout.WEST);


        /* ADD THE LEFT IMAGE (design). */
        Image rightImageScaled;         // Scaled version of the right image

        rightImage = new ImageIcon(getClass().getResource("/assets/board2.png"));
        rightImageScaled = rightImage.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        /* Create the JLabel to contain the scaled version of the image. */
        lblRightImage = new JLabel(new ImageIcon(rightImageScaled));
        lblRightImage.setBackground(Color.white);

        /* Add some right padding for right image. */
        lblRightImage.setBorder(new EmptyBorder(0, 0, 0, 20));

        /* Position in the overall Border layout. */
        add(lblRightImage, BorderLayout.EAST);


        /* CONSTRUCT THE CENTER PANEL FOR LOGO AND CENTER TEXT (PROMPT). */
        pCenter = new JPanel();

        /* Add some top padding for the logo. */
        pCenter.setBorder(new EmptyBorder(17, 0, 10, 0));

        /* The center panel uses Border Layout for its elements. */
        pCenter.setLayout(new BorderLayout());

        /* Position the center panel in the overall Border layout. */
        add(pCenter, BorderLayout.CENTER);

        /* Add logo. */
        Image logoScaled;

        logo = new ImageIcon(getClass().getResource("/assets/logo.png"));
        logoScaled = logo.getImage().getScaledInstance(130, 60, Image.SCALE_DEFAULT);

        /* Create the JLabel to contain the scaled version of the logo. */
        lblLogoScaled = new JLabel(new ImageIcon(logoScaled));
        lblLogoScaled.setBackground(Color.white);

        /* Position in the Border layout of the center panel (logo is on top). */
        pCenter.add(lblLogoScaled, BorderLayout.NORTH);

        /* Add center text (prompt). */
        lblCenterText  = new JLabel("<html><center>Choose the number of players " +
                "<br/>for this game</center></html>", SwingConstants.CENTER);

        /* Position in the Border layout of the center panel. */
        pCenter.add(lblCenterText, BorderLayout.CENTER);
    }

    /**
     * Sets the action listener for the buttons in this graphical user interface
     *
     * @param listener action listener receiving action events
     */
    public void setActionListener(ActionListener listener) {
        btnTwoPlayers.addActionListener(listener);
        btnThreePlayers.addActionListener(listener);
    }
}
