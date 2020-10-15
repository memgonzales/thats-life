package decks;

import cards.BlueCard;
import cards.Card;
import cards.blue_cards.*;

import java.util.ArrayList;

public class BlueCardDeck extends Deck {
    /**
     * The machine project specifications state that there must be 7 blue cards.
     */
    public static final int NUM_BLUE_CARDS = 7;

    /**
     * Creates a blue card deck object
     *
     * <p>In particular, a blue card deck object is initialized as follows:</p>
     *
     * <ul>
     *     <li>The name is initialized to "Blue Card Deck".</li>
     *     <li>The number of blue cards inside this deck initially is 7.</li>
     * </ul>
     */
    public BlueCardDeck() {
        /* Invoke the constructor of the parent class. */
        super("Blue Card Deck", NUM_BLUE_CARDS);
    }

    /**
     * Returns the initial (unshuffled) set of blue cards to be stored inside this deck
     *
     * <p>There are a total of 7 unique blue cards, corresponding to the seven possible cards
     * indicated in the machine project specifications: Lawsuit(Blue), Salary Tax Due, Tip the Server,
     * Ski Accident, Computer Repair, World Cup, and F1 Race.</p>
     *
     * <p>Once this method is called inside the constructor to generate the initial set of cards,
     * re-calling this method will simply return a set of cards but will not affect the
     * cards inside the deck.</p>
     *
     * @return initial (unshuffled) set of career cards to be stored inside this deck
     */
    @Override
    public ArrayList<Card> generate() {
        /* Initial (unshuffled) set of blue cards to be stored inside this deck */
        ArrayList<Card> cards;
        cards = new ArrayList<Card>(getInitNumCards());

        /* Add each of the seven unique career cards. */
        cards.add(new LawsuitBlue());
        cards.add(new SalaryTaxDue());
        cards.add(new TipTheServer());
        cards.add(new SkiAccident());
        cards.add(new ComputerRepair());
        cards.add(new WorldCup());
        cards.add(new F1Race());

        return cards;
    }

    /**
     * Returns the topmost card inside this deck (that is, the blue card
     * drawn by the player)
     *
     * <p>The career card deck will never be empty since the players do not keep the
     * drawn blue cards; hence, the cards are effectively never removed from the deck.</p>
     *
     * @return topmost card that is drawn by the player
     */
    public BlueCard drawFromDeck() {
        /* Topmost blue card to be drawn */
        BlueCard temp;

        /* The topmost card is drawn (but not removed) using the generic method top().
        It is important to cast it to BlueCard since top() is a method
        from the parent class and its return type is the generic Card.
        */
        temp = (BlueCard) top();

        /* The shuffling is done in the same method as players do not return blue cards
        to the deck (since in this implementation, players do not remove blue cards from
        the deck in the first place).
        */
        shuffle();

        /* A copy of the drawn card is returned for its effect to be executed. */
        return temp;
    }
}
