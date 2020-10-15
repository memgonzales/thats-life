package controllers;

import cards.action_cards.collect_from_player.FileALawsuit;
import cards.action_cards.pay_player.Lawsuit;
import core.GameMaster;
import gui.ChoosePlayer;
import gui.MainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class providing the <b>controller</b> for the processes related to <b>choosing another player</b>
 * (during the execution of specific types of lawsuit-related action cards)
 */
public class ChoosePlayerController implements ActionListener {
    /**
     * Graphical user interface related to choosing another player
     */
    private ChoosePlayer chooseScr;
    /**
     * Graphical user interface related to the actual (main) screen of the game proper
     */
    private MainScreen mainScr;
    /**
     * Central class providing access to all the methods necessary to play the game
     */
    private GameMaster game;
    /**
     * Controller for the processes related to the main gameplay
     */
    private MainGameController mainCtrl;

    /**
     * Creates a controller object with the graphical user interface related to choosing another player and
     * the main screen, as well as the controller for the main gameplay and the central class providing
     * all the methods necessary to play the game as parameters
     *
     * @param chooseScr Graphical user interface related to choosing another player
     * @param mainScr  Graphical user interface related to the actual (main) screen of the game proper
     * @param mainCtrl Controller for the processes related to the main gameplay
     * @param game Central class providing access to all the methods necessary to play the game
     */
    public ChoosePlayerController(ChoosePlayer chooseScr, MainScreen mainScr, MainGameController mainCtrl, GameMaster game) {
        this.chooseScr = chooseScr;
        this.mainScr = mainScr;
        this.mainCtrl = mainCtrl;
        this.game = game;

        /* Make the GUI visible. */
        chooseScr.setVisible(true);

        /* Must not lose focus of the choose paths screen */
        chooseScr.setAlwaysOnTop(true);

        /* Disable buttons of the main screen while the loans screen is open. */
        mainScr.setSpinEnabled(false);

        chooseScr.setActionListener(this);
        chooseScr.setChooseEnabled(false, game.getIndexCurrPlayer());

        /* Remove retired players from the list of players that can be chosen. */
        for (int i = 0; i < game.getNumPlayers(); i++)
            if (game.isRetired(game.getIDOf(i)))
                chooseScr.setChooseEnabled(false, i);
    }

    /**
     * Invoked when an action occurs
     *
     * @param e semantic event indicative that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String otherPlayerName;         // name of the other player

        otherPlayerName = "";

        /* Identify which button was pressed. The name of the buttons correspond to the
        names of the players.
         */
        if (e.getActionCommand().equals("Choose " +  game.getPlayerNames().get(0))) {
            otherPlayerName = game.getPlayerNames().get(0);
        } else if (e.getActionCommand().equals("Choose " +  game.getPlayerNames().get(1))) {
            otherPlayerName = game.getPlayerNames().get(1);
        } else if (e.getActionCommand().equals("Choose " +  game.getPlayerNames().get(2))) {
            otherPlayerName = game.getPlayerNames().get(2);
        }

        /* Remove the screen from the display. */
        chooseScr.setVisible(false);

        /* Check if the card drawn is a Lawsuit action card. */
        if (mainCtrl.getCard() instanceof Lawsuit) {
            /* Execute the card accordingly. */
            game.executeActionCard(game.getIDOf(game.getIndexCurrPlayer()), (Lawsuit) (mainCtrl.getCard()),
                    otherPlayerName);

            /* Update the displayed details of all the players. */
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)), 0);
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)), 1);

            if (game.getNumPlayers() == 3)
                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)), 2);


            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

        } else if (mainCtrl.getCard() instanceof FileALawsuit) {
            /* Check if the card drawn is a Lawsuit action card. */

            /* Execute the card accordingly. */
            game.executeActionCard(game.getIDOf(game.getIndexCurrPlayer()), (FileALawsuit) mainCtrl.getCard(),
                    otherPlayerName);

            /* Update the displayed details of all the players. */
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)), 0);
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)), 1);

            if (game.getNumPlayers() == 3)
                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)), 2);

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
        }
    }
}
