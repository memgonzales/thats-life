package cards;

import core.Bank;
import core.Player;

/**
 * Abstract class providing a skeletal implementation of <b>blue card</b>, which asks
 * the player to either collect money from the Bank or pay money to another player
 * or the Bank depending on whether the career specified in the card matches that
 * of the player or of the other players.
 *
 * <p>A blue card is picked whenever the player ends up on a blue space. </p>
 */
public abstract class BlueCard extends Card {
    /* Career specified in this card */
    private String careerMatch;

    /**
     * Amount collected by the player from the Bank if his/her career matches
     * the career specified in this card, indicated in the machine project
     * specifications as $15000
     */
    public static final int AMOUNT_GAIN = 15000;
    /**
     * Flag value indicating that the career match of the blue card matches
     * the player's career
     */
    public static final int MATCHED_CAREER = 1;
    /**
     * Flag value indicating that the career match of the blue card does not
     * match the career of any of the active players
     */
    public static final int NO_MATCH = 2;
    /**
     * Flag value indicating that the career match of the blue card matches
     * another player's career
     */
    public static final int OTHER_MATCH = 3;

    /**
     * Constructor with the specified name of this card and career as parameters
     *
     * <p>The name of a blue card is indicative of the action or event it specifies
     * (for example, Ski Accident, Tip the Server, etc.).</p>
     *
     * @param name name of this card
     * @param careerMatch career specified in this card
     */
    public BlueCard(String name, String careerMatch) {
        super(name);
        this.careerMatch = careerMatch;
    }

    /**
     * Returns the career specified in this card
     *
     * @return career specified in this card
     */
    public String getCareerMatch() {
        return careerMatch;
    }

    /**
     * Returns <code>true</code> if the given career is the same as the career specified
     * in this card; <code>false</code>, otherwise
     *
     * <p>More formally, it performs a case-insensitive string matching to determine
     * if given career is the same as the career specified in the card. </p>
     *
     * @param career career which will be checked if it matches the career specified
     *               in this card
     * @return <code>true</code> if the given career matches the career specified
     * in this card; <code>false</code>, otherwise
     */
    public boolean isMatchedCareer(String career) {
        return careerMatch.equalsIgnoreCase(career);
    }

    /**
     * Executes the effect of the blue card when the current player's career matches the
     * specified career match of the card
     *
     * <p>Specifically, if the player's career matches the specified career on the card,
     * they will collect 15000 from the Bank. </p>
     *
     * @param currPlayer current player with turn
     * @param b Bank of the game
     */
    public void executeMatchedCareer(Player currPlayer, Bank b) {
        currPlayer.collectCashFromBank(b, AMOUNT_GAIN);
    }

    /**
     * Abstract method for returning the string to be used as a prompt in the actual gameplay
     * when the player pays money to the bank
     *
     * <p>As the prompts vary depending on the card, its details are implemented in
     * the seven subclasses of the BlueCard class. </p>
     *
     * @return string to be used as a prompt in the actual gameplay when the player pays
     * money to the bank
     */
    public abstract String getInfoBank();

    /**
     * Abstract method for returning the string to be used as a prompt in the actual gameplay
     * when the player's career matches the career specified in the card (i.e., they will
     * collect money from the bank)
     *
     * <p>As the prompts vary depending on the card, its details are implemented in
     * the seven subclasses of the BlueCard class. </p>
     *
     * @return string to be used as a prompt in the actual gameplay when the player's career
     * matches the career specified in the card
     */
    public abstract String getInfoMatch();

    /**
     * Abstract method for returning the string to be used as a prompt in the actual gameplay
     * when the player pays money to another player
     *
     * <p>As the prompts vary depending on the card, its details are implemented in
     * the seven subclasses of the BlueCard class. </p>
     *
     * @return string to be used as a prompt in the actual gameplay when the player pays
     * money to another player
     */
    public abstract String getInfoOtherPlayer();

    /**
     * Returns a string representation of this card, which includes its name and specified career
     *
     * <p>In particular, the representation contains the following details: </p>
     *
     * <ul>
     *     <li>Type of card (Blue Card)</li>
     *     <li>Specified career</li>
     *     <li>Name of the card (for example, Tip the Server, Ski Accident, etc.)</li>
     * </ul>
     *
     * @return string representation of this card, which includes its name and specified career
     */
    @Override
    public String toString() {
        return "BLUE CARD\n" +
                "Career Match: " + careerMatch + "\n" +
                "Name: " + getName() + "\n" +
                "Received if Career Match: " + AMOUNT_GAIN + "\n";
    }
}
