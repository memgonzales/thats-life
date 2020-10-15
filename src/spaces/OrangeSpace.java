package spaces;

import cards.ActionCard;
import core.DiscardPile;
import core.Player;
import decks.ActionCardDeck;

/**
 * Class implementing an <b>orange space</b>.
 *
 * <p>Players on an orange space are made to draw an orange card, the effect of which is
 * subsequently executed.</p>
 */
public class OrangeSpace extends ColoredSpace {
    /**
     * Creates an orange space object
     *
     * <p>In particular, an orange space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its color is assigned as "Orange".</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next indices are assigned the passed parameter nextIndex.</li>
     * </ul>
     *
     * @param index the index of the space on the board
     * @param nextIndex the index of the next space the player can move to from
     * this space
     */
    public OrangeSpace(int index, int nextIndex) {
        /* Invoke the constructor of the parent class, passing the string "Orange"
        and the appropriate index values. The same index is used for both next index values
        of the blue space, as there is only one other space a player can move to from a blue
        space.
        */
        super("Orange", index, nextIndex, nextIndex);
    }

    /**
     * Executes the action associated with this space; that is, the player draws
     * an action card
     *
     * <p>On an orange space, the player is prompted to draw an action card, and the
     * action card object in turn executes its effect on the player.</p>
     *
     * @param currPlayer current player with turn
     * @param d ActionCardDeck object of the game
     * @param pile DiscardPile of the game
     * @return the drawn action card
     */
    public ActionCard drawActionCard(Player currPlayer, ActionCardDeck d, DiscardPile pile) {
        /* The player is made to draw from the action card deck */
        return currPlayer.drawFromActionDeck(d, pile);
    }

    /**
     * Returns the string to be used as a prompt in the actual gameplay when the player
     * on an orange space
     *
     * <p>In particular, the returned string reads as follows: "[Player name], you are
     * on an orange space. Draw an action card." </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on an orange space
     */
    @Override
    public String getInfo(Player currPlayer) {
        return currPlayer.getName() + ", you are on an orange space.\n" +
                "Draw an action card.\n";
    }
}
