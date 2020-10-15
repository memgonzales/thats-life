package controllers;

import core.GameMaster;
import gui.ChooseHouse;
import gui.MainScreen;
import spaces.magenta_spaces.BuyAHouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class providing the <b>controller</b> for the processes related to <b>choosing a house (on a Buy House space)</b>
 */
public class ChooseHouseController implements ActionListener {
    /**
     * Graphical user interface related to choosing a house (on a Buy House space)
     */
    private ChooseHouse chooseScr;
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
     * Creates a controller object with the graphical user interface related to choosing a house and
     * the main screen, as well as the controller for the main gameplay and the central class providing
     * all the methods necessary to play the game as parameters
     *
     * @param chooseScr Graphical user interface related to choosing a house
     * @param mainScr Graphical user interface related to the actual screen of the game proper
     * @param mainCtrl Controller for the processes related to the main gameplay
     * @param game Central class providing access to all the methods necessary to play the game
     */
    public ChooseHouseController(ChooseHouse chooseScr, MainScreen mainScr, MainGameController mainCtrl, GameMaster game) {
        this.chooseScr = chooseScr;
        this.mainScr = mainScr;
        this.mainCtrl = mainCtrl;
        this.game = game;

        /* Make the GUI visible. */
        chooseScr.setVisible(true);

        /* Must not lose focus of the choose house screen */
        chooseScr.setAlwaysOnTop(true);

        /* Disable buttons of the main screen while the loans screen is open. */
        mainScr.setSpinEnabled(false);

        chooseScr.setActionListener(this);
    }

    /**
     * Invoked when an action occurs
     *
     * @param e semantic event indicative that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        /* Iterate through all the available house cards to check which button was pressed. */
        for (int i = 0; i < mainCtrl.getHouseCards().size(); i++) {

            /* If the button pressed has been identified, then perform the pertinent commands.
            Note that the names of the buttons are the names of the houses.
             */
            if (e.getActionCommand().equals(mainCtrl.getHouseCards().get(i).getName())) {

                /* Execute the instructions specified upon landing a Buy House space. */
                game.executeBuyHouse(game.getIDOf(game.getIndexCurrPlayer()), mainCtrl.getHouseCards(),
                        (BuyAHouse) mainCtrl.getColoredSpace(), i);

                /* Remove the screen from the display. */
                chooseScr.setVisible(false);

                /* Update the displayed details of all the players of the game. */
                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)),
                        0);
                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)),
                        1);

                if (game.getNumPlayers() == 3)
                    mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)),
                            2);

                /* Re-enable all the pertinent buttons, and update the game log. */
                mainScr.enableAllButtonsExceptGo();
                mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
                mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
            }
        }
    }
}
