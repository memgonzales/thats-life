package cards.action_cards.pay_bank;

import cards.action_cards.PayTheBank;

/**
 * Class implementing a <b>Hiking</b> action card, which asks the player
 * to pay money to the Bank, equivalent to the hiking cost
 */
public class Hiking extends PayTheBank {
    /**
     * Creates a Hiking action card object
     *
     * <p>In particular, a Hiking action card object is initialized as follows:</p>
     * <ul>
     *     <li>Its name is "Hiking".</li>
     *     <li>The lower bound for the possible hiking cost is $10000.</li>
     *     <li>The upper bound for the possible hiking cost is $70000.</li>
     *     <li>The increment for the possible hiking cost is $10000.</li>
     * </ul>
     *
     * <p>The bounds and increments were decided upon by the programmers.
     * The initialization of the hiking cost is taken care of in the parent constructor. </p>
     */
    public Hiking() {
        /* Invoke the constructor of the parent class. */
        super("Hiking", 10000, 70000, 10000);
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You went hiking and spent
     * [hiking cost] on hiking gear and other expenses."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You went hiking and spent $" + getAmount() + " on hiking gear and other expenses.\n";
    }
}