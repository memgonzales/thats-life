

import cards.SalaryCard;
import cards.action_cards.collect_from_bank.WriteABook;
import cards.career_cards.Accountant;
import core.Bank;
import core.Player;

/**
 * Test script for <code>WriteABook</code> class
 */
public class WriteABookTestScript {
    public static void main(String[] args) {

        WriteABook c1;
        WriteABook c2;
        WriteABook c3;

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

        /* Constructor: WriteABook ()
         *  Three WriteABook objects are created (to test the random generation of book payments). */
        c1 = new WriteABook();
        c2 = new WriteABook();
        c3 = new WriteABook();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 1: The effect of WriteABook is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated book payment
         *  stored in c1. */
        System.out.println("Test case 1: The effect of WriteABook is executed on p1.");

        System.out.println("Stats before WriteABook execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c1: Book Payment = " + c1.getBookPayment());

        c1.execute(p1, b);

        System.out.println("Stats after WriteABook execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 2: The effect of WriteABook is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated book payment
         *  stored in c2. */
        System.out.println("Test case 2: The effect of WriteABook is executed on p1.");

        System.out.println("Stats before WriteABook execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c2: Book Payment = " + c2.getBookPayment());

        c2.execute(p1, b);

        System.out.println("Stats after WriteABook execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 3: The effect of WriteABook is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated book payment
         *  stored in c3. */
        System.out.println("Test case 3: The effect of WriteABook is executed on p1.");

        System.out.println("Stats before WriteABook execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c3: Book Payment = " + c3.getBookPayment());

        c3.execute(p1, b);

        System.out.println("Stats after WriteABook execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of c1 is called.
         *  Expected output: The string "Your book turned out to be a bestseller!
         *  Collect " + bookPayment + " from the bank.", where book payment
         *  indicates the randomly generated book payment (used to indicate the
         *  execution of the action card in the GameMaster class). */
        System.out.println ("Test case 1: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of c2 is called.
         *  Expected output: The string "Your book turned out to be a bestseller!
         *  Collect " + bookPayment + " from the bank.", where book payment
         *  indicates the randomly generated book payment (used to indicate the
         *  execution of the action card in the GameMaster class). */
        System.out.println ("Test case 2: The getInfo() method of c2 is called.");

        System.out.println (c2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of c3 is called.
         *  Expected output: The string "Your book turned out to be a bestseller!
         *  Collect " + bookPayment + " from the bank.", where book payment
         *  indicates the randomly generated book payment (used to indicate the
         *  execution of the action card in the GameMaster class). */
        System.out.println ("Test case 3: The getInfo() method of c3 is called.");

        System.out.println (c3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The WriteABook object c1 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be collected by
         *  the player from the bank. */
        System.out.println ("Test case 1: The WriteABook object c1 is printed (using the toString() method).");

        System.out.println (c1);

        /* Method: Overridden toString()
         *  Test case 2: The WriteABook object c2 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be collected by
         *  the player from the bank. */
        System.out.println ("Test case 2: The WriteABook object c2 is printed (using the toString() method).");

        System.out.println (c2);

        /* Method: Overridden toString()
         *  Test case 3: The WriteABook object c3 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be collected by
         *  the player from the bank. */
        System.out.println ("Test case 3: The WriteABook object c3 is printed (using the toString() method).");

        System.out.println (c3);
    }
}

