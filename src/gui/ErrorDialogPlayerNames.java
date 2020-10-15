package gui;

import javax.swing.*;

import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 * Class implementing the <b>graphical user interface</b> for the <b>error dialog
 * displayed when invalid or duplicate usernames are entered by the
 * players</b>
 */
public class ErrorDialogPlayerNames extends JFrame {
    /**
     * Constructor for the graphical user interface for the error dialog
     * displayed when invalid or duplicate usernames are entered by the players
     */
    public ErrorDialogPlayerNames () {
        init();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initializes the contents and layout of this graphical user interface
     */
    private void init() {
        /* Use a JOptionPane for non-obtrusive, minimalistic popup display of warning message. */
        JOptionPane.showMessageDialog(this, "Please enter a valid" +
                " and unique username.", "Invalid username", WARNING_MESSAGE);
    }
}
