package decks;

import cards.Card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Abstract class providing a skeletal implementation of a <b>deck</b>
 */
public abstract class Deck {
    /* Name of this deck */
    private String name;
    /* Cards stored in this deck */
    private ArrayList<Card> cards;
    /* Number of cards in this deck initially */
    private int initNumCards;

    /**
     * Constructor with the specified name and the initial number of cards in this deck
     * as parameters
     *
     * The method for shuffling the generated cards is also called in this constructor;
     * therefore, the cards are guaranteed to be shuffled every time an object of a specific
     * subclass of Deck is created.
     *
     * @param name name of this deck
     * @param initNumCards number of cards in the deck initially
     */
    public Deck(String name, int initNumCards) {
        this.name = name;
        this.cards = new ArrayList<Card>(initNumCards);
        this.initNumCards = initNumCards;

        /* Add the generated cards to the deck, and shuffle them. */
        setCards(generate());
        shuffle();
    }

    /**
     * Return the name of this deck
     *
     * <p>The name is the most specific identifier of the deck.</p>
     *
     * @return name of this deck
     */
    public String getName() {
        return name;
    }

    /**
     * Returns an <code>ArrayList</code> of strings containing the names of the cards
     * inside this deck
     *
     * @return <code>ArrayList</code> of strings containing the names of the cards
     * inside this deck
     */
    public ArrayList<String> getCardNames() {
        /* Names of the cards inside this deck */
        ArrayList<String> cardNames;
        cardNames = new ArrayList<String>(cards.size());

        /* Add the names of the cards inside this deck to the ArrayList of strings
        to be returned by this method.
         */
        for (int i = 0; i < cards.size(); i++)
            cardNames.add(cards.get(i).getName());

        return cardNames;
    }

	/**
     * Returns a card at the specified index
     *
	 * @param index index in the deck of the card to be returned 
     * @return <code>Card</code> at the given index
     */
    public Card getCard(int index) {
        return cards.get(index);
    }

	/**
     * Returns a card with a given name
     *
	 * @param name name of the card to be returned
     * @return <code>Card</code> with the given name
     */
    public Card getCard(String name) {
        for (int i = 0; i < cards.size(); i++)
			/* String comparison is done to return the card with the given name */
            if (cards.get(i).getName().equalsIgnoreCase(name))
                return cards.get(i);

		/* If none of the cards in the deck have the given name, null is returned */
        return null;
    }

    /**
     * Returns the number of cards in this deck initially
     *
     * @return number of cards in this deck initially
     */
    public int getInitNumCards() {
        return initNumCards;
    }

    /**
     * Returns the number of cards in this deck currently
     *
     * @return number of cards in this deck currently
     */
    public int getCurrNumCards() {
        return cards.size();
    }

    /**
     * Sets the cards in this deck to the cards in the given <code>ArrayList</code>
     *
     * @param cards is the given <code>ArrayList</code> of cards to which the cards
     *              in this deck will be set
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * Abstract method for returning the initial (unshuffled) set of cards
     * to be stored inside this deck
     *
     * <p>Once this method is called inside the constructor to generate the initial set of cards,
     * re-calling this method will simply return a set of cards but will not affect the
     * cards inside the deck.</p>
     *
     * @return initial (unshuffled) set of cards to be stored inside this deck
     */
    public abstract ArrayList<Card> generate();

    /**
     * Removes and returns the topmost card inside this deck (that is, the card
     * drawn by the player)
     *
     * <p>More formally, it discards and returns the last element of the <code>ArrayList</code>
     * containing the cards (similar to the pop operation in a stack data structure). If this
     * deck is empty, then <code>null</code> is returned. </p>
     *
     * @return topmost card that is drawn by the player and removed from this deck;
     * <code>null</code> if this deck is empty
     */
    public Card pop() {
        if (!isEmpty())
            return cards.remove(cards.size() - 1);

        return null;
    }

    /**
     * Returns the topmost card inside this deck
     *
     * @return topmost card of this deck
     */
    public Card top() {
        if (!isEmpty())
            return cards.get(cards.size() - 1);

        return null;
    }

    /**
     * Returns the card to be removed from the deck given its specified index
     *
     * @param index of the card to be picked
     * @return card at the chosen index inside this deck
     */
    public Card pick(int index) {
        /* If the deck is not empty, the card at the chosen index is removed.
        Otherwise, null is returned.
        */
        if (!isEmpty())
            return cards.remove(index);

        return null;
    }

    /**
     * Transfers a given card back into the deck
     *
     * @param c card to be returned
     */
    public void returnCard(Card c) {
        /* The returned card is added back into the deck, and the deck is
        shuffled afterwards.
        */
        cards.add(c);
        shuffle();
    }

    /**
     * Transfers a given card into the bottom of the deck where it was drawn
     *
     * @param c card to be returned
     */
    public void returnCardToBottom(Card c) {
        /* The returned card is return to the bottom of the deck using one
        of the overloaded add() methods in the ArrayList class.
        */
        cards.add(0, c);
    }

    /**
     * Shuffles the cards inside this deck
     *
     * <p>More formally, it permutes the order of the cards inside this deck using a method
     * in the Java utility class <code>Collections.</code></p>
     */
    public void shuffle() {
        /* As stated in the Java API, the one-parameter version of the method shuffle
        uses the "default source of randomness" and runs in linear time.
         */
        Collections.shuffle(cards);
    }


    /**
     * Returns <code>true</code> if this deck is empty; <code>false</code>, otherwise
     *
     * @return <code>true</code> if this deck is empty; <code>false</code>, otherwise
     */
    public boolean isEmpty() {
        return cards.size() == 0;
    }

    /**
     * Returns a string representation of this deck, which includes its name, the number
     * of cards initially and currently inside it, and the string representations of the cards
     * currently inside it
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Name of this deck</li>
     *     <li>Number of cards initially inside it</li>
     *     <li>Number of cards currently inside it</li>
     *     <li>String representations of the cards currently inside it
     *     (the first card displayed is the topmost)</li>
     * </ul>
     *
     * @return string representation of this deck, which includes its name, the number
     * of cards initially and currently inside it, and the string representations of the cards
     * currently inside it
     */
    @Override
    public String toString() {
        String retStr;

        retStr = name + "\n" +
                "Num. of Cards (Original): " + initNumCards + "\n" +
                "Num. of Cards (Current): " + cards.size() + "\n\n";

        /* Traverse the ArrayList backwards so that the string representation
        of the topmost card is displayed first.
         */
        for (int i = cards.size() - 1; i >= 0; i--)
            retStr += cards.get(i).toString() + "\n";

        return retStr;
    }
}
