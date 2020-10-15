package cards.career_cards;

import cards.CareerCard;

/**
 * Class implementing a <b>Lawyer</b> career card, which dictates
 * the player's career, degree requirement (whether it is required or not),
 * and maximum number of pay raises associated with being a lawyer
 */
public class Lawyer extends CareerCard {
    /**
     * Creates a Lawyer career card object
     *
     * <p>In particular, a Lawyer object is initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is "Lawyer".</li>
     *     <li>Degree requirement is <code>true</code>.</li>
     *     <li>The lower bound for the maximum number of pay raises is 5.</li>
     *     <li>The upper bound for the maximum number of pay raises is 8.</li>
     * </ul>
     *
     * <p>The values enumerated above are explicitly indicated in the machine
     * problem specifications. The initialization of the maximum number of pay raises is
     * taken care of in the parent constructor. </p>
     */
    public Lawyer() {
        /* Invoke the constructor of the parent class. */
        super("Lawyer", true, 5, 8);
    }
}