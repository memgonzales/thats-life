package cards.career_cards;

import cards.CareerCard;

/**
 * Class implementing a <b>Computer Consultant</b> career card, which dictates
 * the player's career, degree requirement (whether it is required or not),
 * and maximum number of pay raises associated with being a computer consultant
 */
public class ComputerConsultant extends CareerCard {
    /**
     * Creates a Computer Consultant career card object
     *
     * <p>In particular, a Computer Consultant object is initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is "Computer Consultant".</li>
     *     <li>Degree requirement is <code>true</code>.</li>
     *     <li>The lower bound for the maximum number of pay raises is 3.</li>
     *     <li>The upper bound for the maximum number of pay raises is 7.</li>
     * </ul>
     *
     * <p>The values enumerated above are explicitly indicated in the machine
     * problem specifications. The initialization of the maximum number of pay raises is
     * taken care of in the parent constructor. </p>
     */
    public ComputerConsultant() {
        /* Invoke the constructor of the parent class. */
        super("Computer Consultant", true, 3, 7);
    }
}