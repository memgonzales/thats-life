package core;

import cards.*;
import cards.action_cards.CollectFromTheBank;
import cards.action_cards.PayTheBank;
import cards.action_cards.collect_from_player.FileALawsuit;
import cards.action_cards.collect_from_player.ItsYourBirthday;
import cards.action_cards.pay_player.ChristmasBonus;
import cards.action_cards.pay_player.Lawsuit;
import cards.blue_cards.*;
import decks.*;
import spaces.*;
import spaces.green_spaces.PayDay;
import spaces.green_spaces.PayRaise;
import spaces.magenta_spaces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Class implementing the <b>game master of That's Life</b>, the central class
 * that provides access to all the methods necessary to play the game
 *
 * <p>The machine project specifications describe the game as follows (authored
 * by Ms. Shirley B. Chu of the College of Computer Studies): </p>
 *
 * <p>"That's Life! mirrors life events of people from going to college, having a career,
 * raising a family, investing, buying a house, working, and retiring. The goal of this
 * game is to reach retirement as early as possible with the most earnings on hand. </p>
 *
 * <p>"The player decides what kind of life he wants to experience during the game. At the
 * start of each round, the player presses for a randomly generated number [1-10]. This
 * determines the number of spaces he will advance on the board. </p>
 *
 * <p>"Unlike the usual board games, where there is only one path to the end, That's Life!,
 * at some areas along the way, present players with two options: to continue moving
 * forward, or to take a shorter (or maybe longer) route to reach another space on the
 * board."</p>
 */
public class GameMaster {
    /* Players of the game */
    private ArrayList<Player> players;

    private ArrayList<Player> activePlayers;

    /* Number wheel of the game */
    private NumberWheel numWheel;
    /* Bank of the game */
    private Bank gameBank;

    /* Career card deck */
    private CareerCardDeck careerDeck;
    /* Salary card deck */
    private SalaryCardDeck salaryDeck;
    /* Action card deck */
    private ActionCardDeck actionDeck;
    /* Blue card deck */
    private BlueCardDeck blueDeck;
    /* House card deck */
    private HouseCardDeck houseDeck;

    /* Pile where the drawn and discarded action cards are transferred */
    private DiscardPile pile;
    /* Board consisting of colored spaces where the actual gameplay happens */
    private Board gameBoard;

    /* Number of retirees */
    private int numRetirees;

    /* The first Integer object in this ArrayList is the index of the first player
    to move, and so on.
     */
    private ArrayList<Integer> playerTurns;
    /* Index of the current player */
    private int indexCurrPlayer;
    /* Move number. Note that, if the player moves twice successively (as in the case when he/she
    steps on a magenta space), then the move number is not incremented.
     */
    private int moveNum;

    /**
     * Numerical code for the normal (unchanged) path
     */
    public static final int NORMAL_PATH_CODE = 0;
    /**
     * Numerical code for the Career Path
     */
    public static final int CAREER_PATH_CODE = 1;
    /**
     * Numerical code for the College path
     */
    public static final int COLLEGE_PATH_CODE = 2;
    /**
     * Numerical code for the Change Career path
     */
    public static final int CHANGE_CAREER_PATH_CODE = 3;
    /**
     * Numerical code for the Start a Family path
     */
    public static final int START_FAMILY_PATH_CODE = 4;

    /**
     * Per the specifications, there must be at least two players.
     */
    public static final int MIN_NUM_PLAYERS = 2;
    /**
     * Per the specifications, there must be at most three players.
     */
    public static final int MAX_NUM_PLAYERS = 3;

    /**
     * Retirement benefit added to the cash of the first player to reach the last space
     */
    public static final int RETIREMENT_BENEFIT_FIRST = 100000;
    /**
     * Retirement benefit added to the cash of the second player to reach the last space
     */
    public static final int RETIREMENT_BENEFIT_SECOND = 50000;
    /**
     * Retirement benefit added to the cash of the third player (in the three-player mode) to reach the last space
     */
    public static final int RETIREMENT_BENEFIT_THIRD = 20000;
    /**
     * Retirement benefit added to the cash of the each player per children
     */
    public static final int RETIREMENT_CHILDREN_BENEFIT = 10000;

    /**
     * Name (string) corresponding to the normal path
     */
    public static final String NORMAL_PATH = "Normal Path";
    /**
     * Name (string) corresponding to the Career Path
     */
    public static final String CAREER_PATH = "Career Path";
    /**
     * Name (string) corresponding to the College path
     */
    public static final String COLLEGE_PATH = "College Path";
    /**
     * Name (string) corresponding to the Change Career path
     */
    public static final String CHANGE_CAREER_PATH = "Change Career Path";
    /**
     * Name (string) corresponding to the Start a Family path
     */
    public static final String START_FAMILY_PATH = "Start a Family Path";

    /**
     * Description corresponding to the normal path
     */
    public static final String NORMAL_PATH_DESC = "Continue along the regular path.";
    /**
     * Description corresponding to the Career Path
     */
    public static final String CAREER_PATH_DESC = "Get a career and salary immediately.";
    /**
     * Description corresponding to the College path
     */
    public static final String COLLEGE_PATH_DESC = "Take out a loan to earn a degree.";
    /**
     * Description corresponding to the Change Career path
     */
    public static final String CHANGE_CAREER_PATH_DESC = "Try to find a different career.";
    /**
     * Description corresponding to the Start a Family path
     */
    public static final String START_FAMILY_PATH_DESC = "Buy a house, marry, and have children.";

    /**
     * Creates a game master object with the number of players and list of their
     * usernames as parameters
     *
     * <p>In particular, all the necessary game components (<code>ArrayList</code> for the
     * players, number wheel, Bank, decks, and discard pile) are created. </p>
     */
    public GameMaster() {
        /* Create the ArrayList for the players. */
        players = new ArrayList<Player>(MAX_NUM_PLAYERS);
        activePlayers = new ArrayList<Player>(MAX_NUM_PLAYERS);

        /* Create all the necessary game components. */
        numWheel = new NumberWheel();
        gameBank = new Bank(MAX_NUM_PLAYERS);

        careerDeck = new CareerCardDeck();
        salaryDeck = new SalaryCardDeck();
        actionDeck = new ActionCardDeck();
        blueDeck = new BlueCardDeck();
        houseDeck = new HouseCardDeck();

        gameBoard = new Board();

        pile = new DiscardPile();
    }

    /**
     * Sets the players of the game given their usernames at the start of the game
     *
     * <p>Assume that all the usernames are valid and unique. Invalid usernames
     * (e.g, blank usernames and duplicates) are already checked during input, and
     * the user is prompted to correct these before this function is called.</p>
     *
     * @param playerNames usernames of the players
     */
    public void setPlayers(ArrayList<String> playerNames) {
        /* Create Player objects given usernames, and set the players of the game */
        for (int i = 0; i < playerNames.size(); i++)
            players.add(new Player(playerNames.get(i)));

        activePlayers.addAll(players);
    }

    /**
     * Sets the order in which the players are to make their moves
     */
    public void setPlayerTurns() {
        playerTurns = generatePlayerTurns();
    }

    /**
     * Updates the pertinent attribute corresponding to the index of the current player
     */
    public void setIndexCurrPlayer() {
        indexCurrPlayer = playerTurns.get(moveNum % players.size());

        /* Increment the number of moves */
        moveNum++;
    }

    /**
     * Returns the index of the current player
     *
     * @return index of the current player
     */
    public int getIndexCurrPlayer() {
        return indexCurrPlayer;
    }

    /**
     * Returns the names of the players in the order in which they make their moves
     *
     * @return names of the players in the order in which they make their moves
     */
    public ArrayList<String> getOrderedPlayers() {
        String [] orderedPlayers;       // names of the players in the order of their moves
        int index;                      // index of the player
		ArrayList<String> orderedPlayersList;	// array list of ordered players
		
		orderedPlayersList = new ArrayList<>();
        orderedPlayers = new String[3];

        /* Iterate through all the players, storing their names in the array corresponding
        to the order in which they make their moves
         */
        for (int i = 0; i < players.size(); i++) {
            index = playerTurns.get(i);
            orderedPlayers[index] = players.get(i).getName();
        }
		
		for (int i = 0; i < players.size(); i++) {
            orderedPlayersList.add(orderedPlayers[i]);
        }

        /* Return the ArrayList. */
        return orderedPlayersList;
    }

    /**
     * Returns the list of the usernames of the players
     *
     * @return list of the usernames of the players
     */
    public ArrayList<String> getPlayerNames() {
        ArrayList<String> playerNames;
        playerNames = new ArrayList<String>(players.size());

        /* Add the name of each player to the list to be returned by this method. */
        for (int i = 0; i < players.size(); i++)
            playerNames.add(players.get(i).getName());

        return playerNames;
    }

    /**
     * Returns the details of the player given his/her ID number
     *
     * <p>In particular, the details correspond to those contained in the string
     * representation of the player: </p>
     *
     * <ul>
     *     <li>Username</li>
     *     <li>ID number</li>
     *     <li>Career</li>
     *     <li>Base salary</li>
     *     <li>Salary</li>
     *     <li>Base tax due</li>
     *     <li>Base pay raise</li>
     *     <li>Current pay raise (total)</li>
     *     <li>Number of pay raises</li>
     *     <li>Maximum number of pay raises</li>
     *     <li>Current cash</li>
     *     <li>Current number of unpaid loans</li>
     *     <li>Details about the player's house (name, buying and selling prices) </li>
     * </ul>
     *
     * @param playerID ID number of the player whose details are to be returned
     * @return details of the player
     */
    public String getPlayerDetails(int playerID) {
        return players.get(getIndexOf(playerID)).toString();
    }

    /**
     * Returns the details about all the players
     *
     * <p>In particular, the details correspond to those contained in the string
     * representation of the player: </p>
     *
     * <ul>
     *     <li>Username</li>
     *     <li>ID number</li>
     *     <li>Career</li>
     *     <li>Base salary</li>
     *     <li>Salary</li>
     *     <li>Base tax due</li>
     *     <li>Base pay raise</li>
     *     <li>Current pay raise (total)</li>
     *     <li>Number of pay raises</li>
     *     <li>Maximum number of pay raises</li>
     *     <li>Current cash</li>
     *     <li>Current number of unpaid loans</li>
     *      <li>Details about the player's house (name, buying and selling prices) </li>
     * </ul>
     *
     * @return details about all the players
     */
    public ArrayList<String> getAllPlayersDetails() {
        ArrayList<String> allPlayersDetails;
        allPlayersDetails = new ArrayList<String>(players.size());

        /* Add the details of every player to the ArrayList to be returned. */
        for (int i = 0; i < players.size(); i++)
            allPlayersDetails.add(getPlayerDetails(players.get(i).getID()));

        return allPlayersDetails;
    }

    /**
     * Returns the number of players
     *
     * @return number of players
     */
    public int getNumPlayers() {
        return players.size();
    }

    /**
     * Returns the details about the number wheel
     *
     * <p>In particular, the details correspond to those contained in the string
     * representation of the number wheel:</p>
     *
     * <ul>
     *     <li>The label "Wheel: ", followed by the numbers that can be obtained
     *     by spinning it (each value separated by a tab character) </li>
     * </ul>
     *
     * @return details about the number wheel
     */
    public String getNumWheelDetails() {
        return numWheel.toString();
    }

    /**
     * Returns the details about the Bank
     *
     * <p>In particular, the details correspond to those contained in the string
     * representation of the Bank:</p>
     *
     * <ul>
     *     <li>Type of game component (Bank)</li>
     *     <li>Number of unpaid loans of all the players (arranged starting
     *     with the first player to input his/her username)</li>
     * </ul>
     *
     * @return details about the Bank
     */
    public String getBankDetails() {
        return gameBank.toString();
    }

    /**
     * Returns the details about the career card deck
     *
     * <p>In particular, the details correspond to those contained in the string
     * representation of the career card deck:</p>
     *
     * <ul>
     *     <li>Name of this deck (Career Card Deck)</li>
     *     <li>Number of cards initially</li>
     *     <li>Number of cards currently</li>
     *     <li>String representations of the cards currently inside it
     *     (the first card displayed is the topmost)</li>
     * </ul>
     *
     * @return details about the career card deck
     */
    public String getCareerDeckDetails() {
        return careerDeck.toString();
    }

    /**
     * Returns the details about the salary card deck
     *
     * <p>In particular, the details correspond to those contained in the string
     * representation of the salary card deck:</p>
     *
     * <ul>
     *     <li>Name of this deck (Salary Card Deck)</li>
     *     <li>Number of cards initially</li>
     *     <li>Number of cards currently</li>
     *     <li>String representations of the cards currently inside it
     *     (the first card displayed is the topmost)</li>
     * </ul>
     *
     * @return details about the salary card deck
     */
    public String getSalaryDeckDetails() {
        return salaryDeck.toString();
    }

    /**
     * Returns the details about the action card deck
     *
     * <p>In particular, the details correspond to those contained in the string
     * representation of the action card deck:</p>
     *
     * <ul>
     *     <li>Name of this deck (Action Card Deck)</li>
     *     <li>Number of cards initially</li>
     *     <li>Number of cards currently</li>
     *     <li>String representations of the cards currently inside it
     *     (the first card displayed is the topmost)</li>
     * </ul>
     *
     * @return details about the action card deck
     */
    public String getActionDeckDetails() {
        return actionDeck.toString();
    }

    /**
     * Returns the number of retired players
     *
     * @return number of retired players
     */
    public int getNumRetirees() {
        return numRetirees;
    }

    /**
     *  Returns the number obtained after the player (identified via ID number)
     *  spins the number wheel
     *
     * @param currPlayerID ID number of the current player to spin the wheel
     * @return number obtained after spinning the number wheel
     */
    public int spinWheel(int currPlayerID) {
        return players.get(getIndexOf(currPlayerID)).spinWheel(numWheel);
    }

    /**
     * Advances the position of the player by the specified number of spaces,
     * following the rules of the game (for instance, a player must prematurely
     * stop on a magenta space)
     *
     * @param numSpaces number of spaces by which the player's position will advance
     */
    public void move(int numSpaces) {
        players.get(indexCurrPlayer).move(numSpaces, gameBoard);
    }

    /**
     * Grants the player (identified via ID number) a college degree, allowing him/her
     * to have a career that requires a degree (for example, Lawyer, Accountant, Computer
     * Consultant, and Doctor)
     *
     * @param currPlayerID ID number of the current player to graduate
     */
    public void graduate(int currPlayerID) {
        players.get(getIndexOf(currPlayerID)).graduate();
    }

    /**
     * Returns the prompt for the start space
     *
     * @param playerID ID of the pertinent player
     * @return prompt for the start space
     */
    public String getPromptStartSpace (int playerID) {
        return ((StartSpace) gameBoard.getColoredSpace(0)).getInfo(players.get(getIndexOf(playerID)));
    }

    /**
     * Returns the prompt for the spin wheel
     *
     * @param playerID ID of the pertinent player
     * @return prompt for the spin wheel
     */
    public String getPromptSpinWheel(int playerID) {
        return "\n\n\n" + "--- TURN OF " + players.get(getIndexOf(playerID)).getName() + " ---\n" +
                players.get(getIndexOf(playerID)).getName() + ", spin the wheel.\n";
    }

    /**
     * Returns the message when the wheel has been spun
     *
     * @param spinNum number obtained upon spinning the wheel
     * @return message when the wheel has been spun
     */
    public String spinMessage(int spinNum) {
        return players.get(indexCurrPlayer).getName() + " spun the number " + spinNum + ".\n";
    }

    /**
     * Returns the informational message when the player landed on a colored space
     *
     * @param currPlayerID ID of the pertinent player
     * @param s colored space on which the player landed
     * @return informational message when the player landed on a colored space
     */
    public String getInfoColoredSpace(int currPlayerID, ColoredSpace s) {

        /* Return the information message corresponding to the specific type of colored space. */
        if (s instanceof PayDay)
            return ((PayDay) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof PayRaise)
            return ((PayRaise) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof BlueSpace)
            return ((BlueSpace) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof OrangeSpace)
            return ((OrangeSpace) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof CollegeCareerChoice)
            return ((CollegeCareerChoice) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof JobSearch)
            return ((JobSearch) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof BuyAHouse)
            return ((BuyAHouse) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof GetMarried)
            return ((GetMarried) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof HaveBaby)
            return ((HaveBaby) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof HaveTwins)
            return ((HaveTwins) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof WhichPath)
            return ((WhichPath) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof GraduationSpace)
            return ((GraduationSpace) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof StartSpace)
            return ((StartSpace) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else if (s instanceof EndSpace)
            return ((EndSpace) s).getInfo(players.get(getIndexOf(currPlayerID)));
        else
            return ((StartSpace) s).getInfo(players.get(getIndexOf(currPlayerID)));
    }

    /**
     * Returns the informational message when the player draws a blue card
     *
     * @param c blue card drawn
     * @param blueCardFlag effect executed by the blue card depending on the career match
     *                     (as specified in the <code>BlueCard</code> class)
     * @return informational message when the player draws a blue card
     */
    public String getBlueInfo(BlueCard c, int blueCardFlag) {
        if (blueCardFlag == BlueCard.MATCHED_CAREER)
            return c.getInfoMatch();
        else if (blueCardFlag == BlueCard.NO_MATCH)
            return c.getInfoBank();
        else if (blueCardFlag == BlueCard.OTHER_MATCH)
            return c.getInfoOtherPlayer();

        return c.getInfoBank();
    }

    /**
     * Returns the informational message when the player lands on a Get Married space
     *
     * @param currPlayerID ID of the current player
     * @param s space where the player lands (in particular, a Get Married Space)
     * @return informational message when the player lands on a Get Married space
     */
    public String getInfoGetMarried(int currPlayerID, ColoredSpace s) {
        return ((GetMarried) s).getInfoDisplay(players.get(getIndexOf(currPlayerID)));
    }

    /**
     * Switches the turn, signaling that it is the turn of the next player to move
     */
    public void switchTurn() {
        try {
            indexCurrPlayer = playerTurns.get((playerTurns.indexOf(indexCurrPlayer) + 1) % playerTurns.size());
        } catch (ArithmeticException e) {
            /* If all players have now retired (leading to modulo 0), then do nothing. */
        }
    }

    /**
     * Sets the attribute of the player related to whether he/she has just landed on a Which Path
     * space
     *
     * @param playerID ID of the pertinent player
     * @param isFromWhichPath <code>true</code> if the player has just landed on a Which Path space (and remains <code>true</code>
     *                        until the player has made his next move); <code>false</code>, otherwise
     */
    public void setIsFromWhichPath(int playerID, boolean isFromWhichPath) {
        players.get(getIndexOf(playerID)).setIsFromWhichPath(isFromWhichPath);
    }

    /**
     * Returns <code>true</code> if the player has just landed on a Which Path space (and remains <code>true</code>
     *     until the player has made his next move); <code>false</code>, otherwise
     *
     * @param playerID ID of the pertinent player
     * @return <code>true</code> if the player has just landed on a Which Path space (and remains <code>true</code>
     * until the player has made his next move); <code>false</code>, otherwise
     */
    public boolean getIsFromWhichPath(int playerID) {
        return players.get(getIndexOf(playerID)).getIsFromWhichPath();
    }

    /**
     * Returns the informational message related to the path specified
     *
     * @param path path chosen by the player
     * @return informational message related to the path specified
     */
    public String pathMessage(int path) {
        String pathName;

        pathName = "";
        switch (path) {
            case CAREER_PATH_CODE:
                pathName = CAREER_PATH;
                break;
            case COLLEGE_PATH_CODE:
                pathName = COLLEGE_PATH;
                break;
            case NORMAL_PATH_CODE:
                pathName = NORMAL_PATH;
                break;
            case CHANGE_CAREER_PATH_CODE:
                pathName = CHANGE_CAREER_PATH;
                break;
            case START_FAMILY_PATH_CODE:
                pathName = START_FAMILY_PATH;
                break;
        }

        return players.get(indexCurrPlayer).getName() + " chose the " + pathName + ".\n\n";
    }

    /**
     * Returns the code of the path followed by the specified player
     *
     * @param playerIndex index of the player
     * @return code of the path followed by the specified player
     */
    public int getPath(int playerIndex) {
        return players.get(playerIndex).getPath();
    }

    /**
     * Allows a player to draw an applicable career card and drawn a salary card as well
     * to define his career, maximum number of pay raises, salary, tax due, and pay raise
     *
     * @param currPlayerID ID of the current player
     */
    public void startCareer(int currPlayerID) {
        CareerCard cCard;           // career card drawn by the player
        SalaryCard sCard;           // salary card drawn by the player
        Player currPlayer;          // current player

        currPlayer = players.get(getIndexOf(currPlayerID));

        cCard = currPlayer.drawFromCareerDeck(careerDeck);

        /* Ensure that a non-degree holder can only keep a career card that does not require a degree.
        Keep drawing a career card, until this condition is satisfied.

        This loop will certainly terminate since there are three non-degree career cards and there is a
        maximum of three players, accounting for the edge case of three players all choosing Career Path.
         */
        while (!currPlayer.getHasDegree() && cCard.getIsDegreeRequired()) {
            currPlayer.returnCardToBottom(cCard, careerDeck);
            cCard = currPlayer.drawFromCareerDeck(careerDeck);
        }

        /* Draw a salary card. */
        sCard = currPlayer.drawFromSalaryDeck(salaryDeck);

        currPlayer.keepCareerCard(cCard);
        currPlayer.keepSalaryCard(sCard);
    }

    /**
     * Allows the current player to start college by loaning $40000 from the bank
     *
     * @param currPlayerID ID of the current player
     */
    public void startCollege(int currPlayerID) {
        Player currPlayer;      // current player
        currPlayer = players.get(getIndexOf(currPlayerID));

        /* Borrow 2 loans from the bank, totaling to the required $40000. */
        currPlayer.borrowLoan(gameBank, 2);

        /* This effectively sets the cash of a player who opted for the College Path to have his
        cash remain at $200000 (there is no increase since the loaned amount is deemed as payment
        for his education). Note that this function does not decrease the number of current loans.
         */
        currPlayer.payCashToBank(gameBank, Bank.LEND_MULTIPLE * 2);
    }

    /**
     * Returns a string corresponding to the color of a colored space given its position
     *
     * @param position position of a colored space
     * @return color of a colored space given its position
     */
    public String getColorPosition(int position) {
        if (gameBoard.isBlueSpace(position))
            return "Blue";
        else if (gameBoard.isGreenSpace(position))
            return "Green";
        else if (gameBoard.isMagentaSpace(position))
            return "Magenta";
        else if (gameBoard.isOrangeSpace(position))
            return "Orange";

        return "";
    }

    /**
     * Returns the colored space given its position
     *
     * @param position position of a colored space
     * @return colored space given its position
     */
    public ColoredSpace getColoredSpace(int position) {
        return gameBoard.getColoredSpace(position);
    }

    /**
     * Returns the position of the current player (identified via ID number)
     *
     * @param currPlayerID ID number of the current player
     * @return position of the current player
     */
    public int getPosition(int currPlayerID) {
        return players.get(getIndexOf(currPlayerID)).getPositionOnBoard();
    }

    /**
     * Executes the instructions indicated on the start space
     *
     * @param playerID ID number of the current player
     * @param path path chosen by the player at the most recent junction (Which Path space)
     */
    public void executeStartSpace(int playerID, int path) {
        ((StartSpace) gameBoard.getColoredSpace(0)).execute(players.get(getIndexOf(playerID)), path);
    }

    /**
     * Executes the instructions indicated on the Pay Day green space where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param s Pay Day green space where the player landed
     */
    public void executeGreenSpace(int currPlayerID, PayDay s) {
        s.execute(players.get(getIndexOf(currPlayerID)), gameBank);
    }

    /**
     * Executes the instructions indicated on the Pay Raise green space where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param s Pay Raise green space where the player landed
     */
    public void executeGreenSpace(int currPlayerID, PayRaise s) {
        s.execute(players.get(getIndexOf(currPlayerID)), gameBank);
    }

    /**
     * Executes the instructions indicated on the Get Married magenta space where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param s Get Married magenta space where the player landed
     * @param randNum random number used to determine the amount received
     */
    public void executeMagentaSpace(int currPlayerID, GetMarried s, int randNum) {
        s.execute(players.get(getIndexOf(currPlayerID)), randNum, activePlayers, gameBank);
    }

    /**
     * Executes the instructions indicated on the Have Baby magenta space where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param s Have Baby magenta space where the player landed
     */
    public void executeMagentaSpace(int currPlayerID, HaveBaby s) {
        s.execute(players.get(getIndexOf(currPlayerID)), activePlayers, gameBank);
    }

    /**
     * Executes the instructions indicated on the Have Twins magenta space where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param s Have Twins magenta space where the player landed
     */
    public void executeMagentaSpace(int currPlayerID, HaveTwins s) {
        s.execute(players.get(getIndexOf(currPlayerID)), activePlayers, gameBank);
    }

    /**
     * Executes the instructions indicated on the Which Path magenta space where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param s Which Path magenta space where the player landed
     * @param path path chosen by the player
     */
    public void executeMagentaSpace(int currPlayerID, WhichPath s, int path) {
        s.execute(players.get(getIndexOf(currPlayerID)), path);
    }

    /**
     * Executes the instructions indicated on the Graduation magenta space where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param s Graduation magenta space where the player landed
     */
    public void executeMagentaSpace(int currPlayerID, GraduationSpace s) {
        graduate(currPlayerID);
    }

    /**
     * Returns the career cards drawn by the player on the College Career Choice magenta space where he/she landed
     *
     * @param currPlayerID ID number of the current player
     * @param s College Career Choice magenta space where the player landed
     * @return career cards drawn by the player on the College Career Choice magenta space where he/she landed
     */
    public ArrayList<CareerCard> drawCareerCards(int currPlayerID, CollegeCareerChoice s) {
        return s.drawCareerCards(players.get(getIndexOf(currPlayerID)), careerDeck);
    }

    /**
     * Returns the salary cards drawn by the player on the College Career Choice magenta space where he/she landed
     *
     * @param currPlayerID ID number of the current player
     * @param s College Career Choice magenta space where the player landed
     * @return salary cards drawn by the player on the College Career Choice magenta space where he/she landed
     */
    public ArrayList<SalaryCard> drawSalaryCards(int currPlayerID, CollegeCareerChoice s) {
        return s.drawSalaryCards(players.get(getIndexOf(currPlayerID)), salaryDeck);
    }

    /**
     * Returns the salary cards drawn by the player on the Job Search magenta space where he/she landed
     *
     * @param currPlayerID ID number of the current player
     * @param s Job Search magenta space where the player landed
     * @return salary card drawn by the player, alongside his/her current one, on the Job Search magenta space where he/she landed
     */
    public ArrayList<SalaryCard> drawSalaryCards(int currPlayerID, JobSearch s) {
        return s.drawSalaryCard(players.get(getIndexOf(currPlayerID)), salaryDeck);
    }

    /**
     * Returns the career cards drawn by the player on the Job Search magenta space where he/she landed
     *
     * @param currPlayerID ID number of the current player
     * @param s Job Search magenta space where the player landed
     * @return career card drawn by the player, alongside his/her current one, on the Job Search magenta space where he/she landed
     */
    public ArrayList<CareerCard> drawCareerCards(int currPlayerID, JobSearch s) {
        return s.drawCareerCard(players.get(getIndexOf(currPlayerID)), careerDeck);
    }

    /**
     * Returns the house cards available to the player on the Buy a House magenta space where he/she landed
     *
     * @param currPlayerID ID number of the current player
     * @param s Buy a House magenta space where the player landed
     * @return house cards available to the player player on the Buy a House magenta space where he/she landed
     */
    public ArrayList<HouseCard> drawHouseCardsToBuy(int currPlayerID, BuyAHouse s) {
        return s.getHouseCards(players.get(getIndexOf(currPlayerID)), houseDeck);
    }

    /**
     * Executes the instructions related to career choosing as specified on the College Career Choice space
     * where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param careerCards career cards drawn by the player on the College Career Choice space
     * @param s College Career Choice magenta space where the player landed
     * @param index index of the career card with respect to those drawn by the player
     */
    public void executeCareer(int currPlayerID, ArrayList<CareerCard> careerCards, CollegeCareerChoice s, int index) {
        s.executeCareer(players.get(getIndexOf(currPlayerID)), careerCards, careerDeck, index);
    }

    /**
     * Executes the instructions related to salary choosing as specified on the College Career Choice space
     * where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param salaryCards salary cards drawn by the player on the College Career Choice space
     * @param s College Career Choice magenta space where the player landed
     * @param index index of the salary card with respect to those drawn by the player
     */
    public void executeSalary(int currPlayerID, ArrayList<SalaryCard> salaryCards, CollegeCareerChoice s, int index) {
        s.executeSalary(players.get(getIndexOf(currPlayerID)), salaryCards, salaryDeck, index);
    }

    /**
     * Executes the instructions related to career choosing as specified on the Job Search space
     * where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param careerCards career card drawn by the player on the Job Search space (alongside his/her current one)
     * @param s Job Search magenta space where the player landed
     * @param index index of the career card with respect to the one drawn by the player (alongside his/her current one)
     */
    public void executeCareer(int currPlayerID, ArrayList<CareerCard> careerCards, JobSearch s, int index) {
        s.executeCareer(players.get(getIndexOf(currPlayerID)), careerCards, careerDeck, index);
    }

    /**
     * Executes the instructions related to salary choosing as specified on the Job Search space
     * where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param salaryCards salary card drawn by the player on the Job Search space (alongside his/her current one)
     * @param s Job Search magenta space where the player landed
     * @param index index of the salary card with respect to the one drawn by the player (alongside his/her current one)
     */
    public void executeSalary(int currPlayerID, ArrayList<SalaryCard> salaryCards, JobSearch s, int index) {
        s.executeSalary(players.get(getIndexOf(currPlayerID)), salaryCards, salaryDeck, index);
    }

    /**
     * Executes the instructions related to house purchase choosing as specified on the Buy a House space
     * where the player landed
     *
     * @param currPlayerID ID number of the current player
     * @param houseCards house cards available to the player on the Buy a House space
     * @param s Buy a House magenta space where the player landed
     * @param index index of the house card with respect to the available house cards upon landing on the space
     */
    public void executeBuyHouse(int currPlayerID, ArrayList<HouseCard> houseCards, BuyAHouse s, int index) {
        s.execute(players.get(getIndexOf(currPlayerID)), houseCards, houseDeck, index, gameBank);
    }

    /**
     * Returns the details of the salary card of the current player (identified via ID)
     *
     * @param currPlayerID ID of the current player
     * @return details of the salary card of the current player
     */
    public String getSalaryCardDetails(int currPlayerID) {
        if (players.get(getIndexOf(currPlayerID)).getSalaryCard() != null)
            return players.get(getIndexOf(currPlayerID)).getSalaryCard().toString();

        return "No salary card just yet";
    }

    /**
     * Returns the details of the career card of the current player (identified via ID)
     *
     * @param currPlayerID ID of the current player
     * @return details of the career card of the current player
     */
    public String getCareerCardDetails(int currPlayerID) {
        if (players.get(getIndexOf(currPlayerID)).getCareerCard() != null)
            return players.get(getIndexOf(currPlayerID)).getCareerCard().toString();

        return "No career card just yet";
    }

    /**
     * Returns the details of the house card of the current player (identified via ID)
     *
     * @param currPlayerID ID of the current player
     * @return details of the house card of the current player
     */
    public String getHouseCardDetails(int currPlayerID) {
        if (players.get(getIndexOf(currPlayerID)).getHouseCard() != null)
            return players.get(getIndexOf(currPlayerID)).getHouseCard().toString();

        return "No house card just yet";
    }

    /**
     * Returns the details of the salary cards kept by all the players
     *
     * @return details of the salary cards kept by all the players
     */
    public ArrayList<String> getAllSalaryCardDetails() {
        ArrayList<String> salaryCardDetails;        // details of the salary cards kept by all the players
        salaryCardDetails = new ArrayList<String>(players.size());

        /* Iterate through all the players. */
        for (int i = 0; i < players.size(); i++)
            salaryCardDetails.add(getSalaryCardDetails(getIDOf(i)));

        return salaryCardDetails;
    }

    /**
     * Returns the details of the career cards kept by all the players
     *
     * @return details of the career cards kept by all the players
     */
    public ArrayList<String> getAllCareerCardDetails() {
        ArrayList<String> careerCardDetails;        // details of the career cards kept by all the players
        careerCardDetails = new ArrayList<String>(players.size());

        /* Iterate through all the players. */
        for (int i = 0; i < players.size(); i++)
            careerCardDetails.add(getCareerCardDetails(getIDOf(i)));

        return careerCardDetails;
    }

    /**
     * Returns the action card drawn by the player (identified via ID number) from
     * the action card deck
     *
     * @param currPlayerID ID number of the current player to draw a action card
     * @return action card drawn by the player
     */
    public ActionCard drawFromActionDeck(int currPlayerID) {
        return players.get(getIndexOf(currPlayerID)).drawFromActionDeck(actionDeck, pile);
    }

    /**
     * Returns the blue card drawn by the player (identified via ID number) from
     * the blue card deck
     *
     * @param currPlayerID ID number of the current player to draw a blue card
     * @return blue card drawn by the player
     */
    public BlueCard drawFromBlueDeck(int currPlayerID) {
        return players.get(getIndexOf(currPlayerID)).drawFromBlueDeck(blueDeck);
    }

    /**
     * Executes the instructions indicated in the given Computer Repair blue card
     *
     * @param currPlayerID ID number of the current player
     * @param c given Computer Repair blue card
     * @param randNum random number dictating the amount
     * @return <code>MATCHED_CAREER</code> if the career in the blue card matches that of the player, <code>NO_MATCH</code>
     * if the career has no match among the players, or <code>OTHER_MATCH</code> if the career matches that of another player
     */
    public int executeBlueCard(int currPlayerID, ComputerRepair c, int randNum) {
        return players.get(getIndexOf(currPlayerID)).executeBlueCard(c,
                findPlayerWithCareer(c.getCareerMatch()), gameBank, randNum);
    }

    /**
     * Executes the instructions indicated in the given F1 Race blue card
     *
     * @param currPlayerID ID number of the current player
     * @param c given F1 Race blue card
     * @return <code>MATCHED_CAREER</code> if the career in the blue card matches that of the player, <code>NO_MATCH</code>
     * if the career has no match among the players, or <code>OTHER_MATCH</code> if the career matches that of another player
     */
    public int executeBlueCard(int currPlayerID, F1Race c) {
        return players.get(getIndexOf(currPlayerID)).executeBlueCard(c,
                findPlayerWithCareer(c.getCareerMatch()), gameBank);
    }

    /**
     * Executes the instructions indicated in the given Lawsuit blue card
     *
     * @param currPlayerID ID number of the current player
     * @param c given Lawsuit blue card
     * @return <code>MATCHED_CAREER</code> if the career in the blue card matches that of the player, <code>NO_MATCH</code>
     * if the career has no match among the players, or <code>OTHER_MATCH</code> if the career matches that of another player
     */
    public int executeBlueCard(int currPlayerID, LawsuitBlue c) {
        return players.get(getIndexOf(currPlayerID)).executeBlueCard(c,
                findPlayerWithCareer(c.getCareerMatch()), gameBank);
    }

    /**
     * Executes the instructions indicated in the given Salary Tax Due blue card
     *
     * @param currPlayerID ID number of the current player
     * @param c given Salary Tax Due blue card
     * @return <code>MATCHED_CAREER</code> if the career in the blue card matches that of the player, <code>NO_MATCH</code>
     * if the career has no match among the players, or <code>OTHER_MATCH</code> if the career matches that of another player
     */
    public int executeBlueCard(int currPlayerID, SalaryTaxDue c) {
        return players.get(getIndexOf(currPlayerID)).executeBlueCard(c,
                findPlayerWithCareer(c.getCareerMatch()), gameBank);
    }

    /**
     * Executes the instructions indicated in the given Ski Accident blue card
     *
     * @param currPlayerID ID number of the current player
     * @param c given Ski Accident blue card
     * @return <code>MATCHED_CAREER</code> if the career in the blue card matches that of the player, <code>NO_MATCH</code>
     * if the career has no match among the players, or <code>OTHER_MATCH</code> if the career matches that of another player
     */
    public int executeBlueCard(int currPlayerID, SkiAccident c) {
        return players.get(getIndexOf(currPlayerID)).executeBlueCard(c,
                findPlayerWithCareer(c.getCareerMatch()), gameBank);
    }

    /**
     * Executes the instructions indicated in the given Tip the Server blue card
     *
     * @param currPlayerID ID number of the current player
     * @param c given Tip the Server blue card
     * @param randNum random number dictating the amount
     * @return <code>MATCHED_CAREER</code> if the career in the blue card matches that of the player, <code>NO_MATCH</code>
     * if the career has no match among the players, or <code>OTHER_MATCH</code> if the career matches that of another player
     */
    public int executeBlueCard(int currPlayerID, TipTheServer c, int randNum) {
        return players.get(getIndexOf(currPlayerID)).executeBlueCard(c,
                findPlayerWithCareer(c.getCareerMatch()), gameBank, randNum);
    }

    /**
     * Executes the instructions indicated in the given World Cup blue card
     *
     * @param currPlayerID ID number of the current player
     * @param c given World Cup blue card
     * @return <code>MATCHED_CAREER</code> if the career in the blue card matches that of the player, <code>NO_MATCH</code>
     * if the career has no match among the players, or <code>OTHER_MATCH</code> if the career matches that of another player
     */
    public int executeBlueCard(int currPlayerID, WorldCup c) {
        return players.get(getIndexOf(currPlayerID)).executeBlueCard(c,
                findPlayerWithCareer(c.getCareerMatch()), gameBank, players.size());
    }

    /**
     * Executes the instructions indicated in the given Collect from the Bank
     * action card
     *
     * @param currPlayerID ID number of the current player
     * @param c given Collect from the Bank action card
     */
    public void executeActionCard(int currPlayerID, CollectFromTheBank c) {
        players.get(getIndexOf(currPlayerID)).executeActionCard(c, gameBank);
    }

    /**
     * Executes the instructions indicated in the given Pay the Bank
     * action card
     *
     * @param currPlayerID ID number of the current player
     * @param c given Pay the Bank action card
     */
    public void executeActionCard(int currPlayerID, PayTheBank c) {
        /* Execute the action card. */
        players.get(getIndexOf(currPlayerID)).executeActionCard(c, gameBank);
    }

    /**
     * Executes the instructions indicated in the Lawsuit action card
     * (a Pay the Player action card)
     *
     * @param currPlayerID ID number of the current player
     * @param c given Pay the Bank action card
     * @param otherPlayerName name of the other player involved in the lawsuit
     */
    public void executeActionCard(int currPlayerID, Lawsuit c, String otherPlayerName) {
        /* Execute the action card. */
        players.get(getIndexOf(currPlayerID)).executeActionCard(c,
                players.get(getIndexOf(otherPlayerName)), gameBank);
    }

    /**
     * Executes the instructions indicated in the Christmas Bonus action card
     * (a Pay the Player action card)
     *
     * @param currPlayerID ID number of the current player
     * @param c given Christmas Bonus  action card
     */
    public void executeActionCard(int currPlayerID, ChristmasBonus c) {
        /* Execute the action card. */
        players.get(getIndexOf(currPlayerID)).executeActionCard(c, activePlayers, gameBank);
    }

    /**
     * Executes the instructions indicated in the File a Lawsuit action card
     * (a Collect from Player action card)
     *
     * @param currPlayerID ID number of the current player
     * @param c given File a Lawsuit action card
     * @param otherPlayerName name of the other player involved in the lawsuit
     */
    public void executeActionCard(int currPlayerID, FileALawsuit c, String otherPlayerName) {
        /* Execute the action card. */
        players.get(getIndexOf(currPlayerID)).executeActionCard(c,
                players.get(getIndexOf(otherPlayerName)), gameBank);
    }

    /**
     * Executes the instructions indicated in the It's Your Birthday action card
     * (a Collect from Player action card)
     *
     * @param currPlayerID ID number of the current player
     * @param c given It's Your Birthday action card
     */
    public void executeActionCard(int currPlayerID, ItsYourBirthday c) {
        /* Execute this card. */
        players.get(getIndexOf(currPlayerID)).executeActionCard(c, activePlayers, gameBank);
    }

    /**
     * Sets the kept career card of this player (identified via ID number) to the given career card
     * and resets the current number of pay raises to 0 should this player decide to switch careers
     *
     * @param currPlayerID ID number of the player keeping the career card
     * @param c career card that will be kept by this player
     */
    public void keepCareerCard(int currPlayerID, CareerCard c) {
        players.get(getIndexOf(currPlayerID)).keepCareerCard(c);
    }

    /**
     * Sets the kept salary card of this player (identified via ID number) to the given salary card
     * and resets the current number of pay raises to 0 should this player decide to switch careers
     * (alongside salaries)
     *
     * @param currPlayerID ID number of the player keeping the salary card
     * @param c salary card that will be kept by this player
     */
    public void keepSalaryCard(int currPlayerID, SalaryCard c) {
        players.get(getIndexOf(currPlayerID)).keepSalaryCard(c);
    }

    /**
     * Sets the kept salary card of this player (identified via ID number) to the given house card
     * and decreases his cash accordingly in payment of the house
     *
     * @param currPlayerID ID number of the player keeping the house card
     * @param c house card that will be kept by this player
     */
    public void keepHouseCard(int currPlayerID, HouseCard c) {
        players.get(getIndexOf(currPlayerID)).keepHouseCard(c, gameBank);
    }

    /**
     * Allows the player (identified via ID number) to borrow the specified number of loans
     * from the Bank
     *
     * @param currPlayerID ID of the current player who will borrow loan from the Bank
     * @param numLoans number of loans to be borrowed from the Bank
     */
    public void borrowLoan(int currPlayerID, int numLoans) {
        players.get(getIndexOf(currPlayerID)).borrowLoan(gameBank, numLoans);
    }

    /**
     * Allows the player (identified via ID number) to make the specified number of payments
     * to the Bank, and returns <code>true</code> if the payment is successful; <code>false</code>,
     * otherwise
     *
     * <p>More formally, a payment is deemed successful if it does not cause the player
     * to have a cash deficit. </p>
     *
     * @param currPlayerID ID of the current player who will pay loans to the Bank
     * @param numLoans number of loans to be paid to the Bank
     * @return <code>true</code> if the player is able to pay the specified number
     * of loan payments to the Bank; <code>false</code>, otherwise
     */
    public boolean payLoan(int currPlayerID, int numLoans) {
        return players.get(getIndexOf(currPlayerID)).payLoan(gameBank, numLoans);
    }

    /**
     * Allows the player with the specified ID to receive a pay raise
     *
     * @param currPlayerID ID of the player to receve a pay raise
     */
    public void receivePayRaise(int currPlayerID) {
        players.get(getIndexOf(currPlayerID)).receivePayRaise();
    }

    /**
     * Performs the instructions when a player retires (that is, when he/she landed on the end space)
     * and removes him/her from the list of active players, effectively excluding him/her from the
     * switching of turns
     *
     * @param currPlayerID ID of the current player
     */
    public void retire(int currPlayerID) {
        /* Exclude the player from the switching of turns. */
        playerTurns.remove(playerTurns.indexOf(getIndexOf(currPlayerID)));

        /* Remove the player from the list of active players. */
        activePlayers.remove(players.get(getIndexOf(currPlayerID)));

        /* Execute the instruction related to retirement, and increment the number of retirees. */
        players.get(getIndexOf(currPlayerID)).retire(gameBank, ++numRetirees, careerDeck, salaryDeck, houseDeck);
    }

    /**
     * Returns <code>true</code> if the player with the specified ID is already retired (that is,
     * he/she is no longer counted among the active players); <code>false</code>, otherwise
     *
     * @param currPlayerID ID of the current player
     * @return <code>true</code> if the player is already retired (that is, he/she is no longer counted among the active players);
     * <code>false</code>, otherwise
     */
    public boolean isRetired(int currPlayerID) {
        /* The index of the player is not among those listed in the player turns since he/she is no longer
        counted among the active players.
         */
        return playerTurns.indexOf(getIndexOf(currPlayerID)) == -1;
    }

    /**
     * Returns <code>true</code> if the player with the specified ID is already retiring (that is,
     * he/she landed on the end space); <code>false</code>, otherwise
     *
     * @param currPlayerID ID of the current player
     * @return <code>true</code> if the player is already retiring (that is, he/she landed on the end space;
     * <code>false</code>, otherwise
     */
    public boolean isRetiring(int currPlayerID) {
        return players.get(getIndexOf(currPlayerID)).getPositionOnBoard() == Board.NUM_SPACES - 1;
    }

    /**
     * Returns <code>true</code> if the player with the specified ID is married; <code>false</code>,
     * otherwise
     *
     * @param currPlayerID ID of the current player
     * @return <code>true</code> if the player is married; <code>false</code>, otherwise
     */
    public boolean isMarried(int currPlayerID) {
        return players.get(getIndexOf(currPlayerID)).getIsMarried();
    }

    /**
     * Returns the current number of loans of the player given his ID
     *
     * @param currPlayerID ID of the current player
     * @return current number of loans of the player
     */
    public int getCurrNumLoans(int currPlayerID) {
        return players.get(getIndexOf(currPlayerID)).getCurrNumLoans();
    }

    /**
     * Returns the cash of the player given his ID
     *
     * @param currPlayerID ID of the current player
     * @return cash of the player
     */
    public int getCash(int currPlayerID) {
        return players.get(getIndexOf(currPlayerID)).getCash();
    }

    /**
     * Returns the ID of the player given his/her index
     *
     * @param playerIndex index of the player
     * @return ID of the player
     */
    public int getIDOf(int playerIndex) {
        return playerIndex + 1;
    }

    /**
     * Returns the index of a player given his/her ID number
     *
     * @param playerID ID number of the player
     * @return index of the player
     */
    private int getIndexOf(int playerID) {
        return playerID - 1;
    }

    /**
     * Returns the index of a player given his/her username
     *
     * @param playerName username of the player
     * @return index of the player
     */
    public int getIndexOf(String playerName) {
        /* The matching of usernames is case-insensitive. */
        for (int i = 0; i < players.size(); i++)
            if (playerName.equalsIgnoreCase(players.get(i).getName()))
                return i;

        return -1;
    }

    /**
     * Returns the index of a player with career matching the given career or
     * -1 if there is no such player
     *
     * @param career career which will be matched with the respective careers of the players
     * @return index of player with career matching the given career or -1 if there
     * is no such player
     */
    private int findPlayerIndexWithCareer (String career) {
        /* Perform case-insensitive string comparison of careers. */
        for (int i = 0; i < players.size(); i++)
            if (players.get(i).getCareerCard() != null)
                if (career.equalsIgnoreCase(players.get(i).getCareer()))
                    return i;

        /* No such player has been found. */
        return -1;
    }

    /**
     * Returns the player having the same career as the one specified; if there is no such player,
     * <code>null</code> is returned
     *
     * @param career specified career for matching
     * @return player with the same career as the one specified; <code>null</code>, otherwise
     */
    private Player findPlayerWithCareer (String career) {
        int playerIndexWithCareer;
        playerIndexWithCareer = findPlayerIndexWithCareer(career);

        if (playerIndexWithCareer != -1)
            return players.get(playerIndexWithCareer);

        return null;
    }

    /**
     * Returns the order of turns of the players
     *
     * <p>In particular, it generates an array of integers [0, number of players - 1],
     * then shuffles it using the method provided in the <code>Collections</code> class
     * to generate the random ordering of the turns of the players.</p>
     *
     * @return order of turns of the players
     */
    private ArrayList<Integer> generatePlayerTurns() {
        ArrayList<Integer> playerTurns;
        playerTurns = new ArrayList<Integer>(players.size());

        /* Construct an ArrayList of integers from 0 to the number of players, with the
        lower bound being exclusive.
         */
        for (int i = 0; i < players.size(); i++)
            playerTurns.add(i);

        /* Shuffle this ArrayList to generate a random ordering of the turns of the
        players. The first element of this shuffled ArrayList pertaint to the first
        player, and so on.
         */
        Collections.shuffle(playerTurns);

        return playerTurns;
    }

    /**
     * Returns the general instructions displayed at the start of the game, together
     * with the order of the player turns
     *
     * @return  general instructions displayed at the start of the game, together with the order of player turns
     */
    public String getInitialInstructions () {
        ArrayList<String> orderedPlayers;           // names of the players in the order of their turns
        orderedPlayers = getOrderedPlayers();

        String instructions;                        // general instuctions

        instructions = orderedPlayers.get(0) + " goes first.\n";
        instructions = instructions + orderedPlayers.get(1) + " goes second.\n";
        if (orderedPlayers.size() == 3)
            instructions = instructions + orderedPlayers.get(2) + " goes third.\n";

        instructions = instructions + "\n1. At the start of their turn, a player can either BORROW or PAY LOAN, or SPIN immediately.\n";
        instructions = instructions + "2. After moving, a player presses GO to execute the effect of the space.\n";
        instructions = instructions + "3. The current player can press the CARDS button to see their held cards.\n";
        instructions = instructions + "4. Press the RULES button for more details.\n";

        return instructions;
    }

    /**
     * Returns the message displayed when a player retires
     *
     * @return  message displayed when a player retires
     */
    public String getRetirementDialog () {
        String dialog;              // message displayed when a player retires

        /* The retirement pay depends on the order of the player in reaching the end space. */
        if (numRetirees == 1)
            dialog = "You receive a retirement pay of $100000.\n";
        else if (numRetirees == 2)
            dialog = "You receive a retirement pay of $50000.\n";
        else
            dialog = "You receive a retirement pay of $20000.\n";

        dialog = dialog + "\nYour held cards have been returned to the board,";
        dialog = dialog + " you have received the selling price for your house (if any),\n";
        dialog = dialog + "and your loans have been settled with the bank.\n\n";
        dialog = dialog + "Congratulations on living a complete life!\n";

        return dialog;
    }

    /**
     * Returns <code>true</code> if the game is over (that is, all players have reached
     * retirement); <code>false</code>, otherwise
     *
     * @return <code>true</code> if the game is over (that is, all players have reached
     * retirement); <code>false</code>, otherwise
     */
    public boolean isGameOver() {
        return numRetirees == players.size();
    }

    /**
     * Returns the name of the player that won the game
     *
     * @return name of the player that won the game
     */
    public String getWinnerName() {
        ArrayList<Integer> cashAmounts;         // amounts of cash of each player at the end
        cashAmounts = new ArrayList<Integer>(players.size());

        for (int i = 0; i < players.size(); i++)
            cashAmounts.add(players.get(i).getCash());

        /* The winner is the player with the highest cash at the end of the game. */
        return getPlayerNames().get(cashAmounts.indexOf(Collections.max(cashAmounts)));
    }


    /**
     * Returns a string representation of this game master, which includes
     * the list of players
     *
     * <p>In particular, the representation contains the label "Game Master" followed
     * by the names of the players separated by a tab.</p>
     *
     * @return string representation of this game master
     */
    @Override
    public String toString() {
        ArrayList<String> playerNames;
        String playerNamesStr;

        playerNames = getPlayerNames();
        playerNamesStr = "";

        for (int i = 0; i < playerNames.size(); i++)
            playerNamesStr += playerNames.get(i) + "\t";

        return "GAME MASTER\n" +
                "Players: " + playerNamesStr + "\n";
    }
}
