package cards.action_cards.pay_bank;

import cards.action_cards.PayTheBank;

/**
 * Class implementing a <b>Watch a Show</b> action card, which asks the player
 * to pay money to the Bank, equivalent to the ticket cost
 */
public class WatchAShow extends PayTheBank {
    /**
     * Creates a Watch a Show action card object
     *
     * <p>In particular, a Visit a Place action card object is initialized as follows:</p>
     * <ul>
     *     <li>Its name is "Watch a Show".</li>
     *     <li>The lower bound for the possible ticket cost is $1000.</li>
     *     <li>The upper bound for the possible ticket cost is $7000.</li>
     *     <li>The increment for the possible ticket cost is $1000.</li>
     * </ul>
     *
     * <p>The bounds and increments were decided upon by the programmers.
     * The initialization of the ticket cost is taken care of in the parent constructor. </p>
     */
    public WatchAShow() {
        /* Invoke the constructor of the parent class. */
        super("Watch a Show", 1000, 7000, 1000);
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You bought a ticket to a show
     * for [ticket cost]."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You bought a ticket to a show for $" + getAmount() + ".\n";
    }
}