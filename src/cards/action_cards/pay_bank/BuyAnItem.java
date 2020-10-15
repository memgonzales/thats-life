package cards.action_cards.pay_bank;

import cards.action_cards.PayTheBank;

/**
 * Class implementing a <b>Buy an Item</b> action card, which asks the player
 * to pay money to the Bank, equivalent to the price of the item
 */
public class BuyAnItem extends PayTheBank {
    /**
     * Creates a Buy an Item action card object
     *
     * <p>In particular, a Buy an Item action card object is initialized as follows:</p>
     * <ul>
     *     <li>Its name is "Buy an Item".</li>
     *     <li>The lower bound for the possible price of the item is $1000.</li>
     *     <li>The upper bound for the possible price of the item is $10000.</li>
     *     <li>The increment for the possible price of the item is $1000.</li>
     * </ul>
     *
     * <p>The bounds and increments were decided upon by the programmers.
     * The initialization of the item price is taken care of in the parent constructor. </p>
     */
    public BuyAnItem() {
        /* Invoke the constructor of the parent class. */
        super("Buy an Item", 1000, 10000, 1000);
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You have bought an item
     * for [item price]."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You have bought an item for $" + getAmount() + ".\n";
    }
}
