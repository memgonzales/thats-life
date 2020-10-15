package cards.action_cards.collect_from_bank;

import cards.action_cards.CollectFromTheBank;
import core.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing a <b>Setup School</b> action card, which asks the player
 * to collect money from the Bank, equivalent to the charity benefit
 */
public class SetupSchool extends CollectFromTheBank implements MachineRandom {
    /* Charity benefit for establishing a school (amount of money to be collected from the Bank) */
    private int charityBenefit;

    /**
     * Minimum possible charity benefit (decided upon by the programmers to be $50000)
     */
    public static final int MIN_CHARITY_BENEFIT = 50000;
    /**
     * Maximum possible charity benefit (decided upon by the programmers to be $150000)
     */
    public static final int MAX_CHARITY_BENEFIT = 150000;
    /**
     * Increment for the possible charity benefit (decided upon by the programmers to be $10000)
     */
    public static final int INCREMENT = 10000;

    /**
     * Creates a Setup School action card object
     *
     * <p>In particular, a Setup school action card object is initialized with the name
     * "Setup School".</p>
     */
    public SetupSchool() {
        super("Setup School");

        /* Initialize the charity benefit to a randomly generated value within the
        specified upper and lower bounds and following the increment. */
        setCharityBenefit();
    }

    /**
     * Returns the charity benefit specified in this card
     * @return charity benefit specified in this card
     */
    public int getCharityBenefit() {
        return charityBenefit;
    }

    /**
     * Executes the action specified in this card, that is, the player collects
     * money from the bank, equivalent to the charity benefit indicated in this card
     *
     * @param currPlayer current player with turn
     * @param b Bank of the game
     */
    @Override
    public void execute(Player currPlayer, Bank b) {
        currPlayer.collectCashFromBank(b, charityBenefit);
    }

    /**
     * Sets the charity benefit to a randomly generated value within the
     * upper and lower bounds and following the specified increment
     * (used in the constructor)
     */
    private void setCharityBenefit() {
        charityBenefit = getMachineRandNum();
    }

    /**
     * Returns a randomly generated value within the lower and upper bounds
     * of the possible charity benefit (inclusive) and following the specified increment
     * using the Java <code>ThreadLocalRandom</code> utility class
     *
     * <p>A separate (private) function sets the charity benefit to the returned randomly
     * generated value. </p>
     *
     * <p>Technically, the number is generated in a pseudorandom fashion, which
     * is adequate for the purposes of the game.</p>
     *
     * @return Randomly generated value within the lower and upper bounds of the possible
     * amount (inclusive) and following the specified increment
     */
    @Override
    public int getMachineRandNum() {
        /* Dividing the minimum and maximum possible charity benefit by the increment, setting
        these as the bounds, and multiplying the randomly generated value by the increment are
        necessary to ensure that the return value is a multiple of the increment within the
        originally specified bounds.

        The +1 in the upper bound is important since ThreadLocalRandom treats the
        lower bound as inclusive but the upper bound as exclusive.
         */
        return INCREMENT * ThreadLocalRandom.current().nextInt(MIN_CHARITY_BENEFIT / INCREMENT, MAX_CHARITY_BENEFIT / INCREMENT + 1);
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You received charity benefits
     * for setting up a school. Collect [charity benefit] from the Bank."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo () {
        return "You received charity benefits for setting up a school. Collect $" + charityBenefit + " from the Bank.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amount it instructs the player to collect from the Bank
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Action card)</li>
     *     <li>Name of the card (Setup School)</li>
     *     <li>The header "Amount Collected from the Bank" (which is a general
     *     description of the Collect from the Bank category of action cards)</li>
     *     <li>The charity benefit as the amount collected from the Bank</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() + charityBenefit + "\n";
    }
}
