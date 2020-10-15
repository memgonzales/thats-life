package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

/**
 * Class implementing a <b>PayLoans window</b> as part of the GUI for
 * paying loans to the bank
 */
public class PayLoans extends JFrame {
    /**
     *  An informative prompt indicating instructions for the player
     */
    private JLabel tfPrompt;
    /**
     *  Text field for player input
     */
    private JTextField tfInput;
    /**
     *  Button for confirming the entered of loans
     */
    private JButton btnConfirm;
    /**
     *  Button for cancelling the action
     */
    private JButton btnCancel;

    /**
     * Creates a PayLoans object
     *
     * <p>As part of the larger interface of the game, this window is not visible persistently;
     * it is hidden when not in use and rendered visible upon appropriate player input.</p>
     */
    public PayLoans () {

        /* The string "Pay Loans" is passed as the label for the title bar */
        super("Pay Loans");

        /* init() is called to initialize the elements of the window */
        init();

        /* Additional formatting methods for the window are executed */
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(320, 160);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Initializes the elements of the PayLoans object
     *
     * <p>The object contains a text prompt for the player, a text field for player input,
     * and confirm and cancel buttons.</p>
     */
    private void init() {
        /* JPanels used to arrange the window elements */
        JPanel pBody;
        JPanel pSouth;

        /* The pBody panel is formatted */
        pBody = new JPanel();
        pBody.setLayout(new FlowLayout());
        pBody.setBackground(new Color(142, 229, 238));
        pBody.setBorder(new EmptyBorder(10, 10, 0, 10));

        /* A player prompt is added to the panel */
        tfPrompt = new JLabel("<html><center>Enter the number of loans you wish to pay:</center></html>");
        tfPrompt.setBorder(new EmptyBorder(0, 0, 5, 0));
        pBody.add(tfPrompt);

        /* A text field for player input is added to the panel */
        tfInput = new JTextField(10);
        pBody.add(tfInput);

        add(pBody, BorderLayout.CENTER);

        /* The pSouth panel is formatted */
        pSouth = new JPanel();
        pSouth.setLayout(new FlowLayout());
        pSouth.setBackground(new Color(142, 229, 238));

        /* Buttons for confirming and cancelling the action are added to the panel */
        btnConfirm = new JButton("Pay");
        btnCancel = new JButton("Cancel");
        pSouth.add(btnConfirm);
        pSouth.add(btnCancel);
        add(pSouth, BorderLayout.SOUTH);
    }

    /**
     * Sets action listeners for the window
     *
     * <p>Two action listeners are added, one for each of the buttons in the window.</p>
     *
     * @param listener action listener for the window buttons
     */
    public void setActionListener(ActionListener listener) {
        btnConfirm.addActionListener(listener);
        btnCancel.addActionListener(listener);
    }

    /**
     * Sets window listeners for the window
     *
     * <p>One window listener is added for the window.</p>
     *
     * @param listener window listener for the window
     */
    public void setWindowListener(WindowListener listener) {
        addWindowListener(listener);
    }

    /**
     * Sets document listeners for the window
     *
     * <p>One document listener is added for the window.</p>
     *
     * @param listener document listener for the text field
     */
    public void setDocumentListener(DocumentListener listener) {
        tfInput.getDocument().addDocumentListener(listener);
    }

    /**
     * Returns the number of loans entered by the player
     *
     * <p>The input in the text field is returned.</p>
     *
     * @return the player input in the text field
     */
    public String getNumLoans() {
        return tfInput.getText();
    }

    /**
     * Clears the text field input
     *
     * <p>The input in the text field is reset to a blank input.</p>
     */
    public void clearTfInput() {
        tfInput.setText("");
    }

    /**
     * Enables the confirm button
     *
     * <p>The confirm button is made clickable or non-clickable.</p>
     *
     * @param isEnabled <code>true</code> if the button is to be enabled;
     *                  <code>false</code>, otherwise
     */
    public void setConfirmEnabled(boolean isEnabled) {
        btnConfirm.setEnabled(isEnabled);
    }
}
