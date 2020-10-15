package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class implementing a <b>ChoosePlayer window</b> as part of the GUI for
 * choosing another player
 */
public class ChoosePlayer extends JFrame {
    /**
     *  List of buttons for choosing the players in the game
     */
    private ArrayList<JButton> btnChoices;
    /**
     *  Prompt indicating instructions for the player
     */
    private JLabel lblMessage;

    /**
     * Creates a ChoosePlayer object
     *
     * <p>As part of the larger interface of the game, this window cannot be closed without proper player input;
     * it remains visible until the player presses one of the buttons.</p>
     *
     * @param title title of the window
     * @param message message containing player instructions
     * @param names list of names of the players
     */
    public ChoosePlayer (String title, String message, ArrayList<String> names) {

        /* The passed parameter title is passed as the label for the title bar */
        super(title);

        /* Additional formatting methods for the window are executed */
        setLayout(new BorderLayout());

        /* init() is called to initialize the elements of the window */
        init(message, names);

        /* Additional formatting methods for the window are executed */
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(139, 0, 139), 8));

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Initializes the elements of the ChoosePlayer object
     *
     * <p>The object contains buttons for each of the players in the game.</p>
     *
     * @param message prompt indicating instructions for the player
     * @param names list of names of the players in the game
     */
    private void init(String message, ArrayList<String> names) {
        /* JPanels used to arrange the window elements */
        JPanel pMain;
        JPanel pBox;

        /* A new array list is created for the JButtons */
        btnChoices = new ArrayList<>();

        /* The pMain panel is formatted */
        pMain = new JPanel();
        pMain.setLayout(new BorderLayout());
        pMain.setBackground(new Color(142, 229, 238));

        /* The pBox panel is formatted; it can hold at most three elements (corresponding to
        the maximum number of players in the game)
        */
        pBox = new JPanel();
        pBox.setLayout(new GridLayout(3, 1));
        pBox.setBackground(new Color(142, 229, 238));
        pBox.setBorder(new EmptyBorder(10, 40, 10, 40));

        /* The player prompt is formatted and added to the window */
        lblMessage = new JLabel("<html><center>" + message + "</center></html>");
        lblMessage.setBorder(new EmptyBorder(10, 10, 10, 10));
        pMain.add(lblMessage);
        add (pMain, BorderLayout.NORTH);

        /* The names of each of the players in the game are used to create the
        window buttons
        */
        for (int i = 0; i < names.size(); i++) {
            btnChoices.add(new JButton("Choose " + names.get(i)));
            pBox.add(btnChoices.get(i));
        }

        /* The panel containing the window buttons is added to the window */
        add(pBox, BorderLayout.CENTER);
    }


    /**
     * Enables a button at a particular index
     *
     * <p>One of the window buttons is made clickable.</p>
     *
     * @param isEnabled boolean value enabling or disabling the button
     * @param index index of the button to be made clickable
     */
    public void setChooseEnabled(boolean isEnabled, int index) {
        btnChoices.get(index).setEnabled(isEnabled);
    }

    /**
     * Sets action listeners for the window
     *
     * <p>Action listeners are added for each of the buttons in the window.</p>
     *
     * @param listener action listener for the window buttons
     */
    public void setActionListener(ActionListener listener) {
        for (int i = 0; i < btnChoices.size(); i++)
            btnChoices.get(i).addActionListener(listener);
    }
}
