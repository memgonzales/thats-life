package decks;

import cards.ActionCard;
import cards.Card;
import cards.action_cards.collect_from_bank.*;
import cards.action_cards.collect_from_player.FileALawsuit;
import cards.action_cards.collect_from_player.ItsYourBirthday;
import cards.action_cards.pay_bank.*;
import cards.action_cards.pay_player.ChristmasBonus;
import cards.action_cards.pay_player.Lawsuit;
import core.DiscardPile;
import core.MachineRandom;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing the <b>deck containing the action cards</b>
 *
 * <p>This deck contains 50 action cards, generated and shuffled at the start
 * of each game. The deck composition is as follows:</p>
 *
 * <ul>
 *     <li>Collect from the Bank - 40%</li>
 *     <li>Pay the Bank - 40%</li>
 *     <li>Pay the Player - 10%</li>
 *     <li>Collect from Player - 10%</li>
 * </ul>
 */
public class ActionCardDeck extends Deck implements MachineRandom {
    /* Pile of action cards that have been drawn and subsequently discarded from the deck */
    private DiscardPile pile;

    /**
     * Number of Collect from the Bank action cards (since there are 50 cards in this
     * deck, this is set to 40% of 50, which is 20)
     */
    public static final int NUM_COLLECT_FROM_BANK = 20;
    /**
     * Number of Pay the Bank action cards (since there are 50 cards in this
     * deck, this is set to 40% of 50, which is 20)
     */
    public static final int NUM_PAY_BANK = 20;
    /**
     * Number of Pay the Player action cards (since there are 50 cards in this
     * deck, this is set to 10% of 50, which is 5)
     */
    public static final int NUM_PAY_PLAYER = 5;
    /**
     * Number of Collect from Player action cards (since there are 50 cards in this
     * deck, this is set to 10% of 50, which is 5)
     */
    public static final int NUM_COLLECT_FROM_PLAYER = 5;

    /**
     * Creates an action card deck object
     *
     * <p>In particular, an action card deck object is initialized as follows:</p>
     *
     * <ul>
     *     <li>The name is initialized to "Action Card Deck".</li>
     *     <li>The number of career cards inside this deck initially is 50
     *     (the sum of the numbers of the four types of action cards).</li>
     * </ul>
     */
    public ActionCardDeck() {
        /* Invoke the constructor of the parent class. */
        super("Action Card Deck", NUM_COLLECT_FROM_BANK + NUM_PAY_BANK + NUM_PAY_PLAYER + NUM_COLLECT_FROM_PLAYER);
    }

    /**
     * Returns the initial (unshuffled) set of career cards to be stored inside this deck
     *
     * <p>The Collect from the Bank, Pay the Bank, Pay the Player, and Collect
     * from Player form 40%, 40%, 10%, and 10% of the deck respectively. The
     * specific numbers are static final attributes of this class. </p>
     *
     * <p>The specific action cards under each category are determined using a random
     * number generator, with each possible non-negative modulo of the randomly generated
     * value mapped to a particular action card.</p>
     *
     * <p>Once this method is called inside the constructor to generate the initial set of cards,
     * re-calling this method will simply return a set of cards but will not affect the
     * cards inside the deck.</p>
     *
     * @return initial (unshuffled) set of action cards to be stored inside this deck
     */
    @Override
    public ArrayList<Card> generate() {
        /* Initial (unshuffled) set of action cards to be stored inside this deck */
        ArrayList<Card> cards;
        cards = new ArrayList<Card>(getInitNumCards());

        /* Generate the Collect from the Bank action cards.

        The specific action cards are generated randomly based on a random number generator.
        A random integer is generated, and its remainder when divided by 5 is considered.
        Each remainder maps to one of the five Collect from the Bank action cards:
        (1) Tax Refund, (2) Sell an Item, (3) Bonus Payday, (4) Setup School, and
        (0) Write a Book.
         */
        for (int i = 0; i < NUM_COLLECT_FROM_BANK; i++) {
            /* Take the value modulo 5 since there are five Collect from the Bank action cards. */
            switch(getMachineRandNum() % 5) {
                case 1:
                    cards.add(new TaxRefund());
                    break;
                case 2:
                    cards.add(new SellAnItem());
                    break;
                case 3:
                    cards.add(new BonusPayday());
                    break;
                case 4:
                    cards.add(new SetupSchool());
                    break;
                case 0:
                    cards.add(new WriteABook());
                    break;
            }
        }

        /* Generate the Pay the Bank action cards.

        The specific action cards are generated randomly based on a random number generator.
        A random integer is generated, and its remainder when divided by 6 is considered.
        Each remainder maps to one of the six Pay the Bank action cards:
        (1) Buy an Item, (2) Visit a Place, (3) Hiking, (4) Watch a Show, (5) Win a Competition,
        and (0) Traffic violation.
         */
        for (int i = 0; i < NUM_PAY_BANK; i++) {
            /* Take the value modulo 6 since there are six Pay the Bank action cards. */
            switch(getMachineRandNum() % 6) {
                case 1:
                    cards.add(new BuyAnItem());
                    break;
                case 2:
                    cards.add(new VisitAPlace());
                    break;
                case 3:
                    cards.add(new Hiking());
                    break;
                case 4:
                    cards.add(new WatchAShow());
                    break;
                case 5:
                    cards.add(new WinACompetition());
                    break;
                case 0:
                    cards.add(new TrafficViolation());
                    break;
            }
        }

        /* Generate the Pay the Player action cards.

        The specific action cards are generated randomly based on a random number generator.
        A random integer is generated, and its remainder when divided by 2 is considered.
        Each remainder maps to one of the two Pay the Player action cards:
        (1) Lawsuit and (0) Christmas Bonus
         */
        for (int i = 0; i < NUM_PAY_PLAYER; i++) {
            /* Take the value modulo 2 since there are two Pay the Player action cards. */
            switch(getMachineRandNum() % 2) {
                case 1:
                    cards.add(new Lawsuit());
                    break;
                case 0:
                    cards.add(new ChristmasBonus());
                    break;
            }
        }

        /* Generate the Collect from Player action cards.

        The specific action cards are generated randomly based on a random number generator.
        A random integer is generated, and its remainder when divided by 2 is considered.
        Each remainder maps to one of the two Pay the Player action cards:
        (1) File a Lawsuit and (0) It's Your Birthday
         */
        for (int i = 0; i < NUM_COLLECT_FROM_PLAYER; i++) {
            /* Take the value modulo 2 since there are two Collect from Player action cards. */
            switch(getMachineRandNum() % 2) {
                case 1:
                    cards.add(new FileALawsuit());
                    break;
                case 0:
                    cards.add(new ItsYourBirthday());
                    break;
            }
        }

        return cards;
    }

    /**
     * Removes and returns the topmost card inside this deck (that is, the action card
     * drawn by the player)
     *
     * <p>More formally, to discard an action card is to transfer it to the discard
     * pile for recycling once this deck becomes empty.</p>
     *
     * <p>If the action card deck is empty, then the cards inside the discard pile
     * (the shuffling has already been handled in the <code>DiscardPile</code> class)
     * will be transferred back to this deck, and the topmost action card will be
     * returned. </p>
     *
     * @param pile set of action cards that have been drawn and discarded
     *             from this deck
     * @return topmost card that is drawn by the player and removed from this deck
     */
    public ActionCard drawFromDeck(DiscardPile pile) {
        /* Topmost action card to be drawn and discarded */
        ActionCard temp;

        /* If this deck is empty, then the cards inside the discard file (the shuffling has
        already been handled in the DiscardPile class) will be transferred back to this deck.

        Therefore, this method always returns a non-null action card object.
         */
        if (isEmpty())
            receiveDiscarded(pile);

        /* Remove the card from this deck, and transfer it to the discard pile.

        It is important to cast it to ActionCard since pop() is a method
        from the parent class and its return type is the generic Card.
         */
        temp = (ActionCard) pop();
        pile.add(temp);

        return temp;
    }

    /**
     * Receives the drawn and discarded cards in the discard pile (after shuffling,
     * which is handled in the <code>DiscardPile</code> class) to refill
     * this deck once it becomes empty
     *
     * <p>If this deck is not empty, then this method does not perform anything. </p>
     * @param pile set of action cards that have been drawn and discarded
     *        from this deck
     */
    private void receiveDiscarded(DiscardPile pile) {
        /* If this deck is not empty, then this method does not perform anything. */
        if (isEmpty())
            pile.returnCardsTo(this);
    }

    /**
     * Returns the absolute value of a randomly generated integer using the Java utility
     * class <code>ThreadLocalRandom</code>
     *
     * <p>The returned value is used in the generation of the specific action cards
     * comprising this deck. Since the implementation of the method associated with this maps
     * non-negative modulo to particular action cards, it is necessary to take the absolute
     * value of the randomly generated integer to ensure that it is non-negative. </p>
     *
     * <p>Technically, the number is generated in a pseudorandom fashion, which
     * is adequate for the purposes of the game.</p>
     *
     * @return Absolute value of a randomly generated integer
     */
    @Override
    public int getMachineRandNum() {
        /* Take the absolute value to ensure that the returned value is non-negative,
        as explained in the documentation above.
         */
        return Math.abs(ThreadLocalRandom.current().nextInt());
    }
}
