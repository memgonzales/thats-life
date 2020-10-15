package cards.blue_cards;

import cards.BlueCard;
import core.Bank;
import core.NumberWheel;
import core.PlayerRandom;
import core.Player;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing a <b>Computer Repair</b> blue card, which asks the player
 * to pay either 5000 or 10000, depending on the number generated from spinning
 * the number wheel, to either the bank or the player with the Computer Consultant
 * career
 *
 * <p>The player pays 10000 if the generated number is odd, and 5000 if the
 * number is even.</p>
 */
public class ComputerRepair extends BlueCard implements PlayerRandom {
    /**
     * Amount to be paid if the wheel spin returns an even number
     */
    public static final int EVEN_NUM_PAY = 5000;
    /**
     * Amount to be paid if the wheel spin returns an odd number
     */
    public static final int ODD_NUM_PAY = 10000;

    /**
     * Creates a Computer Repair blue card object
     *
     * <p>In particular, a Computer Repair blue card is initialized with the
     * name "Computer Repair" and the career match "Computer Consultant".</p>
     */
    public ComputerRepair() {
        /* Invoke the constructor of the parent class, passing the strings "Computer Repair"
        and "Computer Consultant"
        */
        super("Computer Repair", "Computer Consultant");
    }

    /**
     * Executes the action specified in this card.
     *
     * <p> In particular, the player spins the wheel and executes one of the following
     * three actions: </p>
     *
     * <ul>
     *     <li> If the player matches the career match of the card, they receive 15000
     *     from the bank</li>
     *     <li> If no player matches the career match of the card, the player will pay
     *     either 5000 or 10000 (depending on the result of the wheel spin) to the bank</li>
     *     <li>If a different player matches the career match of the card, the player
     *     will pay either 5000 or 10000 (depending on the result of the wheel spin)
     *     to the other player</li>
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
            either 5000 or 10000 (depending on the result of the wheel spin) to the bank
            */

            /* The bitwise AND operator is used to optimize the identification of the parity
            of the random number (that is, whether it is odd or even).

            If the number is odd, then the rightmost digit of its binary equivalent is 1.
            Therefore, its bitwise AND with respect to 1 is also 1.
             */
            if ((randNum & 1) == 1)
                currPlayer.payCashToBank(b, ODD_NUM_PAY);
            else
                currPlayer.payCashToBank(b, EVEN_NUM_PAY);
            return NO_MATCH;

        } else {
            /* If a different player matches the career match of the card, the player
            will pay either 5000 or 10000 (depending on the result of the wheel spin)
            to the other player
            */

            /* The bitwise AND operator is used to optimize the identification of the parity
            of the random number (that is, whether it is odd or even).

            If the number is odd, then the rightmost digit of its binary equivalent is 1.
            Therefore, its bitwise AND with respect to 1 is also 1.
             */
            if ((randNum & 1) == 1)
                currPlayer.payCashToPlayer(playerWithCareer, b, ODD_NUM_PAY);
            else
                currPlayer.payCashToPlayer(playerWithCareer, b, EVEN_NUM_PAY);

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
     * <p>In particular, the card description reads as follows: "You drew a computer
     * repair card."</p>
     *
     * @return base card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You drew a computer repair card.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     *
     * <p>In particular, the card description reads as follows: "You drew a computer
     * repair card. Spin the wheel to determine the repair cost to be paid to the bank.
     * Pay [EVEN_NUM_PAY] for an even number spun and [ODD_NUM_PAY] for an odd number spun."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     */
    @Override
    public String getInfoBank() {
        return getInfo() + "Spin the wheel to determine the repair cost to be paid to the bank." +
                " Pay $" + EVEN_NUM_PAY + " for an even number spun and $" + ODD_NUM_PAY + " for an odd number spun.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     *
     * <p>In particular, the card description reads as follows: "You drew a computer
     * repair card. Receive 15000 as a computer consultant."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     */
    @Override
    public String getInfoMatch() {
        return getInfo() + "Receive $15000 as a computer consultant.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     *
     * <p>In particular, the card description reads as follows: "You drew a computer
     * repair card. Spin the wheel to determine the repair cost to be paid to the
     * computer consultant. Pay [EVEN_NUM_PAY] for an even number spun and [ODD_NUM_PAY]
     * for an odd number spun."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     */
    @Override
    public String getInfoOtherPlayer() {
        return getInfo() + "Spin the wheel to determine the repair cost to be paid to the computer consultant." +
                " Pay $" + EVEN_NUM_PAY + " for an even number spun and $" + ODD_NUM_PAY + " for an odd number spun.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amounts the player will pay depending on the scenario.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Blue card)</li>
     *     <li>Name of the card (Computer Repair)</li>
     *     <li>Career match of the card (Computer Consultant)</li>
     *     <li>The header "Received if Career Match" (which is a general
     *     description of the blue cards)</li>
     *     <li>The amount 15000 (which is the same for all blue cards)</li>
     *     <li>The header "Paid to Other Player (or Bank)" (which is a general
     *     description of the blue cards)</li>
     *     <li>The possible repair costs (either 5000 or 10000) and the respective
     *     scenarios for which they are determined</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() +
                "Paid to Other Player (or Bank): " + ODD_NUM_PAY + " (if odd) "
                + EVEN_NUM_PAY + " (if even) " + "\n";
    }
}
