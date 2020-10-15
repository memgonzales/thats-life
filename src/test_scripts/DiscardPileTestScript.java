

import cards.action_cards.collect_from_bank.BonusPayday;
import cards.action_cards.collect_from_player.FileALawsuit;
import cards.action_cards.pay_bank.BuyAnItem;
import cards.action_cards.pay_player.ChristmasBonus;
import core.DiscardPile;
import decks.ActionCardDeck;

/**
 * Test script for <code>DiscardPile</code> class
 */
public class DiscardPileTestScript {
    public static void main(String[] args) {

        ActionCardDeck deck;
        BonusPayday c1;
        FileALawsuit c2;
        BuyAnItem c3;
        ChristmasBonus c4;
        BonusPayday c5;
        DiscardPile pile;

        /* An ActionCardDeck object and five ActionCard objects are created
         *  to test the DiscardPile methods. */
        deck = new ActionCardDeck();
        c1 = new BonusPayday();
        c2 = new FileALawsuit();
        c3 = new BuyAnItem();
        c4 = new ChristmasBonus();
        c5 = new BonusPayday();

        /* Constructor: DiscardPile ()
         *  A new DiscardPile object is created. */
        pile = new DiscardPile();

        System.out.println("add()");

        /* Method: add(Card c)
         *  Test case 1: c1 is added to the discard pile.
         *  Expected output: pile will contain one element (a "Bonus Pay Day" card). */
        System.out.println("Test case 1: c1 is added to the discard pile.");

        pile.add(c1);
        System.out.println("Number of cards: " + pile.getCurrNumCards());
        System.out.println("Cards: " + pile.getCardNames());

        /* Method: add(Card c)
         *  Test case 2: c2, c3, and c4 are added to the discard pile.
         *  Expected output: pile will contain four elements (different types of cards). */
        System.out.println("Test case 2: c2, c3, and c4 are added to the discard pile.");

        pile.add(c2);
        pile.add(c3);
        pile.add(c4);
        System.out.println("Number of cards: " + pile.getCurrNumCards());
        System.out.println("Cards: " + pile.getCardNames());

        /* Method: add(Card c)
         *  Test case 3: c5 (a second instance of BonusPayday) is added to the discard pile.
         *  Expected output: pile will contain five elements (duplicate action cards are allowed). */
        System.out.println("Test case 3: c5 (a second instance of BonusPayDay) is added to the discard pile.");

        pile.add(c5);
        System.out.println("Number of cards: " + pile.getCurrNumCards());
        System.out.println("Cards: " + pile.getCardNames());

        System.out.println();
        System.out.println("returnCardsTo()");

        /* Method: returnCardsTo(Deck d)
         *  Test case 1: The cards in pile are returned to deck (pile originally contains 5 elements).
         *  Expected output: deck will contain 5 elements (the original contents of pile), and
         *  pile will be empty. */
        System.out.println("Test case 1: The cards in pile are returned to deck (pile originally contains 5 elements).");

        pile.returnCardsTo(deck);
        System.out.println("Cards in the deck: " + deck.getCardNames());
        System.out.println("Cards in the discard pile: " + pile.getCardNames());

        /* Method: returnCardsTo(Deck d)
         *  Test case 2: The cards in pile are returned to deck (pile originally contains 0 elements).
         *  Expected output: deck will contain 0 elements (the original contents of pile), and
         *  pile will be empty. */
        System.out.println("Test case 2: The cards in pile are returned to deck (pile originally contains 0 elements).");

        pile.returnCardsTo(deck);
        System.out.println("Cards in the deck: " + deck.getCardNames());
        System.out.println("Cards in the discard pile: " + pile.getCardNames());

        System.out.println();
        System.out.println("toString()");

        /* The individual action cards are added back to pile to test the toString() method. */
        pile.add(c1);
        pile.add(c2);
        pile.add(c3);
        pile.add(c4);
        pile.add(c5);

        /* Method: Overridden toString()
         *  Test case: The DiscardPile object is printed (using the toString() method).
         *  Expected output: The number of elements in pile (5) and the names and effects
         *  of the individual action cards. */
        System.out.println("Test case: The DiscardPile object is printed (using the toString() method).");

        System.out.println(pile);
    }
}
