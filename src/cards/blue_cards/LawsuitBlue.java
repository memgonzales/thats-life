package cards.blue_cards;

import cards.BlueCard;
import core.Bank;
import core.MachineRandom;
import core.Player;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing a <b>Lawsuit (Blue)</b> blue card, which asks the player
 * to pay a randomly generated amount to either the bank or the player with the
 * Lawyer career
 *
 * <p>The player pays a multiple of 10000 between 50000 and 150000 inclusive. </p>
 */
public class LawsuitBlue extends BlueCard implements MachineRandom {
    /**
     * Amount to be paid that is randomly generated at the start of the game
     */
    private int amount;

    /**
     * Lower bound for the randomly generated amount
     */
    public static final int AMOUNT_LB = 50000;
    /**
     * Upper bound for the randomly generated amount
     */
    public static final int AMOUNT_UB = 150000;
    /**
     * Increment for the randomly generated amount
     */
    public static final int INCREMENT = 10000;

    /**
     * Creates a Lawsuit (Blue) blue card object
     *
     * <p>In particular, a Lawsuit (Blue) blue card is initialized with the
     * name "Lawsuit (Blue Card)" and the career match "Lawyer". </p>
     */
    public LawsuitBlue() {
        /* Invoke the constructor of the parent class, passing the strings "Lawsuit (Blue Card)"
        and "Lawyer"
        */
        super("Lawsuit (Blue Card)", "Lawyer");
        /* The amount to be paid by the player is set in the constructor */
        setAmount();
    }

    /**
     * Returns the amount for the legal fees specified in this card
     * @return amount for the legal fees specified in this card
     */
    public int getAmount() {
        return amount;
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
     * Executes the action specified in this card.
     *
     * <p> In particular, the player executes one of the following three actions: </p>
     *
     * <ul>
     *     <li> If the player matches the career match of the card, they receive 15000
     *     from the bank</li>
     *     <li> If no player matches the career match of the card, the player will pay
     *     the randomly generated legal fees to the bank</li>
     *     <li>If a different player matches the career match of the card, the player
     *     will pay the randomly generated legal fees to the other player</li>
     *</ul>
     *
     * @param currPlayer current player with turn
     * @param playerWithCareer player whose career matches the career specified in the card
     * @param b Bank of the game
     * @return flag indicative of the executed scenario
     */
    public int execute(Player currPlayer, Player playerWithCareer, Bank b) {
        if (currPlayer.getCareer().equalsIgnoreCase(getCareerMatch())) {
            /* If the player matches the career match of the card, they receive 15000
            from the bank
            */
            executeMatchedCareer(currPlayer, b);
            return MATCHED_CAREER;

        } else if (playerWithCareer == null) {
            /* If no player matches the career match of the card, the player will pay
            the randomly generated legal fees to the bank
            */
            currPlayer.payCashToBank(b, getAmount());
            return NO_MATCH;

        } else {
            /* If a different player matches the career match of the card, the player
            will pay the randomly generated legal fees to the other player
            */
            currPlayer.payCashToPlayer(playerWithCareer, b, getAmount());
            return OTHER_MATCH;
        }
    }

    /**
     * Returns the base card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You drew a Lawsuit (Blue) card."</p>
     *
     * @return base card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You drew a Lawsuit (Blue) card.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     *
     * <p>In particular, the card description reads as follows: "You drew a Lawsuit (Blue) card.
     * Pay [amount] to the bank for legal fees."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     */
    @Override
    public String getInfoBank() {
        return getInfo() + "Pay $" + getAmount() + " to the bank for legal fees.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     *
     * <p>In particular, the card description reads as follows: "You drew a Lawsuit (Blue) card.
     * Receive 15000 as a lawyer."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     */
    @Override
    public String getInfoMatch() {
        return getInfo() + "Receive $15000 as a lawyer.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     *
     * <p>In particular, the card description reads as follows: "You drew a Lawsuit (Blue) card.
     * Pay [amount] to the lawyer for legal fees."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     */
    @Override
    public String getInfoOtherPlayer() {
        return getInfo() + "Pay $" + getAmount() + " to the lawyer for legal fees.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amounts the player will pay depending on the scenario.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Blue card)</li>
     *     <li>Name of the card (Lawsuit (Blue Card))</li>
     *     <li>Career match of the card (Lawyer)</li>
     *     <li>The header "Received if Career Match" (which is a general
     *     description of the blue cards)</li>
     *     <li>The amount 15000 (which is the same for all blue cards)</li>
     *     <li>The header "Paid to Other Player (or Bank)" (which is a general
     *     description of the blue cards)</li>
     *     <li>The amount to be paid by the player</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() +
                "Paid to Other Player (or Bank): " + getAmount() + "\n";
    }
}
