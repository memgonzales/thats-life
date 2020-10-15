package controllers;

import cards.SalaryCard;
import core.GameMaster;
import gui.ChooseSalaryCard;
import gui.MainScreen;
import spaces.magenta_spaces.CollegeCareerChoice;
import spaces.magenta_spaces.JobSearch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class providing the <b>controller</b> for the processes related to <b>choosing salary cards</b>
 */
public class ChooseSalaryCardController implements ActionListener {
    /**
     * Graphical user interface related to choosing salary cards
     */
    private ChooseSalaryCard chooseScr;
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
     * Creates a controller object with the graphical user interface related to choosing salary cards and
     * the main screen, as well as the controller for the main gameplay and the central class providing
     * all the methods necessary to play the game as parameters
     *
     * @param chooseScr Graphical user interface related to choosing salary cards
     * @param mainScr Graphical user interface related to the actual screen of the game proper
     * @param mainCtrl Controller for the processes related to the main gameplay
     * @param game Central class providing access to all the methods necessary to play the game
     */
    public ChooseSalaryCardController(ChooseSalaryCard chooseScr, MainScreen mainScr, MainGameController mainCtrl, GameMaster game) {
        this.chooseScr = chooseScr;
        this.mainScr = mainScr;
        this.mainCtrl = mainCtrl;
        this.game = game;

        chooseScr.setVisible(true);

        /* Must not lose focus of the choose cards screen. */
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
        ArrayList<SalaryCard> drawnCards;                               // cards to be drawn
        drawnCards = new ArrayList<SalaryCard>(2);

        drawnCards.add((SalaryCard) mainCtrl.getCard());
        drawnCards.add((SalaryCard) mainCtrl.getOtherCard());

        /* Check if the first card is chosen. */
        if (e.getActionCommand().equals("Choose Card One")) {

            /* Check if the colored space where the player landed is a College Career Choice space. */
            if (mainCtrl.getColoredSpace() instanceof CollegeCareerChoice) {
                game.executeSalary(game.getIDOf(game.getIndexCurrPlayer()), drawnCards,
                        (CollegeCareerChoice) mainCtrl.getColoredSpace(), 0);
            } else {
                /* Execute accordingly if the colored space where the player landed is a Job Search space. */
                game.executeSalary(game.getIDOf(game.getIndexCurrPlayer()), drawnCards,
                        (JobSearch) mainCtrl.getColoredSpace(), 0);
            }

            /* Update the displayed details of all the players of the game. */
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)),
                    0);
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)),
                    1);

            if (game.getNumPlayers() == 3)
                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)),
                        2);

            /* Re-enable the pertinent buttons in the main screen. */
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

        } else if (e.getActionCommand().equals("Choose Card Two")) {
            /* Check if the second card is chosen. */

            /* Check if the colored space where the player landed is a College Career Choice space. */
            if (mainCtrl.getColoredSpace() instanceof CollegeCareerChoice) {
                game.executeSalary(game.getIDOf(game.getIndexCurrPlayer()), drawnCards,
                        (CollegeCareerChoice) mainCtrl.getColoredSpace(), 1);
            } else {
                /* Execute accordingly if the colored space where the player landed is a Job Search space. */
                game.executeSalary(game.getIDOf(game.getIndexCurrPlayer()), drawnCards,
                        (JobSearch) mainCtrl.getColoredSpace(), 1);
            }

            /* Update the displayed details of all the players of the game. */
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)),
                    0);
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)),
                    1);

            if (game.getNumPlayers() == 3)
                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)),
                        2);

            /* Re-enable the pertinent buttons in the main screen. */
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
        }

        /* Remove the screen from the display, and update the game log (since both career and salary
        cards have been drawn already).
         */
        mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
        chooseScr.setVisible(false);
    }
}
