package cards.action_cards;

import cards.ActionCard;
import core.MachineRandom;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Abstract class providing a skeletal implementation of an <b>action card that asks
 * the player to pay money to another player</b>
 *
 * <p>Since all such action cards require the amount to be randomly generated
 * at the start of the game, this abstract class implements the method in the
 * interface <code>MachineRandom</code></p>.
 */
public abstract class PayThePlayer extends ActionCard implements MachineRandom {
    /* Amount of money to be paid to another player  */
    private int amount;

    /* Lower bound for the possible amount of money to be paid to another player */
    private final int AMOUNT_LB;
    /* Upper bound for the possible amount of money to be paid to another player */
    private final int AMOUNT_UB;
    /* Increment for the possible amount of money to be paid to another player */
    private final int INCREMENT;

    /**
     * Constructor with the specified name, lower bound and upper bound, and increment
     * for the possible amount of money to be paid to another player as parameters
     *
     * <p>The name of an action card that asks the player to pay money to another player
     * is indicative of the action if specifies: Lawsuit, Christmas Bonus.</p>
     *
     * @param name name of this card
     * @param amountLB lower bound for the possible amount of money to be paid to
     *                 another player
     * @param amountUB upper bound for the possible amount of money to be paid to
     *                 another player
     * @param increment increment for the possible amount of money to be paid to
     *                  another player
     */
    public PayThePlayer(String name, int amountLB, int amountUB, int increment) {
        /* Invoke the constructor of the parent class. */
        super(name);

        /* Initialize the blank final variables for the lower and upper bounds, and increment
        for the possible amount of money to be paid to another player.
         */
        AMOUNT_LB = amountLB;
        AMOUNT_UB = amountUB;
        INCREMENT = increment;

        /* Initialize the amount of money to be paid to another player to a randomly generated
        value within the specified lower and upper bounds, and following the increment.
         */
        setAmount();
    }

    /**
     * Returns the amount of money to be paid to another player
     *
     * @return amount of money to be paid to another player
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Returns the lower bound for the possible amount of money to be paid to another player
     *
     * @return lower bound for the possible amount of money to be paid to another player
     */
    public int getAmountLB() {
        return AMOUNT_LB;
    }

    /**
     * Returns the upper bound for the possible amount of money to be paid to another player
     *
     * @return upper bound for the possible amount of money to be paid to another player
     */
    public int getAmountUB() {
        return AMOUNT_UB;
    }

    /**
     * Returns the increment for the possible amount of money to be paid to another player
     *
     * @return increment for the possible amount of money to be paid to another player
     */
    public int getIncrement() {
        return INCREMENT;
    }

    /**
     * Sets the amount to a randomly generated value within the
     * upper and lower bounds and following the specified increment
     * (used in the constructor)
     */
    private void setAmount() {
        amount = getMachineRandNum();
    }

    /**
     * Returns a randomly generated value within the lower and upper bounds
     * of the possible amount (inclusive) and following the specified increment using the
     * Java <code>ThreadLocalRandom</code> utility class
     *
     * <p>A separate (private) function sets the amount paid to another player to the returned
     * randomly generated value. </p>
     *
     * <p>Technically, the number is generated in a pseudorandom fashion, which
     * is adequate for the purposes of the game.</p>
     *
     * @return Randomly generated value within the lower and upper bounds of the possible
     * amount (inclusive) and following the specified increment
     */
    @Override
    public int getMachineRandNum() {
        /* Dividing the minimum and maximum possible prices by the increment, setting these
        as the bounds, and multiplying the randomly generated value by the increment are
        necessary to ensure that the return value is a multiple of the increment
        within the originally specified bounds.

        The +1 in the upper bound is important since ThreadLocalRandom treats the
        lower bound as inclusive but the upper bound as exclusive.
         */
        return INCREMENT * ThreadLocalRandom.current().nextInt(AMOUNT_LB / INCREMENT, AMOUNT_UB / INCREMENT + 1);
    }

    /**
     * Returns a string representation of this card, which includes its name and its
     * description as an action card that asks a player to pay money to another player
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Action card)</li>
     *     <li>Name of the card (for example, Visit a Place, Hiking, etc.)</li>
     *     <li>The header "Amount Paid to Other Player" (which is a general
     *     description of the Pay the Bank category of action cards)</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() + "Paid to Other Player: ";
    }
}
