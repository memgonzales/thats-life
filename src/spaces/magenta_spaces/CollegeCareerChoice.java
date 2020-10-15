package spaces.magenta_spaces;

import cards.CareerCard;
import cards.SalaryCard;
import core.Player;
import decks.CareerCardDeck;
import decks.SalaryCardDeck;
import spaces.MagentaSpace;

import java.util.ArrayList;

/**
 * Class implementing a <b>college career choice space</b>.
 *
 * <p>Players on a college career choice space choose a career and salary between
 * two career cards and two salary cards.</p>
 */
public class CollegeCareerChoice extends MagentaSpace {
    /**
     * Creates a college career choice space object
     *
     * <p>In particular, a college career choice space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is assigned as "College Career Choice".</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next index is assigned the passed parameter nextIndex.</li>
     * </ul>
     *
     * @param index the index of the space on the board
     * @param nextIndex the index of the next space the player can move to from
     * this space
     */
    public CollegeCareerChoice(int index, int nextIndex) {
        /* Invoke the constructor of the parent class, passing the string "College Career Choice"
        and the appropriate index values. The same index is used for both next index values
        of the space, as there is only one other space a player can move to from a
        college career choice space.
        */
        super("College Career Choice", index, nextIndex, nextIndex);
    }

    /**
     * Returns the career cards a player can choose from
     *
     * <p>On a college career choice space, a player draws two career cards
     * they can choose from.</p>
     *
     * @param currPlayer current player with turn
     * @param d CareerCardDeck object of the game
     * @return the career cards a player can choose from
     */
    public ArrayList<CareerCard> drawCareerCards(Player currPlayer, CareerCardDeck d) {
        ArrayList<CareerCard> careerCards;
        CareerCard cCard1;
        CareerCard cCard2;

        /* The player draws the top two cards from the career card deck */
        cCard1 = currPlayer.drawFromCareerDeck(d);
        cCard2 = currPlayer.drawFromCareerDeck(d);

        /* The career cards are stored in an array list and returned for the
        player to choose from.
        */
        careerCards = new ArrayList<CareerCard>(2);
        careerCards.add(cCard1);
        careerCards.add(cCard2);

        return careerCards;
    }

    /**
     * Returns the salary cards a player can choose from
     *
     * <p>On a college career choice space, a player draws two salary cards
     * they can choose from.</p>
     *
     * @param currPlayer current player with turn
     * @param d SalaryCardDeck object of the game
     * @return the salary cards a player can choose from
     */
    public ArrayList<SalaryCard> drawSalaryCards(Player currPlayer, SalaryCardDeck d) {
        ArrayList<SalaryCard> salaryCards;
        SalaryCard sCard1;
        SalaryCard sCard2;

        /* The player draws the top two cards from the salary card deck */
        sCard1 = currPlayer.drawFromSalaryDeck(d);
        sCard2 = currPlayer.drawFromSalaryDeck(d);

        /* The salary cards are stored in an array list and returned for the
        player to choose from.
        */
        salaryCards = new ArrayList<SalaryCard>(2);
        salaryCards.add(sCard1);
        salaryCards.add(sCard2);

        return salaryCards;
    }

    /**
     * Executes one of the actions associated with this space; that is, the player
     * chooses between two career cards
     *
     * <p>On a college career choice space, the player draws two career cards and
     * chooses the card to keep between them.</p>
     *
     * @param currPlayer current player with turn
     * @param careerCards list of drawn career cards the player can choose from
     * @param d CareerCardDeck object of the game
     * @param index index of the chosen career card in the passed array list
     */
    public void executeCareer(Player currPlayer, ArrayList<CareerCard> careerCards, CareerCardDeck d, int index) {
        /* The player keeps their chosen career card */
        currPlayer.keepCareerCard(careerCards.get(index));

        /* The card not kept by the player is returned to the career card deck */
        if (index == 0)
            currPlayer.returnCard(careerCards.get(1), d);
        else
            currPlayer.returnCard(careerCards.get(0), d);
    }

    /**
     * Executes one of the actions associated with this space; that is, the player
     * chooses between two salary cards
     *
     * <p>On a college career choice space, the player draws two salary cards and
     * chooses the card to keep between them.</p>
     *
     * @param currPlayer current player with turn
     * @param salaryCards list of drawn salary cards the player can choose from
     * @param d SalaryCardDeck object of the game
     * @param index index of the chosen salary card in the passed array list
     */
    public void executeSalary(Player currPlayer, ArrayList<SalaryCard> salaryCards, SalaryCardDeck d, int index) {
        /* The player keeps their chosen salary card */
        currPlayer.keepSalaryCard(salaryCards.get(index));

        /* The card not kept by the player is returned to the salary card deck */
        if (index == 0)
            currPlayer.returnCard(salaryCards.get(1), d);
        else
            currPlayer.returnCard(salaryCards.get(0), d);
    }

    /**
     * Returns the string to be used as a prompt in the actual gameplay when the player
     * is on a college career choice space
     *
     * <p>In particular, the returned string reads as follows: "[Player name], you are
     * on a College Career Choice space. Choose a career and salary card from the
     * available options." </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a college career choice space
     */
    @Override
    public String getInfo(Player currPlayer) {
        return currPlayer.getName() + ", you are on a College Career Choice space.\n" +
                "Choose a career and salary card from the available options.\n" +
                "You are entitled to ANOTHER TURN right after this.\n";
    }
}
