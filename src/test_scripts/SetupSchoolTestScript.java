

import cards.SalaryCard;
import cards.action_cards.collect_from_bank.SetupSchool;
import cards.career_cards.Accountant;
import core.Bank;
import core.Player;

/**
 * Test script for <code>SetupSchool</code> class
 */
public class SetupSchoolTestScript {
    public static void main(String[] args) {

        SetupSchool c1;
        SetupSchool c2;
        SetupSchool c3;

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

        /* Constructor: SetupSchool ()
         *  Three SetupSchool objects are created (to test the random generation of charity benefits). */
        c1 = new SetupSchool();
        c2 = new SetupSchool();
        c3 = new SetupSchool();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 1: The effect of SetupSchool is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated charity benefit
         *  stored in c1. */
        System.out.println("Test case 1: The effect of SetupSchool is executed on p1.");

        System.out.println("Stats before SetupSchool execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c1: Charity Benefit = " + c1.getCharityBenefit());

        c1.execute(p1, b);

        System.out.println("Stats after SetupSchool execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 2: The effect of SetupSchool is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated charity benefit
         *  stored in c2. */
        System.out.println("Test case 2: The effect of SetupSchool is executed on p1.");

        System.out.println("Stats before SetupSchool execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c2: Charity Benefit = " + c2.getCharityBenefit());

        c2.execute(p1, b);

        System.out.println("Stats after SetupSchool execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 3: The effect of SetupSchool is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated charity benefit
         *  stored in c3. */
        System.out.println("Test case 3: The effect of SetupSchool is executed on p1.");

        System.out.println("Stats before SetupSchool execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c3: Charity Benefit = " + c3.getCharityBenefit());

        c3.execute(p1, b);

        System.out.println("Stats after SetupSchool execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of c1 is called.
         *  Expected output: The string "You received charity benefits for setting up
         *  a school. Collect " + charityBenefit + " from the bank.", where charityBenefit
         *  indicates the randomly generated charity benefit (used to indicate the
         *  execution of the action card in the GameMaster class). */
        System.out.println ("Test case 1: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of c2 is called.
         *  Expected output: The string "You received charity benefits for setting up
         *  a school. Collect " + charityBenefit + " from the bank.", where charityBenefit
         *  indicates the randomly generated charity benefit (used to indicate the
         *  execution of the action card in the GameMaster class). */
        System.out.println ("Test case 2: The getInfo() method of c2 is called.");

        System.out.println (c2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of c3 is called.
         *  Expected output: The string "You received charity benefits for setting up
         *  a school. Collect " + charityBenefit + " from the bank.", where charityBenefit
         *  indicates the randomly generated charity benefit (used to indicate the
         *  execution of the action card in the GameMaster class). */
        System.out.println ("Test case 3: The getInfo() method of c3 is called.");

        System.out.println (c3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The SetupSchool object c1 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be collected by
         *  the player from the bank. */
        System.out.println ("Test case 1: The SetupSchool object c1 is printed (using the toString() method).");

        System.out.println (c1);

        /* Method: Overridden toString()
         *  Test case 2: The SetupSchool object c2 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be collected by
         *  the player from the bank. */
        System.out.println ("Test case 2: The SetupSchool object c2 is printed (using the toString() method).");

        System.out.println (c2);

        /* Method: Overridden toString()
         *  Test case 3: The SetupSchool object c3 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be collected by
         *  the player from the bank. */
        System.out.println ("Test case 3: The SetupSchool object c3 is printed (using the toString() method).");

        System.out.println (c3);
    }
}

