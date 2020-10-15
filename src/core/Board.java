package core;

import spaces.*;
import spaces.green_spaces.PayDay;
import spaces.green_spaces.PayRaise;
import spaces.magenta_spaces.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing the <b>board</b>, which consists of the colored spaces where
 * the actual gameplay happens
 */
public class Board implements MachineRandom {
    /* Spaces consisting the board */
    private ArrayList<ColoredSpace> spaces;
    /* Indices of the orange spaces */
    private ArrayList<Integer> indicesOrange;
    /* Indices of the blue spaces */
    private ArrayList<Integer> indicesBlue;
    /* Indices of the green spaces */
    private ArrayList<Integer> indicesGreen;
    /* Indices of the magenta spaces */
    private ArrayList<Integer> indicesMagenta;

    /**
     * Number of colored spaces in the board
     */
    public static final int NUM_SPACES = 67;
    /**
     * Index of the Which Path space forking to the Normal vs Change Career Path
     */
    public static final int INDEX_FORK_CAREER = 23;
    /**
     * Index of the Which Path space forking to the Normal vs Start A Family Path
     */
    public static final int INDEX_FORK_FAMILY = 45;

    /**
     * Index of the space corresponding to the Career Path at the start of the game
     */
    public static final int NEXT_INDEX_FORK_START_1 = 1;
    /**
     * Index of the space corresponding to the College Path at the start of the game
     */
    public static final int NEXT_INDEX_FORK_START_2 = 5;
    /**
     * Index of the space corresponding to the Normal Path at a Which Path juncture
     */
    public static final int NEXT_INDEX_FORK_CAREER_1 = 24;
    /**
     * Index of the space corresponding to the Change Career Path at a Which Path juncture
     */
    public static final int NEXT_INDEX_FORK_CAREER_2 = 27;
    /**
     * Index of the space corresponding to the Normal Path at a Which Path juncture
     */
    public static final int NEXT_INDEX_FORK_FAMILY_1 = 46;
    /**
     * Index of the space corresponding to the Start a Family Path at a Which Path juncture
     */
    public static final int NEXT_INDEX_FORK_FAMILY_2 = 49;

    /**
     * Creates a board object consisting of colored spaces: orange, blue, green, and magenta spaces
     * (as well as start and end spaces) that dictate the layout and course of the gameplay
     */
    public Board() {
        /* Set the colored spaces. */
        spaces = new ArrayList<ColoredSpace>(NUM_SPACES);
        initSpaces();

        /* Store the indices of the colored spaces into the appropriate attributes. */
        indicesOrange = new ArrayList<Integer>(NUM_SPACES);
        setIndicesOrange();

        indicesBlue = new ArrayList<Integer>(NUM_SPACES);
        setIndicesBlue();

        indicesGreen = new ArrayList<Integer>(NUM_SPACES);
        setIndicesGreen();

        indicesMagenta = new ArrayList<Integer>(NUM_SPACES);
        setIndicesMagenta();
    }

    /**
     * Returns the colored space given the specified index
     *
     * @param index index of the colored space to be returned
     * @return colored space corresponding to the index
     */
    public ColoredSpace getColoredSpace(int index) {
        return spaces.get(index);
    }

    /**
     * Returns the index of the magenta space in the range of indices specified; if no magenta
     * space exists in the said range, -1 is returned
     *
     * @param startIndex start index of the range of indices considered
     * @param endIndex end index of the range of indices considered
     * @return index of the magenta space in the range of indices specified; -1 if there is no
     * such magenta space
     */
    public int getIndexMagentaInRange(int startIndex, int endIndex) {
        int indexMagenta;           // index of the magenta space
        int searchIndex;            // result of searching against the list of the indices of magenta spaces

        indexMagenta = startIndex;

        /* Iterate until a magenta index has been found or until all the indices have been exhausted. */
        while (indexMagenta != endIndex && indexMagenta != -1) {
            /* Search against the list of the indices of magenta spaces. */
            searchIndex = indicesMagenta.indexOf(indexMagenta);

            /* Returns the index if a magenta space has been found. */
            if (searchIndex != -1)
                return indexMagenta;

            indexMagenta = spaces.get(indexMagenta).getActualNextIndex();
        }

        /* No magenta space found */
        return -1;
    }

    /**
     * Returns <code>true</code> if the space corresponding to the specified index is orange;
     * <code>false</code>, otherwise
     *
     * @param index index of the space to be checked
     * @return <code>true</code> if the space corresponding to the specified index is orange;
     *         <code>false</code>, otherwise
     */
    public boolean isOrangeSpace(int index) {
        return indicesOrange.indexOf(index) != -1;
    }

    /**
     * Returns <code>true</code> if the space corresponding to the specified index is blue;
     * <code>false</code>, otherwise
     *
     * @param index index of the space to be checked
     * @return <code>true</code> if the space corresponding to the specified index is blue;
     *         <code>false</code>, otherwise
     */
    public boolean isBlueSpace(int index) {
        return indicesBlue.indexOf(index) != -1;
    }

    /**
     * Returns <code>true</code> if the space corresponding to the specified index is green;
     * <code>false</code>, otherwise
     *
     * @param index index of the space to be checked
     * @return <code>true</code> if the space corresponding to the specified index is green;
     *         <code>false</code>, otherwise
     */
    public boolean isGreenSpace(int index) {
        return indicesGreen.indexOf(index) != -1;
    }

    /**
     * Returns <code>true</code> if the space corresponding to the specified index is magenta;
     * <code>false</code>, otherwise
     *
     * @param index index of the space to be checked
     * @return <code>true</code> if the space corresponding to the specified index is magenta;
     *         <code>false</code>, otherwise
     */
    public boolean isMagentaSpace(int index) {
        return indicesMagenta.indexOf(index) != -1;
    }

    /**
     * Initializes the colored spaces comprising the board, dictating the layout
     * and the gameplay
     */
    private void initSpaces() {
        spaces.add(new StartSpace());
        spaces.add(new OrangeSpace(1, 2));
        spaces.add(new OrangeSpace(2, 3));
        spaces.add(new OrangeSpace(3, 4));
        spaces.add(new GetMarried(4, 14));
        spaces.add(new OrangeSpace(5, 6));
        spaces.add(new OrangeSpace(6, 7));
        spaces.add(new OrangeSpace(7, 8));
        spaces.add(new OrangeSpace(8, 9));
        spaces.add(new OrangeSpace(9, 10));
        spaces.add(new GraduationSpace(10, 11));
        spaces.add(new OrangeSpace(11, 12));
        spaces.add(new OrangeSpace(12, 13));
        spaces.add(new CollegeCareerChoice(13, 14));

        spaces.add(new OrangeSpace(14, 15));
        spaces.add(new BlueSpace(15, 16));
        spaces.add(new OrangeSpace(16, 17));
        spaces.add(new OrangeSpace(17, 18));
        spaces.add(new PayDay(18, 19));
        spaces.add(new OrangeSpace(19, 20));
        spaces.add(new OrangeSpace(20, 21));
        spaces.add(new OrangeSpace(21, 22));
        spaces.add(new OrangeSpace(22, 23));
        spaces.add(new WhichPath(23, 24, 27));
        spaces.add(new OrangeSpace(24, 25));
        spaces.add(new OrangeSpace(25, 26));
        spaces.add(new PayRaise(26, 36));
        spaces.add(new OrangeSpace(27, 28));
        spaces.add(new JobSearch(28, 29));
        spaces.add(new OrangeSpace(29, 30));
        spaces.add(new BlueSpace(30, 31));
        spaces.add(new OrangeSpace(31, 32));
        spaces.add(new PayDay(32, 33));
        spaces.add(new OrangeSpace(33, 34));
        spaces.add(new PayRaise(34, 35));
        spaces.add(new BlueSpace(35, 36));

        spaces.add(new OrangeSpace(36, 37));
        spaces.add(new OrangeSpace(37, 38));
        spaces.add(new OrangeSpace(38, 39));
        spaces.add(new BlueSpace(39, 40));
        spaces.add(new PayDay(40, 41));
        spaces.add(new OrangeSpace(41, 42));
        spaces.add(new OrangeSpace(42, 43));
        spaces.add(new OrangeSpace(43, 44));
        spaces.add(new PayRaise(44, 45));
        spaces.add(new WhichPath(45, 46, 49));
        spaces.add(new OrangeSpace(46, 47));
        spaces.add(new PayDay(47, 48));
        spaces.add(new BlueSpace(48, 58));
        spaces.add(new OrangeSpace(49, 50));
        spaces.add(new GetMarried(50, 51));
        spaces.add(new PayRaise(51, 52));
        spaces.add(new BlueSpace(52, 53));
        spaces.add(new BuyAHouse(53, 54));
        spaces.add(new OrangeSpace(54, 55));

        if ((getMachineRandNum() & 1) == 1)
            spaces.add(new HaveBaby(55, 56));
        else
            spaces.add(new HaveTwins(55, 56));

        spaces.add(new OrangeSpace(56, 57));
        spaces.add(new OrangeSpace(57, 58));

        spaces.add(new OrangeSpace(58, 59));
        spaces.add(new OrangeSpace(59, 60));
        spaces.add(new PayRaise(60, 61));
        spaces.add(new OrangeSpace(61, 62));
        spaces.add(new PayDay(62, 63));
        spaces.add(new OrangeSpace(63, 64));
        spaces.add(new BlueSpace(64, 65));
        spaces.add(new PayDay(65, 66));
        spaces.add(new EndSpace());
    }

    /**
     * Stores the indices of the orange spaces to the pertinent attribute
     */
    private void setIndicesOrange() {
        for (int i = 0; i < spaces.size(); i++)
            if (spaces.get(i).getColor().equalsIgnoreCase("Orange"))
                indicesOrange.add(spaces.get(i).getIndex());
    }

    /**
     * Stores the indices of the blue spaces to the pertinent attribute
     */
    private void setIndicesBlue() {
        for (int i = 0; i < spaces.size(); i++)
            if (spaces.get(i).getColor().equalsIgnoreCase("Blue"))
                indicesBlue.add(spaces.get(i).getIndex());
    }

    /**
     * Stores the indices of the green spaces to the pertinent attribute
     */
    private void setIndicesGreen() {
        for (int i = 0; i < spaces.size(); i++)
            if (spaces.get(i).getColor().equalsIgnoreCase("Green"))
                indicesGreen.add(spaces.get(i).getIndex());
    }

    /**
     * Stores the indices of the magenta spaces to the pertinent attribute
     */
    private void setIndicesMagenta() {
        for (int i = 0; i < spaces.size(); i++)
            if (spaces.get(i).getColor().equalsIgnoreCase("Magenta"))
                indicesMagenta.add(spaces.get(i).getIndex());
    }

    /**
     * Returns a randomly generated value between 1 and 2, inclusive, to determine
     * whether a Have Baby or Have Twins space is to be generated
     *
     * <p>Technically, the number is generated in a pseudorandom fashion, which
     * is adequate for the purposes of the game.</p>
     *
     * @return Randomly generated value within the lower and upper bounds for the
     * maximum number of pay raises (inclusive)
     */
    @Override
    public int getMachineRandNum() {
        /* The +1 in the upper bound is important since ThreadLocalRandom treats the
        lower bound as inclusive but the upper bound as exclusive.
         */
        return ThreadLocalRandom.current().nextInt(1, 3);
    }

    /**
     * Returns a string representation of this board, which includes the string representations
     * of all its colored spaces
     *
     * @return string representation of this board
     */
    @Override
    public String toString() {
        String retStr;
        retStr = "";

        /* Iterate through all the colored spaces. */
        for (int i = 0; i < spaces.size(); i++)
            retStr = retStr + spaces.get(i).toString() + "\n";

        return retStr;
    }
}
