

import core.DiscardPile;
import core.Player;
import decks.ActionCardDeck;
import spaces.OrangeSpace;

/**
 * Test script for <code>Orange Space</code> class
 */
public class OrangeSpaceTestScript {
    public static void main(String[] args) {

        Player p1;
        ActionCardDeck d;
        OrangeSpace space1;
        DiscardPile pile;

        /* Constructor: OrangeSpace ()
        One OrangeSpace object is created. The indices for this test script are dummy
        values, as their values will not affect the tested methods in the script.
        */
        space1 = new OrangeSpace(-1, -1);

        /* Player, ActionCardDeck, and DiscardPile objects are created to test the
        methods of the OrangeSpace object.
        */
        p1 = new Player("Sample Name");
        d = new ActionCardDeck();
        pile = new DiscardPile();
        System.out.println("drawActionCard()");

        /* Method: drawActionCard(Player currPlayer, ActionCardDeck d)
       Test case: The drawActionCard() method of space1 is called.
       Expected output: A drawn action card
        */
        System.out.println ("Test case: The drawActionCard() method of space1 is called.");

        System.out.println(space1.drawActionCard(p1, d, pile));

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo(Player currPlayer)
        Test case: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on an orange space.
        Draw an action card."
        */
        System.out.println("Test case: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
