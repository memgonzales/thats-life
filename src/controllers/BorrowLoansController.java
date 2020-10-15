package controllers;

import core.GameMaster;
import gui.BorrowLoans;
import gui.ErrorDialogLoan;
import gui.GenericInfo;
import gui.MainScreen;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Class providing the <b>controller</b> for the processes related to <b>borrowing loans</b>
 */
public class BorrowLoansController implements ActionListener, DocumentListener, WindowListener {
    /**
     * Graphical user interface related to borrowing loans
     */
    private BorrowLoans loansScr;
    /**
     * Graphical user interface related to the actual (main) screen of the game proper
     */
    private MainScreen mainScr;
    /**
     * Central class providing access to all the methods necessary to play the game
     */
    private GameMaster game;

    /**
     * Creates a controller object with the graphical user interface related to borrowing
     * loans and the game master as parameters
     *
     * @param loansScr Graphical user interface related to borrowing loans
     * @param mainScr Graphical user interface related to the actual screen of the game proper
     * @param game game master (providing access to all the methods
     *             necessary to play the game)
     */
    public BorrowLoansController(BorrowLoans loansScr, MainScreen mainScr, GameMaster game) {
        this.loansScr = loansScr;
        this.mainScr = mainScr;
        this.game = game;

        /* Make the GUI visible. */
        loansScr.setVisible(true);

        /* Must not lose focus of the loans screen */
        loansScr.setAlwaysOnTop(true);

        /* Disable buttons of the main screen while the loans screen is open. */
        mainScr.setSpinEnabled(false);
        /* Disable confirm button until an input is placed on the number of loans text field. */
        loansScr.setConfirmEnabled(false);

        loansScr.setActionListener(this);
        loansScr.setDocumentListener(this);
        loansScr.setWindowListener(this);
    }

    /**
     * Invoked when the user attempts to close the window from the window's system menu
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowClosing(WindowEvent e) {
        /* Close the loans screen, and enable all pertinent buttons in the main screen. */
        loansScr.setVisible(false);

        mainScr.disableAllButtons();
        mainScr.setSpinEnabled(true);
        mainScr.setBorrowEnabled(true);
        mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
        mainScr.setDisplayBtnsEnabled(true);
    }

    /**
     * Invoked when the Window is set to be the active Window
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowActivated(WindowEvent e) {

    }

    /**
     * Invoked when a window has been closed as the result of calling dispose on the window
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowClosed(WindowEvent e) {

    }

    /**
     * Invoked when a window is no longer the active window
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a minimized to a normal state
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a normal to a minimized state
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }

    /**
     * Invoked when a window is made visible
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     * Invoked when an action occurs
     *
     * @param e semantic event indicative that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Borrow")) {
            int numLoans;               // number of loans
            boolean isNumber;           // true if the input is a number; false, otherwise

            isNumber = false;
            numLoans = 0;

            /* Perform error handling to prevent non-integer inputs. */
            try {
                numLoans = Integer.parseInt(loansScr.getNumLoans());
                isNumber = true;
            } catch (NumberFormatException error) {
                /* Clear the text field, and display an error message. */
                loansScr.clearTfInput();

                loansScr.setAlwaysOnTop(false);
                ErrorDialogLoan errScr;
                errScr = new ErrorDialogLoan("Borrow Loan", "Must be a whole number");
                loansScr.setAlwaysOnTop(true);
            }

            /* Display an error message if the number of loans is negative */
            if (isNumber && numLoans < 0) {
                /* Clear the text field. */
                loansScr.clearTfInput();

                /* Make room for the error message. */
                loansScr.setAlwaysOnTop(false);

                ErrorDialogLoan errScr;
                errScr = new ErrorDialogLoan("Borrow Loan", "Must not be less than 0");
                loansScr.setAlwaysOnTop(true);
            } else if (isNumber && numLoans >= 0) {
                /* Allow the player to borrow the specified number of loans. */
                game.borrowLoan(game.getIDOf(game.getIndexCurrPlayer()), numLoans);
                loansScr.setVisible(false);

                /* Enable all pertinent buttons in the main screen after removing the loans screen from display. */
                mainScr.disableAllButtons();
                mainScr.setSpinEnabled(true);
                mainScr.setDisplayBtnsEnabled(true);

                /* Display information message. */
                GenericInfo info;
                info = new GenericInfo("Your cash is now " + game.getCash(game.getIDOf(game.getIndexCurrPlayer())),
                        "New Cash Amount", "/assets/salaryIcon.png");

                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(game.getIndexCurrPlayer())),
                        game.getIndexCurrPlayer());

            }
        } else if (e.getActionCommand().equals("Cancel")) {
            /* Remove the loans screen from display. */
            loansScr.setVisible(false);

            /* Re-enable all the pertinent buttons in the main screen. */
            mainScr.disableAllButtons();
            mainScr.setSpinEnabled(true);
            mainScr.setBorrowEnabled(true);
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.setDisplayBtnsEnabled(true);
        }
    }

    /**
     * Gives notification that an attribute or set of attributes changed
     *
     * @param e document event corresponding to a document change
     */
    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    /**
     * Gives notification that a portion of the document has been removed
     *
     * @param e document event corresponding to a document change
     */
    @Override
    public void removeUpdate(DocumentEvent e) {
        loansScr.setConfirmEnabled(true);
    }

    /**
     * Gives notification that there was an insert into the document
     *
     * @param e document event corresponding to a document change
     */
    @Override
    public void insertUpdate(DocumentEvent e) {
        loansScr.setConfirmEnabled(true);
    }
}
