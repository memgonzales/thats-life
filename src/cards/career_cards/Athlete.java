package cards.career_cards;

import cards.CareerCard;

/**
 * Class implementing an <b>Athlete</b> career card, which dictates
 * the player's career, degree requirement (whether it is required or not),
 * and maximum number of pay raises associated with being an athlete
 */
public class Athlete extends CareerCard {
    /**
     * Creates an Athlete career card object
     *
     * <p>In particular, an Athlete career card object is initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is "Athlete".</li>
     *     <li>Degree requirement is <code>false</code>.</li>
     *     <li>The lower bound for the maximum number of pay raises is 1.</li>
     *     <li>The upper bound for the maximum number of pay raises is 6.</li>
     * </ul>
     *
     * <p>The values enumerated above are explicitly indicated in the machine
     * problem specifications. The initialization of the maximum number of pay raises is
     * taken care of in the parent constructor. </p>
     */
    public Athlete() {
        /* Invoke the constructor of the parent class. */
        super("Athlete", false, 1, 6);
    }
}
