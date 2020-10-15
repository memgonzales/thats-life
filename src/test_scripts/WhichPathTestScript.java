

import core.Player;
import spaces.magenta_spaces.WhichPath;

/**
 * Test script for <code>Which Path</code> class
 */
public class WhichPathTestScript {
    public static void main(String[] args) {

        Player p1;
        WhichPath space1;

        /* Constructor: WhichPath ()
        One WhichPath object is created. The indices for this test script are dummy
        values, as their values will not affect the tested methods in the script.
        */
        space1 = new WhichPath(-1, 1, 2);

        /* A Player object is created to test the methods of the WhichPath object.
        */
        p1 = new Player("Sample Name");

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, int path)
       Test case 1: The execute() method of space1 is called, and p1 chooses the Change Career Path.
       Expected output: The nextIndex attribute of space1 will be 2 */
        System.out.println ("Test case 1: The execute() method of space1 is called, and p1 chooses the Change Career Path.");

        System.out.println("Current next index = " + space1.getActualNextIndex());
        space1.execute(p1, 3);
        System.out.println("New next index = " + space1.getActualNextIndex());

        /* Method: execute(Player currPlayer, int path)
       Test case 2: The execute() method of space1 is called, and p1 chooses the Normal Path.
       Expected output: The nextIndex attribute of space1 will be 1 */
        System.out.println ("Test case 2: The execute() method of space1 is called, and p1 chooses the Normal Path.");

        System.out.println("Current next index = " + space1.getActualNextIndex());
        space1.execute(p1, 0);
        System.out.println("New next index = " + space1.getActualNextIndex());

        /* Method: execute(Player currPlayer, int path)
       Test case 3: The execute() method of space1 is called, and p1 chooses the Start A Family Path.
       Expected output: The nextIndex attribute of space1 will be 2 */
        System.out.println ("Test case 3: The execute() method of space1 is called, and p1 chooses the Start A Family Path.");

        System.out.println("Current next index = " + space1.getActualNextIndex());
        space1.execute(p1, 4);
        System.out.println("New next index = " + space1.getActualNextIndex());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo(Player currPlayer)
        Test case: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on a Which Path space.
        Choose between the two paths."
        */
        System.out.println("Test case: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
