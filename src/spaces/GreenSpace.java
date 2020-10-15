package spaces;

import core.Bank;
import core.Player;

/**
 * Abstract class implementing a <b>green space</b>.
 *
 * <p>Players on a green space execute the effects of one of the two
 * green space subclasses.</p>
 */
public abstract class GreenSpace extends ColoredSpace {
    /* The name of the green space is indicative of its effect */
    private String name;

    /**
     * Creates a green space object
     *
     * <p>In particular, a green space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its color is assigned as "Green".</li>
     *     <li>Its name is assigned the passed parameter name.</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next indices are assigned the passed parameter nextIndex.</li>
     * </ul>
     *
     * @param name the name of the space
     * @param index the index of the space on the board
     * @param nextIndex the index of the next space the player can move to from
     * this space
     */
    public GreenSpace(String name, int index, int nextIndex) {
        /* Invoke the constructor of the parent class, passing the string "Green"
        and the appropriate index values. The same index is used for both next index values
        of the green space, as there is only one other space a player can move to from a green
        space.
        */
        super("Green", index, nextIndex, nextIndex);
        /* The name of the space is assigned the passed parameter name */
        this.name = name;
    }

    /**
     * Returns the name of the green space
     *
     * @return the name of the green space
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract class for executing the action associated with this space
     *
     * <p>On a green space, the player can either receive their current salary
     * or receive a pay raise.</p>
     *
     * @param currPlayer current player with turn
     * @param b Bank of the game
     */
    public abstract void execute(Player currPlayer, Bank b);

    /**
     * Abstract method for returning the string to be used as a prompt in the actual
     * gameplay when the player is on a green space
     *
     * <p>As the prompts vary depending on the type of green space, its details are
     * implemented in the subclasses of the GreenSpace class. </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a green space
     */
    public abstract String getInfo(Player currPlayer);

    /**
     * Returns a string representation of this green space, which includes its
     * color, index, list of next indices, and name.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Color of this space</li>
     *     <li>Index of this space</li>
     *     <li>Next indices of this space</li>
     *     <li>Name of this space</li>
     * </ul>
     *
     * @return string representation of this green space, which includes its
     * color, index, list of next indices, and name.
     */
    @Override
    public String toString() {
        /* The toString() methods of its parent class (ColoredSpace) is called,
        and the name of the space is appended to the existing string
        */
        return super.toString() + "Name: " + name + "\n";
    }
}
