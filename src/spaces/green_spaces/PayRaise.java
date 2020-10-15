package spaces.green_spaces;

import core.Bank;
import core.Player;
import spaces.GreenSpace;

/**
 * Class implementing a <b>pay raise space</b>.
 *
 * <p>Players on a pay raise space receive a pay raise from the bank.</p>
 */
public class PayRaise extends GreenSpace {
    /**
     * Creates a pay raise space object
     *
     * <p>In particular, a pay raise space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is assigned as "Pay Raise".</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next index is assigned the passed parameter nextIndex.</li>
     * </ul>
     *
     * @param index the index of the space on the board
     * @param nextIndex the index of the next space the player can move to from
     * this space
     */
    public PayRaise(int index, int nextIndex) {
        /* Invoke the constructor of the parent class, passing the string "Pay Raise"
        and the appropriate index values.
        */
        super("Pay Raise", index, nextIndex);
    }

    /**
     * Executes the action associated with this space; that is, the player receives
     * a pay raise from the bank
     *
     * <p>On a pay raise space, the player has their current salary increased
     * in accordance with the details on their drawn salary card.</p>
     *
     * @param currPlayer current player with turn
     * @param b Bank object of the game
     */
    @Override
    public void execute(Player currPlayer, Bank b) {
        /* The player receives a pay raise and collects cash equivalent to their
        new salary
        */
        currPlayer.receivePayRaise();
        currPlayer.receiveCash(currPlayer.getSalary());
    }

    /**
     * Returns the string to be used as a prompt in the actual gameplay when the player
     * is on a pay raise space
     *
     * <p>In particular, the returned string reads as follows: "[Player name], you are
     * on a Pay Raise space. Receive a pay raise and your new salary from the bank." </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a pay raise space
     */
    @Override
    public String getInfo(Player currPlayer) {
        return currPlayer.getName() + ", you are on a Pay Raise space.\n" +
                "Receive a pay raise and your new salary from the bank.\n" +
                "New salary values have been updated in the player details.\n";
    }
}
