

import cards.career_cards.ComputerConsultant;

/**
 * Test script for <code>ComputerConsultant</code> class
 */
public class ComputerConsultantTestScript {
    public static void main(String[] args) {

        ComputerConsultant career1;
        ComputerConsultant career2;
        ComputerConsultant career3;

        /* Constructor: ComputerConsultant ()
         *  Three ComputerConsultant objects are created (to test the random generation of maximum
         *  pay raises). */
        career1 = new ComputerConsultant();
        career2 = new ComputerConsultant();
        career3 = new ComputerConsultant();

        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of career1 is called.
         *  Expected output: "Computer Consultant", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  3 and 7 inclusive). */
        System.out.println ("Test case 1: The getInfo() method of career1 is called.");

        System.out.println (career1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of career2 is called.
         *  Expected output: "Computer Consultant", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  3 and 7 inclusive). */
        System.out.println ("Test case 2: The getInfo() method of career2 is called.");

        System.out.println (career2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of career3 is called.
         *  Expected output: "Computer Consultant", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  3 and 7 inclusive). */
        System.out.println ("Test case 3: The getInfo() method of career3 is called.");

        System.out.println (career3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The ComputerConsultant object career1 is printed (using the toString() method).
         *  Expected output: "true", [3, 7], the randomly generated maximum number of pay raises,
         *  "Computer Consultant". */
        System.out.println("Test case 1: The ComputerConsultant object career1 is printed (using the toString() method).");

        System.out.println(career1);

        /* Method: Overridden toString()
         *  Test case 2: The ComputerConsultant object career2 is printed (using the toString() method).
         *  Expected output: "true", [3, 7], the randomly generated maximum number of pay raises,
         *  "Computer Consultant". */
        System.out.println("Test case 2: The ComputerConsultant object career2 is printed (using the toString() method).");

        System.out.println(career2);

        /* Method: Overridden toString()
         *  Test case 3: The ComputerConsultant object career3 is printed (using the toString() method).
         *  Expected output: "true", [3, 7], the randomly generated maximum number of pay raises,
         *  "Computer Consultant". */
        System.out.println("Test case 3: The ComputerConsultant object career3 is printed (using the toString() method).");

        System.out.println(career3);
    }
}
