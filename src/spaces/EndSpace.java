package spaces;

import core.Bank;
import core.Board;
import core.Player;
import decks.CareerCardDeck;
import decks.HouseCardDeck;
import decks.SalaryCardDeck;

/**
 * Class implementing an <b>end space</b>.
 *
 * <p>Players on the end space retire, and, if all players have reached the end
 * space, the game ends.</p>
 */
public class EndSpace extends ColoredSpace {
    /**
     * Creates an end space object
     *
     * <p>In particular, an end space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its color is assigned as "Special (End)".</li>
     *     <li>Its index on the board is the last index on the board.</li>
     *     <li>Its next indices are both -1 (a sentinel value to indicate)
     *     that this is the last space on the board.</li>
     * </ul>
     */
    public EndSpace() {
        /* Invoke the constructor of the parent class, passing the string "Special (End)"
        and the appropriate index values.
        */
        super("Special (End)", Board.NUM_SPACES - 1, -1, -1);
    }

    /**
     * Executes the action associated with this space; that is, the player is retired
     *
     * <p>After reaching the end space, the stats of the player are no longer affected
     * by the actions of the remaining players who are still active.</p>
     *
     * @param currPlayer current player with turn
     * @param b Bank of the game
     * @param orderRetirement order in which the player retired (e.g., first to retire,
     * second to retire, etc.)
     * @param careerDeck CareerCardDeck of the game
     * @param salaryDeck SalaryCardDeck of the game
     * @param houseDeck HouseCardDeck of the game
     */
    public void execute(Player currPlayer, Bank b, int orderRetirement, CareerCardDeck careerDeck, SalaryCardDeck salaryDeck, HouseCardDeck houseDeck) {
        /* The current player is retired. They receive the retirement pay corresponding to
        their retirement order, return their assets to their respective decks, and settle
        their loans with the bank.
        */
        currPlayer.retire(b, orderRetirement, careerDeck, salaryDeck, houseDeck);
    }

    /**
     * Returns the string to be used as a prompt in the actual gameplay when the player
     * on the end space
     *
     * <p>In particular, the returned string reads as follows: "[Player name], you are
     * on the end space. Congratulations! You are now retired." </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on the end space
     */
    @Override
    public String getInfo(Player currPlayer) {
        return currPlayer.getName() + ", you are on the end space.\n" +
                "Congratulations! You are now retired.\n";
    }
}
