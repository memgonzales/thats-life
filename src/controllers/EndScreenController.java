package controllers;

import core.GameMaster;
import gui.EndScreen;
import gui.MainScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Class providing the <b>controller</b> for the processes related to the <b>end screen of the game,
 * where the final stats of the players alongside the winner are displayed</b>
 */
public class EndScreenController implements ActionListener, WindowListener {
    /**
     * Graphical user interface for the end screen of the game, where the final stats of the players
     * alongside the winner are displayed
     */
    private EndScreen displayScr;
    /**
     * Graphical user interface related to the actual (main) screen of the game proper
     */
    private MainScreen mainScr;
    /**
     * Central class providing access to all the methods necessary to play the game
     */
    private GameMaster game;

    /**
     * Creates a controller object with the graphical user interface related to the end screen and
     * the main screen, as well as the game master as parameters
     *
     * @param displayScr Graphical user interface for the end screen of the game
     * @param mainScr Graphical user interface related to the actual (main) screen of the game proper
     * @param game game master (providing access to all the methods
     *             necessary to play the game)
     */
    public EndScreenController(EndScreen displayScr, MainScreen mainScr, GameMaster game) {
        this.displayScr = displayScr;
        this.mainScr = mainScr;
        this.game = game;

        /* Make the GUI visible. */
        displayScr.setVisible(true);

        /* Must not lose focus of the end screen */
        displayScr.setAlwaysOnTop(true);
        displayScr.setActionListener(this);
        displayScr.setWindowListener(this);

        /* Note that, by the time the end screen is displayed, all the buttons in the main
        screen have been disabled (since all the players have reached retirement).
         */
    }

    /**
     * Invoked when the user attempts to close the window from the window's system menu
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowClosing(WindowEvent e) {
        int confirm;            // response to the confirmation dialog

        /* Display a confirmation prompt. */
        confirm = JOptionPane.showConfirmDialog(displayScr, "Are you sure you want to exit That's Life?",
                "Quit", JOptionPane.YES_NO_OPTION);

        /* End the game if the player's response is affirmative. Otherwise, the game is not ended. */
        switch (confirm) {
            case JOptionPane.YES_OPTION:
                /* End the game (EXIT_ON_CLOSE). */
                displayScr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                break;
            case JOptionPane.NO_OPTION:
                displayScr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                displayScr.setAlwaysOnTop(true);
                break;
        }
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
        if (e.getActionCommand().equals("Exit Game")) {
            /* Display the confirmatory prompt, and exit the game if affirmative response is received. */
            displayScr.dispatchEvent(new WindowEvent(displayScr, WindowEvent.WINDOW_CLOSING));
        }
    }

}
