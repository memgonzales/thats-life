package core;

import cards.Card;
import cards.action_cards.CollectFromPlayer;
import cards.action_cards.CollectFromTheBank;
import cards.action_cards.PayTheBank;
import cards.action_cards.PayThePlayer;
import decks.Deck;

import java.util.ArrayList;

/**
 * Class implementing the <b>discard pile</b>, where all drawn and discarded
 * action cards are transferred.
 *
 * <p>Once the action card deck becomes empty, the cards in the discard pile
 * are shuffled then transferred (or recycled) back to the action card deck
 * to allow for the continuity of the game. </p>
 */
public class DiscardPile {
    /* Name of this game component */
    private String name;
    /* Cards stored in this discard pile */
    private ArrayList<Card> cards;

    /**
     * Creates a discard pile object
     *
     * <p>In particular, a discard pile object is initialized with the name
     * "Action Card Discard Pile" and the initial capacity of the <code>ArrayList</code>
     * containing the cards is set to 50 since there are 50 action cards. </p>
     */
    public DiscardPile() {
        name = "Action Card Discard Pile";
        /* The initial capacity is set to 50 since there are 50 action cards. */
        cards = new ArrayList<Card>(50);
    }

    /**
     * Returns the name of the discard pile
     *
     * @return name of the discard pile
     */
    public String getName() {
        return name;
    }

    /**
     * Returns an <code>ArrayList</code> of strings containing the names of the cards
     * inside this discard pile
     *
     * @return <code>ArrayList</code> of strings containing the names of the cards
     * inside this discard pile
     */
    public ArrayList<String> getCardNames() {
        /* Names of the cards inside this discard pile */
        ArrayList<String> cardNames;
        cardNames = new ArrayList<String>(cards.size());

        /* Add the names of the cards inside this discard pile to the ArrayList of
        strings to be returned by this method.
         */
        for (int i = 0; i < cards.size(); i++)
            cardNames.add(cards.get(i).getName());

        return cardNames;
    }

    /**
     * Returns the number of cards in this discard pile currently
     *
     * @return number of cards in this discard pile currently
     */
    public int getCurrNumCards() {
        return cards.size();
    }

    /**
     * Adds a card to this discard pile
     *
     * <p>Every time an action card is drawn and discarded from the action card
     * deck, this method is called to transfer the said card to this discard pile. </p>
     *
     * @param c card added to this discard pile
     */
    public void add(Card c) {
        cards.add(c);
    }

    /**
     * Shuffles all the cards inside this discard pile and transfers them back to
     * their original deck
     *
     * <p>Once the player tries to draw a card from an empty action card deck,
     * this method is called to recycle the cards and allow the game to continue. </p>
     *
     * @param d original deck to which the cards inside this discard pile will be
     *          transferred back
     */
    public void returnCardsTo(Deck d) {
        /* A container for the cards (to which the cards in the pertinent deck will
        be set) that is different from the cards attribute of this class is needed
        since the remove method of ArrayList is destructive.
         */
        ArrayList<Card> cards;
        cards = new ArrayList<Card>(this.cards.size());

        /* Remove the card from this discard pile and add it to the container (to which
        the cards in the pertinent deck will be set), repeating this process as long
        as there are still cards in this discard pile.
         */
        while (!isEmpty())
            cards.add(this.cards.remove(this.cards.size() - 1));

        /* Set the cards in the pertinent deck to the container containing all the
        cards previously in this discard pile.
         */
        d.setCards(cards);

        /* Shuffle the cards. */
        d.shuffle();
    }

    /**
     * Returns <code>true</code> if this discard pile is empty; <code>false</code>, otherwise
     *
     * @return <code>true</code> if this discard pile is empty; <code>false</code>, otherwise
     */
    private boolean isEmpty() {
        return cards.size() == 0;
    }

    /**
     * Returns a string representation of this discard pile, which includes its name, the
     * number of cards currently, and the string representations of the cards currently
     * inside it
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Name of this discard pile</li>
     *     <li>Number of cards currently</li>
     *     <li>String representations of the cards currently inside it
     *     (the first card displayed is the most recent card added to this
     *     discard pile)</li>
     * </ul>
     *
     * @return string representation of this discard pile, which includes its name,
     * the number of cards initially and currently, and the string representations
     * of the cards currently inside it
     */
    @Override
    public String toString() {
        String retStr;
        int cat1, cat2, cat3, cat4;
        cat1 = 0;
        cat2 = 0;
        cat3 = 0;
        cat4 = 0;

        retStr = name + "\n" +
                "Num. of Cards (Current): " + cards.size() + "\n\n";

         /* Traverse the ArrayList backwards so that the string representation
        of the most recent card added to this discard pile is displayed first.
         */
        for (int i = cards.size() - 1; i >= 0; i--) {
            retStr += cards.get(i).toString() + "\n";

            if (cards.get(i) instanceof CollectFromPlayer)
                cat1++;

            else if (cards.get(i) instanceof CollectFromTheBank)
                cat2++;

            else if (cards.get(i) instanceof PayTheBank)
                cat3++;

            else if (cards.get(i) instanceof PayThePlayer)
                cat4++;
        }

        retStr += "Collect From Player: " + cat1 + "\n";
        retStr += "Collect From The Bank: " + cat2 + "\n";
        retStr += "Pay The Bank: " + cat3 + "\n";
        retStr += "Pay The Player: " + cat4 + "\n";

        return retStr;
    }
}
