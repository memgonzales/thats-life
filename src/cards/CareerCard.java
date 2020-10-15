package cards;

import core.MachineRandom;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Abstract class providing a skeletal implementation of a <b>career card</b>,
 * which dictates the player's career, degree requirement (whether it is required or not),
 * and maximum number of pay raises
 *
 * <p> A career card is picked alongside a salary card at the start of the game
 * and when the player lands on a magenta space with instruction "College Career
 * Choice" or "Job Search." </p>
 */
public abstract class CareerCard extends Card implements MachineRandom {
    /* Set to true if the career requires a college degree; false, otherwise */
    private boolean isDegreeRequired;
    /* Maximum number of pay raises that a player can have */
    private int maxNumPayRaises;

    /* Lower bound for the maximum number of pay raises that a player can have */
    private final int MAX_NUM_PAY_RAISES_LB;
    /* Upper bound for the maximum number of pay raises that a player can have */
    private final int MAX_NUM_PAY_RAISES_UB;

    /**
     * Constructor with the specified name of this card, degree requirement (whether
     * it is required or not), and lower and upper bounds for the maximum number of pay
     * raises that a player can have as parameters
     *
     * <p>The name of a career card is indicative of the career it specifies
     * (Lawyer, Accountant, etc.).</p>
     *
     * @param name name of this card
     * @param isDegreeRequired set to <code>true</code> if the career requires a college degree;
     *                         <code>false</code>, otherwise
     * @param maxNumPayRaisesLB lower bound for the maximum number of pay raises that a player can have
     * @param maxNumPayRaisesUB upper bound for the maximum number of pay raises that a player can have
     */
    public CareerCard(String name, boolean isDegreeRequired, int maxNumPayRaisesLB, int maxNumPayRaisesUB) {
        /* Invoke the constructor of the parent class. */
        super(name);
        this.isDegreeRequired = isDegreeRequired;
        this.MAX_NUM_PAY_RAISES_LB = maxNumPayRaisesLB;
        this.MAX_NUM_PAY_RAISES_UB = maxNumPayRaisesUB;

        /* Initialize the maximum number of pay raises to a randomly generated value within the
        specified upper and lower bounds. */
        setMaxNumPayRaises();
    }

    /**
     * Returns <code>true</code> if the career requires a college degree; <code>false</code>,
     * otherwise
     *
     * @return <code>true</code> if the career requires a college degree; <code>false</code>,
     * otherwise
     */
    public boolean getIsDegreeRequired() {
        return isDegreeRequired;
    }

    /**
     * Returns the maximum number of pay raises that a player can have
     *
     * @return maximum number of pay raises that a player can have
     */
    public int getMaxNumPayRaises() {
        return maxNumPayRaises;
    }

    /**
     * Returns the lower bound for the maximum number of pay raises that a player can have
     *
     * @return lower bound for the maximum number of pay raises that a player can have
     */
    public int getMaxNumPayRaisesLB() {
        return MAX_NUM_PAY_RAISES_LB;
    }

    /**
     * Returns the upper bound for the maximum number of pay raises that a player can have
     *
     * @return upper bound for the maximum number of pay raises that a player can have
     */
    public int getMaxNumPayRaisesUB() {
        return MAX_NUM_PAY_RAISES_UB;
    }

    /**
     * Sets the maximum number of pay raises that a player can have.
     *
     * <p>The maximum number of pay raises is a randomly generated value within the
     * specified upper and lower bounds. </p>
     */
    private void setMaxNumPayRaises() {
        maxNumPayRaises = getMachineRandNum();
    }

    /**
     * Returns a randomly generated value within the lower and upper bounds for the
     * maximum number of pay raises (inclusive) using the Java utility class
     * <code>ThreadLocalRandom</code>
     *
     * <p>A separate (private) function sets the maximum number of pay raises indicated
     * in this card to the returned randomly generated value. </p>
     *
     * <p>Technically, the number is generated in a pseudorandom fashion, which
     * is adequate for the purposes of the game.</p>
     *
     * @return Randomly generated value within the lower and upper bounds for the
     * maximum number of pay raises (inclusive)
     */
    @Override
    public int getMachineRandNum() {
        /* The +1 in the upper bound is important since ThreadLocalRandom treats the
        lower bound as inclusive but the upper bound as exclusive.
         */
        return ThreadLocalRandom.current().nextInt(MAX_NUM_PAY_RAISES_LB, MAX_NUM_PAY_RAISES_UB + 1);
    }

    /**
     * Returns the card description to be displayed on the console during the actual gameplay
     *
     * <p>In particular, the card description contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Career Card)</li>
     *     <li>Name of the card (actual career)</li>
     *     <li>Degree requirement (whether a degree is required)</li>
     *     <li>Maximum number of pay raises</li>
     * </ul>
     *
     * @return card description to be displayed on the console during the actual gameplay
     */
    @Override
    public String getInfo() {
        String degreeStatus;                // "Yes" if a degree is required; "No", otherwise

        /* In the actual gameplay, it is more user-friendly and appropriate to display
        "Yes" instead of the boolean true and "No" instead of the boolean false.
         */
        if (isDegreeRequired)
            degreeStatus = "Yes";
        else
            degreeStatus = "No";

        /* The following information must be displayed on the console for the player to be
        informed of the pertinent details about the career card drawn.
         */
        return "CAREER CARD\n" +
                "Career: " + getName() + "\n" +
                "Is Degree Required: " + degreeStatus + "\n" +
                "Max Number of Pay Raises: " + maxNumPayRaises + "\n";
    }

    /**
     * Returns a string representation of this career card, which includes its name,
     * degree requirement, and the range for and the actual maximum number of pay raises
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Career Card)</li>
     *     <li>Degree requirement (whether a degree is required)</li>
     *     <li>Upper and lower bounds for the maximum number of pay raises</li>
     *     <li>Maximum number of pay raises</li>
     *     <li>Name of the card (actual career: for example, Lawyer, Accountant, etc.)</li>
     * </ul>
     *
     * @return string representation of this career card, which includes its name,
     * degree requirement, and the range for and the actual maximum number of pay raises
     */
    @Override
    public String toString() {

        String isDegreeRequired;
        if (getIsDegreeRequired())
            isDegreeRequired = "Yes";
        else
            isDegreeRequired = "No";

        return "CAREER CARD\n" +
                "Career: " + getName() + "\n" +
                "Is Degree Required: " + isDegreeRequired + "\n" +
                "Max Number of Pay Raises Range: [" + MAX_NUM_PAY_RAISES_LB + ", " + MAX_NUM_PAY_RAISES_UB + "]\n" +
                "Max Number of Pay Raises: " + maxNumPayRaises + "\n";

    }

    /**
     * Returns <code>true</code> if the names of two career cards are equal
     * and <code>false</code> otherwise
     *
     * <p>This method is used in the program to ensure that two career cards are unique.</p>
     *
     * @return <code>true</code> if the names of two career cards are equal;
     * <code>false</code>, otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        /* The names of this CareerCard object and the object passed as the
        method parameter are compared.
        */
        return ((CareerCard) obj).getName() == this.getName();
    }
}
