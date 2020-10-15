package cards.blue_cards;

import cards.BlueCard;
import core.Bank;
import core.Player;

/**
 * Class implementing a <b>Ski Accident</b> blue card, which asks the player
 * to pay 10000 to either the bank or the player with the Doctor career
 *
 * <p>The player pays a fixed amount of 10000.</p>
 */
public class SkiAccident extends BlueCard {
    /**
     * Amount to be paid by the player
     */
    public static final int AMOUNT_PAY = 10000;

    /**
     * Creates a Ski Accident blue card object
     *
     * <p>In particular, a Ski Accident blue card is initialized with the
     * name "Ski Accident" and the career match "Doctor".</p>
     */
    public SkiAccident() {
        /* Invoke the constructor of the parent class, passing the strings "Ski Accident"
        and "Doctor"
        */
        super("Ski Accident", "Doctor");
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
     *     10000 to the bank</li>
     *     <li>If a different player matches the career match of the card, the player
     *     will pay 10000 to the other player</li>
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
           10000 to the bank
           */
            currPlayer.payCashToBank(b, AMOUNT_PAY);
            return NO_MATCH;
        } else {
            /* If a different player matches the career match of the card, the player
            will pay 10000 to the other player
            */
            currPlayer.payCashToPlayer(playerWithCareer, b, AMOUNT_PAY);
            return OTHER_MATCH;
        }
    }

    /**
     * Returns the base card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You drew a ski accident card."</p>
     *
     * @return base card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You drew a ski accident card.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     *
     * <p>In particular, the card description reads as follows: "You drew a ski accident card.
     * Pay 10000 to the bank for treatment fees."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     */
    @Override
    public String getInfoBank() {
        return getInfo() + "Pay $10000 to the bank for treatment fees.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     *
     * <p>In particular, the card description reads as follows: "You drew a ski accident card.
     * Receive 15000 as a doctor."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     */
    @Override
    public String getInfoMatch() {
        return getInfo() + "Receive $15000 as a doctor.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     *
     * <p>In particular, the card description reads as follows: "You drew a ski accident card.
     * Pay 10000 to the doctor for treatment fees."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     */
    @Override
    public String getInfoOtherPlayer() {
        return getInfo() + "Pay $10000 to the doctor for treatment fees.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amounts the player will pay depending on the scenario.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Blue card)</li>
     *     <li>Name of the card (Ski Accident)</li>
     *     <li>Career match of the card (Doctor)</li>
     *     <li>The header "Received if Career Match" (which is a general
     *     description of the blue cards)</li>
     *     <li>The amount 15000 (which is the same for all blue cards)</li>
     *     <li>The header "Paid to Other Player (or Bank)" (which is a general
     *     description of the blue cards)</li>
     *     <li>The constant 10000 (the value of the static final variable AMOUNT_PAY)</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() +
                "Paid to Other Player (or Bank): " + AMOUNT_PAY + "\n";
    }
}
