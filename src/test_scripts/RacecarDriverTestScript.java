

import cards.career_cards.RacecarDriver;

/**
 * Test script for <code>RacecarDriver</code> class
 */
public class RacecarDriverTestScript {
    public static void main(String[] args) {

        RacecarDriver career1;
        RacecarDriver career2;
        RacecarDriver career3;

        /* Constructor: RacecarDriver ()
         *  Three RacecarDriver objects are created (to test the random generation of maximum
         *  pay raises). */
        career1 = new RacecarDriver();
        career2 = new RacecarDriver();
        career3 = new RacecarDriver();

        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of career1 is called.
         *  Expected output: "Racecar Driver", "No", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  2 and 8 inclusive). */
        System.out.println ("Test case 1: The getInfo() method of career1 is called.");

        System.out.println (career1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of career2 is called.
         *  Expected output: "Racecar Driver", "No", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  2 and 8 inclusive). */
        System.out.println ("Test case 2: The getInfo() method of career2 is called.");

        System.out.println (career2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of career3 is called.
         *  Expected output: "Racecar Driver", "No", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  2 and 8 inclusive). */
        System.out.println ("Test case 3: The getInfo() method of career3 is called.");

        System.out.println (career3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The RacecarDriver object career1 is printed (using the toString() method).
         *  Expected output: "false", [2, 8], the randomly generated maximum number of pay raises,
         *  "Racecar Driver". */
        System.out.println("Test case 1: The RacecarDriver object career1 is printed (using the toString() method).");

        System.out.println(career1);

        /* Method: Overridden toString()
         *  Test case 2: The RacecarDriver object career2 is printed (using the toString() method).
         *  Expected output: "false", [2, 8], the randomly generated maximum number of pay raises,
         *  "Racecar Driver". */
        System.out.println("Test case 2: The RacecarDriver object career2 is printed (using the toString() method).");

        System.out.println(career2);

        /* Method: Overridden toString()
         *  Test case 3: The RacecarDriver object career3 is printed (using the toString() method).
         *  Expected output: "false", [2, 8], the randomly generated maximum number of pay raises,
         *  "Racecar Driver". */
        System.out.println("Test case 3: The RacecarDriver object career3 is printed (using the toString() method).");

        System.out.println(career3);
    }
}
