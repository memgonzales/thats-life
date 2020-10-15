

import cards.SalaryCard;
import cards.action_cards.collect_from_bank.TaxRefund;
import cards.career_cards.Accountant;
import cards.career_cards.Athlete;
import cards.career_cards.ComputerConsultant;
import core.Bank;
import core.Player;

/**
 * Test script for <code>TaxRefund</code> class
 */
public class TaxRefundTestScript {
    public static void main(String[] args) {

        TaxRefund c1;

        Player p1;
        Player p2;
        Player p3;

        Accountant career1;
        Athlete career2;
        ComputerConsultant career3;

        SalaryCard salary1;
        SalaryCard salary2;
        SalaryCard salary3;

        Bank b;

        /* Player, CareerCard, SalaryCard, and Bank objects are created to
         *  test the BonusPayday object methods. */
        p1 = new Player("Player One");
        career1 = new Accountant();
        salary1 = new SalaryCard();

        p2 = new Player("Player Two");
        career2 = new Athlete();
        salary2 = new SalaryCard();

        p3 = new Player("Player Three");
        career3 = new ComputerConsultant();
        salary3 = new SalaryCard();

        b = new Bank(3);

        /* The three players are assigned careers and salaries (for testing purposes) by keeping the
         *  created career and salary cards. */
        p1.keepCareerCard(career1);
        p1.keepSalaryCard(salary1);

        p2.keepCareerCard(career2);
        p2.keepSalaryCard(salary2);

        p3.keepCareerCard(career3);
        p3.keepSalaryCard(salary3);

        /* Constructor: TaxRefund ()
         *  A new TaxRefund object is created. */
        c1 = new TaxRefund();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 1: The effect of TaxRefund is executed on p1.
         *  Expected output: The cash of p1 will increase by their current tax due. */
        System.out.println("Test case 1: The effect of TaxRefund is executed on p1.");

        System.out.println("Stats before TaxRefund execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Tax Due = " + p1.getTaxDue());

        c1.execute(p1, b);

        System.out.println("Stats after TaxRefund execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 2: The effect of TaxRefund is executed on p2.
         *  Expected output: The cash of p2 will increase by their current tax due. */
        System.out.println("Test case 2: The effect of TaxRefund is executed on p2.");

        System.out.println("Stats before TaxRefund execution:");
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Tax Due = " + p2.getTaxDue());

        c1.execute(p2, b);

        System.out.println("Stats after TaxRefund execution:");
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 3: The effect of TaxRefund is executed on p3.
         *  Expected output: The cash of p3 will increase by their current tax due. */
        System.out.println("Test case 3: The effect of TaxRefund is executed on p3.");

        System.out.println("Stats before TaxRefund execution:");
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Tax Due = " + p3.getTaxDue());

        c1.execute(p3, b);

        System.out.println("Stats after TaxRefund execution:");
        System.out.println("p3: Cash = " + p3.getCash());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case: The getInfo() method of c1 is called.
         *  Expected output: The string "You received a tax refund! Collect your
         *  tax due from the bank." (used to indicate the execution of the action
         *  card in the GameMaster class). */
        System.out.println ("Test case: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case: The TaxRefund object is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be collected by
         *  the player from the bank. */
        System.out.println ("Test case: The TaxRefund object is printed (using the toString() method).");

        System.out.println (c1);
    }
}
