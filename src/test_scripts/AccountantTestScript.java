import cards.career_cards.Accountant;

/**
 * Test script for <code>Accountant</code> class
 */
public class AccountantTestScript {
    public static void main(String[] args) {

        Accountant career1;
        Accountant career2;
        Accountant career3;

        /* Constructor: Accountant ()
         *  Three Accountant objects are created (to test the random generation of maximum
         *  pay raises). */
        career1 = new Accountant();
        career2 = new Accountant();
        career3 = new Accountant();

        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of career1 is called.
         *  Expected output: "Accountant", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  4 and 7 inclusive). */
        System.out.println ("Test case 1: The getInfo() method of career1 is called.");

        System.out.println (career1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of career2 is called.
         *  Expected output: "Accountant", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  4 and 7 inclusive). */
        System.out.println ("Test case 2: The getInfo() method of career2 is called.");

        System.out.println (career2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of career3 is called.
         *  Expected output: "Accountant", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  4 and 7 inclusive). */
        System.out.println ("Test case 3: The getInfo() method of career3 is called.");

        System.out.println (career3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The Accountant object career1 is printed (using the toString() method).
         *  Expected output: "true", [4, 7], the randomly generated maximum number of pay raises,
         *  "Accountant". */
        System.out.println("Test case 1: The Accountant object career1 is printed (using the toString() method).");

        System.out.println(career1);

        /* Method: Overridden toString()
         *  Test case 2: The Accountant object career2 is printed (using the toString() method).
         *  Expected output: "true", [4, 7], the randomly generated maximum number of pay raises,
         *  "Accountant". */
        System.out.println("Test case 2: The Accountant object career2 is printed (using the toString() method).");

        System.out.println(career2);

        /* Method: Overridden toString()
         *  Test case 3: The Accountant object career3 is printed (using the toString() method).
         *  Expected output: "true", [4, 7], the randomly generated maximum number of pay raises,
         *  "Accountant". */
        System.out.println("Test case 3: The Accountant object career3 is printed (using the toString() method).");

        System.out.println(career3);
    }
}
