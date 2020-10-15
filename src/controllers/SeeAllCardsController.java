package controllers;

import core.GameMaster;
import gui.MainScreen;
import gui.SeeAllCards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Class providing the <b>controller</b> for the processes related to <b>displaying all the
 * cards of all the players</b>: salary and career cards at the start of the game
 */
public class SeeAllCardsController implements ActionListener, WindowListener {
    /**
     * Graphical user interface for displaying all the cards of the players
     */
    private SeeAllCards displayScr;
    /**
     * Graphical user interface related to the actual (main) screen of the game proper
     */
    private MainScreen mainScr;
    /**
     * Central class providing access to all the methods necessary to play the game
     */
    private GameMaster game;

    /**
     * Creates a controller object with the graphical user interface related to displaying all the cards of the players
     * and the game master as parameters
     *
     * @param displayScr Graphical user interface related to displaying all the cards of the players
     * @param mainScr Graphical user interface related to the actual screen of the game proper
     * @param game game master (providing access to all the methods
     *             necessary to play the game)
     */
    public SeeAllCardsController(SeeAllCards displayScr, MainScreen mainScr, GameMaster game) {
        this.displayScr = displayScr;
        this.mainScr = mainScr;
        this.game = game;

        /* Disable buttons of the main screen while the cards screen is open. */
        displayScr.setVisible(true);
        mainScr.disableAllButtons();

        /* Must not lose focus of the cards screen */
        displayScr.setAlwaysOnTop(true);
        displayScr.setWindowListener(this);
        displayScr.setActionListener(this);
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
     * Invoked when the user attempts to close the window from the window's system menu
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowClosing(WindowEvent e) {
        /* Close the cards screen, and enable all pertinent buttons in the main screen. */
        displayScr.setVisible(false);


        mainScr.disableAllButtons();
        mainScr.setSpinEnabled(true);
        mainScr.setBorrowEnabled(true);
        mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
        mainScr.setDisplayBtnsEnabled(true);

        /* Update the displayed details of all the players of the game. */
        mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(game.getIndexCurrPlayer())),
                game.getIndexCurrPlayer());

        mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(game.getIndexCurrPlayer())),
                game.getIndexCurrPlayer());
        mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)),
                0);
        mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)),
                1);

        if (game.getNumPlayers() == 3)
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)),
                    2);
    }

    /**
     * Invoked when an action occurs
     *
     * @param e semantic event indicative that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OK")) {
            /* Close the cards screen, and enable all pertinent buttons in the main screen. */
            displayScr.setVisible(false);

            mainScr.disableAllButtons();
            mainScr.setSpinEnabled(true);
            mainScr.setBorrowEnabled(true);
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.setDisplayBtnsEnabled(true);

            /* Update the displayed details of all the players of the game. */
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(game.getIndexCurrPlayer())),
                    game.getIndexCurrPlayer());

            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(game.getIndexCurrPlayer())),
                    game.getIndexCurrPlayer());
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)),
                    0);
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)),
                    1);

            if (game.getNumPlayers() == 3)
                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)),
                        2);
        }
    }
}
