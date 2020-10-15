package cards.action_cards.pay_bank;

import cards.action_cards.PayTheBank;

/**
 * Class implementing a <b>Win a Competition</b> action card, which asks the player
 * to pay money to the Bank, equivalent to the competition tax.
 */
public class WinACompetition extends PayTheBank {
    /**
     * Creates a Win a Competition action card object
     *
     * <p>In particular, a Win a Competition action card object is initialized as follows:</p>
     * <ul>
     *     <li>Its name is "Win a Competition".</li>
     *     <li>The lower bound for the possible competition tax is $1000.</li>
     *     <li>The upper bound for the possible competition tax is $5000.</li>
     *     <li>The increment for the possible competition tax is $1000.</li>
     * </ul>
     *
     * <p>The bounds and increments were decided upon by the programmers.
     * The initialization of the competition tax is taken care of in the parent constructor. </p>
     */
    public WinACompetition() {
        /* Invoke the constructor of the parent class. */
        super("Win a Competition", 1000, 5000, 1000);
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You have won a competition.
     * Pay [competition tax] as competition tax."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You have won a competition. Pay $" + getAmount() + " as competition tax.\n";
    }
}