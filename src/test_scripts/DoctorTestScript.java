

import cards.career_cards.Doctor;

/**
 * Test script for <code>Doctor</code> class
 */
public class DoctorTestScript {
    public static void main(String[] args) {

        Doctor career1;
        Doctor career2;
        Doctor career3;

        /* Constructor: Doctor ()
         *  Three Doctor objects are created (to test the random generation of maximum
         *  pay raises). */
        career1 = new Doctor();
        career2 = new Doctor();
        career3 = new Doctor();

        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of career1 is called.
         *  Expected output: "Doctor", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  5 and 8 inclusive). */
        System.out.println ("Test case 1: The getInfo() method of career1 is called.");

        System.out.println (career1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of career2 is called.
         *  Expected output: "Doctor", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  5 and 8 inclusive). */
        System.out.println ("Test case 2: The getInfo() method of career2 is called.");

        System.out.println (career2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of career3 is called.
         *  Expected output: "Doctor", "Yes", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  5 and 8 inclusive). */
        System.out.println ("Test case 3: The getInfo() method of career3 is called.");

        System.out.println (career3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The Doctor object career1 is printed (using the toString() method).
         *  Expected output: "true", [5, 8], the randomly generated maximum number of pay raises,
         *  "Doctor". */
        System.out.println("Test case 1: The Doctor object career1 is printed (using the toString() method).");

        System.out.println(career1);

        /* Method: Overridden toString()
         *  Test case 2: The Doctor object career2 is printed (using the toString() method).
         *  Expected output: "true", [5, 8], the randomly generated maximum number of pay raises,
         *  "Doctor". */
        System.out.println("Test case 2: The Doctor object career2 is printed (using the toString() method).");

        System.out.println(career2);

        /* Method: Overridden toString()
         *  Test case 3: The Doctor object career3 is printed (using the toString() method).
         *  Expected output: "true", [5, 8], the randomly generated maximum number of pay raises,
         *  "Doctor". */
        System.out.println("Test case 3: The Doctor object career3 is printed (using the toString() method).");

        System.out.println(career3);
    }
}
