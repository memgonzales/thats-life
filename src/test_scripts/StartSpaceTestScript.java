

import core.Player;
import spaces.StartSpace;

/**
 * Test script for <code>Start Space</code> class
 */
public class StartSpaceTestScript {
    public static void main(String[] args) {

        Player p1;
        StartSpace space1;

        /* Constructor: StartSpace ()
        One StartSpace object is created.
        */
        space1 = new StartSpace();

        /* A Player object is created to test the methods of the StartSpace object. */
        p1 = new Player("Sample Name");

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, int path)
       Test case 1: The execute() method of space1 is called, and p1 chooses the Career Path.
       Expected output: The nextIndex attribute of space1 will be 1 */
        System.out.println ("Test case 1: The execute() method of space1 is called, and p1 chooses the Career Path.");

        System.out.println("Current next index = " + space1.getActualNextIndex());
        space1.execute(p1, 1);
        System.out.println("New next index = " + space1.getActualNextIndex());

        /* Method: execute(Player currPlayer, int path)
       Test case 2: The execute() method of space1 is called, and p1 chooses the College Path.
       Expected output: The nextIndex attribute of space1 will be 5 */
        System.out.println ("Test case 2: The execute() method of space1 is called, and p1 chooses the College Path.");

        System.out.println("Current next index = " + space1.getActualNextIndex());
        space1.execute(p1, 2);
        System.out.println("New next index = " + space1.getActualNextIndex());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo(Player currPlayer)
        Test case: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on the start space.
        Choose between the Career and College Paths."
        */
        System.out.println("Test case: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
