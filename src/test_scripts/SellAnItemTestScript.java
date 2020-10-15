

import cards.SalaryCard;
import cards.action_cards.collect_from_bank.SellAnItem;
import cards.career_cards.Accountant;
import core.Bank;
import core.Player;

/**
 * Test script for <code>SellAnItem</code> class
 */
public class SellAnItemTestScript {
    public static void main(String[] args) {

        SellAnItem c1;
        SellAnItem c2;
        SellAnItem c3;

        Player p1;

        Accountant career1;

        SalaryCard salary1;

        Bank b;

        /* Player, Accountant, SalaryCard, and Bank objects are created to
         *  test the SellAnItem object methods. */
        p1 = new Player("Player One");
        career1 = new Accountant();
        salary1 = new SalaryCard();

        b = new Bank(3);

        /* The player is assigned a career and salary (for testing purposes) by keeping the
         *  created career and salary cards. */
        p1.keepCareerCard(career1);
        p1.keepSalaryCard(salary1);

        /* Constructor: SellAnItem ()
         *  Three SellAnItem objects are created (to test the random generation of item prices). */
        c1 = new SellAnItem();
        c2 = new SellAnItem();
        c3 = new SellAnItem();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 1: The effect of SellAnItem is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated item price
         *  stored in c1. */
        System.out.println("Test case 1: The effect of SellAnItem is executed on p1.");

        System.out.println("Stats before SellAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c1: Item Price = " + c1.getItemPrice());

        c1.execute(p1, b);

        System.out.println("Stats after SellAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 2: The effect of SellAnItem is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated item price
         *  stored in c2. */
        System.out.println("Test case 2: The effect of SellAnItem is executed on p1.");

        System.out.println("Stats before SellAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c2: Item Price = " + c2.getItemPrice());

        c2.execute(p1, b);

        System.out.println("Stats after SellAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 3: The effect of SellAnItem is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated item price
         *  stored in c3. */
        System.out.println("Test case 3: The effect of SellAnItem is executed on p1.");

        System.out.println("Stats before SellAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c3: Item Price = " + c3.getItemPrice());

        c3.execute(p1, b);

        System.out.println("Stats after SellAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of c1 is called.
         *  Expected output: The string "You have completed a sale. Collect " + itemPrice +
         *  " from the bank.", where itemPrice indicates the randomly generated item price
         *  (used to indicate the execution of the action card in the GameMaster class). */
        System.out.println ("Test case 1: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of c2 is called.
         *  Expected output: The string "You have completed a sale. Collect " + itemPrice +
         *  " from the bank.", where itemPrice indicates the randomly generated item price
         *  (used to indicate the execution of the action card in the GameMaster class). */
        System.out.println ("Test case 2: The getInfo() method of c2 is called.");

        System.out.println (c2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of c3 is called.
         *  Expected output: The string "You have completed a sale. Collect " + itemPrice +
         *  " from the bank.", where itemPrice indicates the randomly generated item price
         *  (used to indicate the execution of the action card in the GameMaster class). */
        System.out.println ("Test case 3: The getInfo() method of c3 is called.");

        System.out.println (c3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The SellAnItem object c1 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be collected by
         *  the player from the bank. */
        System.out.println ("Test case 1: The SellAnItem c1 object is printed (using the toString() method).");

        System.out.println (c1);

        /* Method: Overridden toString()
         *  Test case 2: The SellAnItem object c2 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be collected by
         *  the player from the bank. */
        System.out.println ("Test case 2: The SellAnItem c2 object is printed (using the toString() method).");

        System.out.println (c2);

        /* Method: Overridden toString()
         *  Test case 3: The SellAnItem object c3 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be collected by
         *  the player from the bank. */
        System.out.println ("Test case 3: The SellAnItem c3 object is printed (using the toString() method).");

        System.out.println (c3);
    }
}

