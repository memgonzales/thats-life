import cards.career_cards.Athlete;

/**
 * Test script for <code>Athlete</code> class
 */
public class AthleteTestScript {
    public static void main(String[] args) {

        Athlete career1;
        Athlete career2;
        Athlete career3;

        /* Constructor: Athlete ()
         *  Three Athlete objects are created (to test the random generation of maximum
         *  pay raises). */
        career1 = new Athlete();
        career2 = new Athlete();
        career3 = new Athlete();

        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of career1 is called.
         *  Expected output: "Athlete", "No", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  1 and 6 inclusive). */
        System.out.println ("Test case 1: The getInfo() method of career1 is called.");

        System.out.println (career1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of career2 is called.
         *  Expected output: "Athlete", "No", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  1 and 6 inclusive). */
        System.out.println ("Test case 2: The getInfo() method of career2 is called.");

        System.out.println (career2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of career3 is called.
         *  Expected output: "Athlete", "No", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  1 and 6 inclusive). */
        System.out.println ("Test case 3: The getInfo() method of career3 is called.");

        System.out.println (career3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The Athlete object career1 is printed (using the toString() method).
         *  Expected output: "false", [1, 6], the randomly generated maximum number of pay raises,
         *  "Athlete". */
        System.out.println("Test case 1: The Athlete object career1 is printed (using the toString() method).");

        System.out.println(career1);

        /* Method: Overridden toString()
         *  Test case 2: The Athlete object career2 is printed (using the toString() method).
         *  Expected output: "false", [1, 6], the randomly generated maximum number of pay raises,
         *  "Athlete". */
        System.out.println("Test case 2: The Athlete object career2 is printed (using the toString() method).");

        System.out.println(career2);

        /* Method: Overridden toString()
         *  Test case 3: The Athlete object career3 is printed (using the toString() method).
         *  Expected output: "false", [1, 6], the randomly generated maximum number of pay raises,
         *  "Athlete". */
        System.out.println("Test case 3: The Athlete object career3 is printed (using the toString() method).");

        System.out.println(career3);
    }
}
