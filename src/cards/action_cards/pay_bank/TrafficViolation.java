package cards.action_cards.pay_bank;

import cards.action_cards.PayTheBank;

/**
 * Class implementing a <b>Traffic Violation</b> action card, which asks the player
 * to pay money to the Bank, equivalent to the fine
 */
public class TrafficViolation extends PayTheBank {
    /**
     * Creates a Traffic Violation action card object
     *
     * <p>In particular, a Traffic Violation action card object is initialized as follows:</p>
     * <ul>
     *     <li>Its name is "Traffic Violation".</li>
     *     <li>The lower bound for the possible fine is $1000.</li>
     *     <li>The upper bound for the possible fine is $6000.</li>
     *     <li>The increment for the possible fine is $1000.</li>
     * </ul>
     *
     * <p>The bounds and increments were decided upon by the programmers.
     * The initialization of the fine is taken care of in the parent constructor. </p>
     */
    public TrafficViolation() {
        /* Invoke the constructor of the parent class. */
        super("Traffic Violation", 1000, 6000, 1000);
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You committed a traffic violation.
     * Pay a fine of [fine]."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You committed a traffic violation. Pay a fine of $" + getAmount() + ".\n";
    }
}