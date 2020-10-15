package spaces.green_spaces;

import core.Bank;
import core.Player;
import spaces.GreenSpace;

/**
 * Class implementing a <b>pay day space</b>.
 *
 * <p>Players on a pay day space receive their current salary from the bank.</p>
 */
public class PayDay extends GreenSpace {
    /**
     * Creates a pay day space object
     *
     * <p>In particular, a pay day space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is assigned as "Pay Day".</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next index is assigned the passed parameter nextIndex.</li>
     * </ul>
     *
     * @param index the index of the space on the board
     * @param nextIndex the index of the next space the player can move to from
     * this space
     */
    public PayDay(int index, int nextIndex) {
        /* Invoke the constructor of the parent class, passing the string "Pay Day"
        and the appropriate index values.
        */
        super("Pay Day", index, nextIndex);
    }

    /**
     * Executes the action associated with this space; that is, the player receives
     * their current salary the bank
     *
     * <p>On a pay day space, the player receives cash equivalent to their current
     * salary from the bank.</p>
     *
     * @param currPlayer current player with turn
     * @param b Bank object of the game
     */
    @Override
    public void execute(Player currPlayer, Bank b) {

        currPlayer.receiveCash(currPlayer.getSalary());
    }

    /**
     * Returns the string to be used as a prompt in the actual gameplay when the player
     * is on a pay day space
     *
     * <p>In particular, the returned string reads as follows: "[Player name], you are
     * on a Pay Day space. Receive your current salary from the bank." </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a pay day space
     */
    @Override
    public String getInfo(Player currPlayer) {
        return currPlayer.getName() + ", you are on a Pay Day space.\n" +
                "Receive your current salary from the bank.\n";
    }
}
