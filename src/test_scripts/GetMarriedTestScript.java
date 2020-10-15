

import core.Bank;
import core.NumberWheel;
import core.Player;
import spaces.magenta_spaces.GetMarried;

import java.util.ArrayList;

/**
 * Test script for <code>Get Married</code> class
 */
public class GetMarriedTestScript {
    public static void main(String[] args) {

        Player p1;
        Player p2;
        Player p3;
        GetMarried space1;
        Bank b;
        NumberWheel wheel;

        /* Constructor: GetMarried ()
        One GetMarried object is created. The indices for this test script are dummy
        values, as their values will not affect the tested methods in the script.
        */
        space1 = new GetMarried(-1, -1);

        /* Player and Bank objects are created to test the
        methods of the GetMarried object.
        */
        p1 = new Player("Sample Name");
        p2 = new Player("Player 2");
        p3 = new Player("Player 3");
        b = new Bank(3);
        wheel = new NumberWheel();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, int randNum, ArrayList<Player> players, Bank b)
        Test case 1: The execute() method of space1 is called, with an odd random number passed.
        Expected output: The current player p1 receives 5000 from every other player.
        */
        System.out.println ("Test case 1: The execute() method of space1 is called, with an odd random number passed.");

        ArrayList<Player> players;
        players = new ArrayList<>();
        players.add(p2);
        players.add(p3);

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Status = " + p1.getIsMarried());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p3: Cash = " + p3.getCash());
        space1.execute(p1, 1, players, b);
        System.out.println("p1: New Cash = " + p1.getCash());
        System.out.println("p1: Status = " + p1.getIsMarried());
        System.out.println("p2: New Cash = " + p2.getCash());
        System.out.println("p3: New Cash = " + p3.getCash());

        /* Method: execute(Player currPlayer, int randNum, ArrayList<Player> players, Bank b)
        Test case 2: The execute() method of space1 is called, with an even random number passed.
        Expected output: The current player p2 receives 10000 from every other player.
        */
        System.out.println ("Test case 2: The execute() method of space1 is called, with an even random number passed.");

        players = new ArrayList<>();
        players.add(p1);
        players.add(p3);

        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Status = " + p2.getIsMarried());
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p3: Cash = " + p3.getCash());
        space1.execute(p2, 2, players, b);
        System.out.println("p2: New Cash = " + p2.getCash());
        System.out.println("p2: Status = " + p2.getIsMarried());
        System.out.println("p1: New Cash = " + p1.getCash());
        System.out.println("p3: New Cash = " + p3.getCash());

        /* Method: execute(Player currPlayer, int randNum, ArrayList<Player> players, Bank b)
        Test case 3: The execute() method of space1 is called, with p1 already married.
        Expected output: No change.
        */
        System.out.println ("Test case 3: The execute() method of space1 is called, with p1 already married.");

        players = new ArrayList<>();
        players.add(p2);
        players.add(p3);

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Status = " + p1.getIsMarried());
        space1.execute(p1, 2, players, b);
        System.out.println("p1: New Cash = " + p1.getCash());
        System.out.println("p1: Status = " + p1.getIsMarried());

        System.out.println();
        System.out.println("spinWheel()");

        /* Method: spinWheel(NumberWheel w, Player currPlayer)
       Test case 1: The spinWheel() method of space1 is called.
       Expected output: A randomly generated number between 1 and 10 inclusive. */
        System.out.println ("Test case 1: The spinWheel() method of space1 is called.");

        System.out.println(space1.spinWheel(wheel, p1));

        /* Method: spinWheel(NumberWheel w, Player currPlayer)
       Test case 2: The spinWheel() method of space1 is called a second time.
       Expected output: A randomly generated number between 1 and 10 inclusive. */
        System.out.println ("Test case 2: The spinWheel() method of space1 is called a second time.");

        System.out.println(space1.spinWheel(wheel, p1));

        /* Method: spinWheel(NumberWheel w, Player currPlayer)
       Test case 3: The spinWheel() method of space1 is called a third time.
       Expected output: A randomly generated number between 1 and 10 inclusive. */
        System.out.println ("Test case 3: The spinWheel() method of space1 is called a third time.");

        System.out.println(space1.spinWheel(wheel, p1));

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo(Player currPlayer)
        Test case 1: The getInfo() method of space1 is called with p3 passed as
        the parameter.
        Expected output: The string "[Player name], you are on a Get Married space.
        Spin the wheel to determine the amount of your wedding gifts."
        */
        System.out.println("Test case 1: The getInfo() method of space1 is called with p3 passed as the parameter.");

        System.out.println(space1.getInfo(p3));

        /* Method: getInfo(Player currPlayer)
        Test case 2: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name] is already married."
        */
        System.out.println("Test case 1: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));


        System.out.println();
        System.out.println("getInfoDisplay()");

        /* Method: getInfoDisplay(Player currPlayer)
        Test case 1: The getInfoDisplay() method of space1 is called with p3 passed as
        the parameter.
        Expected output: The string "[Player name], you are on a Get Married space.
        Spin the wheel to determine the amount of your wedding gifts."
        */
        System.out.println("Test case 1: The getInfoDisplay() method of space1 is called with p3 passed as the parameter.");

        System.out.println(space1.getInfo(p3));

        /* Method: getInfoDisplay(Player currPlayer)
        Test case 2: The getInfoDisplay() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name] is already married."
        */
        System.out.println("Test case 2: The getInfoDisplay() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
