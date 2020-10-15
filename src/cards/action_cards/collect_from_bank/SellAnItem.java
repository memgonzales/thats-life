package cards.action_cards.collect_from_bank;

import cards.action_cards.CollectFromTheBank;
import core.*;

import java.util.concurrent.ThreadLocalRandom;


/**
 * Class implementing a <b>Sell an Item</b> action card, which asks the player
 * to collect money from the Bank, equivalent to the price of the item
 */
public class SellAnItem extends CollectFromTheBank implements MachineRandom {
    /* Price of the item to be sold (amount of money to be collected from the bank) */
    private int itemPrice;

    /**
     * Minimum possible price of the item (decided upon by the programmers to be $1000)
     */
    public static final int MIN_ITEM_PRICE = 1000;
    /**
     * Maximum possible price of the item (decided upon by the programmers to be $10000)
     */
    public static final int MAX_ITEM_PRICE = 10000;
    /**
     * Increment for the possible price of the item (decided upon by the programmers to be $1000)
     */
    public static final int INCREMENT = 1000;

    /**
     * Creates a Sell an Item action card object
     *
     * <p>In particular, a Sell an Item action card object is initialized with the name
     * "Sell an Item".</p>
     */
    public SellAnItem() {
        /* Invoke the constructor of the parent class. */
        super("Sell an Item");

        /* Initialize the price of the item to a randomly generated value within the
        specified upper and lower bounds and following the increment. */
        setItemPrice();
    }

    /**
     * Returns the price of the item specified in this card
     * @return price of the item specified in this card
     */
    public int getItemPrice() {
        return itemPrice;
    }

    /**
     * Executes the action specified in this card, that is, the player collects
     * money from the bank, equivalent to the price of the item indicated in this card
     *
     * @param currPlayer current player with turn
     * @param b Bank of the game
     */
    @Override
    public void execute(Player currPlayer, Bank b) {
        currPlayer.collectCashFromBank(b, itemPrice);
    }

    /**
     * Sets the price to a randomly generated value within the
     * upper and lower bounds and following the specified increment
     * (used in the constructor)
     */
    private void setItemPrice() {
        itemPrice = getMachineRandNum();
    }

    /**
     * Returns a randomly generated value within the lower and upper bounds
     * of the possible price (inclusive) and following the specified increment using the
     * Java <code>ThreadLocalRandom</code> utility class
     *
     * <p>A separate (private) function sets the item price to the returned randomly
     * generated value. </p>
     *
     * <p>Technically, the number is generated in a pseudorandom fashion, which
     * is adequate for the purposes of the game.</p>
     *
     * @return Randomly generated value within the lower and upper bounds of the possible
     * amount (inclusive) and following the specified increment
     */
    @Override
    public int getMachineRandNum() {
        /* Dividing the minimum and maximum possible prices by the increment, setting these
        as the bounds, and multiplying the randomly generated value by the increment are
        necessary to ensure that the return value is a multiple of the increment
        within the originally specified bounds.

        The +1 in the upper bound is important since ThreadLocalRandom treats the
        lower bound as inclusive but the upper bound as exclusive.
         */
        return INCREMENT * ThreadLocalRandom.current().nextInt(MIN_ITEM_PRICE / INCREMENT, MAX_ITEM_PRICE / INCREMENT + 1);
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You have completed a sale.
     * Collect [price of the item] from the Bank."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo () {
        return "You have completed a sale. Collect $" + itemPrice + " from the " + "Bank.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amount it instructs the player to collect from the Bank
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Action card)</li>
     *     <li>Name of the card (Sell an Item)</li>
     *     <li>The header "Amount Collected from the Bank" (which is a general
     *     description of the Collect from the Bank category of action cards)</li>
     *     <li>The price of the item as the amount collected from the Bank</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() + itemPrice + "\n";
    }
}
