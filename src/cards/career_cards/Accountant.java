package cards.career_cards;

import cards.CareerCard;

/**
 * Class implementing an <b>Accountant</b> career card, which dictates
 * the player's career, degree requirement (whether it is required or not),
 * and maximum number of pay raises associated with being an accountant
 */
public class Accountant extends CareerCard {
    /**
     * Creates an Accountant career card object
     *
     * <p>In particular, an Accountant career card object is initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is "Accountant".</li>
     *     <li>Degree requirement is <code>true</code>.</li>
     *     <li>The lower bound for the maximum number of pay raises is 4.</li>
     *     <li>The upper bound for the maximum number of pay raises is 7.</li>
     * </ul>
     *
     * <p>The values enumerated above are explicitly indicated in the machine
     * problem specifications. The initialization of the maximum number of pay raises is
     * taken care of in the parent constructor. </p>
     */
    public Accountant() {
        /* Invoke the constructor of the parent class. */
        super("Accountant", true, 4, 7);
    }
}
