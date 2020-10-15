package cards.blue_cards;

import cards.BlueCard;
import core.Bank;
import core.Player;

/**
 * Class implementing an <b>F1Race</b> blue card, which asks the player
 * to pay 10% of their current salary to either the bank or the player
 * with the Racecar Driver career
 *
 * <p>The player pays 10% of their current salary.</p>
 */
public class F1Race extends BlueCard {
    /**
     * Multiplier used to compute for the amount to be paid (0.1 or 10%)
     */
    public static final double PERCENT_MULTIPLIER = 0.1;

    /**
     * Creates an F1 Race blue card object
     *
     * <p>In particular, an F1 Race blue card is initialized with the
     * name "F1 Race" and the career match "Racecar Driver".</p>
     */
    public F1Race() {
        /* Invoke the constructor of the parent class, passing the strings "F1 Race"
        and "Racecar Driver"
        */
        super("F1 Race", "Racecar Driver");
    }

    /**
     * Executes the action specified in this card.
     *
     * <p> In particular, the player executes one of the following
     * three actions: </p>
     *
     * <ul>
     *     <li> If the player matches the career match of the card, they receive 15000
     *     from the bank</li>
     *     <li> If no player matches the career match of the card, the player will pay
     *     10% of their current salary to the bank</li>
     *     <li>If a different player matches the career match of the card, the player
     *     will pay 10% of their current salary to the other player</li>
     *</ul>
     *
     * @param currPlayer current player with turn
     * @param playerWithCareer player whose career matches the career specified in the card
     * @param b Bank of the game
     * @return flag indicative of the executed scenario
     */
    public int execute(Player currPlayer, Player playerWithCareer, Bank b) {
        if (currPlayer.getSalaryCard() != null) {

            if (currPlayer.getCareer().equalsIgnoreCase(getCareerMatch())) {
                /* If the player matches the career match of the card, they receive 15000
                from the bank
                */
                executeMatchedCareer(currPlayer, b);
                return MATCHED_CAREER;

            } else if (playerWithCareer == null) {
                /* If no player matches the career match of the card, the player will pay
                10% of their current salary to the bank
                */
                currPlayer.payCashToBank(b, (int) (currPlayer.getSalary() * PERCENT_MULTIPLIER));
                return NO_MATCH;
            } else {
                /* If a different player matches the career match of the card, the player
                will pay 10% of their current salary to the other player
                */
                currPlayer.payCashToPlayer(playerWithCareer, b, (int) (currPlayer.getSalary() * PERCENT_MULTIPLIER));
                return OTHER_MATCH;
            }
        }
        return NO_MATCH;
    }

    /**
     * Returns the base card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You drew an F1 race card."</p>
     *
     * @return base card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You drew an F1 race card.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     *
     * <p>In particular, the card description reads as follows: "You drew an F1 race card.
     * Pay 10% of your salary to the bank as a donation fee."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     */
    @Override
    public String getInfoBank() {
        return getInfo() + "Pay 10% of your salary to the bank as a donation fee.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     *
     * <p>In particular, the card description reads as follows: "You drew an F1 race card.
     * Receive 15000 as a racecar driver."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     */
    @Override
    public String getInfoMatch() {
        return getInfo() + "Receive $15000 as a racecar driver.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     *
     * <p>In particular, the card description reads as follows: "You drew an F1 race card.
     * Pay 10% of your salary to the racecar driver as a donation fee."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     */
    @Override
    public String getInfoOtherPlayer() {
        return getInfo() + "Pay 10% of your salary to the racecar driver as a donation fee.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amounts the player will pay.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Blue card)</li>
     *     <li>Name of the card (F1 Race)</li>
     *     <li>Career match of the card (Racecar Driver)</li>
     *     <li>The header "Received if Career Match" (which is a general
     *     description of the blue cards)</li>
     *     <li>The amount 15000 (which is the same for all blue cards)</li>
     *     <li>The header "Paid to Other Player (or Bank)" (which is a general
     *     description of the blue cards)</li>
     *     <li>The string "10% of salary"</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() +
                "Paid to Other Player (or Bank): " + (int) (PERCENT_MULTIPLIER * 100) + "% of salary \n";
    }
}
