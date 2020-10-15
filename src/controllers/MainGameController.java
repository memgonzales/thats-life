package controllers;

import cards.*;
import cards.action_cards.CollectFromTheBank;
import cards.action_cards.PayTheBank;
import cards.action_cards.collect_from_bank.*;
import cards.action_cards.collect_from_player.FileALawsuit;
import cards.action_cards.collect_from_player.ItsYourBirthday;
import cards.action_cards.pay_bank.*;
import cards.action_cards.pay_player.ChristmasBonus;
import cards.action_cards.pay_player.Lawsuit;
import cards.blue_cards.*;
import core.Board;
import core.GameMaster;
import decks.HouseCardDeck;
import gui.*;
import spaces.ColoredSpace;
import spaces.green_spaces.PayDay;
import spaces.green_spaces.PayRaise;
import spaces.magenta_spaces.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Class providing the <b>controller</b> for the processes related to <b>the main gameplay</b>
 */
public class MainGameController implements ActionListener, WindowListener {
    /**
     * Graphical user interface related to the actual (main) screen of the game proper
     */
    private MainScreen mainScr;
    /**
     * Central class providing access to all the methods necessary to play the game
     */
    private GameMaster game;

    /**
     * Active card. It is possible that there are two active cards (for example, during a Career College
     * Choice execution, the player draws two cards from the deck.
     */
    private Card c;
    /**
     * Active card. It is possible that there are two active cards (for example, during a Career College
     * Choice execution, the player draws two cards from the deck.
     */
    private Card d;
    /**
     * Available house cards
     */
    private ArrayList<HouseCard> h;
    /**
     * Active colored space (that is, the colored space where the current player landed)
     */
    private ColoredSpace s;
    /**
     * Component of the game requesting for a wheel spin (either a space or a card)
     */
    private int spinComponent;

    /**
     * Code for a card (in particular, specific types of blue cards) requesting a wheel spin
     */
    public static final int SPIN_COMPONENT_CARD = 0;
    /**
     * Code for a space (in particular, a Get Married magenta space) is requesting a wheel spin
     */
    public static final int SPIN_COMPONENT_SPACE = 1;

    /**
     * Creates a controller object with the graphical user interface related to the main screen
     * and the central class providing all the methods necessary to play the game as parameters
     *
     * @param mainScr Graphical user interface related to the actual (main) screen of the game proper
     * @param game Central class providing access to all the methods necessary to play the game
     */
    public MainGameController(MainScreen mainScr, GameMaster game) {
        this.mainScr = mainScr;
        this.game = game;

        /* Make the GUI visible. */
        mainScr.setVisible(true);
        mainScr.setDrawEnabled(false);

        mainScr.setActionListener(this);
        mainScr.setWindowListener(this);

        /* Display the general instructions for playing the game. */
        GenericInfo info;
        info = new GenericInfo(game.getInitialInstructions(), "Initial Instructions", "/assets/logo.png");

        /* Ask the players to choose their path (either College Path or Career Path) */
        ChoosePath pathScr1;
        pathScr1 = new ChoosePath(GameMaster.COLLEGE_PATH, GameMaster.CAREER_PATH, GameMaster.COLLEGE_PATH_DESC,
                GameMaster.CAREER_PATH_DESC, "/assets/collegePath.png",
                "/assets/careerPath.png");

        /* Disable all the buttons in the main screen while the players are choosing their paths. */
        mainScr.disableAllButtons();

        ChoosePathController pathScr1Ctrl;
        mainScr.addToLog(game.getPromptStartSpace(game.getIDOf(game.getIndexCurrPlayer())));

        /* Set the number of required displays of the choose path GUI to the number of players since they
        choose their initial paths in succession.
         */
        pathScr1Ctrl = new ChoosePathController(pathScr1, mainScr, this, game, game.getNumPlayers());
    }

    /**
     * Invoked when the user attempts to close the window from the window's system menu
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowClosing(WindowEvent e) {
        int confirm;                             // response to the confirmation dialog

        /* Supersede the priority of any screen display when the user clicks the close (x) button. */
        mainScr.setAlwaysOnTop(true);

        /* Display a confirmation prompt. */
        confirm = JOptionPane.showConfirmDialog(mainScr, "Are you sure you want to exit That's Life?",
                "Quit", JOptionPane.YES_NO_OPTION);

        /* End the game if the player's response is affirmative. Otherwise, the game is not ended. */
        switch (confirm) {
            case JOptionPane.YES_OPTION:
                mainScr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                break;
            case JOptionPane.NO_OPTION:
                mainScr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                mainScr.setAlwaysOnTop(false);
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

        /* Check if the player clicks the Spin button. */
        if (e.getActionCommand().equals("SPIN")) {
            int prevPosition;           // index of the player prior to his/her current index
            int randNum;                // random number obtained via a wheel spin

            /* The previous position is kept track for the visual movement of the pegs. */
            prevPosition = game.getPosition(game.getIDOf(game.getIndexCurrPlayer()));

            /* Check if the player came from a Which Path space. */
            if (game.getIsFromWhichPath(game.getIDOf(game.getIndexCurrPlayer()))) {
                /* This is handled as a special case since a Which Path space points to
                two next indices (as it signals a junction).
                 */
                switch (game.getPosition(game.getIDOf(game.getIndexCurrPlayer()))) {
                    case Board.NEXT_INDEX_FORK_CAREER_1:
                    case Board.NEXT_INDEX_FORK_CAREER_2:
                        prevPosition = Board.INDEX_FORK_CAREER;
                        break;
                    case Board.NEXT_INDEX_FORK_FAMILY_1:
                    case Board.NEXT_INDEX_FORK_FAMILY_2:
                        prevPosition = Board.INDEX_FORK_FAMILY;
                        break;
                    case Board.NEXT_INDEX_FORK_START_1:
                    case Board.NEXT_INDEX_FORK_START_2:
                        prevPosition = 0;           // start of the board
                        break;
                }
            }

            /* Spin the wheel. */
            randNum = game.spinWheel(game.getIDOf(game.getIndexCurrPlayer()));
            updateViewSpinWheel(randNum);

            /* The active (shaded in white) number in the wheel is set as a visual cue. */
            mainScr.setActiveWheelX(randNum);
            mainScr.setActiveWheelY(randNum);

            /* Display an informational message. */
            GenericInfo info;
            info = new GenericInfo("You spun " + randNum + ".", "Wheel Spin", "/assets/wheel.png");

            /* Update the game log. */
            mainScr.addToLog(game.spinMessage(randNum));

            /* Advance the player's position. */
            game.move(randNum);

            /* Move the peg displayed on the board. */
            switch(game.getIndexCurrPlayer()) {
                /* The different cases correspond to the players of the game. */
                case 0:
                    mainScr.movePeg(MainScreen.PLAYER_ONE_COLOR, prevPosition,
                            game.getPosition(game.getIDOf(game.getIndexCurrPlayer())));
                    break;
                case 1:
                    mainScr.movePeg(MainScreen.PLAYER_TWO_COLOR, prevPosition,
                            game.getPosition(game.getIDOf(game.getIndexCurrPlayer())));
                    break;
                case 2:
                    mainScr.movePeg(MainScreen.PLAYER_THREE_COLOR, prevPosition,
                            game.getPosition(game.getIDOf(game.getIndexCurrPlayer())));
                    break;
            }

            /* Update the game log. */
            mainScr.addToLog(game.getInfoColoredSpace(game.getIDOf(game.getIndexCurrPlayer()),
                    game.getColoredSpace(game.getPosition(game.getIDOf(game.getIndexCurrPlayer())))));

            /* A player cannot borrow or pay a loan once the wheel is spun. The only action allowed
            are to "go" (execute) and display the rules or the current cards kept.
             */
            mainScr.setLoanEnabled(false);

            /* Check if the current player is retiring (that is, he is at the last space of the board). */
            if (game.isRetiring(game.getIDOf(game.getIndexCurrPlayer()))) {
                /* The player retires. */
                game.retire(game.getIDOf(game.getIndexCurrPlayer()));

                /* Update the displayed details of the retired player. */
                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(game.getIndexCurrPlayer())),
                        game.getIndexCurrPlayer());

                /* Display the informational message. */
                info = new GenericInfo(game.getRetirementDialog(), "Retirement", "/assets/logo.png");

                /* TURN OF THE NEXT PLAYER */
                game.switchTurn();

                /* Check if game over (that is, all players have retired). */
                if (game.isGameOver()) {
                    /* Disable all the buttons, signifying the end of the game. */
                    mainScr.disableAllButtons();

                    /* Display the end screen of the game. */
                    EndScreen endScr;
                    EndScreenController endCtrl;

                    endScr = new EndScreen(game.getPlayerNames(), game.getAllPlayersDetails(), game.getWinnerName());
                    endCtrl = new EndScreenController(endScr, mainScr, game);
                }

                /* If it is not yet game over, then just update the log, and allow the next player
                to spin the wheel.
                 */
                if (!game.isGameOver())
                    mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));

                mainScr.setSpinEnabled(true);
            } else {
                /* If the player is not yet retiring, then he can still draw the appropriate card. */
                mainScr.setDrawEnabled(true);
            }

        } else if (e.getActionCommand().equals("GO")) {
            /* Check if the player clicks the "Go" button. */

            String colorPosition;           // color of the space where the current player is currently on
            colorPosition = game.getColorPosition(game.getPosition(game.getIDOf(game.getIndexCurrPlayer())));

            /* Execute the appropriate instructions depending on the color of the space. */
            if (colorPosition.equalsIgnoreCase("Magenta"))
                processMagenta();
            else if (colorPosition.equalsIgnoreCase("Green"))
                processGreen();
            else if (colorPosition.equalsIgnoreCase("Blue"))
                processBlue();
            else if (colorPosition.equalsIgnoreCase("Orange"))
                processOrange();

            /* Update the displayed details of the players. */
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(game.getIndexCurrPlayer())),
                    game.getIndexCurrPlayer());
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)), 0);
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)), 1);

            if (game.getNumPlayers() == 3)
                mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)), 2);

            /* The button is disabled since its function is done. */
            mainScr.setDrawEnabled(false);

        } else if (e.getActionCommand().equals("BORROW")) {
            /* If the player clicks the "Borrow" button, then the pertinent GUI and controller are
            activated to allow him/her to borrow loans.
             */

            BorrowLoans loansScr;
            loansScr = new BorrowLoans();

            /* The buttons in the main screen are disabled since there is a new active screen. */
            mainScr.disableAllButtons();

            BorrowLoansController loansCtrl;
            loansCtrl = new BorrowLoansController(loansScr, mainScr, game);

        } else if (e.getActionCommand().equals("PAY LOAN")) {
            /* If the player clicks the "Pay Loan" button, then the pertinent GUI and controller are
            activated to allow him/her to pay loans, if applicable.
             */

            PayLoans loansScr;
            loansScr = new PayLoans();

            /* The buttons in the main screen are disabled since there is a new active screen. */
            mainScr.disableAllButtons();

            PayLoansController loansCtrl;
            loansCtrl = new PayLoansController(loansScr, mainScr, game);

        } else if (e.getActionCommand().equals("CARDS")) {
            /* If the player clicks the "Cards" button, then the pertinent GUI and controller
            are activated to allow him/her to view his/her kept cards.
             */

            SeeCards displayScr;
            displayScr = new SeeCards(game.getPlayerNames().get(game.getIndexCurrPlayer()),
                    game.getCareerCardDetails(game.getIDOf(game.getIndexCurrPlayer())),
                    game.getSalaryCardDetails(game.getIDOf(game.getIndexCurrPlayer())),
                    game.getHouseCardDetails(game.getIDOf(game.getIndexCurrPlayer())));

            SeeCardsController displayCtrl;
            displayCtrl = new SeeCardsController(displayScr, game);

            /* No need to disable all buttons since this is a non-essential screen. When a player
            clicks outside the see cards GUI, then it is automatically hidden from view.
             */

        } else if (e.getActionCommand().equals("RULES")) {
            /* If the player clicks the "Rules" button, then the pertinent GUI and controller
            are activated to allow him/her to view the complete rules of the game.
             */

            SeeRules displayScr;
            displayScr = new SeeRules();

            SeeRulesController displayCtrl;
            displayCtrl = new SeeRulesController(displayScr, game);

            /* No need to disable all buttons since this is a non-essential screen. When a player
            clicks outside the see cards GUI, then it is automatically hidden from view.
             */
        }

        /* Update the displayed details of the players. */
        mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(game.getIndexCurrPlayer())),
                game.getIndexCurrPlayer());

        mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(0)), 0);
        mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(1)), 1);

        if (game.getNumPlayers() == 3)
            mainScr.updatePlayerDetails(game.getPlayerDetails(game.getIDOf(2)), 2);
    }

    /**
     * Updates the view once a wheel is spun (to obtain the number of spaces advanced by the player)
     *
     * @param randNum random number obtained after spinning the wheel
     */
    private void updateViewSpinWheel(int randNum) {
        /* Disable clicking "Spin" when the wheel is spinning and after it has already spun. */
        mainScr.setSpinEnabled(false);
        /* Animate the spinning of the wheel. */
        mainScr.highlightWheel(randNum);
    }

    /**
     * Executes the instructions specified upon landing on a green space
     */
    private void processGreen() {
        ColoredSpace s;         // colored space where the player landed
        s = game.getColoredSpace(game.getPosition(game.getIDOf(game.getIndexCurrPlayer())));

        /* The player landed on a Pay Raise space. */
        if (s instanceof PayRaise) {
            /* Display the informational message. */
            GenericInfo info;
            info = new GenericInfo(game.getInfoColoredSpace(game.getIDOf(game.getIndexCurrPlayer()), s),
                    "Pay Raise", "/assets/payRaise.png");

            /* Execute the specified instructions. */
            game.executeGreenSpace(game.getIDOf(game.getIndexCurrPlayer()), (PayRaise) s);

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

        } else if (s instanceof PayDay) {
            /* The player landed on a Pay Raise space. */

            /* Display the informational message. */
            GenericInfo info;
            info = new GenericInfo(game.getInfoColoredSpace(game.getIDOf(game.getIndexCurrPlayer()), s),
                    "Pay Day", "/assets/payDay.png");

            /* Execute the specified instructions. */
            game.executeGreenSpace(game.getIDOf(game.getIndexCurrPlayer()), (PayDay) s);

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
        }
    }

    /**
     * Executes the instructions specified upon landing on an orange space
     */
    private void processOrange() {
        ActionCard c;           // action card drawn by the player
        c = game.drawFromActionDeck(game.getIDOf(game.getIndexCurrPlayer()));

        /* The player drew a Collect from the Bank card. */
        if (c instanceof CollectFromTheBank) {
            GenericInfo info;

            /* Display the informational message depending on the specific card drawn. */
            if (c instanceof BonusPayday)
                info = new GenericInfo(c.getInfo(), "Bonus Payday", "/assets/bonusPayday.png");
            else if (c instanceof SellAnItem)
                info = new GenericInfo(c.getInfo(), "Sell An Item", "/assets/sellAnItem.png");
            else if (c instanceof SetupSchool)
                info = new GenericInfo(c.getInfo(), "Setup School", "/assets/setupSchool.png");
            else if (c instanceof TaxRefund)
                info = new GenericInfo(c.getInfo(), "Tax Refund", "/assets/taxRefund.png");
            else if (c instanceof WriteABook)
                info = new GenericInfo(c.getInfo(), "Write A Book", "/assets/writeABook.png");

            /* Execute the instructions specified. */
            game.executeActionCard(game.getIDOf(game.getIndexCurrPlayer()), (CollectFromTheBank) c);

            /* Update the game log. */
            mainScr.addToLog(c.getInfo());

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

        } else if (c instanceof PayTheBank) {
            /* The player drew a Pay the Bank card. */

            GenericInfo info;

            /* Display the informational message depending on the specific card drawn. */
            if (c instanceof BuyAnItem)
                info = new GenericInfo(c.getInfo(), "Buy An Item", "/assets/buyAnItem.png");
            else if (c instanceof Hiking)
                info = new GenericInfo(c.getInfo(), "Hiking", "/assets/hiking.png");
            else if (c instanceof TrafficViolation)
                info = new GenericInfo(c.getInfo(), "Traffic Violation", "/assets/trafficViolation.png");
            else if (c instanceof VisitAPlace)
                info = new GenericInfo(c.getInfo(), "Visit A Place", "/assets/visitAPlace.png");
            else if (c instanceof WatchAShow)
                info = new GenericInfo(c.getInfo(), "Watch A Show", "/assets/watchAShow.png");
            else if (c instanceof WinACompetition)
                info = new GenericInfo(c.getInfo(), "Win A Competition", "/assets/winACompetition.png");

            /* Execute the instructions specified. */
            game.executeActionCard(game.getIDOf(game.getIndexCurrPlayer()), (PayTheBank) c);

            /* Update the game log. */
            mainScr.addToLog(c.getInfo());

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

        } else if (c instanceof Lawsuit) {
            /* The player drew a Lawsuit card. */

            /* Check if there are still other players left to be involved in a lawsuit. */
            if (game.getNumRetirees() != game.getNumPlayers() - 1) {
                /* Set the attributes since execution will be passed to another controller. */
                this.spinComponent = SPIN_COMPONENT_CARD;
                this.c = c;

                /* Activate the choose player GUI and controller. Turn switching is handled there. */
                ChoosePlayer chooseScr;
                chooseScr = new ChoosePlayer("Lawsuit", c.getInfo(), game.getPlayerNames());

                mainScr.disableAllButtons();
                mainScr.addToLog(c.getInfo());

                ChoosePlayerController chooseCtrl;
                chooseCtrl = new ChoosePlayerController(chooseScr, mainScr, this, game);

            } else {
                /* Display the message indicating that there are no more lawsuit parties to be involved. */
                GenericInfo info;
                info = new GenericInfo("No more lawsuit victims.", "Lawsuit", "/assets/lawsuit.png");
                mainScr.addToLog("No more lawsuit victims.");

                /* TURN OF THE NEXT PLAYER */
                game.switchTurn();

                /* Update the game log, and enable all pertinent buttons. */
                mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
                mainScr.enableAllButtonsExceptGo();
                mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
            }

        } else if (c instanceof ChristmasBonus) {
            /* Display the informational message. */
            GenericInfo info;
            info = new GenericInfo(c.getInfo(), "Christmas Bonus", "/assets/christmasBonus.png");

            /* Execute the instructions specified, then update the log. */
            game.executeActionCard(game.getIDOf(game.getIndexCurrPlayer()), (ChristmasBonus) c);
            mainScr.addToLog(c.getInfo());

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

        } else if (c instanceof FileALawsuit) {
            /* The player drew a File a Lawsuit card. */

            /* Check if there are still other players left to be involved in a lawsuit. */
            if (game.getNumRetirees() != game.getNumPlayers() - 1) {
                /* Set the attributes since execution will be passed to another controller. */
                this.spinComponent = SPIN_COMPONENT_CARD;
                this.c = c;

                /* Activate the choose player GUI and controller. Turn switching is handled there. */
                ChoosePlayer chooseScr;
                chooseScr = new ChoosePlayer("File a Lawsuit", c.getInfo(), game.getPlayerNames());

                mainScr.disableAllButtons();
                mainScr.addToLog(c.getInfo());

                ChoosePlayerController chooseCtrl;
                chooseCtrl = new ChoosePlayerController(chooseScr, mainScr, this, game);

            } else {
                /* Display the message indicating that there are no more lawsuit parties to be involved. */
                GenericInfo info;
                info = new GenericInfo("No more opponents.",
                        "File A Lawsuit", "/assets/fileALawsuit.png");
                mainScr.addToLog("No more opponents.");

                /* TURN OF THE NEXT PLAYER */
                game.switchTurn();

                /* Update the game log, and enable all pertinent buttons. */
                mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
                mainScr.enableAllButtonsExceptGo();
                mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
            }

        } else if (c instanceof ItsYourBirthday) {
            /* Display the informational message. */
            GenericInfo info;
            info = new GenericInfo(c.getInfo(), "It's Your Birthday", "/assets/itsYourBirthday.png");

            /* Execute the instructions specified, then update the log. */
            game.executeActionCard(game.getIDOf(game.getIndexCurrPlayer()), (ItsYourBirthday) c);
            mainScr.addToLog(c.getInfo());

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
        }
    }

    /**
     * Executes the instructions specified upon landing on an magenta space
     */
    private void processMagenta() {
        ColoredSpace s;         // colored space where the player landed
        s = game.getColoredSpace(game.getPosition(game.getIDOf(game.getIndexCurrPlayer())));

        /* The player landed on a College Career Choice space. */
        if (s instanceof CollegeCareerChoice) {
            ChooseCareerCard chooseScr;                 // GUI for choosing career cards
            ChooseCareerCardController chooseCtrl;      // Controller for choosing career cards

            ArrayList<CareerCard> drawnCareerCards;     // Drawn career cards

            /* Draw the two career cards from the deck. */
            drawnCareerCards = game.drawCareerCards(game.getIDOf(game.getIndexCurrPlayer()),
                    (CollegeCareerChoice) s);

            /* Set the attributes since execution will be passed to another controller. */
            this.c = drawnCareerCards.get(0);
            this.d = drawnCareerCards.get(1);
            this.s = s;

            /* Activate the choose career cards GUI and controller. */
            chooseScr = new ChooseCareerCard("Choose a career card:", drawnCareerCards.get(0).getName(),
                    drawnCareerCards.get(0).getInfo(), drawnCareerCards.get(1).getName(),
                    drawnCareerCards.get(1).getInfo());

            /* Disable all the buttons in the main screen. */
            mainScr.disableAllButtons();

            chooseCtrl = new ChooseCareerCardController(chooseScr, mainScr, this, game);

        } else if (s instanceof JobSearch) {
            /* The player landed on a Job Search space. */

            ChooseCareerCard chooseScr;                 // GUI for choosing career cards
            ChooseCareerCardController chooseCtrl;      // Controller for choosing career cards

            ArrayList<CareerCard> drawnCareerCards;     // Drawn career cards

            /* Draw the new career card from the deck. */
            drawnCareerCards = game.drawCareerCards(game.getIDOf(game.getIndexCurrPlayer()),
                    (JobSearch) s);

            /* Set the attributes since execution will be passed to another controller. */
            this.c = drawnCareerCards.get(0);
            this.d = drawnCareerCards.get(1);
            this.s = s;

            /* Activate the choose career cards GUI and controller. */
            chooseScr = new ChooseCareerCard("Choose a career card:", drawnCareerCards.get(0).getName(),
                    drawnCareerCards.get(0).getInfo(), drawnCareerCards.get(1).getInfo(),
                    drawnCareerCards.get(1).getInfo());

            /* Disable all the buttons in the main screen. */
            mainScr.disableAllButtons();

            chooseCtrl = new ChooseCareerCardController(chooseScr, mainScr, this, game);

        } else if (s instanceof BuyAHouse) {
            /* The player landed on a Buy a House space. */

            ChooseHouse houseScr;               // GUI for choosing a house
            ArrayList<String> paths;            // paths for the icons associated with each house
            ArrayList<String> houseNames;       // names of the houses
            ArrayList<String> houseDetails;     // details of the houses
            ArrayList<HouseCard> houseCards;    // available house cards

            houseDetails = new ArrayList<String>(HouseCardDeck.NUM_HOUSE_CARDS);
            houseNames = new ArrayList<String>(HouseCardDeck.NUM_HOUSE_CARDS);
            paths = new ArrayList<String>(HouseCardDeck.NUM_HOUSE_CARDS);

            /* Set the attributes since execution will be passed to another controller. */
            houseCards = game.drawHouseCardsToBuy(game.getIDOf(game.getIndexCurrPlayer()), (BuyAHouse) s);
            this.h = houseCards;
            this.s = s;

            /* Get the names of the house cards. */
            for (int i = 0; i < houseCards.size(); i++)
                houseNames.add(houseCards.get(i).getName());

            /* Get the details of the house cards. */
            for (int i = 0; i < houseCards.size(); i++)
                houseDetails.add(houseCards.get(i).toString());

            /* Get the paths for the icons associated with each house. */
            for (int i = 0; i < houseNames.size(); i++) {
                if (houseNames.get(i).equalsIgnoreCase("Florence Penthouse") || houseNames.get(i).equalsIgnoreCase("Swing Penthouse"))
                    paths.add("/assets/penthouse.png");
                else if (houseNames.get(i).equalsIgnoreCase("Hai Lin Villa") || houseNames.get(i).equalsIgnoreCase("Havsis Villa"))
                    paths.add("/assets/villa.png");
                else if (houseNames.get(i).equalsIgnoreCase("Edwardian Mansion") || houseNames.get(i).equalsIgnoreCase("Jacobian Mansion"))
                    paths.add("/assets/mansion.png");
                else if (houseNames.get(i).equalsIgnoreCase("Cece Townhouse") || houseNames.get(i).equalsIgnoreCase("Purogh Townhouse"))
                    paths.add("/assets/townhouse.png");
                else if (houseNames.get(i).equalsIgnoreCase("Java Farmhouse") || houseNames.get(i).equalsIgnoreCase("Bali Farmhouse"))
                    paths.add("/assets/farmhouse.png");
            }

            /* Activate the choose house GUI and controller. */
            houseScr = new ChooseHouse(houseNames, houseDetails, paths);

            /* Disable all the buttons in the main screen. */
            mainScr.disableAllButtons();

            ChooseHouseController houseCtrl;
            houseCtrl = new ChooseHouseController(houseScr, mainScr, this, game);

        } else if (s instanceof GetMarried) {
            /* The player landed on a Get Married space. */

            /* Check if the player is not yet married since you can only marry once in-game */
            if (!game.isMarried(game.getIDOf(game.getIndexCurrPlayer()))) {
                /* Set the attributes since execution will be passed to another controller. */
                this.spinComponent = SPIN_COMPONENT_SPACE;
                this.s = s;

                /* Activate the get married GUI and controller. */
                SpinWheel spinScr;
                spinScr = new SpinWheel("Get Married", game.getInfoGetMarried(game.getIDOf(game.getIndexCurrPlayer()), s));

                /* Disable all the buttons in the main screen. */
                mainScr.disableAllButtons();

                PlayerRandSpinController spinCtrl;
                spinCtrl = new PlayerRandSpinController(spinScr, mainScr, this, game);

            } else {
                /* If the player is already married, display the appropriate informational message. */

                GenericInfo info;
                info = new GenericInfo("You're already married.", "Get Married", "/assets/getMarried.png");
                mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
                mainScr.enableAllButtonsExceptGo();
                mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
            }
        } else if (s instanceof HaveBaby) {
            /* The player landed on a Have Baby space. */

            /* Display the informational message. */
            GenericInfo info;
            info = new GenericInfo(game.getInfoColoredSpace(game.getIDOf(game.getIndexCurrPlayer()), s),
                    "Have Baby", "/assets/haveBaby.png");

            /* Execute the instructions specified, then update the log. */
            game.executeMagentaSpace(game.getIDOf(game.getIndexCurrPlayer()), (HaveBaby) s);
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));

            /* Re-enable all pertinent buttons. */
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
        } else if (s instanceof HaveTwins) {
            /* The player landed on a Have Twins space. */

            /* Display the informational message. */
            GenericInfo info;
            info = new GenericInfo(game.getInfoColoredSpace(game.getIDOf(game.getIndexCurrPlayer()), s),
                    "Have Twins", "/assets/haveTwins.png");

            /* Execute the instructions specified, then update the log. */
            game.executeMagentaSpace(game.getIDOf(game.getIndexCurrPlayer()), (HaveTwins) s);
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));

            /* Re-enable all pertinent buttons. */
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

        } else if (s instanceof WhichPath) {
            /* The player landed on a Which Path space. */

            /* Set the attributes since execution will be passed to another controller. */
            this.s = s;

            /* The player landed on a Change Career vs. Normal Path junction. */
            if (s.getIndex() == Board.INDEX_FORK_CAREER) {

                /* Activate the choose path GUI and controller. */
                ChoosePath pathScr1;
                pathScr1 = new ChoosePath(GameMaster.CHANGE_CAREER_PATH, GameMaster.NORMAL_PATH,
                        GameMaster.CHANGE_CAREER_PATH_DESC,
                        GameMaster.NORMAL_PATH_DESC, "/assets/changeCareerPath.png",
                        "/assets/normalPath.png");

                /* Disable all the buttons in the main screen. */
                mainScr.disableAllButtons();

                ChoosePathController pathScr1Ctrl;

                /* Reset the counters in the choose path controller, and require the number
                of calls to 1 only (since only one player is involved).
                 */
                ChoosePathController.initCtr();
                ChoosePathController.initCtrClick();
                pathScr1Ctrl = new ChoosePathController(pathScr1, mainScr, this, game, 1);

            } else if (s.getIndex() == Board.INDEX_FORK_FAMILY) {
                /* The player landed on a Start a Family vs. Normal Path junction. */

                /* Activate the choose path GUI and controller. */
                ChoosePath pathScr1;
                pathScr1 = new ChoosePath(GameMaster.START_FAMILY_PATH, GameMaster.NORMAL_PATH,
                        GameMaster.START_FAMILY_PATH_DESC,
                        GameMaster.NORMAL_PATH_DESC, "/assets/startAFamilyPath.png",
                        "/assets/normalPath.png");

                /* Disable all the buttons in the main screen. */
                mainScr.disableAllButtons();

                ChoosePathController pathScr1Ctrl;

                /* Reset the counters in the choose path controller, and require the number
                of GUI displays to 1 only (since only one player is involved).
                 */
                ChoosePathController.initCtr();
                ChoosePathController.initCtrClick();
                pathScr1Ctrl = new ChoosePathController(pathScr1, mainScr, this, game, 1);
            }

        } else if (s instanceof GraduationSpace) {
            /* The player landed on a Graduation Space space. */

            /* Display the informational message. */
            GenericInfo info;
            info = new GenericInfo(game.getInfoColoredSpace(game.getIDOf(game.getIndexCurrPlayer()), s),
                    "Graduation Space", "/assets/graduation.png");

            /* Execute the instructions specified, then update the log. */
            game.executeMagentaSpace(game.getIDOf(game.getIndexCurrPlayer()), (GraduationSpace) s);
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));

            /* Re-enable all pertinent buttons. */
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
        }

    }

    /**
     * Executes the instructions specified upon landing on an blue space
     */
    private void processBlue() {
        BlueCard c;             // card drawn
        c = game.drawFromBlueDeck(game.getIDOf(game.getIndexCurrPlayer()));

        /* The player drew a Lawsuit blue card. */
        if (c instanceof LawsuitBlue) {
            GenericInfo info;           // informational message
            int displayFlag;            // represents the execution of the blue card

            /* Execute the instructions specified. */
            displayFlag = game.executeBlueCard(game.getIDOf(game.getIndexCurrPlayer()), (LawsuitBlue) c);

            /* Display the informational message. */
            info = new GenericInfo(game.getBlueInfo(c, displayFlag), "Lawsuit(Blue)", "/assets/lawsuitBlue.png");

            /* Update the log. */
            mainScr.addToLog(game.getBlueInfo(c, displayFlag));

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

        } else if (c instanceof SalaryTaxDue) {
            GenericInfo info;           // informational message
            int displayFlag;            // represents the execution of the blue card

            /* Execute the instructions specified. */
            displayFlag = game.executeBlueCard(game.getIDOf(game.getIndexCurrPlayer()), (SalaryTaxDue) c);

            /* Display the informational message. */
            info = new GenericInfo(game.getBlueInfo(c, displayFlag), "Salary Tax Due", "/assets/salaryTaxDue.png");

            /* Update the log. */
            mainScr.addToLog(game.getBlueInfo(c, displayFlag));

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

        } else if (c instanceof SkiAccident) {
            GenericInfo info;           // informational message
            int displayFlag;            // represents the execution of the blue card

            /* Execute the instructions specified. */
            displayFlag = game.executeBlueCard(game.getIDOf(game.getIndexCurrPlayer()), (SkiAccident) c);

            /* Display the informational message. */
            info = new GenericInfo(game.getBlueInfo(c, displayFlag), "Ski Accident", "/assets/skiAccident.png");

            /* Update the log. */
            mainScr.addToLog(game.getBlueInfo(c, displayFlag));

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

        } else if (c instanceof TipTheServer) {
            /* Set the attributes since execution will be passed to another controller. */
            this.spinComponent = SPIN_COMPONENT_CARD;
            this.c = c;

            /* Activate the GUI and controller for wheel spinning. Turn switching is handled there. */
            SpinWheel spinScr;
            spinScr = new SpinWheel("Tip the Server", c.getInfo() + "Spin the wheel and the amount at stake " +
                    "is 1000 times that number. \n");

            /* Disable all the buttons in the main screen. */
            mainScr.disableAllButtons();

            PlayerRandSpinController spinCtrl;
            spinCtrl = new PlayerRandSpinController(spinScr, mainScr, this, game);

        } else if (c instanceof ComputerRepair) {
            /* Set the attributes since execution will be passed to another controller. */
            this.spinComponent = SPIN_COMPONENT_CARD;
            this.c = c;

            /* Activate the choose player GUI and controller. Turn switching is handled there. */
            SpinWheel spinScr;
            spinScr = new SpinWheel("Computer Repair", c.getInfo() + "Spin the wheel and the amount at stake is 5000" +
                    "if the number is even or 10000 if the number is odd.\n");

            /* Disable all the buttons in the main screen. */
            mainScr.disableAllButtons();

            PlayerRandSpinController spinCtrl;
            spinCtrl = new PlayerRandSpinController(spinScr, mainScr, this, game);

        } else if (c instanceof WorldCup) {
            GenericInfo info;           // informational message
            int displayFlag;            // represents the execution of the blue card

            /* Execute the instructions specified. */
            displayFlag = game.executeBlueCard(game.getIDOf(game.getIndexCurrPlayer()), (WorldCup) c);

            /* Display the informational message. */
            info = new GenericInfo(game.getBlueInfo(c, displayFlag), "World Cup", "/assets/worldCup.png");

            /* Update the log. */
            mainScr.addToLog(game.getBlueInfo(c, displayFlag));

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));

        } else if (c instanceof F1Race) {
            GenericInfo info;           // informational message
            int displayFlag;            // represents the execution of the blue card

            /* Execute the instructions specified. */
            displayFlag = game.executeBlueCard(game.getIDOf(game.getIndexCurrPlayer()), (F1Race) c);

            /* Display the informational message. */
            info = new GenericInfo(game.getBlueInfo(c, displayFlag), "F1 Race", "/assets/f1Race.png");

            /* Update the log. */
            mainScr.addToLog(game.getBlueInfo(c, displayFlag));

            /* TURN OF THE NEXT PLAYER */
            game.switchTurn();

            /* Update the game log, and enable all pertinent buttons. */
            mainScr.addToLog(game.getPromptSpinWheel(game.getIDOf(game.getIndexCurrPlayer())));
            mainScr.enableAllButtonsExceptGo();
            mainScr.setPayEnabled(game.getCurrNumLoans(game.getIDOf(game.getIndexCurrPlayer())));
        }
    }

    /**
     * Returns the code of the component of the game requesting for the spin (the component is
     * either a space or a card): <code>SPIN_COMPONENT_CARD</code> or  <code>SPIN_COMPONENT_SPACE</code>
     *
     * @return code of the component of the game requesting for the spin (the component is
     *         either a space or a card)
     */
    public int getSpinComponent() {
        return spinComponent;
    }

    /**
     * Returns the active card (the card drawn by the player at specific points in the game)
     *
     * @return active card
     */
    public Card getCard() {
        return c;
    }

    /**
     * Sets the active card to the one specified
     *
     * @param c specified active card
     */
    public void setCard(Card c) {
        this.c = c;
    }

    /**
     * Returns the other active card (the other card drawn by the player at specific points in the game,
     * such as in the case when two cards are drawn on a College Career Choice space)
     *
     * @return other active card
     */
    public Card getOtherCard() {
        return d;
    }

    /**
     * Sets the other card to the one specified (such as in the case when two cards are drawn on a College
     * Career Choice space)
     *
     * @param d specified other active card
     */
    public void setOtherCard(Card d) {
        this.d = d;
    }

    /**
     * Returns all the available house cards
     *
     * @return available house cards
     */
    public ArrayList<HouseCard> getHouseCards() {
        return h;
    }

    /**
     * Returns the active colored space (that is, the colored space where the current player landed)
     *
     * @return active colored space
     */
    public ColoredSpace getColoredSpace() {
        return s;
    }
}
