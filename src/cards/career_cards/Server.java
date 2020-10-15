package cards.career_cards;

import cards.CareerCard;

/**
 * Class implementing a <b>Server</b> career card, which dictates
 * the player's career, degree requirement (whether it is required or not),
 * and maximum number of pay raises associated with being a server
 */
public class Server extends CareerCard {
    /**
     * Creates a Server career card object
     *
     * <p>In particular, a Server object is initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is "Server".</li>
     *     <li>Degree requirement is <code>false</code>.</li>
     *     <li>The lower bound for the maximum number of pay raises is 1.</li>
     *     <li>The upper bound for the maximum number of pay raises is 4.</li>
     * </ul>
     *
     * <p>The values enumerated above are explicitly indicated in the machine
     * problem specifications. The initialization of the maximum number of pay raises is
     * taken care of in the parent constructor. </p>
     */
    public Server() {
        /* Invoke the constructor of the parent class. */
        super("Server", false, 1, 4);
    }
}