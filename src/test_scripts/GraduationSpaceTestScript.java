

import core.Player;
import spaces.magenta_spaces.GraduationSpace;

/**
 * Test script for <code>Graduation Space</code> class
 */
public class GraduationSpaceTestScript {
    public static void main(String[] args) {

        Player p1;
        GraduationSpace space1;

        /* Constructor: GraduationSpace ()
        One GraduationSpace object is created. The indices for this test script are dummy
        values, as their values will not affect the tested methods in the script.
        */
        space1 = new GraduationSpace(-1, -1);

        /* A Player object is created to test the methods of the GraduationSpace object. */
        p1 = new Player("Sample Name");

        System.out.println("execute()");

        /* Method: execute(Player currPlayer)
        Test case: The execute() method of space1 is called, with p1 passed as a parameter.
        Expected output: p1 gets a degree.
        */
        System.out.println ("Test case: The execute() method of space1 is called, with p1 passed as a parameter.");

        System.out.println("p1: Degree = " + p1.getHasDegree());
        space1.execute(p1);
        System.out.println("p1: New Degree = " + p1.getHasDegree());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo(Player currPlayer)
        Test case: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on a Graduation space.
        You now have a college degree."
        */
        System.out.println("Test case: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
