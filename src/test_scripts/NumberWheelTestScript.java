

import core.NumberWheel;

/**
 * Test script for <code>NumberWheel</code> class
 */
public class NumberWheelTestScript {
    public static void main (String[] args) {

        NumberWheel wheel;

        /* Constructor: NumberWheel ()
         *  A new NumberWheel object is created. */
        wheel = new NumberWheel();

        System.out.println("Spin()");

        /* Method: Spin()
         *  Test case: The number wheel is spun five times.
         *  Expected output: 5 randomly generated numbers between 1 and 10 inclusive.
         *  The outputs of each spin should be random. */
        System.out.println("Test case: The number wheel is spun five times.");

        System.out.println("Spin 1: " + wheel.spin());
        System.out.println("Spin 2: " + wheel.spin());
        System.out.println("Spin 3: " + wheel.spin());
        System.out.println("Spin 4: " + wheel.spin());
        System.out.println("Spin 5: " + wheel.spin());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case: The number wheel is printed (using the overridden toString() method).
         *  Expected output: The elements of the number wheel (integers from 1 to 10). */
        System.out.println("Test case: The number wheel is printed (using the overridden toString() method).");

        System.out.println(wheel);
    }
}
