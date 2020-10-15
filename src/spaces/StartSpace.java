package spaces;

import core.GameMaster;
import core.Player;

/**
 * Class implementing a <b>start space</b>.
 *
 * <p>Players on the start space are made to choose between the Career and
 * College Paths for their first move.</p>
 */
public class StartSpace extends ColoredSpace {
    /**
     * Creates a start space object
     *
     * <p>In particular, a start space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its color is assigned as "Special (Start)".</li>
     *     <li>Its index on the board is 0.</li>
     *     <li>Its next indices are 1 (the first space of the Career Path) and 5 (the)
     *     first space of the College Path).</li>
     * </ul>
     */
    public StartSpace() {
        /* Invoke the constructor of the parent class, passing the string "Special (Start)"
        and the appropriate index values.
        */
        super("Special (Start)", 0, 1, 5);
    }

    /**
     * Executes the action associated with this space; that is, the player chooses
     * between two possible paths
     *
     * <p>From the start space, the player can choose between the Career Path
     * and the College Path.</p>
     *
     * @param currPlayer current player with turn
     * @param path code of the path chosen by the player
     */
    public void execute(Player currPlayer, int path) {
        switch(path) {
            /* Depending on the path chosen by the player, the actual next
            index of the start space is set accordingly.
            */
            case GameMaster.CAREER_PATH_CODE:
                setActualNextIndex(getNextIndex1());
                break;
            case GameMaster.COLLEGE_PATH_CODE:
                setActualNextIndex(getNextIndex2());
                break;
        }
        /* The path of the current player is also set according to the
        given path index.
        */
        currPlayer.setPath(path);
    }

    /**
     * Returns the string to be used as a prompt in the actual gameplay when the player
     * on the start space
     *
     * <p>In particular, the returned string reads as follows: "[Player name], you are
     * on the start space. Choose between the Career and College Paths." </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on the start space
     */
    @Override
    public String getInfo(Player currPlayer) {
        return currPlayer.getName() + ", you are on the start space.\n" +
                "Choose between the Career and College Paths.\n";
    }
}
