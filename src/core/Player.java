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

import java.util.ArrayList;

/**
 * Class implementing a <b>player</b> of the game
 *
 * <p>A player's ID number is used as his/her unique identifier in the internal
 * implementation of the game. In addition, the username of every player must
 * be unique to allow a player to choose another player by name (for example,
 * during the execution of a Lawsuit or File a Lawsuit action card). </p>
 *
 * <p>For the <b>Phase 1</b> of this machine project, the following simplifications
 * have been made (these will be updated to conform with the proper game mechanics
 * during Phase 2): </p>
 *
 * <ul>
 *     <li>A player can draw any career card regardless of the degree requirement.</li>
 *     <li>Only the attributes and methods needed for Phase 1 demonstration (with
 *     certain additions, such as the actual implementation of career and salary cards,
 *     and number wheel) are included in the present implementation.</li>
 * </ul>
 */
public class Player {
    /* Keeps track of the player count for use in generating the ID number */
    private static int count;
    /* Username of this player */
    private String name;
    /* ID number of this player */
    private int id;

    /* Career card kept by this player, dictating his/her career and the maximum number
    of pay raises he/she can have
     */
    private CareerCard currCareerCard;
    /* Salary card kept by this player, dictating his/her base salary, tax due, and pay raise */
    private SalaryCard currSalaryCard;

    private HouseCard currHouseCard;

    /* Current cash of this player */
    private int cash;
    /* Current number of unpaid loans of this player */
    private int currNumLoans;
    /* Current number of pay raise of this player */
    private int currNumPayRaises;

    /* true if this player has a college degree; false, otherwise */
    private boolean hasDegree;
    /* true if this player has a spouse; false, otherwise */
    private boolean isMarried;
    /* Current number of children of this player */
    private int numChildren;

    /* Current position of this player on the board */
    private int positionOnBoard;

    /* Path chosen by the player. The value of this attribute is one of the Path constants (codes)
    defined in the central class GameMaster
     */
    private int path;
    /* Set to true if the player has just landed on a Which Path space (and remains true
    until the player has made his next move); false, otherwise
     */
    private boolean isFromWhichPath;

    /**
     * Per the machine project specifications, a player is given an initial cash
     * of $200000.
     */
    public static final int INIT_CASH = 200000;

    /**
     * Per the machine project specifications, the tax due increases during a pay raise
     * by $2000.
     */
    public static final int TAX_DUE_INCREASE = 2000;

    /**
     * Creates a player object
     *
     * <p>In particular, a player object is initialized as follows:</p>
     *
     * <ul>
     *     <li>The ID number is generated using a counter variable that keeps track
     *     of the number of times the constructor was used to create a player object.
     *     The first player is, thus, given the ID number 1, and so on.</li>
     *     <li>The default name assigned to a player is "Player [ID number]".</li>
     *     <li>The player's cash is initialized to $200000 as indicated in the
     *     machine project specifications.</li>
     * </ul>
     */
    public Player() {
        /* The first player is given the ID number 1, and so on. */
        this.id = ++count;
        /* The default name is "Player [ID number]. The pertinent ID number is equal
        to the current value of the static variable count.
         */
        this.name = "Player " + count;
        this.cash = INIT_CASH;
    }

    /**
     * Creates a player object with a specified username as parameter
     *
     * <p>In particular, a player object is initialized as follows (with the first
     * and the third taken care of by invoking the zero-parameter constructor):</p>
     *
     * <ul>
     *     <li>The ID number is generated using a counter variable that keeps track
     *     of the number of times the constructor was used to create a player object.
     *     The first player is, thus, given the ID number 1, and so on.</li>
     *     <li>The name is set to the specified username, provided it is a valid
     *     username. Otherwise, the default name, "Player [ID number]", remains.</li>
     *     <li>The player's cash is initialized to $200000 as indicated in the
     *     machine project specifications.</li>
     * </ul>
     *
     * <p> A player's name is considered valid if it contains at least one non-whitespace
     * character and it is unique (that is, no other player has the same name). Note that
     * the second condition is handled in the <code>GameMaster</code> class since it
     * requires information about other players. </p>
     *
     * @param name username of this player
     */
    public Player(String name) {
        this();
        /* If the specified name is invalid, the default name remains. */
        if (isValidName(name))
            this.name = name;
    }

    /**
     * Returns the count of this player (that is, the number of times the constructor
     * has been used to create a player object)
     *
     * @return count of this player (that is, the number of times the constructor
     * has been used to create a player object)
     */
    public static int getCount() {
        return count;
    }

    /**
     * Returns the username of this player
     *
     * @return username of this player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID number of this player
     *
     * <p>A player's ID number is his/her unique identifier in the internal
     * implementation of the game. </p>
     *
     * @return ID number of this player
     */
    public int getID() {
        return id;
    }

    /**
     * Returns the path chosen by the player
     *
     * <p>In particular, the path is any one of the Path constants (codes) defined in the central
     * class <code>GameMaster</code>: </p>
     *
     * <ul>
     *     <li><code>NORMAL_PATH_CODE</code></li>
     *     <li><code>CAREER_PATH_CODE</code></li>
     *     <li><code>COLLEGE_PATH_CODE</code></li>
     *     <li><code>CHANGE_CAREER_PATH_CODE</code></li>
     *     <li><code>FAMILY_PATH_CODE</code></li>
     * </ul>
     *
     * @return path chosen by the player
     */
    public int getPath() {
        return path;
    }

    /**
     * Sets the path chosen by the player
     *
     * <p>In particular, the path is any one of the Path constants (codes) defined in the central
     * class <code>GameMaster</code>: </p>
     *
     * <ul>
     *     <li><code>NORMAL_PATH_CODE</code></li>
     *     <li><code>CAREER_PATH_CODE</code></li>
     *     <li><code>COLLEGE_PATH_CODE</code></li>
     *     <li><code>CHANGE_CAREER_PATH_CODE</code></li>
     *     <li><code>FAMILY_PATH_CODE</code></li>
     * </ul>
     *
     * @param path path chosen by the player
     */
    public void setPath(int path) {
        this.path = path;
    }

    /**
     * Returns a reference to the career card kept by this player
     *
     * <p>There is no need to clone this career card since its attributes
     * cannot be modified after initialization.</p>
     *
     * <p>This career card dictates the player's career and maximum number of pay raises. </p>
     *
     * @return reference to the career card kept by this player
     */
    public CareerCard getCareerCard() {
        return currCareerCard;
    }

    /**
     * Returns a reference to the salary card kept by this player
     *
     * <p>There is no need to clone this salary card since its attributes
     * cannot be modified after initialization.</p>
     *
     * <p>This salary card dictates the player's base salary, tax due, and pay raise. </p>
     *
     * @return reference to the salary card kept by this player
     */
    public SalaryCard getSalaryCard() {
        return currSalaryCard;
    }

    /**
     * Returns a reference to the house card kept by this player
     *
     * <p>There is no need to clone this house card since its attributes
     * cannot be modified after initialization.</p>
     *
     * <p>This house card dictates the name of the house of the player, alongside its buying
     * and selling prices. </p>
     *
     * @return reference to the house card kept by this player
     */
    public HouseCard getHouseCard() {
        return currHouseCard;
    }

    /**
     * Returns the career of this player
     *
     * @return career of this player
     */
    public String getCareer() {
        return currCareerCard.getName();
    }

    /**
     * Returns the base salary of this player (that is, the salary without
     * any pay raise)
     *
     * @return base salary of this player (that is, the salary without any pay raise)
     */
    public int getBaseSalary() {
        return currSalaryCard.getSalary();
    }

    /**
     * Returns the current salary of this player (that is, with the pay raise/s added)
     *
     * @return current salary of this player (that is, with the pay raise/s added)
     */
    public int getSalary() {
        return currSalaryCard.getSalary() + getPayRaise();
    }

    /**
     * Returns the base tax due of this player (that is, the tax due before
     * re-computation due to pay raise)
     *
     * @return base tax due of this player (that is, the tax due before re-computation
     * due to pay raise)
     */
    public int getBaseTaxDue() {
        return currSalaryCard.getTaxDue();
    }

    /**
     * Returns the current tax due of this player (that is, the tax due after
     * re-computation due to pay raise)
     *
     * Following the computation mentioned in the <code>SalaryCard</code> class,
     * the current tax due is equivalent to 10% of the current salary
     *
     * @return current tax due of the player (that is, the tax due after
     * re-computation due to pay raise)
     */
    public int getTaxDue() {
        return getBaseTaxDue() + currNumPayRaises * TAX_DUE_INCREASE;
    }

    /**
     * Returns the amount by which the salary of this player increases every time
     * he/she receives a pay raise
     *
     * @return amount by which the salary of this player increases every time
     * he/she receives a pay raise
     */
    public int getBasePayRaise() {
        return currSalaryCard.getPayRaise();
    }

    /**
     * Returns the total amount by which the salary of this player has increased
     * considering all received pay raises
     *
     * @return total amount by which the salary of this player has increased
     * considering all received pay raises
     */
    public int getPayRaise() {
        return getBasePayRaise() * currNumPayRaises;
    }

    /**
     * Returns the current cash of this player
     *
     * @return current cash of this player
     */
    public int getCash() {
        return cash;
    }

    /**
     * Returns the current number of loans of this player
     *
     * @return current number of loans of this player
     */
    public int getCurrNumLoans() {
        return currNumLoans;
    }
    /**
     * Returns the current number of pay raises of this player
     *
     * @return current number of pay raises of this player
     */
    public int getCurrNumPayRaises() {
        return currNumPayRaises;
    }

    /**
     * Returns the maximum number of pay raises this player can receive
     *
     * @return maximum number of pay raises this player can receive
     */
    public int getMaxNumPayRaises() {
        return currCareerCard.getMaxNumPayRaises();
    }

    /**
     * Returns <code>true</code> if this player has a degree; <code>false</code>, otherwise
     *
     * @return <code>true</code> if this player has a degree; <code>false</code>, otherwise
     */
    public boolean getHasDegree() {
        return hasDegree;
    }

    /**
     * Returns <code>true</code> if this player has a spouse; <code>false</code>, otherwise
     *
     * @return <code>true</code> if this player has a spouse; <code>false</code>, otherwise
     */
    public boolean getIsMarried() {
        return isMarried;
    }

    /**
     * Returns the number of children of this player
     *
     * @return number of children of this player
     */
    public int getNumChildren() {
        return numChildren;
    }

    /**
     * Returns the name of the house indicated in the house card kept by the player
     *
     * @return name of the house indicated in the house card kept by the player
     */
    public String getHouseName() { return currHouseCard.getName(); }

    /**
     * Returns the buying price of the house indicated in the house card kept by the player
     *
     * @return buying price of the house indicated in the house card kept by the player
     */
    public int getHouseBuyingPrice() {
        return currHouseCard.getBuyingPriceHouse();
    }

    /**
     * Returns the selling price of the house indicated in the house card kept by the player
     *
     * @return selling price of the house indicated in the house card kept by the player
     */
    public int getHouseSellingPrice() {
        return currHouseCard.getSellingPriceHouse();
    }

    /**
     * Returns the position of this player on the board
     *
     * @return position of this player on the board
     */
    public int getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * Returns the number obtained after spinning the number wheel
     *
     * @param w number wheel of the game
     * @return number obtained after spinning the number wheel
     */
    public int spinWheel(NumberWheel w) {
        return w.spin();
    }

    /**
     * Advances the position of the player by the specified number of spaces,
     * subject to the condition that the player has to prematurely stop upon
     * landing on a magenta space
     *
     * @param numSpunSpaces number spun by the player, indicating the number of spaces that he has
     *                      to advance (with the exception of the special case of magenta spaces)
     * @param brd board of the game
     */
    public void move(int numSpunSpaces, Board brd) {
        /* Check if the player has not reached the end of the board. */
        if (positionOnBoard < Board.NUM_SPACES) {
            int numSpaces;              // number of spaces to be advanced by the player
            int newPosition;            // new position of the player
            int magentaIndex;           // index of the magenta space in the range to be advanced by the player (if there is)

            numSpaces = numSpunSpaces;

            /* If the player has just come from a fork, decrement the number of spaces to be advanced
            by one since the player has prematurely advanced by this point.
             */
            if (isFromWhichPath) {
                /* Reset this attribute. */
                isFromWhichPath = false;

                /* If the number spun is 1, then there is no need to move since the player has already
                prematurely advanced by this point.
                 */
                if (numSpaces == 1)
                    return;
                else
                    numSpaces--;
            }

            newPosition = positionOnBoard;

            /* Check if there is a magenta space in the range to be advanced by the player. */
            for (int i = 0; i < numSpaces; i++) {
                /* Check if the end of the board has not yet been reached. */
                if (newPosition == Board.NUM_SPACES - 1)
                    break;

                /* Advance the position. */
                newPosition = brd.getColoredSpace(newPosition).getActualNextIndex();
            }

            magentaIndex = brd.getIndexMagentaInRange(brd.getColoredSpace(positionOnBoard).getActualNextIndex(), newPosition);

            /* If there is a magenta space, then the player has to stop on the magenta space prematurely. */
            if (magentaIndex != -1)
                newPosition = magentaIndex;

            /* Advance the player position as pertinent. */
            positionOnBoard = newPosition;
        }
    }

    /**
     * Grants the player a college degree, allowing him/her to have a career
     * that requires a degree (for example, Lawyer, Accountant, Computer Consultant,
     * and Doctor)
     */
    public void graduate() {
        hasDegree = true;
    }

    /**
     * Sets the attribute of the player to married
     */
    public void marry() {
        isMarried = true;
    }

    /**
     * Increases the number of children of the player by 1
     */
    public void haveBaby() {
        numChildren++;
    }

    /**
     * Increases the number of children of the player by 2
     */
    public void haveTwins() {
        numChildren = numChildren + 2;
    }

    /**
     * Transfers the specified card back to the appropriate deck, causing the deck to undergo
     * reshuffling
     *
     * @param c card to be returned
     * @param d deck to which the card will be returned
     */
    public void returnCard(Card c, Deck d) {
        d.returnCard(c);
    }

    /**
     * Transfers the specified card to the bottom of the appropriate deck
     *
     * @param c card to be returned
     * @param d deck to which the card will be returned
     */
    public void returnCardToBottom(Card c, Deck d) {
        d.returnCardToBottom(c);
    }

    /**
     * Returns the career card drawn by the player from the career card deck
     *
     * @param d career card deck from which the player drew the career card
     * @return career card drawn by the player from the career card deck
     */
    public CareerCard drawFromCareerDeck(CareerCardDeck d) {
        return d.drawFromDeck();
    }

    /**
     * Returns the salary card drawn by the player from the salary card deck
     *
     * @param d salary card deck from which the player drew the salary card
     * @return salary card drawn by the player from the salary card deck
     */
    public SalaryCard drawFromSalaryDeck(SalaryCardDeck d) { return d.drawFromDeck(); }

    /**
     * Returns the action card drawn by the player from the action card deck
     *
     * @param d action card deck from which the player drew the action card
     * @param pile pile where the drawn and discarded action cards are transferred
     * @return action card drawn by the player from the action card deck
     */
    public ActionCard drawFromActionDeck(ActionCardDeck d, DiscardPile pile) {
        return d.drawFromDeck(pile);
    }

    /**
     * Returns the drawn house card from the deck given the index of this house card
     *
     * @param d house card deck
     * @param index index of the house card to be drawn
     * @return house card drawn from the deck
     */
    public HouseCard drawFromHouseDeck(HouseCardDeck d, int index) {
        return d.drawFromDeck(index);
    }

    /**
     * Returns the drawn blue card from the deck
     *
     * @param d blue card deck
     * @return blue card drawn from the deck
     */
    public BlueCard drawFromBlueDeck(BlueCardDeck d) {
        return d.drawFromDeck();
    }

    /**
     * Executes the specified Lawsuit blue card
     *
     * @param c Lawsuit blue card to be executed
     * @param playerWithCareer player with a matching career (<code>null</code> if none)
     * @param b bank of the game
     * @return flag for the executed scenario as defined in the <code>Blue Card</code> class
     */
    public int executeBlueCard(LawsuitBlue c, Player playerWithCareer, Bank b) {
        return c.execute(this, playerWithCareer, b);
    }

    /**
     * Executes the specified Salary Tax Due blue card
     *
     * @param c Salary Tax Due blue card to be executed
     * @param playerWithCareer player with a matching career (<code>null</code> if none)
     * @param b bank of the game
     * @return flag for the executed scenario as defined in the <code>Blue Card</code> class
     */
    public int executeBlueCard(SalaryTaxDue c, Player playerWithCareer, Bank b) {
        return c.execute(this, playerWithCareer, b);
    }

    /**
     * Executes the specified Tip the Server blue card
     *
     * @param c Tip the Server blue card to be executed
     * @param playerWithCareer player with a matching career (<code>null</code> if none)
     * @param b bank of the game
     * @param randNum random number dictating the amount involved
     * @return flag for the executed scenario as defined in the <code>Blue Card</code> class
     */
    public int executeBlueCard(TipTheServer c, Player playerWithCareer, Bank b, int randNum) {
        return c.execute(this, playerWithCareer, b, randNum);
    }

    /**
     * Executes the specified Ski Accident blue card
     *
     * @param c Ski Accident blue card to be executed
     * @param playerWithCareer player with a matching career (<code>null</code> if none)
     * @param b bank of the game
     * @return flag for the executed scenario as defined in the <code>Blue Card</code> class
     */
    public int executeBlueCard(SkiAccident c, Player playerWithCareer, Bank b) {
        return c.execute(this, playerWithCareer, b);
    }

    /**
     * Executes the specified Computer Repair blue card
     *
     * @param c Computer Repair blue card to be executed
     * @param playerWithCareer player with a matching career (<code>null</code> if none)
     * @param b bank of the game
     * @param randNum random number dictating the amount involved
     * @return flag for the executed scenario as defined in the <code>Blue Card</code> class
     */
    public int executeBlueCard(ComputerRepair c, Player playerWithCareer, Bank b, int randNum) {
        return c.execute(this, playerWithCareer, b, randNum);
    }

    /**
     * Executes the specified World Cup blue card
     *
     * @param c World Cup blue card to be executed
     * @param playerWithCareer player with a matching career (<code>null</code> if none)
     * @param b bank of the game
     * @param numPlayers number of players of the game
     * @return flag for the executed scenario as defined in the <code>Blue Card</code> class
     */
    public int executeBlueCard(WorldCup c, Player playerWithCareer, Bank b, int numPlayers) {
       return c.execute(this, playerWithCareer, b, numPlayers);
    }

    /**
     * Executes the specified F1 Race blue card
     *
     * @param c F1 Race blue card to be executed
     * @param playerWithCareer player with a matching career (<code>null</code> if none)
     * @param b bank of the game
     * @return flag for the executed scenario as defined in the <code>Blue Card</code> class
     */
    public int executeBlueCard(F1Race c, Player playerWithCareer, Bank b) {
        return c.execute(this, playerWithCareer, b);
    }

    /**
     * Executes the instructions indicated in the given Collect from the Bank
     * action card
     *
     * @param c given Collect from the Bank action card to be executed
     * @param b Bank of the game
     */
    public void executeActionCard(CollectFromTheBank c, Bank b) {
        c.execute(this, b);
    }

    /**
     * Executes the instructions indicated in the given Pay the Bank
     * action card
     *
     * @param c given Pay the Bank action card to be executed
     * @param b Bank of the game
     */
    public void executeActionCard(PayTheBank c, Bank b) {
        c.execute(this, b);
    }

    /**
     * Executes the instructions indicated in the Lawsuit action card
     * (a Pay the Player action card)
     *
     * @param c Lawsuit action card to be executed
     * @param otherPlayer player who will be paid by the current player with an amount
     *      *             equivalent to the litigation cost indicated in the Lawsuit card
     * @param b Bank of the game
     */
    public void executeActionCard(Lawsuit c, Player otherPlayer, Bank b) {
        c.execute(this, otherPlayer, b);
    }

    /**
     * Executes the instructions indicated in the Christmas Bonus action card
     * (a Pay the Player action card)
     *
     * @param c Christmas Bonus action card to be executed
     * @param players <code>ArrayList</code> containing all the players in the game
     * @param b Bank of the game
     */
    public void executeActionCard(ChristmasBonus c, ArrayList<Player> players, Bank b) {
        c.execute(this, players, b);
    }

    /**
     * Executes the instructions indicated in the File a Lawsuit action card
     * (a Collect from Player action card)
     *
     * @param c File a Lawsuit action card to be executed
     * @param otherPlayer player who will pay the current player an amount equivalent
     *      *             to the lawsuit compensation indicated in the File a Lawsuit card
     * @param b Bank of the game
     */
    public void executeActionCard(FileALawsuit c, Player otherPlayer, Bank b) {
        c.execute(this, otherPlayer, b);
    }

    /**
     * Executes the instructions indicated in the It's Your Birthday action card
     * (a Collect from Player action card)
     *
     * @param c It's Your Birthday action card to be executed
     * @param players <code>ArrayList</code> containing all the players in the game
     * @param b Bank of the game
     */
    public void executeActionCard(ItsYourBirthday c, ArrayList<Player> players, Bank b) {
        c.execute(this, players, b);
    }

    /**
     * Sets the kept career card of this player to the given career card and resets
     * the current number of pay raises to 0 should this player decide to switch careers
     *
     * @param c career card that will be kept by this player
     */
    public void keepCareerCard(CareerCard c) {
        if (currCareerCard != null && !currCareerCard.equals(c))
            currNumPayRaises = 0;

        currCareerCard = c;
    }

    /**
     * Sets the kept salary card of this player to the given salary card and resets
     * the current number of pay raises to 0 should this player decide to switch careers
     * (alongside salaries)
     *
     * @param c salary card that will be kept by this player
     */
    public void keepSalaryCard(SalaryCard c) {
        currSalaryCard = c;
        currNumPayRaises = 0;
    }

    /**
     * Sets the kept house card of this player to the given house card and modifies the
     * cash of the player accordingly based on the buying price indicated in the card
     *
     * @param c salary card that will be kept by this player
     * @param b bank of the game
     */
    public void keepHouseCard(HouseCard c, Bank b) {
        payCashToBank(b, c.getBuyingPriceHouse());
        currHouseCard = c;
    }

    /**
     * Borrows the specified number of loans from the Bank
     *
     * <p>Basic error handling (for example, the specified number of loans is negative)
     * is handled inside the <code>Bank</code> class since it is the Bank that lends
     * the loans. </p>
     *
     * @param b is the Bank of the game
     * @param numLoans number of loans to be borrowed from the Bank
     */
    public void borrowLoan(Bank b, int numLoans) {
        b.lendLoan(this, numLoans);
    }

    /**
     * Returns <code>true</code> if the player is able to pay the specified number
     * of loan payments to the Bank; <code>false</code>, otherwise
     *
     * <p>In particular, <code>true</code> is returned if all three of the
     * following conditions are satisfied:</p>
     *
     * <ul>
     *     <li>The number of payments is positive. </li>
     *     <li>Paying the loans will not lead to a cash deficit.</li>
     *     <li>The number of payments is not greater than the current number of loans.</li>
     * </ul>
     *
     * @param b is the Bank of the game
     * @param numPayments number of loan payments to be paid to the Bank
     * @return <code>true</code> if the player is able to pay the specified number
     * of loan payments to the Bank; <code>false</code>, otherwise
     */
    public boolean payLoan(Bank b, int numPayments) {
        /* Check the three conditions mentioned in the documentation above. */
        if (isNumPositive(numPayments) && Bank.PAYMENT_MULTIPLE * numPayments <= cash &&
                numPayments <= currNumLoans) {
            b.receivePayment(this, numPayments);
            return true;
        }

        return false;
    }

    /**
     * Updates the current cash of the player after receiving a specified amount of cash
     *
     * <p>If the specified amount is negative, then nothing happens.</p>
     *
     * @param amount amount of cash received
     */
    public void receiveCash(int amount) {
        /* Do nothing if specified amount is negative. */
        if (isNumPositive(amount))
            increaseCashBy(amount);
    }

    /**
     * Pays the specified amount of cash to another player, loaning from the Bank
     * if necessary
     *
     * <p>If the specified amount is negative, then nothing happens.</p>
     *
     * @param p player to which the current player will pay the specified amount of cash
     * @param b Bank of the game
     * @param amount amount of cash to be paid to another player
     */
    public void payCashToPlayer(Player p, Bank b, int amount) {
        if (isNumPositive(amount)) {
            /* If there is a cash deficit, loan from the Bank. */
            if (amount > cash)
                /* The number of loans is computed as the ceiling function (that is, the least integer
                greater than or equal to a given number) of the value resulting from dividing the
                deficit by the amount lent by the Bank for every loan.
                 */
                this.borrowLoan(b, (int) Math.ceil((double) (amount - cash) / Bank.LEND_MULTIPLE));

            p.receiveCash(amount);
            this.decreaseCashBy(amount);
        }
    }

    /**
     * Collects the specified amount of cash from the Bank (not counted as a loan)
     *
     * <p>If the specified amount is negative, then nothing happens.</p>
     *
     * @param b Bank of the game
     * @param amount amount of cash collected from the Bank
     */
    public void collectCashFromBank(Bank b, int amount) {
        if (isNumPositive(amount))
            b.giveCash(this, amount);
    }

    /**
     * Pays the specified amount of cash to the Bank (not counted as a loan payment)
     *
     * <p>If the specified amount is negative, then nothing happens.</p>
     *
     * @param b Bank of the game
     * @param amount amount of cash to be paid to the Bank
     */
    public void payCashToBank(Bank b, int amount) {
        if (isNumPositive(amount)) {
            /* If there is a cash deficit, loan from the Bank. */
            if (amount > cash)
            /* The number of loans is computed as the ceiling function (that is, the least integer
            greater than or equal to a given number) of the value resulting from dividing the
            deficit by the amount lent by the Bank for every loan.
             */
                this.borrowLoan(b, (int) Math.ceil((double) (amount - cash) / Bank.LEND_MULTIPLE));

            b.receiveCash(this, amount);
        }
    }

    /**
     * Sells the house of this player to the bank for the selling price indicated in the house card
     *
     * @param b bank of the game
     */
    public void sellHouseToBank(Bank b) {
        if (currHouseCard != null)
            collectCashFromBank(b, getHouseSellingPrice());
    }

    /**
     * Increases the cash of this player by the specified amount
     *
     * <p>This method is used in this class internally and called by some methods
     * in the <code>Bank</code> class (for example, <code>lendLoan</code>) to increase
     * the cash of this player.
     *
     * <p>If the specified amount is negative, then nothing happens.</p>
     *
     * @param amount amount by which this player's cash is increased
     */
    public void increaseCashBy(int amount) {
        if (isNumPositive(amount))
            cash += amount;
    }

    /**
     * Decreases the cash of this player by the specified amount
     *
     * <p>This method is used in this class internally and called by some methods
     * in the <code>Bank</code> class (for example, <code>receivePayment</code>) to decrease
     * the cash of this player.
     *
     * <p>If the specified amount is negative, then nothing happens.</p>
     *
     * @param amount amount by which this player's cash is decreased
     */
    public void decreaseCashBy(int amount) {
        if (cash >= amount && isNumPositive(amount))
            cash -= amount;
    }

    /**
     * Increases the number of unpaid loans of this player by the specified number
     *
     * <p>This method is used in this class internally and called by some methods
     * in the <code>Bank</code> class (for example, <code>lendLoan</code>) to increase
     * the number of unpaid loans of this player.
     *
     * <p>If the specified number is negative, then nothing happens.</p>
     *
     * @param numLoans number by which this player's number of unpaid loans is increased
     */
    public void increaseNumLoansBy(int numLoans) {
        if (isNumPositive(numLoans))
            currNumLoans += numLoans;
    }

    /**
     * Decreases the number of unpaid loans of this player by the specified number
     *
     * <p>This method is used in this class internally and called by some methods
     * in the <code>Bank</code> class (for example, <code>receivePayment</code>) to decrease
     * the number of unpaid loans of this player.
     *
     * <p>If the specified number is negative, then nothing happens.</p>
     *
     * @param numLoans number by which this player's number of unpaid loans is decreased
     */
    public void decreaseNumLoansBy(int numLoans) {
        if (currNumLoans >= numLoans && isNumPositive(numLoans))
            currNumLoans -= numLoans;
    }

    /**
     * Increases the current number of pay raises of this player by 1
     *
     */
    public void receivePayRaise() {
        if (currNumPayRaises < getMaxNumPayRaises())
            currNumPayRaises++;
    }

    /**
     * Modifies the player attributes based on the specifications when this player retires
     *
     * <p>In particular, the following happens:</p>
     *
     * <ul>
     *     <li> The retirement benefit is collected from the bank depending on the order in which
     *     this player reached th last space.</li>
     *     <li> Collect $10000 for each child.</li>
     *     <li> Sell the house to the bank. </li>
     *     <li> Repay all outstanding loans with interest. </li>
     * </ul>
     *
     * @param b bank of the game
     * @param orderRetirement order in which this player reached the last space of the board
     * @param careerDeck career card deck where the card will be returned
     * @param salaryDeck salary card deck where the card will be returned
     * @param houseDeck house card deck where the card will be returned
     */
    public void retire(Bank b, int orderRetirement, CareerCardDeck careerDeck, SalaryCardDeck salaryDeck, HouseCardDeck houseDeck) {
        int retirementBenefit;          // retirement benefit to be received

        retirementBenefit = 0;

        /* The retirement benefit varies depending on the order of reaching the end space. */
        switch(orderRetirement) {
            case 1:
                retirementBenefit = GameMaster.RETIREMENT_BENEFIT_FIRST;
                break;
            case 2:
                retirementBenefit = GameMaster.RETIREMENT_BENEFIT_SECOND;
                break;
            case 3:
                retirementBenefit = GameMaster.RETIREMENT_BENEFIT_THIRD;
                break;
        }

        /* Collect the retirement benefit, alongside the cash per children. */
        collectCashFromBank(b, retirementBenefit);
        collectCashFromBank(b, numChildren * GameMaster.RETIREMENT_CHILDREN_BENEFIT);

        /* Sell the house to the bank, and repay all outstanding loans. */
        sellHouseToBank(b);
        cash = cash - Bank.PAYMENT_MULTIPLE * currNumLoans;
        currNumLoans = 0;

        /* Returns the cards kept by the player to the deck for re-circulation. */
        returnCard(currCareerCard, careerDeck);
        returnCard(currSalaryCard, salaryDeck);

        if (currHouseCard != null)
            returnCard(currHouseCard, houseDeck);
    }

    /**
     * Returns <code>true</code> if the player has just landed on a Which Path space (and remains <code>true</code>
     *     until the player has made his next move); <code>false</code>, otherwise
     *
     * @return <code>true</code> if the player has just landed on a Which Path space (and remains <code>true</code>
     * until the player has made his next move); <code>false</code>, otherwise
     */
    public boolean getIsFromWhichPath() {
        return isFromWhichPath;
    }

    /**
     * Sets the pertinent attribute to <code>true</code> if the player has just landed on a Which Path space
     * (and remains <code>true</code> until the player has made his next move); <code>false</code>, otherwise
     *
     * @param isFromWhichPath <code>true</code> if the player has just landed on a Which Path space (and remains <code>true</code>
     *                        until the player has made his next move); <code>false</code>, otherwise
     */
    public void setIsFromWhichPath(boolean isFromWhichPath) {
        this.isFromWhichPath = isFromWhichPath;
    }

    /**
     * Returns <code>true</code> if the given username is valid (that is, it contains
     * at least one non-whitespace character); <code>false</code>, otherwise
     *
     * <p>The goal of this method is to invalidate a username that consists
     * only of spaces or a newline character.</p>
     *
     * @param name is the given username
     * @return <code>true</code> if the given username is valid (that is, it contains
     * at least non-whitespace character); <code>false</code>, otherwise
     */
    public static boolean isValidName(String name) {
        for (int i = 0; i < name.length(); i++)
            if (name.charAt(i) != ' ')
                return true;

        return false;
    }

    /**
     * Returns <code>true</code> if the given number is positive; <code>false</code>, otherwise
     *
     * @param num is the given number to be tested for positivity
     * @return <code>true</code> if the given number is positive; <code>false</code>, otherwise
     */
    private boolean isNumPositive(int num) { return num > 0; }

    /**
     * Returns a string representation of this player, which includes core information
     * about its attributes
     *
     * <p>In particular, the representation includes the following details: </p>
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
     *     <li>Details on the house card (if the player kept one)</li>
     * </ul>
     *
     * @return string representation of this player, which includes core information
     * about its attributes
     */
    @Override
    public String toString() {
        String baseStr;
        String hasDegree;
        String isMarried;

        if (getHasDegree())
            hasDegree = "Yes";
        else
            hasDegree = "No";

        if (getIsMarried())
            isMarried = "Yes";
        else
            isMarried = "No";

        baseStr =
                "Cash: " + cash + "\n" +
                "Num. of Loans: " + currNumLoans + "\n\n";


        if (currCareerCard != null) {
            String careerDetails;
            careerDetails = "Career: " + getCareer() + "\n";

            baseStr = baseStr + careerDetails;
        }


        if (currSalaryCard != null) {
            String salaryDetails;
            salaryDetails =
                    "Current Salary: " + getSalary() + "\n" +
                    "Current Tax Due: " + getTaxDue() + "\n" +
                    "Current Pay Raise: " + getPayRaise() + "\n" +
                    "Num. of Pay Raises: " + getCurrNumPayRaises() + "\n" +
                    "Max. Num. of Pay Raises: " + getMaxNumPayRaises() + "\n\n" +
                    "Increase per Pay Raise: " + getBasePayRaise() + "\n\n";

            baseStr = baseStr + salaryDetails;
        }

        if (currHouseCard != null) {
            String houseDetails;
            houseDetails = "House (Name): " + getHouseName() + "\n" +
                    "Buying Price: " + getHouseBuyingPrice() + "\n" +
                    "Selling Price: " + getHouseSellingPrice() + "\n\n";

            baseStr = baseStr + houseDetails;
        }

        String finalDetails;
        finalDetails = "Is Married: " + isMarried + "\n" +
                "Num. of Children: " + numChildren + "\n" +
                "Has Degree: " + hasDegree + "\n\n";

        baseStr = baseStr + finalDetails;

        return baseStr;
    }
}