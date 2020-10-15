package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class implementing a <b>ChooseSalaryCard window</b> as part of the GUI for
 * choosing a salary card
 */
public class ChooseSalaryCard extends JFrame {
    /* Text area and button for the first salary card */
    private JTextArea taOne;
    private JButton btnOne;

    /* Text area and button for the second salary card */
    private JTextArea taTwo;
    private JButton btnTwo;

    /* Prompt indicating instructions for the player */
    private JLabel lblPrompt;

    /**
     * Creates a ChooseSalaryCard object
     *
     * <p>As part of the larger interface of the game, this window cannot be closed without proper player input;
     * it remains visible until the player presses one of the buttons.</p>
     *
     * @param prompt player instructions displayed in the window
     * @param nameCardOne name of the first salary card
     * @param statsOne details of the first salary card
     * @param nameCardTwo name of the second salary card
     * @param statsTwo details of the second salary card
     */
    public ChooseSalaryCard (String prompt, String nameCardOne, String statsOne, String nameCardTwo, String statsTwo) {

        /* The string "Choose a Card" is passed as the label for the title bar */
        super("Choose A Card");
        setLayout(new BorderLayout());

        /* init() is called to initialize the elements of the window */
        init(prompt, statsOne, statsTwo);

        /* Additional formatting methods for the window are executed */
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(139, 0, 139), 8));

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(false);
    }

    /**
     * Initializes the elements of the ChooseSalaryCard object
     *
     * <p>The object contains a text prompt for the player and two text areas and buttons
     * for choosing a salary card.</p>
     *
     * @param prompt instructions for the player
     * @param statsOne details of the first salary card
     * @param statsTwo details of the second salary card
     */
    private void init(String prompt, String statsOne, String statsTwo) {
        /* JPanels used to arrange the window elements */
        JPanel pLeft;
        JPanel pRight;
        JPanel pBox;
        JPanel pSouth;
        JPanel pNorth;

        /* The pNorth panel is formatted */
        pNorth = new JPanel();
        pNorth.setLayout(new FlowLayout());
        pNorth.setBackground(new Color(142, 229, 238));

        /* A player prompt is added to the panel */
        lblPrompt = new JLabel("<html><center>" + prompt + "</center></html>");
        pNorth.add(lblPrompt);
        add (pNorth, BorderLayout.NORTH);

        /* The pBox panel is formatted */
        pBox = new JPanel();
        pBox.setLayout(new BoxLayout(pBox, BoxLayout.X_AXIS));
        pBox.setBackground(new Color(142, 229, 238));

        /* The pLeft panel is formatted */
        pLeft = new JPanel();
        pLeft.setLayout(new FlowLayout());
        pLeft.setBorder(new EmptyBorder(10, 5, 5, 5));
        pLeft.setOpaque(false);

        /* The details of the first salary card are formatted and added to pLeft */
        taOne = new JTextArea(statsOne);
        taOne.setLineWrap(true);
        taOne.setWrapStyleWord(true);
        taOne.setEditable(false);
        taOne.setOpaque(false);
        pLeft.add(taOne);
        pBox.add(pLeft);

        /* The pRight panel is formatted */
        pRight = new JPanel();
        pRight.setLayout(new FlowLayout());
        pRight.setBorder(new EmptyBorder(10, 5, 5, 5));
        pRight.setOpaque(false);

        /* The details of the second salary card are formatted and added to pRight */
        taTwo = new JTextArea(statsTwo);
        taTwo.setLineWrap(true);
        taTwo.setWrapStyleWord(true);
        taTwo.setEditable(false);
        taTwo.setOpaque(false);
        pRight.add(taTwo);
        pBox.add(pRight);

        add(pBox, BorderLayout.CENTER);

        /* The pSouth panel is formatted */
        pSouth = new JPanel();
        pSouth.setLayout(new GridLayout(1, 2));

        /* Buttons for each of the salary cards is added to pSouth */
        btnOne = new JButton("Choose Card One");
        pSouth.add(btnOne);

        btnTwo = new JButton("Choose Card Two");
        pSouth.add(btnTwo);

        add(pSouth, BorderLayout.SOUTH);
    }

    /**
     * Sets action listeners for the window
     *
     * <p>Two action listeners are added, one for each of the buttons in the window.</p>
     *
     * @param listener action listener object for the window buttons
     */
    public void setActionListener(ActionListener listener) {
        btnOne.addActionListener(listener);
        btnTwo.addActionListener(listener);
    }
}
