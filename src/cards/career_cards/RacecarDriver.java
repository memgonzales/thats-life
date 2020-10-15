package cards.career_cards;

import cards.CareerCard;

/**
 * Class implementing a <b>Racecar Driver</b> career card, which dictates
 * the player's career, degree requirement (whether it is required or not),
 * and maximum number of pay raises associated with being a racecar driver
 */
public class RacecarDriver extends CareerCard {
    /**
     * Creates a Racecar Driver career card object
     *
     * <p>In particular, a Racecar Driver object is initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is "Racecar Driver".</li>
     *     <li>Degree requirement is <code>false</code>.</li>
     *     <li>The lower bound for the maximum number of pay raises is 2.</li>
     *     <li>The upper bound for the maximum number of pay raises is 8.</li>
     * </ul>
     *
     * <p>The values enumerated above are explicitly indicated in the machine
     * problem specifications. The initialization of the maximum number of pay raises is
     * taken care of in the parent constructor. </p>
     */
    public RacecarDriver() {
        /* Invoke the constructor of the parent class. */
        super("Racecar Driver", false, 2, 8);
    }
}