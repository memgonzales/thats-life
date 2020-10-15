

import cards.career_cards.Lawyer;

/**
 * Test script for <code>Lawyer</code> class
 */
public class LawyerTestScript {
    public static void main(String[] args) {

        Lawyer career1;
        Lawyer career2;
        Lawyer career3;

        /* Constructor: Lawyer ()
         *  Three Lawyer objects are created (to test the random generation of maximum
         *  pay raises). */
        career1 = new Lawyer();
        career2 = new Lawyer();
        career3 = new Lawyer();

        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of career1 is called.
         *  Expected output: "Lawyer", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  5 and 8 inclusive). */
        System.out.println ("Test case 1: The getInfo() method of career1 is called.");

        System.out.println (career1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of career2 is called.
         *  Expected output: "Lawyer", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  5 and 8 inclusive). */
        System.out.println ("Test case 2: The getInfo() method of career2 is called.");

        System.out.println (career2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of career3 is called.
         *  Expected output: "Lawyer", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  5 and 8 inclusive). */
        System.out.println ("Test case 3: The getInfo() method of career3 is called.");

        System.out.println (career3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The Lawyer object career1 is printed (using the toString() method).
         *  Expected output: "true", [5, 8], the randomly generated maximum number of pay raises,
         *  "Lawyer". */
        System.out.println("Test case 1: The Lawyer object career1 is printed (using the toString() method).");

        System.out.println(career1);

        /* Method: Overridden toString()
         *  Test case 2: The Lawyer object career2 is printed (using the toString() method).
         *  Expected output: "true", [5, 8], the randomly generated maximum number of pay raises,
         *  "Lawyer". */
        System.out.println("Test case 2: The Lawyer object career2 is printed (using the toString() method).");

        System.out.println(career2);

        /* Method: Overridden toString()
         *  Test case 3: The Lawyer object career3 is printed (using the toString() method).
         *  Expected output: "true", [5, 8], the randomly generated maximum number of pay raises,
         *  "Lawyer". */
        System.out.println("Test case 3: The Lawyer object career3 is printed (using the toString() method).");

        System.out.println(career3);
    }
}
