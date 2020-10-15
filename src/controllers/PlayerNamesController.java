package controllers;

import core.GameMaster;
import core.Player;
import gui.ErrorDialogPlayerNames;
import gui.InitPlayerNames;
import gui.MainScreen;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Class providing the <b>controller</b> for the processes related to <b>asking for the
 * usernames of the players</b> at the start of the game
 */
public class PlayerNamesController implements ActionListener, DocumentListener {
    /**
     * Graphical user interface related to asking for the usernames of the players
     */
    private InitPlayerNames playerNamesScr;
    /**
     * Central class providing access to all the methods necessary to play the game
     */
    private GameMaster game;

    /**
     * Creates a controller object with the graphical user interface related to asking
     * for the usernames of the players at the start of the game and the game master
     * as parameters
     *
     * @param playerNamesScr Graphical user interface related to asking for the usernames
     *                       of the players at the start of the game
     * @param game game master (providing access to all the methods
     *             necessary to play the game)
     */
    public PlayerNamesController(InitPlayerNames playerNamesScr, GameMaster game) {
        this.playerNamesScr = playerNamesScr;
        this.game = game;

        playerNamesScr.setActionListener(this);
        playerNamesScr.setDocumentListener(this);

        /* Make the GUI visible. */
        playerNamesScr.setVisible(true);
    }

    /**
     * Invoked when an action occurs
     *
     * @param e semantic event indicative that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /* Check if the user clicked the "Let's Play" confirmatory button. */
        if (e.getActionCommand().equals("Let's Play")) {
            ArrayList<String> playerNames;          // Usernames of the players
            playerNames = playerNamesScr.getPlayerNames();

            /* Check if all the usernames entered are unique and valid.

            If they are not unique or valid, then the user is prompted to correct the
            invalid input, until all usernames entered are unique and valid.
             */
            if (areValidUniqueUsernames(playerNames)) {
                /* Set the players in the game master. */
                game.setPlayers(playerNames);
                game.setPlayerTurns();
                game.setIndexCurrPlayer();

                /* Hide the present display. */
                playerNamesScr.setVisible(false);

                /* Proceed to the main screen of the game proper. */
                MainScreen mainScr;
                mainScr = new MainScreen(game.getPlayerNames());

                MainGameController mainCtrl;
                mainCtrl = new MainGameController(mainScr, game);


            }
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
        /* Allow user to confirm entered usernames. */
        playerNamesScr.setConfirmEnabled(true);
    }

    /**
     * Gives notification that there was an insert into the document
     *
     * @param e document event corresponding to a document change
     */
    @Override
    public void insertUpdate(DocumentEvent e) {
        /* Allow user to confirm entered usernames. */
        playerNamesScr.setConfirmEnabled(true);
    }

    /**
     * Returns <code>true</code> if all the usernames entered are valid
     * and unique; <code>false</code>, otherwise
     *
     * <p>In particular, a username is considered valid if and only if it contains at
     * least one non-whitespace character (that is, invalidating a username that consists
     * only of spaces or is an empty string). </p>
     *
     * <p>This method also displays a prompt to notify the user that an invalid
     * username has been entered and clears the text fields corresponding to duplicated
     * usernames (that is, the second or third instance are cleared) or to usernames
     * consisting only of whitespace characters. </p>
     *
     * @param playerNames usernames of the players
     * @return <code>true</code> if all the usernames entered are valid amd unique;
     * <code>false</code>, otherwise
     */
    public boolean areValidUniqueUsernames(ArrayList<String> playerNames) {
        /* Check if there are duplicates or blank entries among the usernames entered. */
        HashSet<String> uniquePlayerNames;      // Hash set for checking for duplicates
        int ctr;                                // Counter variable

        uniquePlayerNames = new HashSet<String>(playerNames.size());
        ctr = 0;

        /* Iterate through all the usernames entered. */
        for (int i = 0; i < playerNames.size(); i++) {
            /* Reject blank usernames. */
            if (!Player.isValidName(playerNames.get(i))) {
                /* Display the error dialog only once. */
                if (ctr == 0) {
                    ErrorDialogPlayerNames errPane;
                    errPane = new ErrorDialogPlayerNames();
                    ctr++;
                }

                /* Clear the text field corresponding to a username consisting only
                of whitespace characters.
                 */
                playerNamesScr.clearTfPlayerName(i);
            } else if (!uniquePlayerNames.add(playerNames.get(i).toUpperCase())) {
                /* Display the error dialog only once. */
                if (ctr == 0) {
                    ErrorDialogPlayerNames errPane;
                    errPane = new ErrorDialogPlayerNames();
                    ctr++;
                }

                /* Clear the text field corresponding to the duplicate. */
                playerNamesScr.clearTfPlayerName(i);
            }
        }

        /* All the usernames entered are valid and unique. */
        if (ctr == 0)
            return true;

        return false;
    }
}
