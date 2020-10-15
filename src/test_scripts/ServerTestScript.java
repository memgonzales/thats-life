

import cards.career_cards.Server;

/**
 * Test script for <code>Server</code> class
 */
public class ServerTestScript {
    public static void main(String[] args) {

        Server career1;
        Server career2;
        Server career3;

        /* Constructor: Server ()
         *  Three Server objects are created (to test the random generation of maximum
         *  pay raises). */
        career1 = new Server();
        career2 = new Server();
        career3 = new Server();

        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of career1 is called.
         *  Expected output: "Server", "No", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  1 and 4 inclusive). */
        System.out.println ("Test case 1: The getInfo() method of career1 is called.");

        System.out.println (career1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of career2 is called.
         *  Expected output: "Server", "No", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  1 and 4 inclusive). */
        System.out.println ("Test case 2: The getInfo() method of career2 is called.");

        System.out.println (career2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of career3 is called.
         *  Expected output: "Server", "No", and maxPayRaise, where maxPayRaise
         *  indicates the randomly generated maximum number of pay raises (should be between
         *  1 and 4 inclusive). */
        System.out.println ("Test case 3: The getInfo() method of career3 is called.");

        System.out.println (career3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The Server object career1 is printed (using the toString() method).
         *  Expected output: "false", [1, 4], the randomly generated maximum number of pay raises,
         *  "Server". */
        System.out.println("Test case 1: The Server object career1 is printed (using the toString() method).");

        System.out.println(career1);

        /* Method: Overridden toString()
         *  Test case 2: The Server object career2 is printed (using the toString() method).
         *  Expected output: "false", [1, 4], the randomly generated maximum number of pay raises,
         *  "Server". */
        System.out.println("Test case 2: The Server object career2 is printed (using the toString() method).");

        System.out.println(career2);

        /* Method: Overridden toString()
         *  Test case 3: The Server object career3 is printed (using the toString() method).
         *  Expected output: "false", [1, 4], the randomly generated maximum number of pay raises,
         *  "Server". */
        System.out.println("Test case 3: The Server object career3 is printed (using the toString() method).");

        System.out.println(career3);
    }
}
