

import core.Player;
import decks.BlueCardDeck;
import spaces.BlueSpace;

/**
 * Test script for <code>Blue Space</code> class
 */
public class BlueSpaceTestScript {
    public static void main(String[] args) {

        Player p1;
        BlueCardDeck d;
        BlueSpace space1;

        /* Constructor: BlueSpace ()
        One BlueSpace object is created. The indices for this test script are dummy
        values, as their values will not affect the tested methods in the script.
        */
        space1 = new BlueSpace(-1, -1);

        /* Player and BlueCardDeck objects are created to test the methods of the
        BlueSpace object.
        */
        p1 = new Player("Sample Name");
        d = new BlueCardDeck();
        System.out.println("drawBlueCard()");

        /* Method: drawBlueCard(Player currPlayer, BlueCardDeck d)
       Test case: The drawBlueCard() method of space1 is called.
       Expected output: A drawn blue card
        */
        System.out.println ("Test case: The drawBlueCard() method of space1 is called.");

        System.out.println(space1.drawBlueCard(p1, d));

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo(Player currPlayer)
        Test case: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on a blue space. Draw a blue card."
        */
        System.out.println("Test case: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
