

import core.Bank;
import core.Player;
import decks.CareerCardDeck;
import decks.HouseCardDeck;
import decks.SalaryCardDeck;
import spaces.EndSpace;

/**
 * Test script for <code>End Space</code> class
 */
public class EndSpaceTestScript {
    public static void main(String[] args) {

        Player p1;
        CareerCardDeck c;
        SalaryCardDeck s;
        HouseCardDeck h;
        Bank b;
        EndSpace space1;

        /* Constructor: EndSpace ()
        One EndSpace object is created.
        */
        space1 = new EndSpace();

        /* Player, CareerCardDeck, SalaryCardDeck, HouseCardDeck, and Bank
        objects are created to test the methods of the EndSpace object.
        */
        p1 = new Player("Sample Name");
        c = new CareerCardDeck();
        s = new SalaryCardDeck();
        h = new HouseCardDeck();
        b = new Bank(2);

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Bank b, int orderRetirement, CareerCardDeck careerDeck, SalaryCardDeck salaryDeck, HouseCardDeck houseDeck)
       Test case: The execute() method of space1 is called.
       Expected output: The cash of p1 increases by $100000 (indicating that they received
       retirement benefits)
        */
        System.out.println("Test case: The execute() method of space1 is called.");

        System.out.println("p1: Cash = " + p1.getCash());
        space1.execute(p1, b, 1, c, s, h);
        System.out.println("p1: New Cash = " + p1.getCash());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo(Player currPlayer)
        Test case: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on the end space.
        Congratulations! You are now retired."
        */
        System.out.println("Test case: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
