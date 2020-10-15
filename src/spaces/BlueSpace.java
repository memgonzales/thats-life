package spaces;

import cards.BlueCard;
import core.Player;
import decks.BlueCardDeck;

/**
 * Class implementing a <b>blue space</b>.
 *
 * <p>Players on a blue space are made to draw a blue card, the effect of which is
 * subsequently executed.</p>
 */
public class BlueSpace extends ColoredSpace {
    /**
     * Creates a blue space object
     *
     * <p>In particular, a blue space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its color is assigned as "Blue".</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next indices are assigned the passed parameter nextIndex.</li>
     * </ul>
     *
     * @param index the index of the space on the board
     * @param nextIndex the index of the next space the player can move to from
     * this space
     */
    public BlueSpace(int index, int nextIndex) {
        /* Invoke the constructor of the parent class, passing the string "Blue"
        and the appropriate index values. The same index is used for both next index values
        of the blue space, as there is only one other space a player can move to from a blue
        space.
        */
        super("Blue", index, nextIndex, nextIndex);
    }

    /**
     * Executes the action associated with this space; that is, the player draws
     * a blue card
     *
     * <p>On a blue space, the player is prompted to draw a blue card, and the
     * blue card object in turn executes its effect on the player.</p>
     *
     * @param currPlayer current player with turn
     * @param d BlueCardDeck object of the game
     * @return the drawn blue card
     */
    public BlueCard drawBlueCard(Player currPlayer, BlueCardDeck d) {
        /* The player is made to draw from the blue card deck */
        return currPlayer.drawFromBlueDeck(d);
    }

    /**
     * Returns the string to be used as a prompt in the actual gameplay when the player is
     * on a blue space
     *
     * <p>In particular, the returned string reads as follows: "[Player name], you are
     * on a blue space. Draw a blue card." </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a blue space
     */
    @Override
    public String getInfo(Player currPlayer) {
        return currPlayer.getName() + ", you are on a blue space.\n" +
                "Draw a blue card.\n";
    }
}
