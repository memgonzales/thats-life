package spaces.magenta_spaces;

import cards.CareerCard;
import cards.SalaryCard;
import core.Player;
import decks.CareerCardDeck;
import decks.SalaryCardDeck;
import spaces.MagentaSpace;

import java.util.ArrayList;

/**
 * Class implementing a <b>job search space</b>.
 *
 * <p>Players on a job search space choose a career and salary between
 * their current cards and one career and salary card drawn from their respective decks.</p>
 */
public class JobSearch extends MagentaSpace {
    /**
     * Creates a job search space object
     *
     * <p>In particular, a job search space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is assigned as "Job Search".</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next index is assigned the passed parameter nextIndex.</li>
     * </ul>
     *
     * @param index the index of the space on the board
     * @param nextIndex the index of the next space the player can move to from
     * this space
     */
    public JobSearch(int index, int nextIndex) {
        /* Invoke the constructor of the parent class, passing the string "Job Search"
        and the appropriate index values. The same index is used for both next index values
        of the space, as there is only one other space a player can move to from a
        college career choice space.
        */
        super("Job Search", index, nextIndex, nextIndex);
    }

    /**
     * Returns the career cards a player can choose from
     *
     * <p>On a job search space, a player draws a career card and chooses between
     * their current career card and the drawn card.</p>
     *
     * @param currPlayer current player with turn
     * @param d CareerCardDeck object of the game
     * @return the career cards a player can choose from
     */
    public ArrayList<CareerCard> drawCareerCard(Player currPlayer, CareerCardDeck d) {
        ArrayList<CareerCard> careerCards;
        CareerCard cCard1;
        CareerCard cCard2;

        /* The player draws the top card from the career card deck, and the remaining card
        is the career card currently kept by the player */
        cCard1 = currPlayer.getCareerCard();
        cCard2 = currPlayer.drawFromCareerDeck(d);

        /* If the player draws a career card that requires a degree while the player does
        not have a degree, they draw another card until they draw one that does not
        require a degree
        */
        int ctr;
        ctr = 0;

        while (!currPlayer.getHasDegree() && cCard2.getIsDegreeRequired()) {
            currPlayer.returnCardToBottom(cCard2, d);
            cCard2 = currPlayer.drawFromCareerDeck(d);

            /* A special case may occur when all 3 players have chosen careers without
            required degrees; in this case, the deck will only contain career cards that
            require a college degree, and the loop will iterate through the deck without
            finding the appropriate card. As the behavior for such a case was not specified
            in the machine problem specifications, the programmers decided to return a copy
            of the player's kept career card.
            */
            ctr++;
            if (ctr == d.getCurrNumCards()) {
                cCard2 = currPlayer.getCareerCard();
                break;
            }
        }

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
     * <p>On a job search space, a player draws a salary card and chooses between
     * their current salary card and the drawn card.</p>
     *
     * @param currPlayer current player with turn
     * @param d SalaryCardDeck object of the game
     * @return the salary cards a player can choose from
     */
    public ArrayList<SalaryCard> drawSalaryCard(Player currPlayer, SalaryCardDeck d) {
        ArrayList<SalaryCard> salaryCards;
        SalaryCard sCard1;
        SalaryCard sCard2;

        /* The player draws the top card from the salary card deck, and the remaining card
        is the salary card currently kept by the player
        */
        sCard1 = currPlayer.getSalaryCard();
        sCard2 = currPlayer.drawFromSalaryDeck(d);

        /* The salary cards are stored in an array list and returned for the
        player to choose from
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
     * <p>On a job search space, the player draws a career card and
     * chooses the card to keep between his current card and the drawn card.</p>
     *
     * @param currPlayer current player with turn
     * @param careerCards list of career cards the player can choose from
     * @param d CareerCardDeck object of the game
     * @param index index of the chosen career card in the passed array list
     */
    public void executeCareer(Player currPlayer, ArrayList<CareerCard> careerCards, CareerCardDeck d, int index) {
        /* The player keeps their chosen career card */
        currPlayer.keepCareerCard(careerCards.get(index));

        /* In most cases, the card not kept by the player is returned to the career card deck.
        However, for the special case detailed in the drawCareerCard() method, the duplicate
        career card should not be returned to the deck. In such a case (when a duplicate
        exists), the remaining card is no longer returned to the deck.
        */
        if (!careerCards.get(0).equals(careerCards.get(1))) {
            if (index == 0)
                currPlayer.returnCard(careerCards.get(1), d);
            else
                currPlayer.returnCard(careerCards.get(0), d);
        }
    }

    /**
     * Executes one of the actions associated with this space; that is, the player
     * chooses between two salary cards
     *
     * <p>On a job search space, the player draws a salary card and
     * chooses the card to keep between his current card and the drawn card.</p>
     *
     * @param currPlayer current player with turn
     * @param salaryCards list of salary cards the player can choose from
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
     * is on a job search space
     *
     * <p>In particular, the returned string reads as follows: "[Player name], you are
     * on a Job Search space. Choose a career and salary card from the available options." </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a job search space
     */
    @Override
    public String getInfo(Player currPlayer) {
        return currPlayer.getName() + ", you are on a Job Search space.\n" +
                "Choose a career and salary card from the available options.\n" +
                "You are entitled to ANOTHER TURN right after this.\n";
    }
}
