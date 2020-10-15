package controllers;

import core.GameMaster;
import gui.ChoosePath;
import gui.MainScreen;
import gui.SeeAllCards;
import spaces.magenta_spaces.WhichPath;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class providing the <b>controller</b> for the processes related to <b>choosing the path (at a junction)</b>
 */
public class ChoosePathController implements ActionListener {
    /**
     * Graphical user interface related to choosing the path (at a junction)
     */
    private ChoosePath pathScr;
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
     * Number of times the choose path GUI must be displayed (alongside the controller)
     *
     * For instance, at the start of the game, it must be displayed twice or thrice, depending on the number
     * of players. However, at any other point (for example, on a Which Path junction), it must be displayed
     * only once, corresponding to the current player.
     */
    private int numCalls;

    /**
     * Static counter variable to keep track of the number of times this object is created
     * (that is, to keep track of the number of times the choose path GUI has been displayed)
     */
    private static int ctr;
    /**
     * Static counter variable to keep track of the number of times a button in the choose path
     * GUI has been clicked (used to keep track of when player details and the log are bound
     * for updating)
     */
    private static int ctrClick;

    /**
     * Creates a controller object with the graphical user interface related to choosing a path and
     * the main screen, as well as the controller for the main gameplay, the central class providing
     * all the methods necessary to play the game, and the number of times the GUI must be displayed
     * as parameters
     *
     * @param pathScr Graphical user interface related to choosing the path (at a junction)
     * @param mainScr Graphical user interface related to the actual (main) screen of the game proper
     * @param mainCtrl Controller for the processes related to the main gameplay
     * @param game Central class providing access to all the methods necessary to play the game
     * @param numCalls Number of times the choose path GUI must be displayed (alongside the controller)
     */
    public ChoosePathController(ChoosePath pathScr, MainScreen mainScr, MainGameController mainCtrl, GameMaster game, int numCalls) {
        this.pathScr = pathScr;
        this.mainScr = mainScr;
        this.mainCtrl = mainCtrl;
        this.game = game;
        this.numCalls = numCalls;

        /* Make the GUI visible. */
        pathScr.setVisible(true);

        /* Must not lose focus of the choose paths screen */
        pathScr.setAlwaysOnTop(true);

        /* Disable buttons of the main screen while the loans screen is open. */
        mainScr.disableAllButtons();

        pathScr.setActionListener(this);

        /* Increment the static counter variable value. */
        ctr++;
    }

    /**
     * Invoked when an action occurs
     *
     * @param e semantic event indicative that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        /* The player chose the College Path */
        if (e.getActionCommand().equals(GameMaster.COLLEGE_PATH)) {

            /* Execute the start space commands accordingly. */
            game.executeStartSpace(game.getIDOf(game.getIndexCurrPlayer()), GameMaster.COLLEGE_PATH_CODE);

            /* Advance by the player position by 1, indicative of his choice at the initial junction.
            This premature advancing is offset in a special case included in the implementation of move
            (found in the Player class).
             */
            game.move(1);
            game.startCollege(game.getIDOf(game.getIndexCurrPlayer()));

            /* Update the attribute of the player related to landing on a Which Path space. */
            game.setIsFromWhichPath(game.getIDOf(game.getIndexCurrPlayer()), true);

            /* Update the log, and remove the screen from the display. */
            mainScr.addToLog(game.pathMessage(game.getPath(game.getIndexCurrPlayer())));
            pathScr.setVisible(false);

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the number of clicks, and use the value to update the logs. */
            ctrClick++;
            if (ctrClick < numCalls)
                mainScr.addToLog(game.getPromptStartSpace(game.getIDOf(game.getIndexCurrPlayer())));

            /* If the GUI has been displayed the specified number of times, then all pertinent
            players have chosen their paths; thus, all pertinent buttons are enabled as well.
             */
            if (ctrClick == numCalls) {
                mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));

                mainScr.enableAllButtonsExceptGo();
                mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

                /* Display all the cards of all the players. */
                SeeAllCards displayScr;
                displayScr = new SeeAllCards(game.getPlayerNames(),
                        game.getAllCareerCardDetails(),
                        game.getAllSalaryCardDetails());

                SeeAllCardsController displayCtrl;
                displayCtrl = new SeeAllCardsController(displayScr, mainScr, game);
            }


        } else if (e.getActionCommand().equals(GameMaster.CAREER_PATH)) {
            /* The player chose the Career Path */

            /* Execute the start space commands accordingly. */
            game.executeStartSpace(game.getIDOf(game.getIndexCurrPlayer()), GameMaster.CAREER_PATH_CODE);

            /* Advance by the player position by 1, indicative of his choice at the initial junction.
            This premature advancing is offset in a special case included in the implementation of move
            (found in the Player class).
             */
            game.move(1);
            game.startCareer(game.getIDOf(game.getIndexCurrPlayer()));

            /* Update the attribute of the player related to landing on a Which Path space. */
            game.setIsFromWhichPath(game.getIDOf(game.getIndexCurrPlayer()), true);

            /* Update the log, and remove the screen from the display. */
            mainScr.addToLog(game.pathMessage(game.getPath(game.getIndexCurrPlayer())));
            pathScr.setVisible(false);

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the number of clicks, and use the value to update the logs. */
            ctrClick++;
            if (ctrClick < numCalls)
                mainScr.addToLog(game.getPromptStartSpace(game.getIDOf(game.getIndexCurrPlayer())));

            /* If the GUI has been displayed the specified number of times, then all pertinent
             players have chosen their paths; thus, all pertinent buttons are enabled as well.
             */
            if (ctrClick == numCalls) {
                mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));

                mainScr.enableAllButtonsExceptGo();
                mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

                /* Display all the cards of all the players. */
                SeeAllCards displayScr;
                displayScr = new SeeAllCards(game.getPlayerNames(),
                        game.getAllCareerCardDetails(),
                        game.getAllSalaryCardDetails());

                SeeAllCardsController displayCtrl;
                displayCtrl = new SeeAllCardsController(displayScr, mainScr, game);
            }


        } else if (e.getActionCommand().equals(GameMaster.NORMAL_PATH)) {
            /* The player chose the Career Path */

            /* Execute the magenta space commands accordingly. */
            game.executeMagentaSpace(game.getIDOf(game.getIndexCurrPlayer()), (WhichPath) mainCtrl.getColoredSpace(),
                    GameMaster.NORMAL_PATH_CODE);

            /* Advance by the player position by 1, indicative of his choice at the initial junction.
            This premature advancing is offset in a special case included in the implementation of move
            (found in the Player class).
             */
            game.move(1);

            /* Update the attribute of the player related to landing on a Which Path space. */
            game.setIsFromWhichPath(game.getIDOf(game.getIndexCurrPlayer()), true);

            /* Update the log, and remove the screen from the display. */
            mainScr.addToLog(game.pathMessage(game.getPath(game.getIndexCurrPlayer())));
            pathScr.setVisible(false);

            /* If the GUI has been displayed the specified number of times, then all pertinent
             players have chosen their paths; thus, all pertinent buttons are enabled as well.
             */
            ctrClick++;
            if (ctrClick == numCalls) {
                mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
                mainScr.enableAllButtonsExceptGo();
                mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
            }

        } else if (e.getActionCommand().equals(GameMaster.CHANGE_CAREER_PATH)) {
            /* The player chose the Change Career Path */

            /* Execute the magenta space commands accordingly. */
            game.executeMagentaSpace(game.getIDOf(game.getIndexCurrPlayer()), (WhichPath) mainCtrl.getColoredSpace(),
                    GameMaster.CHANGE_CAREER_PATH_CODE);

            /* Advance by the player position by 1, indicative of his choice at the initial junction.
            This premature advancing is offset in a special case included in the implementation of move
            (found in the Player class).
             */
            game.move(1);

            /* Update the attribute of the player related to landing on a Which Path space. */
            game.setIsFromWhichPath(game.getIDOf(game.getIndexCurrPlayer()), true);

            /* Update the log, and remove the screen from the display. */
            mainScr.addToLog(game.pathMessage(game.getPath(game.getIndexCurrPlayer())));
            pathScr.setVisible(false);

            /* If the GUI has been displayed the specified number of times, then all pertinent
             players have chosen their paths; thus, all pertinent buttons are enabled as well.
             */
            ctrClick++;
            if (ctrClick == numCalls) {
                mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
                mainScr.enableAllButtonsExceptGo();
                mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
            }

        } else if (e.getActionCommand().equals(GameMaster.START_FAMILY_PATH)) {
            /* The player chose the Start a Family Path */

            /* Execute the magenta space commands accordingly. */
            game.executeMagentaSpace(game.getIDOf(game.getIndexCurrPlayer()), (WhichPath) mainCtrl.getColoredSpace(),
                    GameMaster.START_FAMILY_PATH_CODE);

            /* Advance by the player position by 1, indicative of his choice at the initial junction.
            This premature advancing is offset in a special case included in the implementation of move
            (found in the Player class).
             */
            game.move(1);

            /* Update the attribute of the player related to landing on a Which Path space. */
            game.setIsFromWhichPath(game.getIDOf(game.getIndexCurrPlayer()), true);

            /* Update the log, and remove the screen from the display. */
            mainScr.addToLog(game.pathMessage(game.getPath(game.getIndexCurrPlayer())));
            pathScr.setVisible(false);

            /* If the GUI has been displayed the specified number of times, then all pertinent
             players have chosen their paths; thus, all pertinent buttons are enabled as well.
             */
            ctrClick++;
            if (ctrClick == numCalls) {
                mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
                mainScr.enableAllButtonsExceptGo();
                mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
            }
        }

        /* Keep displaying the GUI (alongside the controller) as long as the required number of calls
        has not been reached. This is used to handle the special case at the start of the game
        when the Choose Path GUI needs to be displayed successively depending on the number of players.
         */
        while (ctr < numCalls) {
            ChoosePath pathScr2;
            pathScr2 = new ChoosePath(GameMaster.COLLEGE_PATH, GameMaster.CAREER_PATH, GameMaster.COLLEGE_PATH_DESC,
                    GameMaster.CAREER_PATH_DESC, "/assets/collegePath.png", "/assets/careerPath.png");

            ChoosePathController pathScr2Ctrl;
            pathScr2Ctrl = new ChoosePathController(pathScr2, mainScr, mainCtrl, game, numCalls);
        }
    }

    /**
     * Resets the value of the counter (used to keep track of the number of times this object is created)
     * to 0
     *
     * <p>This counter variable is used to keep track of the number of times this object is created
     * (that is, to keep track of the number of times the choose path GUI has been displayed). </p>
     */
    public static void initCtr() {
        ctr = 0;
    }

    /**
     * Resets the value of the click counter (used to keep track of the number of times a button in the
     * choose path GUI is pressed) to 0
     *
     * <p>This counter variable is used to keep track of the number of times a button in the choose path
     * GUI has been clicked (used to keep track of when player details and the log are bound
     * for updating)</p>
     */
    public static void initCtrClick() {
        ctrClick = 0;
    }
}
