package gui;

import core.GameMaster;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class implementing the <b>graphical user interface</b> for the <b>screen asking for
 * the usernames of the players at the start of the game</b>
 */
public class InitPlayerNames extends JFrame {
    /**
     * Confirmatory button that usernames have been entered
     */
    private JButton btnConfirm;
    /**
     * JLabel for the prompt asking the players to input their usernames
     */
    private JLabel lblInputNames;
    /**
     * JLabel for the scaled version of the That's Life! logo
     */
    private JLabel lblLogoScaled;

    /**
     * ArrayList of JPanel for the area where the usernames are entered
     */
    private ArrayList<JPanel> pPlayers;
    /**
     * ArrayList of JLabel indicating the player number (starting with Player 1)
     */
    private ArrayList<JLabel> lblPlayerNums;
    /**
     * ArrayList of JTextField where the usernames are entered
     */
    private ArrayList<JTextField> tfPlayerNames;

    /**
     * Logo of That's Life!
     */
    private ImageIcon logo;

    /**
     * Constructor for the graphical user interface for the screen asking for the usernames
     * of the players of the game
     *
     * @param numPlayers number of players
     */
    public InitPlayerNames(int numPlayers) {
        super("That's Life!");

        /* Use Border layout. */
        setLayout(new BorderLayout());

        init(numPlayers);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(375, 300);
        setLocationRelativeTo(null);
        setVisible(false);
        setResizable(false);
    }

    /**
     * Initializes the contents and layout of this graphical user interface
     *
     * @param numPlayers number of players
     */
    private void init (int numPlayers) {
        JPanel pSouth;          // South panel for the button
        JPanel pNorth;          // North panel for the logo and prompt
        JPanel pCenter;         // Center panel for the actual text fields


        /* CONSTRUCT THE SOUTH PANEL */
        pSouth = new JPanel();

        /* The south panel uses Flow layout for the button. */
        pSouth.setLayout(new FlowLayout());
        pSouth.setBackground(Color.pink);

        /* Create the confirmatory button. */
        btnConfirm = new JButton("Let's Play");

        /* The user is not allowed to click the button if no username has been entered. */
        btnConfirm.setEnabled(false);

        /* Add the button to the south panel. */
        pSouth.add(btnConfirm);

        /* Position the south panel in the overall Border layout. */
        add(pSouth, BorderLayout.SOUTH);


        /* CONSTRUCT THE NORTH PANEL FOR LOGO AND PROMPT. */
        pNorth = new JPanel();
        pNorth.setBorder(new EmptyBorder(20, 0, 20, 0));

        /* The North panel uses Border layout for the logo and prompt. */
        pNorth.setLayout(new BorderLayout());

        /* Add logo. */
        Image logoScaled;

        logo = new ImageIcon(getClass().getResource("/assets/logo.png"));
        logoScaled = logo.getImage().getScaledInstance(130, 60, Image.SCALE_DEFAULT);

        /* Create the JLabel to contain the scaled version of the logo. */
        lblLogoScaled = new JLabel(new ImageIcon(logoScaled));
        lblLogoScaled.setBackground(Color.white);

        /* Position in the Border layout of the north panel (logo is on top). */
        pNorth.add(lblLogoScaled, BorderLayout.NORTH);

        /* Add prompt. */
        lblInputNames = new JLabel("Enter your usernames", SwingConstants.CENTER);

        /* Position in the Border layout of the north panel (logo is on top). */
        pNorth.add(lblInputNames, BorderLayout.CENTER);

        /* Position the north panel in the overall Border layout. */
        add(pNorth, BorderLayout.NORTH);


        /* CONSTRUCT THE CENTER PANEL FOR THE TEXT FIELDS. */
        pCenter = new JPanel();

        /* The center panel uses a Box Layout, with components displayed from top to bottom. */
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));

        /* ArrayLists for the components of the center panel */
        pPlayers = new ArrayList<JPanel>(GameMaster.MAX_NUM_PLAYERS);
        lblPlayerNums = new ArrayList<JLabel>(GameMaster.MAX_NUM_PLAYERS);
        tfPlayerNames = new ArrayList<JTextField>(GameMaster.MAX_NUM_PLAYERS);

        /* The number of panels (inclusive of labels and text fields) displayed depends
        on the number of players specified
         */
        for (int i = 0; i < numPlayers; i++) {
            pPlayers.add(new JPanel());

            /* Each panel uses Flow layout for the label (player number) and text field. */
            pPlayers.get(i).setLayout(new FlowLayout());
            pPlayers.get(i).setMaximumSize(new Dimension(400, 30));

            /* Player number and text field */
            lblPlayerNums.add(new JLabel("Player " + (i + 1)));
            tfPlayerNames.add(new JTextField(15));

            /* Add the label (player number) and text field to the panel. */
            pPlayers.get(i).add(lblPlayerNums.get(i));
            pPlayers.get(i).add(tfPlayerNames.get(i));

            /* Position the panel in the Box Layout of the center panel. */
            pCenter.add(pPlayers.get(i));
        }

        /* Position the center panel in the overall Border layout. */
        add(pCenter, BorderLayout.CENTER);
    }

    /**
     * Sets the action listener for the button in this graphical user interface
     *
     * @param listener action listener receiving action events
     */
    public void setActionListener(ActionListener listener) {
        btnConfirm.addActionListener(listener);
    }

    /**
     * Sets the document listener for the text fields where the usernames of the players
     * are entered
     *
     * @param listener document listener receiving document events
     */
    public void setDocumentListener(DocumentListener listener) {
        /* Add a listener for each text field. */
        for (int i = 0; i < tfPlayerNames.size(); i++)
            tfPlayerNames.get(i).getDocument().addDocumentListener(listener);
    }

    /**
     * Enables (or disables) the confirmatory button depending on the <code>
     * boolean</code> parameter passed
     *
     * @param isEnabled <code>true</code> if the confirmatory button is to be enabled;
     *                  <code>false</code>, otherwise
     */
    public void setConfirmEnabled(boolean isEnabled) {
        btnConfirm.setEnabled(isEnabled);
    }

    /**
     * Returns the usernames entered in the text fields
     *
     * @return <code>ArrayList</code> of the usernames entered in the text fields
     */
    public ArrayList<String> getPlayerNames() {
        /* Usernames of the players */
        ArrayList<String> playerNames;
        playerNames = new ArrayList<String>(GameMaster.MAX_NUM_PLAYERS);

        /* Iterate through all the text fields. */
        for (int i = 0; i < pPlayers.size(); i++)
            playerNames.add(tfPlayerNames.get(i).getText());

        return playerNames;
    }

    /**
     * Clears a specified text field (that is, sets its contents to an empty string)
     *
     * @param index index of the text field to be cleared
     */
    public void clearTfPlayerName(int index) {
        /* Clear the text field by setting its contents to an empty string. */
        tfPlayerNames.get(index).setText("");
    }
}

