package spaces;

import core.Player;

import java.util.ArrayList;
/**
 * Abstract class providing a skeletal implementation of a <b>colored space</b>
 */
public abstract class ColoredSpace {
    /* Color of the space */
    private String color;
    /* Index of the space in the created board */
    private int index;
    /* Indices of the colored spaces a player can move to from this space
    (though most colored spaces have only one next index, the start space
    and the Which Path magenta spaces have two next indices)
    */
    private ArrayList<Integer> nextIndices;
    /* The actual next index of the space (the index where the player
    will move to next)
    */
    private int actualNextIndex;

    /**
     * Constructor with the color, index, and next indices of the colored space
     * as parameters
     *
     * The actual next index of the space is set to its first given next index,
     * as most colored spaces have only one possible next index. For spaces with
     * more than one possible next index, the actual next index is reassigned
     * following the pertinent player input.
     *
     * @param color color of the space
     * @param index index of the space on the board
     * @param nextIndex1 the first possible next index of the space
     * @param nextIndex2 the second possible next index of the space
     */
    public ColoredSpace(String color, int index, int nextIndex1, int nextIndex2) {
        this.color = color;
        this.index = index;

        this.nextIndices = new ArrayList<Integer>(2);
        /* The next indices of the space are listed in an array list. */
        nextIndices.add(nextIndex1);
        nextIndices.add(nextIndex2);

        /* The actual next index is set to the first given next index. */
        this.actualNextIndex = nextIndices.get(0);
    }

    /**
     * Return the color of this space
     *
     * @return color of this space
     */
    public String getColor() {
        return color;
    }

    /**
     * Return the index of this space
     *
     * @return index of this space
     */
    public int getIndex() {
        return index;
    }

    /**
     * Return the first next index of this space
     *
     * @return first next index of this space
     */
    public int getNextIndex1() {
        return nextIndices.get(0);
    }

    /**
     * Return the second next index of this space
     *
     * @return second next index of this space
     */
    public int getNextIndex2() {
        return nextIndices.get(1);
    }

    /**
     * Return the actual next index of this space
     *
     * @return actual next index of this space
     */
    public int getActualNextIndex() {
        return actualNextIndex;
    }

    /**
     * Set the actual next index of this space
     *
     * @param actualNextIndex the next index of the space decided upon based on
     * the player input
     */
    public void setActualNextIndex(int actualNextIndex) {
        this.actualNextIndex = actualNextIndex;
    }

    /**
     * Abstract method for returning the string to be used as a prompt in the actual gameplay
     * when the player is on a colored space
     *
     * <p>As the prompts vary depending on the space, its details are implemented in
     * the subclasses of the ColoredSpace class. Moreover, the current player is
     * passed as a parameter so they can be addressed by name during the actual
     * gameplay to make the prompts more informative. </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a colored space
     */
    public abstract String getInfo(Player currPlayer);

    /**
     * Returns a string representation of this colored space, which includes its
     * color, index, and list of next indices.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Color of this space</li>
     *     <li>Index of this space</li>
     *     <li>Next indices of this space</li>
     * </ul>
     *
     * @return string representation of this colored space, which includes its
     * color, index, and list of next indices
     */
    @Override
    public String toString() {
        return "COLORED SPACE\n" +
                "Color: " + color + "\n" +
                "Index: " + index + "\n" +
                "Next Indices: (" + getNextIndex1() + ", " + getNextIndex2() + ")\n";
    }
}
