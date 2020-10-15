

import cards.SalaryCard;
import cards.blue_cards.SalaryTaxDue;
import cards.career_cards.Accountant;
import cards.career_cards.Athlete;
import cards.career_cards.Lawyer;
import core.Bank;
import core.Player;

/**
 * Test script for <code>SalaryTaxDue</code> class
 */
public class SalaryTaxDueTestScript {
    public static void main(String[] args) {

        SalaryTaxDue c1;

        Player p1;
        Player p2;

        Lawyer career1;
        Accountant career2;
        Athlete career3;

        SalaryCard salary1;
        SalaryCard salary2;

        Bank b;

        /* Player, CareerCard, SalaryCard, and Bank objects are created to
         *  test the SalaryTaxDue object methods. */
        p1 = new Player("Player One");
        p2 = new Player("Player Two");
        career1 = new Lawyer();
        career2 = new Accountant();
        career3 = new Athlete();
        salary1 = new SalaryCard();
        salary2 = new SalaryCard();

        b = new Bank(2);

        /* Constructor: SalaryTaxDue ()
         *  One SalaryTaxDue object is created. */
        c1 = new SalaryTaxDue();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b)
         *  Test case 1: The effect of SalaryTaxDue is executed on p1, and p2 is the player
         *  who has the Accountant career.
         *  Expected output: The cash of p1 will decrease by their current tax due
         *  and the cash of p2 will increase by the same amount. */
        System.out.println("Test case 1: The effect of SalaryTaxDue is executed on p1, and p2 is the player who has the Accountant career.");

        p1.keepCareerCard(career1);
        p1.keepSalaryCard(salary1);
        p2.keepCareerCard(career2);
        p2.keepSalaryCard(salary2);

        System.out.println("Stats before SalaryTaxDue execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Tax Due = " + p1.getTaxDue());
        System.out.println("p2: Cash = " + p2.getCash());

        c1.execute(p1, p2, b);

        System.out.println("Stats after SalaryTaxDue execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b)
         *  Test case 2: The effect of SalaryTaxDue is executed on p1, and p1 is the player
         *  who has the Accountant career.
         *  Expected output: The cash of p1 will increase by 15000. */
        System.out.println("Test case 2: The effect of SalaryTaxDue is executed on p1, and p1 is the player who has the Accountant career.");

        p1.keepCareerCard(career2);
        p2.keepCareerCard(career1);

        System.out.println("Stats before SalaryTaxDue execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        c1.execute(p1, p1, b);

        System.out.println("Stats after SalaryTaxDue execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b)
         *  Test case 3: The effect of SalaryTaxDue is executed on p1, and no player has the
         *  Accountant career.
         *  Expected output: The cash of p1 will decrease by their current tax due. */
        System.out.println("Test case 3: The effect of SalaryTaxDue is executed on p1, and no player has the Accountant career.");

        p1.keepCareerCard(career3);

        System.out.println("Stats before SalaryTaxDue execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Tax Due = " + p1.getTaxDue());

        c1.execute(p1, null, b);

        System.out.println("Stats after SalaryTaxDue execution:");
        System.out.println("p1: Cash = " + p1.getCash());


        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case: The getInfo() method of c1 is called.
         *  Expected output: The string "You drew a salary tax due card." */
        System.out.println ("Test case: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        System.out.println();
        System.out.println("getInfoBank()");

        /* Method: getInfoBank()
         *  Test case: The getInfoBank() method of c1 is called.
         *  Expected output: The string "You drew a salary tax due card.
         *  Pay your current tax due to the bank. */
        System.out.println ("Test case: The getInfoBank() method of c1 is called.");

        System.out.println (c1.getInfoBank());

        System.out.println();
        System.out.println("getInfoMatch()");

        /* Method: getInfoMatch()
         *  Test case: The getInfoMatch() method of c1 is called.
         *  Expected output: The string "You drew a salary tax due card.
         *  Receive 15000 as an accountant." */
        System.out.println ("Test case: The getInfoMatch() method of c1 is called.");

        System.out.println (c1.getInfoMatch());

        System.out.println();
        System.out.println("getInfoOtherPlayer()");

        /* Method: getInfoOtherPlayer()
         *  Test case: The getInfoOtherPlayer() method of c1 is called.
         *  Expected output: The string "You drew a salary tax due card.
         *  Pay your current tax due to the accountant." */
        System.out.println ("Test case: The getInfoOtherPlayer() method of c1 is called.");

        System.out.println (c1.getInfoOtherPlayer());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case: The SalaryTaxDue object c1 is printed (using the toString() method).
         *  Expected output: The name and career match of the card and the possible amounts
         *  to be paid or received by the player. */
        System.out.println ("Test case: The SalaryTaxDue object c1 is printed (using the toString() method).");

        System.out.println (c1);
    }
}

