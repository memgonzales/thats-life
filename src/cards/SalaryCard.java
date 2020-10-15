package cards;

import core.MachineRandom;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing a <b>salary card</b>, which dictates the player's
 * base salary, tax due, and pay raise
 *
 * <p> A salary card is picked alongside a career card at the start of the game
 * and when the player lands on a magenta space with instruction "College Career
 * Choice" or "Job Search." </p>
 */
public class SalaryCard extends Card implements MachineRandom {
    /* Base salary that the player is going to have */
    private int salary;
    /* Base tax due that the player has to pay */
    private int taxDue;
    /* Amount by which the player salary increases every time he/she receives a pay raise */
    private int payRaise;

    /**
     * Per the machine project specifications, the salary amount must be a multiple of $10000.
     */
    public static final int SALARY_MULTIPLIER = 10000;
    /**
     * Per the machine project specifications, the tax due must be a multiple of $1000.
     */
    public static final int TAX_DUE_MULTIPLIER = 1000;
    /**
     * The programmers decided that the pay raise must be a multiple of $2000.
     */
    public static final int PAY_RAISE_MULTIPLIER = 2000;

    /**
     * Creates a salary card object
     *
     * <p>In particular, a salary card has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is "Salary Card".</li>
     *     <li>The salary is a randomly generated multiple of $10000 (following the machine
     *     project specifications) within the range $10000 to $100000 (inclusive). The range
     *     was decided upon by the programmers.</li>
     *     <li>The tax due is computed as 10% of the salary; therefore, it is a multiple of
     *     $1000 in accordance with the machine project specifications.</li>
     *     <li>The pay raise is computed as 20% of the salary, as decided upon by the
     *     programmers.</li>
     * </ul>
     */
    public SalaryCard() {
        /* Invoke the constructor of the parent class, passing the string "Salary Card"
        as the name of this card.
         */
        super("Salary Card");

        /* The salary is a randomly generated multiple of $10000 within the range $10000 to
        $10000 (inclusive).
         */
        salary = SALARY_MULTIPLIER * getMachineRandNum();

        /* This is equivalent to getting 10% of the salary since TAX_DUE_MULTIPLIER divided by
        SALARY_MULTIPLIER is 0.1.

        This approach was preferred to maintain explicit conformance with the machine project
        specifications that the tax due must be a multiple of $1000.
         */
        taxDue = TAX_DUE_MULTIPLIER * salary / SALARY_MULTIPLIER;

        /* This is equivalent to getting 20% of the salary since PAY_RAISE_MULTIPLIER divided by
        SALARY_MULTIPLIER IS 0.2.

        Although the machine project specifications did not indicate any requirement as to the
        pay raise, this approach was preferred to maintain uniformity with the computation
        of the tax due in the preceding line of code.
         */
        payRaise = PAY_RAISE_MULTIPLIER * salary / SALARY_MULTIPLIER;
    }

    /**
     * Returns the base salary that the player is going to have, as indicated in this card
     *
     * @return base salary that the player is going to have, as indicated in this card
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Returns the base tax due that the player has to pay, as indicated in this card
     *
     * @return base tax due that the player is going to have, as indicated in this card
     */
    public int getTaxDue() {
        return taxDue;
    }

    /**
     * Returns the amount by which the player's salary increases every time he/she receives
     * a pay raise
     *
     * @return amount by which the player's salary increases every time he/she receives
     * a pay raise
     */
    public int getPayRaise() {
        return payRaise;
    }

    /**
     * Returns a randomly generated value within the range 1 to 10 (inclusive) using
     * the Java utility class <code>ThreadLocalRandom</code>
     *
     * <p>The constructor uses this returned randomly generated value to initialize
     * the salary, tax due, and pay raise. </p>
     *
     * <p><b>Pre-condition:</b>
     * Assume that the range of the salary is [<i>k</i>, 10<i>k</i>], where <i>k</i>
     * is the multiplier (that is, the salary is a multiple of <i>k</i>). </p>
     *
     * <p>The range [1, 10] scales down the range of the salary: [10000, 100000]
     * to ensure that the randomly generated value returned by this method can then be
     * multiplied by the appropriate factor and can be used in setting the salary and
     * in computing the corresponding tax due and pay raise.</p>
     *
     * <p>Technically, the number is generated in a pseudorandom fashion, which
     * is adequate for the purposes of the game.</p>
     *
     * @return randomly generated value within the range 1 to 10 (inclusive)
     */
    @Override
    public int getMachineRandNum() {
        /* The +1 in the upper bound is important since ThreadLocalRandom treats the
        lower bound as inclusive but the upper bound as exclusive.
         */
        return ThreadLocalRandom.current().nextInt(1, 11);
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Salary card)</li>
     *     <li>Salary</li>
     *     <li>Tax due</li>
     *     <li>Pay raise (amount by which the salary increases when a player receives
     *     a pay raise)</li>
     * </ul>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        /* The following information must be displayed for the player to be
        informed of the pertinent details about the salary card drawn.
         */
        return "SALARY CARD\n" +
                "Salary: " + salary + "\n" +
                "Tax Due: " + taxDue + "\n" +
                "Pay Raise Increment: " + payRaise + "\n";
    }

    /**
     * Return a string representation of this salary card, which includes the salary indicated,
     * tax due, and pay raise
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Salary Card)</li>
     *     <li>Salary</li>
     *     <li>Tax due</li>
     *     <li>Pay raise (amount by which the salary increases when a player receives
     *     a pay raise)</li>
     * </ul>
     *
     * @return string representation of this salary card, which includes the salary indicated,
     * tax due, and pay raise
     */
    @Override
    public String toString() {
        return "SALARY CARD\n" +
                "Salary: " + salary + "\n" +
                "Tax Due: " + taxDue + "\n" +
                "Pay Raise: " + payRaise + "\n";
    }

    /**
     * Returns <code>true</code> if the salaries of two salary cards are equal
     * and <code>false</code> otherwise
     *
     * <p>This method is used in the program to ensure that the generated salary cards
     * in the salary card deck have unique salaries.</p>
     *
     * @return <code>true</code> if the salaries of two salary cards are equal;
     * <code>false</code>, otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        /* The salaries of this SalaryCard object and the object passed as the
        method parameter are compared.
        */
        return ((SalaryCard) obj).getSalary() == this.getSalary();
    }
}
