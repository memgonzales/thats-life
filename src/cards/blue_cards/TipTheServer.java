package cards.blue_cards;

import cards.BlueCard;
import core.Bank;
import core.NumberWheel;
import core.PlayerRandom;
import core.Player;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing a <b>Tip The Server</b> blue card, which asks the player
 * to pay an amount dependent on the number generated from spinning the number wheel
 * to either the bank or the player with the Server career
 *
 * <p>The player pays an amount between 1000 and 10000 inclusive (equivalent to
 * the number returned by the wheel spin multiplied by 1000).</p>
 */
public class TipTheServer extends BlueCard implements PlayerRandom {
    /**
     * Multiplier for getting the final amount to be paid
     */
    public static final int MULTIPLIER = 1000;

    /**
     * Creates a Tip The Server blue card object
     *
     * <p>In particular, a Tip The Server blue card is initialized with the
     * name "Tip The Server" and the career match "Server".</p>
     */
    public TipTheServer() {
        /* Invoke the constructor of the parent class, passing the strings "Tip the Server"
        and "Server"
        */
        super("Tip the Server", "Server");
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
     *     the result of the wheel spin multiplied by 1000 to the bank</li>
     *     <li>If a different player matches the career match of the card, the player
     *     will pay the result of the wheel spin multiplied by 1000 to the other player</li>
     *</ul>
     *
     * @param currPlayer current player with turn
     * @param playerWithCareer player whose career matches the career specified in the card
     * @param b Bank of the game
     * @param randNum random number generated from the wheel spin
     * @return flag indicative of the executed scenario
     */
    public int execute(Player currPlayer, Player playerWithCareer, Bank b, int randNum) {
        if (currPlayer.getCareer().equalsIgnoreCase(getCareerMatch())) {
            /* If the player matches the career match of the card, they receive 15000
            from the bank
            */
            executeMatchedCareer(currPlayer, b);
            return MATCHED_CAREER;

        } else if (playerWithCareer == null) {
            /* If no player matches the career match of the card, the player will pay
            the result of the wheel spin multiplied by 1000 to the bank
            */
            currPlayer.payCashToBank(b, randNum * MULTIPLIER);
            return NO_MATCH;

        } else {
            /* If a different player matches the career match of the card, the player
            will pay the result of the wheel spin multiplied by 1000 to the other player
            */
            currPlayer.payCashToPlayer(playerWithCareer, b, randNum * MULTIPLIER);
            return OTHER_MATCH;
        }
    }

    /**
     * Returns the number generated from the number wheel spin
     *
     * <p>Specifically, the method returns an integer between 1 and 10 inclusive (mirroring the
     * range of the number wheel) upon being prompted by the player. </p>
     *
     * @param w NumberWheel of the game
     * @param currPlayer current player with turn
     * @return random number generated as a result of the number wheel spin
     */
    @Override
    public int spinWheel(NumberWheel w, Player currPlayer) {
        return ThreadLocalRandom.current().nextInt(1, NumberWheel.NUM_NUMBERS + 1);
    }

    /**
     * Returns the base card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You drew a tip the server card."</p>
     *
     * @return base card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You drew a tip the server card.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     *
     * <p>In particular, the card description reads as follows: "You drew a tip the server card.
     * Spin the wheel to determine the tip to be paid to the bank. Pay [MULTIPLIER] multiplied by
     * the result of the wheel spin."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     */
    @Override
    public String getInfoBank() {
        return getInfo() + "Spin the wheel to determine the tip to be paid to the bank." +
                "Pay $" + MULTIPLIER + " multiplied by the result of the wheel spin.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     *
     * <p>In particular, the card description reads as follows: "You drew a tip the server card.
     * Receive 15000 as a computer server."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     */
    @Override
    public String getInfoMatch() {
        return getInfo() + "Receive $15000 as a server.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     *
     * <p>In particular, the card description reads as follows: "You drew a tip the server card.
     * Spin the wheel to determine the tip to be paid to the server. Pay [MULTIPLIER] multiplied
     * by the result of the wheel spin."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     */
    @Override
    public String getInfoOtherPlayer() {
        return getInfo() + "Spin the wheel to determine the tip to be paid to the server." +
                "Pay $" + MULTIPLIER + " multiplied by the result of the wheel spin.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amounts the player will pay depending on the scenario.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Blue card)</li>
     *     <li>Name of the card (Tip The Server)</li>
     *     <li>Career match of the card (Server)</li>
     *     <li>The header "Received if Career Match" (which is a general
     *     description of the blue cards)</li>
     *     <li>The amount 15000 (which is the same for all blue cards)</li>
     *     <li>The header "Paid to Other Player (or Bank)" (which is a general
     *     description of the blue cards)</li>
     *     <li>The string "Randomly spun number * [MULTIPLIER]"</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() +
                "Paid to Other Player (or Bank): Randomly spun number * " + MULTIPLIER + "\n";
    }
}
