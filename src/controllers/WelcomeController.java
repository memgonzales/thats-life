package controllers;

import core.GameMaster;
import gui.InitPlayerNames;
import gui.WelcomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class providing the <b>controller</b> for the processes related to <b>welcoming the
 * players to the game and asking for the number of players</b>
 */
public class WelcomeController implements ActionListener {
    /**
     * Graphical user interface for the welcome screen
     */
    private WelcomeScreen welcomeScr;
    /**
     * Central class providing access to all the methods necessary to play the game
     */
    private GameMaster game;

    /**
     * Number of players
     */
    private int numPlayers;

    /**
     * Creates a controller object with the welcome screen GUI and the
     * game master as parameters
     *
     * @param welcomeScr graphical user interface of the welcome screen
     * @param game game master (providing access to all the methods
     *             necessary to play the game)
     */
    public WelcomeController(WelcomeScreen welcomeScr, GameMaster game) {
        this.welcomeScr = welcomeScr;
        this.game = game;

        welcomeScr.setActionListener(this);
    }

    /**
     * Invoked when an action occurs
     *
     * @param e semantic event indicative that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /* Set the number of players depending on the button clicked. */
        if (e.getActionCommand().equals("2 Players"))
            numPlayers = 2;
        else if (e.getActionCommand().equals("3 Players"))
            numPlayers = 3;

        /* Hide the present display. */
        welcomeScr.setVisible(false);

        /* Proceed to ask for the player usernames. This is chained to the pertinent controller. */
        InitPlayerNames playerNamesScr;
        playerNamesScr = new InitPlayerNames(numPlayers);

        PlayerNamesController playerNamesCtrl;
        playerNamesCtrl = new PlayerNamesController(playerNamesScr, game);
    }

    /**
     * Returns the number of players specified by the user
     *
     * @return number of players specified by the user
     */
    public int getNumPlayers() {
        return numPlayers;
    }
}