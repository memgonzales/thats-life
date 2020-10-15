package spaces.magenta_spaces;

import core.Player;
import spaces.MagentaSpace;

/**
 * Class implementing a <b>graduation space</b>.
 *
 * <p>Players on a graduation space earn a college degree and are subsequently allowed to
 * choose careers that require a degree.</p>
 */
public class GraduationSpace extends MagentaSpace {
    /**
     * Creates a graduation space object
     *
     * <p>In particular, a graduation space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is assigned as "Graduation Space".</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next index is assigned the passed parameter nextIndex.</li>
     * </ul>
     *
     * @param index the index of the space on the board
     * @param nextIndex the index of the next space the player can move to from
     * this space
     */
    public GraduationSpace(int index, int nextIndex) {
        /* Invoke the constructor of the parent class, passing the string "Graduation Space"
        and the appropriate index values. The same index is used for both next index values
        of the space, as there is only one other space a player can move to from a
        graduation space.
        */
        super("Graduation Space", index, nextIndex, nextIndex);
    }

    /**
     * Executes the action associated with this space; that is, the player graduates.
     *
     * @param currPlayer current player with turn
     */
    public void execute(Player currPlayer) {
        currPlayer.graduate();
    }

    /**
     * Returns the string to be used as a prompt in the actual gameplay when the player
     * is on a graduation space
     *
     * <p>In particular, the returned string reads as follows: "[Player name], you are
     * on a Graduation space. You now have a college degree." </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a graduation space
     */
    @Override
    public String getInfo(Player currPlayer) {
        return currPlayer.getName() + ", you are on a Graduation space.\n" +
                "You now have a college degree.\n" +
                "You are entitled to ANOTHER TURN right after this.\n";
    }
}
