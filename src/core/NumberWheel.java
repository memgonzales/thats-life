package core;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing the <b>number wheel</b> of the game, which is spun
 * to obtain a random number while the game itself is in motion
 *
 * <p>This resulting value is used to determine the number of moves that
 * a player will take. Certain blue cards also press the player for a
 * random number, which can be obtained by spinning this number wheel.</p>
 */
public class NumberWheel {
    /* Numbers comprising the number wheel */
    private ArrayList<Integer> numbers;

    /**
     * Per the machine project specifications, the number wheel of the game has the
     * numbers 1 to 10.
     */
    public static final int NUM_NUMBERS = 10;

    /**
     * Creates a number wheel object
     *
     * <p>In particular, a number wheel object is initialized to have the numbers 1 to
     * <code>NUM_NUMBERS</code> (set to 10 per the machine project specifications).</p>
     */
    public NumberWheel() {
        numbers = new ArrayList<Integer>(NUM_NUMBERS);

        /* Add the numbers [1, MAX_NUMBERS] to the number wheel. */
        for (int i = 1; i <= NUM_NUMBERS; i++)
            numbers.add(i);
    }

    /**
     * Returns the number obtained after spinning this number wheel
     *
     * <p>More formally, the spinning of this wheel is simulated by returning a random number within
     * the range [1, <code>NUM_NUMBERS</code>] (the upper bound set to 10 per the machine project
     * specifications) using the Java <code>ThreadLocalRandom</code> utility class.</p>
     *
     * <p>Technically, the number is generated in a pseudorandom fashion, which
     * is adequate for the purposes of the game.</p>
     *
     * @return number obtained after spinning this wheel
     */
    public int spin() {
        /*The +1 in the upper bound is important since ThreadLocalRandom treats the
        lower bound as inclusive but the upper bound as exclusive.
         */
        return ThreadLocalRandom.current().nextInt(1, NUM_NUMBERS + 1);
    }

    /**
     * Returns a string representation of this number wheel, which includes all
     * the numbers that can be obtained by spinning it
     *
     * <p>In particular, the label "Wheel: ", followed by the numbers that can be obtained
     * by spinning it (each value separated by a tab character), is returned. </p>
     *
     * @return string representation of this number wheel, which includes all the
     * numbers that can be obtained by spinning it
     */
    @Override
    public String toString() {
        String nums;
        nums = "";

        /* Concatenate each possible number that can be obtained by spinning this wheel,
        separating the values with a tab character.
         */
        for (int i = 0; i < numbers.size(); i++)
            nums += numbers.get(i) + "\t";

        return "Wheel: " + nums + "\n";
    }
}
