package cards.blue_cards;

import cards.BlueCard;
import core.Bank;
import core.Player;

/**
 * Class implementing a <b>World Cup</b> blue card, which asks the player
 * to pay either 5000 for each player in the game to either the bank or
 * the player with the Athlete career
 *
 * <p>The player pays 10000 if there are two players in the game, and 15000
 * if there are three players in the game.</p>
 */
public class WorldCup extends BlueCard {
    /**
     * Multiplier for determining the amount to be paid
     */
    public static int MULTIPLIER = 5000;

    /**
     * Creates a World Cup blue card object
     *
     * <p>In particular, a World Cup blue card is initialized with the
     * name "World Cup" and the career match "Athlete".</p>
     */
    public WorldCup() {
        /* Invoke the constructor of the parent class, passing the strings "World Cup"
        and "Athlete"
        */
        super("World Cup", "Athlete");
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
     *     5000 multiplied by the number of players in the game to the bank</li>
     *     <li>If a different player matches the career match of the card, the player
     *     will pay 5000 multiplied by the number of players in the game to the other player</li>
     *</ul>
     *
     * @param currPlayer current player with turn
     * @param playerWithCareer player whose career matches the career specified in the card
     * @param b Bank of the game
     * @param numPlayers number of players in the game
     * @return flag indicative of the executed scenario
     */
    public int execute(Player currPlayer, Player playerWithCareer, Bank b, int numPlayers) {
        if (currPlayer.getCareer().equalsIgnoreCase(getCareerMatch())) {
            /* If the player matches the career match of the card, they receive 15000
            from the bank
            */
            executeMatchedCareer(currPlayer, b);
            return MATCHED_CAREER;

        } else if (playerWithCareer == null) {
            /* If no player matches the career match of the card, the player will pay
            5000 multiplied by the number of players in the game to the bank
            */
            currPlayer.payCashToBank(b, numPlayers * MULTIPLIER);
            return NO_MATCH;

        } else {
            /* If a different player matches the career match of the card, the player
            5000 multiplied by the number of players in the game to the other player
            */
            currPlayer.payCashToPlayer(playerWithCareer, b, numPlayers * MULTIPLIER);
            return OTHER_MATCH;
        }
    }

    /**
     * Returns the base card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You drew a world cup card."</p>
     *
     * @return base card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You drew a world cup card.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     *
     * <p>In particular, the card description reads as follows: "You drew a world cup card.
     * Pay 5000 for each player to the bank for training costs."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     */
    @Override
    public String getInfoBank() {
        return getInfo() + "Pay $5000 for each player to the bank for training costs.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     *
     * <p>In particular, the card description reads as follows: "You drew a world cup card.
     * Receive 15000 as an athlete."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     */
    @Override
    public String getInfoMatch() {
        return getInfo() + "Receive $15000 as an athlete.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     *
     * <p>In particular, the card description reads as follows: "You drew a world cup card.
     * Pay 5000 for each player to the athlete for training costs."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     */
    @Override
    public String getInfoOtherPlayer() {
        return getInfo() + "Pay $5000 for each player to the athlete for training costs.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amounts the player will pay depending on the scenario.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Blue card)</li>
     *     <li>Name of the card (World Cup)</li>
     *     <li>Career match of the card (Athlete)</li>
     *     <li>The header "Received if Career Match" (which is a general
     *     description of the blue cards)</li>
     *     <li>The amount 15000 (which is the same for all blue cards)</li>
     *     <li>The header "Paid to Other Player (or Bank)" (which is a general
     *     description of the blue cards)</li>
     *     <li>The string "Number of players * [MULTIPLIER]"</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() +
                "Paid to Other Player (or Bank): Number of players * " + MULTIPLIER + "\n";
    }
}
