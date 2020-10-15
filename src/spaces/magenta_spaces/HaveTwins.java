package spaces.magenta_spaces;

import core.Bank;
import core.Player;
import spaces.MagentaSpace;

import java.util.ArrayList;

/**
 * Class implementing a <b>have twins space</b>.
 *
 * <p>Players on a have twins space have two babies and receive gifts from every other
 * player if they are married.</p>
 */
public class HaveTwins extends MagentaSpace {
    /* Following the machine problem specifications, the player receives $5000 from every
    other player for every child they have.
    */
    public static final int GIFT_AMOUNT = 5000;

    /**
     * Creates a have twins space object
     *
     * <p>In particular, a have twins space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is assigned as "Have Twins".</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next index is assigned the passed parameter nextIndex.</li>
     * </ul>
     *
     * @param index the index of the space on the board
     * @param nextIndex the index of the next space the player can move to from
     * this space
     */
    public HaveTwins(int index, int nextIndex) {
        /* Invoke the constructor of the parent class, passing the string "Have Twins"
        and the appropriate index values. The same index is used for both next index values
        of the space, as there is only one other space a player can move to from a
        have baby space.
        */
        super("Have Twins", index, nextIndex, nextIndex);
    }

    /**
     * Execute the action associated with this space; that is, the player
     * has twins and receives cash gifts from every other player
     *
     * <p>On a have twins space, the player receives $10000 from every other player
     * as a gift if they are married.</p>
     *
     * @param currPlayer current player with turn
     * @param players list of players in the game
     * @param b Bank object of the game
     */
    public void execute(Player currPlayer, ArrayList<Player> players, Bank b) {
        if (currPlayer.getIsMarried()) {
           /* If the player is married, they have twins and receive $10000 ($5000
           multiplied by the number of babies) from every other player
           */
            currPlayer.haveTwins();

            for (int i = 0; i < players.size(); i++)
                players.get(i).payCashToPlayer(currPlayer, b, GIFT_AMOUNT * 2);
        }
    }

    /**
     * Returns the string to be used as a prompt in the actual gameplay when the player
     * is on a have twins space
     *
     * <p>In particular, if the player is married, the returned string reads as follows:
     * "[Player name], you are on a Have Baby space. Receive [gift amount * 2] from
     * every other player as a gift." </p>
     *
     * <p>If the player is not married, the returned string reads as follows:
     * "[Player name] is not married."</p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a have twins space
     */
    @Override
    public String getInfo(Player currPlayer) {
        if (currPlayer.getIsMarried())
            return currPlayer.getName() + ", you are on a Have Twins space.\n" +
                    "Receive $" + (GIFT_AMOUNT * 2) + " from each player as a gift.\n" +
                    "You are entitled to ANOTHER TURN right after this.\n";
        else
            return currPlayer.getName() + " is not married.\n" +
                    "You are entitled to ANOTHER TURN right after this.\n";
    }
}
