package gui;

import javax.swing.*;

import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 * Class implementing the <b>graphical user interface</b> for the <b>error dialog
 * displayed when an invalid number of loans is entered by the player</b>
 */
public class ErrorDialogLoan extends JFrame {
    /**
     * Constructor for the graphical user interface for the error dialog
     * displayed when an invalid number of loans is entered by the player
     *
     * @param title title of the window
     * @param msg message to be displayed on the window
     */
    public ErrorDialogLoan (String title, String msg) {
        init(title, msg);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
    }

    /**
     * Initializes the contents and layout of this graphical user interface
     *
     * @param title title of the window
     * @param msg message to be displayed on the window
     */
    private void init(String title, String msg) {
        /* Use a JOptionPane for non-obtrusive, minimalistic popup display of warning message. */
        JOptionPane.showMessageDialog(this, msg, title, WARNING_MESSAGE);
    }
}