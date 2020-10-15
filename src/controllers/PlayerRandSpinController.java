package controllers;

import cards.BlueCard;
import cards.blue_cards.ComputerRepair;
import cards.blue_cards.TipTheServer;
import core.GameMaster;
import gui.MainScreen;
import gui.SpinWheel;
import spaces.magenta_spaces.GetMarried;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class providing the <b>controller</b> for the processes related to <b>spinning the wheel
 * in order to dictate the amount received by a player on specific spaces or when a specific
 * blue card is drawn</b>
 */
public class PlayerRandSpinController implements ActionListener {
    /**
     * Graphical user interface related to spinning the wheel on a specific space or upon
     * drawing a specific card
     */
    private SpinWheel spinScr;
    /**
     * Graphical user interface related to the actual (main) screen of the game proper
     */
    private MainScreen mainScr;
    /**
     * Controller for the processes related to the main gameplay
     */
    private MainGameController mainCtrl;
    /**
     * Central class providing access to all the methods necessary to play the game
     */
    private GameMaster game;

    /**
     * Creates a controller object with the graphical user interface related to spinning the wheel and
     * the main screen, as well as the controller for the main gameplay and the central class providing
     * all the methods necessary to play the game as parameters
     *
     * @param spinScr Graphical user interface related to spinning the wheel
     * @param mainScr Graphical user interface related to the actual (main) screen of the game proper
     * @param mainCtrl Controller for the processes related to the main gameplay
     * @param game Central class providing access to all the methods necessary to play the game
     */
    public PlayerRandSpinController(SpinWheel spinScr, MainScreen mainScr, MainGameController mainCtrl, GameMaster game) {
        this.spinScr = spinScr;
        this.mainScr = mainScr;
        this.mainCtrl = mainCtrl;
        this.game = game;

        /* Make the GUI visible. */
        spinScr.setVisible(true);

        /* Must not lose focus of the choose paths screen */
        spinScr.setAlwaysOnTop(true);

        /* Disable buttons of the main screen while the loans screen is open. */
        mainScr.setSpinEnabled(false);

        spinScr.setActionListener(this);
    }

    /**
     * Invoked when an action occurs
     *
     * @param e semantic event indicative that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Spin Wheel")) {
            int randNum;                    // random number spun

            /* Remove the screen from the display. */
            spinScr.setVisible(false);

            /* Spin the wheel to obtain a random number. */
            randNum = game.spinWheel(game.getIDOf(game.getIndexCurrPlayer()));

            /* Animate the wheel spinning, and update the game log. */
            mainScr.highlightWheel(randNum);
            mainScr.setActiveWheelX(randNum);
            mainScr.setActiveWheelY(randNum);
            mainScr.addToLog(game.spinMessage(randNum));

            /* Check if the wheel was spun as the effect of drawing a card. */
            if (mainCtrl.getSpinComponent() == MainGameController.SPIN_COMPONENT_CARD) {

                /* The player drew a Tip the Server blue card. */
                if (mainCtrl.getCard() instanceof TipTheServer) {
                    int displayFlag;            // represents the execution of the blue card

                    /* Execute the card accordingly. */
                    displayFlag = game.executeBlueCard(game.getIDOf(game.getIndexCurrPlayer()), (TipTheServer) mainCtrl.getCard(),
                            randNum);

                    /* Update the displayed details of all the players. */
                    mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)), 0);
                    mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)), 1);

                    if (game.getNumPlayers() == 3)
                        mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)), 2);

                    /* Update the game log. */
                    mainScr.addToLog(game.getBlueInfo((BlueCard)mainCtrl.getCard(), displayFlag));

                    /* TURN OF THE NEXT PLAYER (signal the next player to turn through the game log). */
                    game.switchTurn();
                    mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));

                } else if (mainCtrl.getCard() instanceof ComputerRepair) {
                    /* The player drew a Computer Repair blue card. */

                    int displayFlag;            // represents the execution of the blue card

                    /* Execute the card accordingly. */
                    displayFlag = game.executeBlueCard(game.getIDOf(game.getIndexCurrPlayer()), (ComputerRepair) mainCtrl.getCard(),
                            randNum);

                    /* Update the displayed details of all the players. */
                    mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)), 0);
                    mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)), 1);

                    if (game.getNumPlayers() == 3)
                        mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)), 2);

                    /* Update the game log. */
                    mainScr.addToLog(game.getBlueInfo((BlueCard)mainCtrl.getCard(), displayFlag));

                    /* TURN OF THE NEXT PLAYER (signal the next player to turn through the game log). */
                    game.switchTurn();
                    mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
                }

                /* Re-enable all the pertinent buttons. */
                mainScr.enableAllButtonsExceptGo();
                mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

            } else if (mainCtrl.getSpinComponent() == MainGameController.SPIN_COMPONENT_SPACE) {
                /* Check if the wheel was spun as the effect of landing on a space. */

                /* The player landed on a Get Married magenta space. */
                if (mainCtrl.getColoredSpace() instanceof GetMarried) {
                    /* Execute the instructions in the space accordingly. */
                    game.executeMagentaSpace(game.getIDOf(game.getIndexCurrPlayer()), (GetMarried) mainCtrl.getColoredSpace(),
                            randNum);

                    /* Update the displayed details of all the players. */
                    mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)), 0);
                    mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)), 1);

                    if (game.getNumPlayers() == 3)
                        mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)), 2);
                }

                /* NO SWITCHING OF TURNS since this is a magenta space */

                /* Update the game log, and re-enable all the pertinent buttons. */
                mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
                mainScr.enableAllButtonsExceptGo();
                mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
            }
        }
    }
}
