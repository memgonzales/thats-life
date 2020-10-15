package spaces.magenta_spaces;

import core.GameMaster;
import core.Player;
import spaces.MagentaSpace;

/**
 * Class implementing a <b>which path space</b>.
 *
 * <p>Players on a which path space choose between two paths for their next move.</p>
 */
public class WhichPath extends MagentaSpace {
    /**
     * Creates a which path object
     *
     * <p>In particular, a which path space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its color is assigned as "Which Path".</li>
     *     <li>Its index on the board is assigned as the passed parameter index.</li>
     *     <li>Its next indices are assigned the passed parameters nextIndex1 and
     *     nextIndex2.</li>
     * </ul>
     *
     * @param index index of the space on the board
     * @param nextIndex1 index of the next space on the board if the normal path is taken
     * @param nextIndex2 index of the next space on the board if the player deviates from the normal path
     */
    public WhichPath(int index, int nextIndex1, int nextIndex2) {
        /* Invoke the constructor of the parent class, passing the string "Which Path"
        and the appropriate index values.
        */
        super("Which Path", index, nextIndex1, nextIndex2);
    }

    /**
     * Executes the action associated with this space; that is, the player chooses
     * between two possible paths
     *
     * <p>On a which path space, the player can choose between either the Normal Path
     * or the Change Career Path at the first junction, and between either the Normal
     * Path or the Start A Family Path at the second junction.</p>
     *
     * @param currPlayer current player with turn
     * @param path code of the path chosen by the player
     */
    public void execute(Player currPlayer, int path) {
        switch(path) {
            /* Depending on the path chosen by the player, the actual next
            index of the which path space is set accordingly.
            */
            case GameMaster.NORMAL_PATH_CODE:
                currPlayer.setPath(GameMaster.NORMAL_PATH_CODE);
                setActualNextIndex(getNextIndex1());
                break;
            case GameMaster.CHANGE_CAREER_PATH_CODE:
                currPlayer.setPath(GameMaster.CHANGE_CAREER_PATH_CODE);
                setActualNextIndex(getNextIndex2());
                break;
            case GameMaster.START_FAMILY_PATH_CODE:
                setActualNextIndex(getNextIndex2());
                currPlayer.setPath(GameMaster.START_FAMILY_PATH_CODE);
                break;
        }
    }

    /**
     * Returns the string to be used as a prompt in the actual gameplay when the player
     * on a which path space
     *
     * <p>In particular, the returned string reads as follows: "[Player name], you are
     * on a Which Path space. Choose between the two paths." </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a which path space
     */
    @Override
    public String getInfo(Player currPlayer) {
        return currPlayer.getName() + ", you are on a Which Path space.\n" +
                "Choose between the two paths.\n" +
                "You are entitled to ANOTHER TURN right after this.\n";
    }
}

