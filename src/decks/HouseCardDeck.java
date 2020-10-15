package decks;

import cards.Card;
import cards.HouseCard;

import java.util.ArrayList;

/**
 * Class implementing the <b>deck containing the salary cards</b>
 *
 * <p>This deck contains 10 house cards with varying names and buying prices
 * generated at the start of the game. </p>
 */
public class HouseCardDeck extends Deck {
    /**
     * The programmers decided to implement ten house cards.
     */
    public static final int NUM_HOUSE_CARDS = 10;
    /**
     * The unique names of the house cards were chosen by the programmers for
     * smoother gameplay and are implemented as a constant list in this class.
     */
    public static final String[] NAMES_HOUSE = {"Florence Penthouse", "Swing Penthouse",
                                                "Hai Lin Villa", "Havsis Villa", "Edwardian Mansion",
                                                "Jacobian Mansion", "Cece Townhouse", "Purogh Townhouse",
                                                "Java Farmhouse", "Bali Farmhouse"};
    /**
     * Creates a house card deck object
     *
     * <p>In particular, a house card deck object is initialized as follows:</p>
     *
     * <ul>
     *     <li>The name is initialized to "House Card Deck".</li>
     *     <li>The number of house cards inside this deck initially is 10.</li>
     * </ul>
     */
    public HouseCardDeck() {
        /* Invoke the constructor of the parent class. */
        super("House Card Deck", NUM_HOUSE_CARDS);
    }

    /**
     * Returns the initial (unshuffled) set of house cards to be stored inside this deck
     *
     * <p>There are a total of 10 house cards with varying names and buying prices generated
     * at the start of the game. </p>
     *
     * <p>Once this method is called inside the constructor to generate the initial set of cards,
     * re-calling this method will simply return a set of cards but will not affect the
     * cards inside the deck.</p>
     *
     * @return initial (unshuffled) set of house cards to be stored inside this deck
     */
    @Override
    public ArrayList<Card> generate() {
        /* Initial (unshuffled) set of house cards to be stored inside this deck */
        ArrayList<Card> cards;
        /* Number of house cards with varying buying prices currently in the deck */
        int numUniqueCards;
        /* The index in the string of the name currently being used to initialize
        the house card
        */
        int nameIndex;
        /* true if the card generated is unique (that is, it is the only card in the deck
        with the indicated buying price); false, otherwise
         */
        boolean isUniqueCard;

        cards = new ArrayList<Card>(getInitNumCards());
        numUniqueCards = 0;
        nameIndex = 0;

        /* The number of cards generated must be equal to 10. */
        while (numUniqueCards != getInitNumCards()) {
            cards.add(new HouseCard(NAMES_HOUSE[nameIndex]));
            isUniqueCard = true;

            /* Check if there is already a card in the deck with the same indicated
            buying price.
             */
            for (int i = 0; i < cards.size() - 1 && isUniqueCard; i++) {
                /* If there is already a card in the deck with the same indicated
                buying price, remove the newly added card from the deck and identify
                it as a non-unique card to exit the loop.
                 */
                if (((HouseCard) cards.get(i)).equals((HouseCard) cards.get(cards.size() - 1))) {
                    cards.remove(cards.size() - 1);
                    isUniqueCard = false;
                }
            }

            /* Increment the number of unique cards if and only if the newly added card
            has a unique buying price.
             */
            if (isUniqueCard) {
                numUniqueCards++;
                nameIndex++;
            }
        }

        return cards;
    }

    /**
     * Returns an array list of the details of the house cards currently in the deck
     *
     * @return array list of the details of the house cards currently in the deck
     */
    public ArrayList<String> getHouseDetails() {
        ArrayList<String> houseDetails;
        /* An ArrayList object is initialized to hold the current number of cards
        in the deck.
        */
        houseDetails = new ArrayList<String>(getCurrNumCards());

        /* The details of each card in the deck are added to the houseDetails variable
        by calling the toString() method of each of the cards.
        */
        for (int i = 0; i < getCurrNumCards(); i++)
            houseDetails.add(((HouseCard) getCard(i)).toString());

        return houseDetails;
    }

    /**
     * Removes and returns the card inside this deck at the specified index, as
     * the removal is dependent on the house the player chooses
     *
     * <p>The house card deck will never be empty since only a maximum of three
     * house cards can be removed from the deck in a game (and there are ten house cards).</p>
     *
     * @param index string index of the card chosen by the player
     * @return card that is drawn by the player and removed from this deck
     */
    public HouseCard drawFromDeck(int index) {
        return (HouseCard) pick(index);
    }
}
