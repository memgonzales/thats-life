package decks;

import cards.Card;
import cards.CareerCard;
import cards.career_cards.*;

import java.util.ArrayList;

/**
 * Class implementing the <b>deck containing the career cards</b>
 *
 * <p>This deck contains 7 unique career cards, generated and shuffled at the start
 * of the game. The seven cards correspond to the seven possible careers indicated
 * in the machine project specifications: lawyer, accountant, computer consultant,
 * doctor, server, racecar driver, and athlete.</p>
 */
public class CareerCardDeck extends Deck {
    /**
     * There are 7 career cards, corresponding to the 7 careers enumerated in the
     * machine project specifications.
     */
    public static final int NUM_CAREER_CARDS = 7;

    /**
     * Creates a career card deck object
     *
     * <p>In particular, a career card deck object is initialized as follows:</p>
     *
     * <ul>
     *     <li>The name is initialized to "Career Card Deck".</li>
     *     <li>The number of career cards inside this deck initially is 7.</li>
     * </ul>
     */
    public CareerCardDeck() {
        /* Invoke the constructor of the parent class. */
        super("Career Card Deck", NUM_CAREER_CARDS);
    }

    /**
     * Returns the initial (unshuffled) set of career cards to be stored inside this deck
     *
     * <p>There are a total of 7 unique career cards, corresponding to the seven possible careers
     * indicated in the machine project specifications: lawyer, accountant, computer consultant,
     * doctor, server, racecar driver, and athlete.</p>
     *
     * <p>Once this method is called inside the constructor to generate the initial set of cards,
     * re-calling this method will simply return a set of cards but will not affect the
     * cards inside the deck.</p>
     *
     * @return initial (unshuffled) set of career cards to be stored inside this deck
     */
    @Override
    public ArrayList<Card> generate() {
        /* Initial (unshuffled) set of career cards to be stored inside this deck */
        ArrayList<Card> cards;
        cards = new ArrayList<Card>(getInitNumCards());

        /* Add each of the seven unique career cards. */
        cards.add(new Lawyer());
        cards.add(new Accountant());
        cards.add(new ComputerConsultant());
        cards.add(new Doctor());
        cards.add(new Server());
        cards.add(new RacecarDriver());
        cards.add(new Athlete());
        
        return cards;
    }

    /**
     * Removes and returns the topmost card inside this deck (that is, the career card
     * drawn by the player)
     *
     * <p>The career card deck will never be empty since this game can only have
     * a maximum of three players (and there are seven career cards).</p>
     *
     * @return topmost card that is drawn by the player and removed from this deck
     */
    public CareerCard drawFromDeck() {
        /* It is important to cast it to CareerCard since pop() is a method
        from the parent class and its return type is the generic Card.
         */
        return (CareerCard) pop();
    }
}
