package spaces;

import core.Player;
/**
 * Abstract class implementing a <b>magenta space</b>.
 *
 * <p>Players on a magenta space execute the effects of one of the eight
 * magenta space subclasses.</p>
 */
public abstract class MagentaSpace extends ColoredSpace {
    /* The name of the magenta space is indicative of its effect */
    private String name;

    /**
     * Creates a magenta space object
     *
     * <p>In particular, a magenta space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its color is assigned as "Magenta".</li>
     *     <li>Its name is assigned the passed parameter name.</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next indices are assigned the passed parameters nextIndex1
     *     and nextIndex2.</li>
     * </ul>
     *
     * @param name the name of the space
     * @param index the index of the space on the board
     * @param nextIndex1 the index of the first space the player can move to from
     * this space
     * @param nextIndex2 the index of the second space the player can move to from
     * this space
     */
    public MagentaSpace(String name, int index, int nextIndex1, int nextIndex2) {
        /* Invoke the constructor of the parent class, passing the string "Magenta"
        and the appropriate index values.
        */
        super("Magenta", index, nextIndex1, nextIndex2);
        /* The name of the space is assigned the passed parameter name */
        this.name = name;
    }

    /**
     * Returns the name of the magenta space
     *
     * @return the name of the magenta space
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract method for returning the string to be used as a prompt in the actual
     * gameplay when the player is on a magenta space
     *
     * <p>As the prompts vary depending on the type of green space, its details are
     * implemented in the subclasses of the MagentaSpace class. </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a magenta space
     */
    public abstract String getInfo(Player currPlayer);

    /**
     * Returns a string representation of this magenta space, which includes its
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
     * @return string representation of this magenta space, which includes its
     * color, index, list of next indices, and name.
     */
    @Override
    public String toString() {
        return super.toString() + "Name: " + name + "\n";
    }
}
