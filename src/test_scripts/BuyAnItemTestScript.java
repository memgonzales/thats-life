

import cards.SalaryCard;
import cards.action_cards.pay_bank.BuyAnItem;
import cards.career_cards.Accountant;
import core.Bank;
import core.Player;

/**
 * Test script for <code>BuyAnItem</code> class
 */
public class BuyAnItemTestScript {
    public static void main(String[] args) {

        BuyAnItem c1;
        BuyAnItem c2;
        BuyAnItem c3;

        Player p1;

        Accountant career1;

        SalaryCard salary1;

        Bank b;

        /* Player, Accountant, SalaryCard, and Bank objects are created to
         *  test the BuyAnItem object methods. */
        p1 = new Player("Player One");
        career1 = new Accountant();
        salary1 = new SalaryCard();

        b = new Bank(3);

        /* The player is assigned a career and salary (for testing purposes) by keeping the
         *  created career and salary cards. */
        p1.keepCareerCard(career1);
        p1.keepSalaryCard(salary1);

        /* Constructor: BuyAnItem ()
         *  Three BuyAnItem objects are created (to test the random generation of item prices). */
        c1 = new BuyAnItem();
        c2 = new BuyAnItem();
        c3 = new BuyAnItem();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 1: The effect of BuyAnItem is executed on p1.
         *  Expected output: The cash of p1 will decrease by the randomly generated item price
         *  stored in c1. */
        System.out.println("Test case 1: The effect of BuyAnItem is executed on p1.");

        System.out.println("Stats before BuyAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c1: Item Price = " + c1.getAmount());

        c1.execute(p1, b);

        System.out.println("Stats after BuyAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 2: The effect of BuyAnItem is executed on p1.
         *  Expected output: The cash of p1 will decrease by the randomly generated item price
         *  stored in c2. */
        System.out.println("Test case 2: The effect of BuyAnItem is executed on p1.");

        System.out.println("Stats before BuyAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c2: Item Price = " + c2.getAmount());

        c2.execute(p1, b);

        System.out.println("Stats after BuyAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 3: The effect of BuyAnItem is executed on p1.
         *  Expected output: The cash of p1 will decrease by the randomly generated item price
         *  stored in c3. */
        System.out.println("Test case 3: The effect of BuyAnItem is executed on p1.");

        System.out.println("Stats before BuyAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c3: Item Price = " + c3.getAmount());

        c3.execute(p1, b);

        System.out.println("Stats after BuyAnItem execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of c1 is called.
         *  Expected output: The string "You have bought an item for " + getAmount() +
         *  ".", where getAmount indicates the randomly generated item price
         *  (used to indicate the execution of the action card in the GameMaster class). */
        System.out.println ("Test case 1: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of c2 is called.
         *  Expected output: The string "You have bought an item for " + getAmount() +
         *  ".", where getAmount indicates the randomly generated item price
         *  (used to indicate the execution of the action card in the GameMaster class). */
        System.out.println ("Test case 2: The getInfo() method of c2 is called.");

        System.out.println (c2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of c3 is called.
         *  Expected output: The string "You have bought an item for " + getAmount() +
         *  ".", where getAmount indicates the randomly generated item price
         * (used to indicate the execution of the action card in the GameMaster class). */
        System.out.println ("Test case 3: The getInfo() method of c3 is called.");

        System.out.println (c3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The BuyAnItem object c1 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  the player to the bank. */
        System.out.println ("Test case 1: The BuyAnItem object c1 is printed (using the toString() method).");

        System.out.println (c1);

        /* Method: Overridden toString()
         *  Test case 2: The BuyAnItem object c2 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  the player to the bank. */
        System.out.println ("Test case 2: The BuyAnItem object c2 is printed (using the toString() method).");

        System.out.println (c2);

        /* Method: Overridden toString()
         *  Test case 3: The BuyAnItem object c3 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  the player to the bank. */
        System.out.println ("Test case 3: The BuyAnItem object c3 is printed (using the toString() method).");

        System.out.println (c3);
    }
}

