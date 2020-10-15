package cards.action_cards.pay_bank;

import cards.action_cards.PayTheBank;

/**
 * Class implementing a <b>Visit a Place</b> action card, which asks the player
 * to pay money to the Bank, equivalent to the travel cost
 */
public class VisitAPlace extends PayTheBank {
    /**
     * Creates a Visit a Place action card object
     *
     * <p>In particular, a Visit a Place action card object is initialized as follows:</p>
     * <ul>
     *     <li>Its name is "Visit a Place".</li>
     *     <li>The lower bound for the possible travel cost is $20000.</li>
     *     <li>The upper bound for the possible travel cost is $80000.</li>
     *     <li>The increment for the possible travel cost is $10000.</li>
     * </ul>
     *
     * <p>The bounds and increments were decided upon by the programmers.
     * The initialization of the travel cost is taken care of in the parent constructor. </p>
     */
    public VisitAPlace() {
        /* Invoke the constructor of the parent class. */
        super("Visit a Place", 20000, 80000, 10000);
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You decided to travel for
     * your vacation. You spent [travel cost] on expenses."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You decided to travel for your vacation. You spent $" + getAmount() + " on expenses.\n";
    }
}