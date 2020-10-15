

import cards.HouseCard;
import cards.SalaryCard;
import cards.career_cards.Accountant;
import core.Bank;
import core.Player;
import decks.HouseCardDeck;
import spaces.magenta_spaces.BuyAHouse;

import java.util.ArrayList;

/**
 * Test script for <code>Buy A House</code> class
 */
public class BuyAHouseTestScript {
    public static void main(String[] args) {

        Player p1;
        BuyAHouse space1;
        HouseCardDeck d;
        Bank b;
        SalaryCard s1;
        Accountant c1;

        /* Constructor: BuyAHouse ()
        One BuyAHouse object is created. The indices for this test script are dummy
        values, as their values will not affect the tested methods in the script.
        */
        space1 = new BuyAHouse(-1, -1);

        /* Player, Bank, and HouseCardDeck objects are created to
        test the methods of the BuyAHouse object.
        */
        p1 = new Player("Sample Name");
        b = new Bank(2);
        d = new HouseCardDeck();
        c1 = new Accountant();
        s1 = new SalaryCard();

        System.out.println("getHouseCards()");

        /* Method: getHouseCards(Player currPlayer, HouseCardDeck d)
        Test case: The getHouseCards() method of space1 is called.
        Expected output: The list of cards available in the house card deck. */
        System.out.println ("The getHouseCards() method of space1 is called.");

        p1.keepCareerCard(c1);
        p1.keepSalaryCard(s1);

        ArrayList<HouseCard> houses;
        houses = space1.getHouseCards(p1, d);

        for (int i = 0; i < houses.size(); i++)
            System.out.println(houses.get(i));

        System.out.println();
        System.out.println("execute()");

        /* Method: execute(Player currPlayer, ArrayList<HouseCard> houseCards, HouseCardDeck d, int index, Bank b)
       Test case 1: The execute() method of space1 is called, and p1 chooses to keep the
       first house card in the list.
       Expected output: p1 keeps the first house card. */
        System.out.println ("Test case 1: The execute() method of space1 is called, and p1 chooses to keep the first house card in the list.");

        System.out.println("p1: House = " + p1.getHouseCard());
        space1.execute(p1, houses, d, 0, b);
        System.out.println("p1: New House = " + p1.getHouseCard());

        /* Method: execute(Player currPlayer, ArrayList<HouseCard> houseCards, HouseCardDeck d, int index, Bank b)
       Test case 2: The execute() method of space1 is called, and p1 chooses to keep the
       second house card in the list.
       Expected output: p1 has a new house card. */
        System.out.println ("Test case 2: The execute() method of space1 is called, and p1 chooses to keep the second house card in the list.");

        System.out.println("p1: House = " + p1.getHouseCard());
        space1.execute(p1, houses, d, 1, b);
        System.out.println("p1: New House = " + p1.getHouseCard());

        /* Method: execute(Player currPlayer, ArrayList<HouseCard> houseCards, HouseCardDeck d, int index, Bank b)
       Test case 3: The execute() method of space1 is called, and p1 chooses to keep the
       third house card in the list.
       Expected output: p1 has a new house card. */
        System.out.println ("Test case 3: The execute() method of space1 is called, and p1 chooses to keep the third house card in the list.");

        System.out.println("p1: House = " + p1.getHouseCard());
        space1.execute(p1, houses, d, 2, b);
        System.out.println("p1: New House = " + p1.getHouseCard());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo(Player currPlayer)
        Test case: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on a Buy A House space.
        Choose a house to buy from the available options."
        */
        System.out.println("Test case: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
