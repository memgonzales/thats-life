

import cards.SalaryCard;
import cards.action_cards.pay_bank.VisitAPlace;
import cards.career_cards.Accountant;
import core.Bank;
import core.Player;

/**
 * Test script for <code>VisitAPlace</code> class
 */
public class VisitAPlaceTestScript {
    public static void main(String[] args) {

        VisitAPlace c1;
        VisitAPlace c2;
        VisitAPlace c3;

        Player p1;

        Accountant career1;

        SalaryCard salary1;

        Bank b;

        /* Player, Accountant, SalaryCard, and Bank objects are created to
         *  test the VisitAPlace object methods. */
        p1 = new Player("Player One");
        career1 = new Accountant();
        salary1 = new SalaryCard();

        b = new Bank(3);

        /* The player is assigned a career and salary (for testing purposes) by keeping the
         *  created career and salary cards. */
        p1.keepCareerCard(career1);
        p1.keepSalaryCard(salary1);

        /* Constructor: VisitAPlace ()
         *  Three VisitAPlace objects are created (to test the random generation of expenses). */
        c1 = new VisitAPlace();
        c2 = new VisitAPlace();
        c3 = new VisitAPlace();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 1: The effect of VisitAPlace is executed on p1.
         *  Expected output: The cash of p1 will decrease by the randomly generated expenses
         *  stored in c1. */
        System.out.println("Test case 1: The effect of VisitAPlace is executed on p1.");

        System.out.println("Stats before VisitAPlace execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c1: Expenses = " + c1.getAmount());

        c1.execute(p1, b);

        System.out.println("Stats after VisitAPlace execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 2: The effect of VisitAPlace is executed on p1.
         *  Expected output: The cash of p1 will decrease by the randomly generated expenses
         *  stored in c2. */
        System.out.println("Test case 1: The effect of VisitAPlace is executed on p1.");

        System.out.println("Stats before VisitAPlace execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c2: Expenses = " + c2.getAmount());

        c2.execute(p1, b);

        System.out.println("Stats after VisitAPlace execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
         *  Test case 3: The effect of VisitAPlace is executed on p1.
         *  Expected output: The cash of p1 will decrease by the randomly generated expenses
         *  stored in c3. */
        System.out.println("Test case 1: The effect of VisitAPlace is executed on p1.");

        System.out.println("Stats before VisitAPlace execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("c3: Expenses = " + c3.getAmount());

        c3.execute(p1, b);

        System.out.println("Stats after VisitAPlace execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of c1 is called.
         *  Expected output: The string "You decided to travel for your vacation.
         *  You spent " + getAmount() + " on expenses.", where getAmount() indicates the
         *  randomly generated expenses (used to indicate the execution of the action
         *  card in the GameMaster class). */
        System.out.println ("Test case 1: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of c2 is called.
         *  Expected output: The string "You decided to travel for your vacation.
         *  You spent " + getAmount() + " on expenses.", where getAmount() indicates the
         *  randomly generated expenses (used to indicate the execution of the action
         *  card in the GameMaster class). */
        System.out.println ("Test case 2: The getInfo() method of c2 is called.");

        System.out.println (c2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of c3 is called.
         *  Expected output: The string "You decided to travel for your vacation.
         *  You spent " + getAmount() + " on expenses.", where getAmount() indicates the
         *  randomly generated expenses (used to indicate the execution of the action
         *  card in the GameMaster class). */
        System.out.println ("Test case 3: The getInfo() method of c3 is called.");

        System.out.println (c3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The VisitAPlace object c1 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  the player to the bank. */
        System.out.println ("Test case 1: The VisitAPlace object c1 is printed (using the toString() method).");

        System.out.println (c1);

        /* Method: Overridden toString()
         *  Test case 2: The VisitAPlace object c2 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  the player to the bank. */
        System.out.println ("Test case 2: The VisitAPlace object c2 is printed (using the toString() method).");

        System.out.println (c2);

        /* Method: Overridden toString()
         *  Test case 3: The VisitAPlace object c3 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  the player to the bank. */
        System.out.println ("Test case 3: The VisitAPlace object c3 is printed (using the toString() method).");

        System.out.println (c3);
    }
}


