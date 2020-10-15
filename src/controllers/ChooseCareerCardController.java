package controllers;

import cards.CareerCard;
import cards.SalaryCard;
import core.GameMaster;
import gui.ChooseCareerCard;
import gui.ChooseSalaryCard;
import gui.MainScreen;
import spaces.magenta_spaces.CollegeCareerChoice;
import spaces.magenta_spaces.JobSearch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class providing the <b>controller</b> for the processes related to <b>choosing career cards</b>
 */
public class ChooseCareerCardController implements ActionListener {
    /**
     * Graphical user interface related to choosing career cards
     */
    private ChooseCareerCard chooseScr;
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
     * Creates a controller object with the graphical user interface related to choosing career cards and
     * the main screen, as well as the controller for the main gameplay and the central class providing
     * all the methods necessary to play the game as parameters
     *
     * @param chooseScr Graphical user interface related to choosing career cards
     * @param mainScr Graphical user interface related to the actual screen of the game proper
     * @param mainCtrl Controller for the processes related to the main gameplay
     * @param game Central class providing access to all the methods necessary to play the game
     */
    public ChooseCareerCardController(ChooseCareerCard chooseScr, MainScreen mainScr, MainGameController mainCtrl, GameMaster game) {
        this.chooseScr = chooseScr;
        this.mainScr = mainScr;
        this.mainCtrl = mainCtrl;
        this.game = game;

        /* Make the GUI visible. */
        chooseScr.setVisible(true);

        /* Must not lose focus of the choose cards screen */
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
        ArrayList<CareerCard> drawnCards;                               // cards to be drawn
        drawnCards = new ArrayList<CareerCard>(2);

        drawnCards.add((CareerCard) mainCtrl.getCard());
        drawnCards.add((CareerCard) mainCtrl.getOtherCard());

        /* Check if the first card is chosen. */
        if (e.getActionCommand().equals("Choose Card One")) {

            /* Check if the colored space where the player landed is a College Career Choice space. */
            if (mainCtrl.getColoredSpace() instanceof CollegeCareerChoice) {
                game.executeCareer(game.getIDOf(game.getIndexCurrPlayer()), drawnCards,
                        (CollegeCareerChoice) mainCtrl.getColoredSpace(), 0);
            } else {
                /* Execute accordingly if the colored space where the player landed is a Job Search space. */
                game.executeCareer(game.getIDOf(game.getIndexCurrPlayer()), drawnCards,
                        (JobSearch) mainCtrl.getColoredSpace(), 0);
            }

            /* Update the displayed details of all the players of the game. */
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)), 0);
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)), 1);

            if (game.getNumPlayers() == 3)
                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)), 2);


            /* LAUNCH THE SCREEN FOR THE CHOOSING OF SALARY CARDS. */
            ChooseSalaryCard chooseScr;                 // GUI related to the choosing of salary cards
            ChooseSalaryCardController chooseCtrl;      // controller related to the choosing of salary cards

            ArrayList<SalaryCard> drawnSalaryCards;     // cards to be drawn

            /* Check if the colored space where the player landed is a College Career Choice */
            if (mainCtrl.getColoredSpace() instanceof CollegeCareerChoice) {
                /* Draw the two salary cards from which the player will pick. */
                drawnSalaryCards = game.drawSalaryCards(game.getIDOf(game.getIndexCurrPlayer()),
                        (CollegeCareerChoice) mainCtrl.getColoredSpace());
            } else {
                /* Draw a salary card if the colored space where the player landed is a Job Search space. */
                drawnSalaryCards = game.drawSalaryCards(game.getIDOf(game.getIndexCurrPlayer()),
                        (JobSearch) mainCtrl.getColoredSpace());
            }

            /* Set the drawn salary cards of the player. */
            mainCtrl.setCard(drawnSalaryCards.get(0));
            mainCtrl.setOtherCard(drawnSalaryCards.get(1));

            /* Create the GUI and controller object for the choosing of career cards. */
            chooseScr = new ChooseSalaryCard("Choose a salary card", drawnSalaryCards.get(0).getName(),
                    drawnSalaryCards.get(0).toString(), drawnSalaryCards.get(1).getName(),
                    drawnSalaryCards.get(1).toString());
            chooseCtrl = new ChooseSalaryCardController(chooseScr, mainScr, mainCtrl, game);


        } else if (e.getActionCommand().equals("Choose Card Two")) {
            /* Check if the second card is chosen. */

            /* Check if the colored space where the player landed is a College Career Choice space. */
            if (mainCtrl.getColoredSpace() instanceof CollegeCareerChoice) {
                game.executeCareer(game.getIDOf(game.getIndexCurrPlayer()), drawnCards,
                        (CollegeCareerChoice) mainCtrl.getColoredSpace(), 1);
            } else {
                /* Execute accordingly if the colored space where the player landed is a Job Search space. */
                game.executeCareer(game.getIDOf(game.getIndexCurrPlayer()), drawnCards,
                        (JobSearch) mainCtrl.getColoredSpace(), 1);
            }

            /* Update the displayed details of all the players of the game. */
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)), 0);
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)), 1);

            if (game.getNumPlayers() == 3)
                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)), 2);


            /* LAUNCH THE SCREEN FOR THE CHOOSING OF SALARY CARDS. */
            ChooseSalaryCard chooseScr;                 // GUI related to the choosing of salary cards
            ChooseSalaryCardController chooseCtrl;      // controller related to the choosing of salary cards

            ArrayList<SalaryCard> drawnSalaryCards;     // cards to be drawn

            /* Check if the colored space where the player landed is a College Career Choice */
            if (mainCtrl.getColoredSpace() instanceof CollegeCareerChoice) {
                /* Draw the two salary cards from which the player will pick. */
                drawnSalaryCards = game.drawSalaryCards(game.getIDOf(game.getIndexCurrPlayer()),
                        (CollegeCareerChoice) mainCtrl.getColoredSpace());
            } else {
                /* Draw a salary card if the colored space where the player landed is a Job Search space. */
                drawnSalaryCards = game.drawSalaryCards(game.getIDOf(game.getIndexCurrPlayer()),
                        (JobSearch) mainCtrl.getColoredSpace());
            }

            /* Set the drawn salary cards of the player. */
            mainCtrl.setCard(drawnSalaryCards.get(0));
            mainCtrl.setOtherCard(drawnSalaryCards.get(1));

            /* Create the GUI and controller object for the choosing of career cards. */
            chooseScr = new ChooseSalaryCard("Choose a salary card", drawnSalaryCards.get(0).getName(),
                    drawnSalaryCards.get(0).toString(), drawnSalaryCards.get(1).getName(),
                    drawnSalaryCards.get(1).toString());
            chooseCtrl = new ChooseSalaryCardController(chooseScr, mainScr, mainCtrl, game);
        }

        /* Remove the screen from the display. */
        chooseScr.setVisible(false);
    }
}
