package spaces.magenta_spaces;

import core.Bank;
import core.NumberWheel;
import core.Player;
import core.PlayerRandom;
import spaces.MagentaSpace;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing a <b>get married space</b>.
 *
 * <p>Players on a get married space are married and receive cash gifts depending
 * on the result of their number wheel spin.</p>
 */
public class GetMarried extends MagentaSpace implements PlayerRandom {
    /* As stated in the machine problem specifications, the gift amount for an odd
    number from the number wheel spin is $5000
    */
    public static final int ODD_GIFT_AMOUNT = 5000;
    /* As stated in the machine problem specifications, the gift amount for an even
    number from the number wheel spin is $10000
    */
    public static final int EVEN_GIFT_AMOUNT = 10000;

    /**
     * Creates a get married object
     *
     * <p>In particular, a get married space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is assigned as "Get Married".</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next index is assigned the passed parameter nextIndex.</li>
     * </ul>
     *
     * @param index the index of the space on the board
     * @param nextIndex the index of the next space the player can move to from
     * this space
     */
    public GetMarried(int index, int nextIndex) {
        /* Invoke the constructor of the parent class, passing the string "Get Married"
        and the appropriate index values. The same index is used for both next index values
        of the space, as there is only one other space a player can move to from a
        get married space.
        */
        super("Get Married", index, nextIndex, nextIndex);
    }

    /**
     * Executes the action associated with this space; that is, the player
     * is married and receives wedding gifts according to the generated number from
     * the number wheel spin
     *
     * <p>On a get married space, the player receives $5000 from every other player if
     * the generated number is odd, and $10000 from every other player if the generated
     * number is even.</p>
     *
     * @param currPlayer current player with turn
     * @param randNum randomly generated result of the number wheel spin
     * @param players list of players in the game
     * @param b Bank object of the game
     */
    public void execute(Player currPlayer, int randNum, ArrayList<Player> players, Bank b) {
        /* If the player is not yet married, their marital status is changed and they
        receive gifts according to the scheme detailed above. Otherwise, the space will
        have no effect on the player.
        */
        if (!currPlayer.getIsMarried()) {
            currPlayer.marry();

            /* The bitwise AND operator is used to optimize the identification of the parity
            of the random number (that is, whether it is odd or even).

            If the number is odd, then the rightmost digit of its binary equivalent is 1.
            Therefore, its bitwise AND with respect to 1 is also 1.
             */
            if ((randNum & 1) == 1)
                for (int i = 0; i < players.size(); i++)
                    players.get(i).payCashToPlayer(currPlayer, b, ODD_GIFT_AMOUNT);
            else
                for (int i = 0; i < players.size(); i++)
                    players.get(i).payCashToPlayer(currPlayer, b, EVEN_GIFT_AMOUNT);
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
     * Returns the string to be used as a prompt in the actual gameplay when the player
     * is on a get married space
     *
     * <p>In particular, if the player is not yet married, the returned string reads
     * as follows: "[Player name], you are on a Get Married space. Spin the wheel to
     * determine the amount of your wedding gifts." </p>
     *
     * <p>If the player is already married, the returned string reads as follows:
     * "[Player name] is already married."</p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a get married space
     */
    @Override
    public String getInfo(Player currPlayer) {
        if (!currPlayer.getIsMarried())
            return currPlayer.getName() + ", you are on a Get Married space.\n" +
                    "Spin the wheel and collect $" + ODD_GIFT_AMOUNT + " from each player " +
                    "for an odd number spun and $" +
                    EVEN_GIFT_AMOUNT + " from each player for an even number.\n" +
                    "You are entitled to ANOTHER TURN right after this.\n";
        else
            return currPlayer.getName() + " is already married.\n" +
                    "You are entitled to ANOTHER TURN right after this.\n";
    }

    public String getInfoDisplay(Player currPlayer) {
        if (!currPlayer.getIsMarried())
            return currPlayer.getName() + ", you are on a Get Married space.<br/><br/>" +
                    "Spin the wheel and collect $" + ODD_GIFT_AMOUNT + " from each player " +
                    "for an odd number spun and $" +
                    EVEN_GIFT_AMOUNT + " from each player for an even number.<br/><br/>" +
                    "You are entitled to ANOTHER TURN right after this.\n";
        else
            return currPlayer.getName() + " is already married.\n" +
                    "You are entitled to ANOTHER TURN right after this.\n";
    }
}
