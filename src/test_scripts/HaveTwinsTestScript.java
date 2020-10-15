

import core.Bank;
import core.Player;
import spaces.magenta_spaces.GetMarried;
import spaces.magenta_spaces.HaveTwins;

import java.util.ArrayList;

/**
 * Test script for <code>Have Twins</code> class
 */
public class HaveTwinsTestScript {
    public static void main(String[] args) {

        Player p1;
        Player p2;
        Player p3;
        HaveTwins space1;
        GetMarried marry;
        Bank b;

        /* Constructor: HaveTwins ()
        One HaveTwins object is created. The indices for this test script are dummy
        values, as their values will not affect the tested methods in the script.
        */
        space1 = new HaveTwins(-1, -1);

        /* Player, Bank, and GetMarried objects are created to test the methods of the
        HaveTwins object.
        */
        p1 = new Player("Sample Name");
        p2 = new Player("Player 2");
        p3 = new Player("Player 3");
        b = new Bank(3);
        marry = new GetMarried(-1, -1);

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, ArrayList<Player> players, Bank b)
        Test case 1: The execute() method of space1 is called, with p1 (unmarried) passed as a parameter.
        Expected output: No change.
        */
        System.out.println ("Test case 1: The execute() method of space1 is called, with p1 (unmarried) passed as a parameter.");

        ArrayList<Player> players;
        players = new ArrayList<>();
        players.add(p2);
        players.add(p3);

        System.out.println("p1: Status = " + p1.getIsMarried());
        System.out.println("p1: Children = " + p1.getNumChildren());
        space1.execute(p1, players, b);
        System.out.println("p1: New Children = " + p1.getNumChildren());

        /* Method: execute(Player currPlayer, ArrayList<Player> players, Bank b)
        Test case 2: The execute() method of space1 is called, with p1 (married) passed as a parameter.
        Expected output: p1 receives 10000 from every other player.
        */
        System.out.println ("Test case 2: The execute() method of space1 is called, with p1 (married) passed as a parameter.");

        marry.execute(p1, 1, players, b);

        System.out.println("p1: Status = " + p1.getIsMarried());
        System.out.println("p1: Children = " + p1.getNumChildren());
        System.out.println("p1: Cash = " + p1.getCash());
        space1.execute(p1, players, b);
        System.out.println("p1: New Children = " + p1.getNumChildren());
        System.out.println("p1: New Cash = " + p1.getCash());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo(Player currPlayer)
        Test case 1: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on a Have Twins space.
        Receive [gift amount * 2] from every other player as a gift."
        */
        System.out.println("Test case 1: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));

        /* Method: getInfo(Player currPlayer)
        Test case 2: The getInfo() method of space1 is called with p2 passed as
        the parameter.
        Expected output: The string "[Player name] is not married."
        */
        System.out.println("Test case 2: The getInfo() method of space1 is called with p2 passed as the parameter.");

        System.out.println(space1.getInfo(p2));
    }
}
