package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Class implementing an <b>EndScreen window</b> as part of the GUI for
 * concluding the game
 */
public class EndScreen extends JFrame {
    /* Prompt telling the players the game has ended */
    private JLabel lblMessage;
    /* List of names of the players in the game */
    private  ArrayList<JLabel> lblPlayerNames;
    /* List of player details of the players in the game */
    private ArrayList<JTextArea> taPlayerStats;
    /* Scroll pane enabling scrolling for the player details */
    private JScrollPane scroll;
    /* Label for the winner of the game*/
    private JLabel lblWinner;
    /* Button for exiting the window */
    private JButton btnExit;

    /**
     * Creates an EndScreen object
     *
     * <p>As part of the larger interface of the game, this window is created at the end of the game
     * and is followed by program termination.</p>
     *
     * @param playerNames list of names of the players in the game
     * @param playerDetails list of details of the players in the game
     * @param winner name of the winner of the game
     */
    public EndScreen(ArrayList<String> playerNames, ArrayList<String> playerDetails, String winner) {

        /* The string "That's Life " is passed as the label for the title bar */
        super("That's Life!");

        /* init() is called to initialize the elements of the window */
        init(playerNames, playerDetails, winner);

        /* Additional formatting methods for the window are executed */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Initializes the elements of the EndScreen object
     *
     * <p>The object contains the final details of the players in the game and a
     * message indicating the winner (i.e., the player with the most cash).</p>
     *
     * @param playerNames names of the players in the game
     * @param playerDetails details of the players in the game
     * @param winner name of the winning player
     */
    private void init (ArrayList<String> playerNames, ArrayList<String> playerDetails, String winner) {
        /* JPanels used to arrange the window elements */
        JPanel pNorth;
        JPanel pDetails;
        JPanel pStats;
        JPanel pCenter;
        JPanel pSouth;

        /* The pNorth panel is formatted */
        pNorth = new JPanel();
        pNorth.setLayout(new BorderLayout());

        /* A player prompt is added to the panel */
        lblMessage = new JLabel("<html><center>Thank you for playing That's Life! Here are your final stats: </center></html>");
        lblMessage.setBorder(new EmptyBorder(10, 10, 10, 10));

        /* An image is added to the panel using the helper method setImage() */
        pNorth.add(setImage(), BorderLayout.NORTH);
        pNorth.add(lblMessage, BorderLayout.CENTER);

        add(pNorth, BorderLayout.NORTH);

        /* the pDetails panel is formatted */
        pDetails = new JPanel();
        pDetails.setLayout(new BoxLayout(pDetails, BoxLayout.X_AXIS));
        pDetails.setBackground(Color.pink);

        /* A list of JLabels for storing the player names is created */
        lblPlayerNames = new ArrayList<>();

        for (int i = 0; i < playerNames.size(); i++) {
            /* Each of the player names passed is stored as a label, formatted, and added to the window */
            lblPlayerNames.add(new JLabel("<html><center>" + playerNames.get(i) + "</center></html>"));
            lblPlayerNames.get(i).setBorder(new EmptyBorder(10, 10, 10, 0));

            pDetails.add(lblPlayerNames.get(i));
        }

        /* The pStats panel is formatted */
        pStats = new JPanel();
        pStats.setLayout(new BoxLayout(pStats,BoxLayout.X_AXIS));

        /* A list of JTextAreas for storing the player details is created */
        taPlayerStats = new ArrayList<>();

        for (int i = 0; i < playerDetails.size(); i++) {
            /* Each of the sets of player details is stored as a text area, formatted, and
            added to the window
            */
            taPlayerStats.add(new JTextArea(playerDetails.get(i)));
            taPlayerStats.get(i).setEditable(false);
            taPlayerStats.get(i).setLineWrap(true);
            taPlayerStats.get(i).setWrapStyleWord(true);
            taPlayerStats.get(i).setBackground(Color.pink);
            taPlayerStats.get(i).setBorder(new EmptyBorder(10, 10, 10, 0));

            pStats.add(taPlayerStats.get(i));
        }

        /* The player details are stored in a scroll pane */
        scroll = new JScrollPane(pStats);
        scroll.setBorder(null);

        /* The name of the winner is included in a message */
        lblWinner = new JLabel("<html><center>The winner is " + winner + ".</center><html>");
        lblWinner.setBorder(new EmptyBorder(10, 10, 15, 10));

        /* The pCenter label is formatted, and the window components are arranged on it */
        pCenter = new JPanel(new BorderLayout());
        pCenter.add(pDetails, BorderLayout.NORTH);
        pCenter.add(scroll, BorderLayout.CENTER);
        pCenter.add(lblWinner, BorderLayout.SOUTH);
        add(pCenter, BorderLayout.CENTER);

        /* The pSouth panel is formatted*/
        pSouth = new JPanel();
        pSouth.setLayout(new GridLayout(1, 1));

        /* A button for exiting the game is added to the window */
        btnExit = new JButton("Exit Game");

        pSouth.add(btnExit);
        add(pSouth, BorderLayout.SOUTH);
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

        /* The original image (the provided logo for the game) is retrieved and scaled */
        imageOrig = new ImageIcon(getClass().getResource("/assets/logo.png"));
        imageScaled = imageOrig.getImage().getScaledInstance(130, 60, Image.SCALE_DEFAULT);

        /* The scaled image is converted to a JLabel, further formatted, and returned */
        lblImage = new JLabel(new ImageIcon(imageScaled));
        lblImage.setBackground(Color.white);
        lblImage.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        lblImage.setBorder(new EmptyBorder(5, 5, 5, 5));
        return lblImage;
    }

    /**
     * Sets action listeners for the window
     *
     * <p>An action listener is added for the buttons in the window.</p>
     *
     * @param listener action listener for the window buttons
     */
    public void setActionListener(ActionListener listener) {
        btnExit.addActionListener(listener);
    }

    /**
     * Sets window listeners for the window
     *
     * <p>A window listener is added for the window.</p>
     *
     * @param listener window listener for the window
     */
    public void setWindowListener(WindowListener listener) {
        addWindowListener(listener);
    }
}
