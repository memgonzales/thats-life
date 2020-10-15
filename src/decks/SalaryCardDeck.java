package decks;

import cards.Card;
import cards.SalaryCard;

import java.util.ArrayList;

/**
 * Class implementing the <b>deck containing the salary cards</b>
 *
 * <p>This deck contains 10 salary cards with varying salary amounts generated
 * at the start of the game. </p>
 */
public class SalaryCardDeck extends Deck {
    /**
     * The machine project specifications state there must be at least 10 unique
     * salary cards.
     */
    public static final int MIN_NUM_SALARY_CARDS = 10;

    /**
     * Creates a salary card deck object
     *
     * <p>In particular, a salary card deck object is initialized as follows:</p>
     *
     * <ul>
     *     <li>The name is initialized to "Salary Card Deck".</li>
     *     <li>The number of salary cards inside this deck initially is 10.</li>
     * </ul>
     */
    public SalaryCardDeck() {
        /* Invoke the constructor of the parent class. */
        super("Salary Card Deck", MIN_NUM_SALARY_CARDS);
    }

    /**
     * Returns the initial (unshuffled) set of salary cards to be stored inside this deck
     *
     * <p>There are a total of 10 salary cards with varying salary amounts generated
     * at the start of the game. </p>
     *
     * <p>Once this method is called inside the constructor to generate the initial set of cards,
     * re-calling this method will simply return a set of cards but will not affect the
     * cards inside the deck.</p>
     *
     * @return initial (unshuffled) set of salary cards to be stored inside this deck
     */
    @Override
    public ArrayList<Card> generate() {
        /* Initial (unshuffled) set of salary cards to be stored inside this deck */
        ArrayList<Card> cards;
        /* Number of salary cards with varying salary amounts currently in the deck */
        int numUniqueCards;
        /* true if the card generated is unique (that is, it is the only card in the deck
        with the indicated salary amount); false, otherwise
         */
        boolean isUniqueCard;

        cards = new ArrayList<Card>(getInitNumCards());
        numUniqueCards = 0;

        /* The number of cards generated must be equal to 10. */
        while (numUniqueCards != getInitNumCards()) {
            cards.add(new SalaryCard());
            isUniqueCard = true;

            /* Check if there is already a card in the deck with the same indicated
            salary amount.
             */
            for (int i = 0; i < cards.size() - 1 && isUniqueCard; i++) {
                /* If there is already a card in the deck with the same indicated
                salary amount, remove the newly added card from the deck and identify
                it as a non-unique card to exit the loop.
                 */
                if (((SalaryCard) cards.get(i)).equals((SalaryCard) cards.get(cards.size() - 1))) {
                    cards.remove(cards.size() - 1);
                    isUniqueCard = false;
                }
            }

            /* Increment the number of unique cards if and only if the newly added card
            has a unique salary amount.
             */
            if (isUniqueCard)
                numUniqueCards++;
        }

        return cards;
    }

    /**
     * Removes and returns the topmost card inside this deck (that is, the salary card
     * drawn by the player)
     *
     * <p>The salary card deck will never be empty since this game can only have
     * a maximum of three players (and there are ten salary cards).</p>
     *
     * @return topmost card that is drawn by the player and removed from this deck
     */
    public SalaryCard drawFromDeck() {
        return (SalaryCard) pop();
    }
}
