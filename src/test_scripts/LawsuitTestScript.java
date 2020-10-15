

import cards.SalaryCard;
import cards.action_cards.pay_player.Lawsuit;
import cards.career_cards.Accountant;
import cards.career_cards.Athlete;
import core.Bank;
import core.Player;

/**
 * Test script for <code>Lawsuit</code> class
 */
public class LawsuitTestScript {
    public static void main(String[] args) {

        Lawsuit c1;
        Lawsuit c2;
        Lawsuit c3;

        Player p1;
        Player p2;

        Accountant career1;
        Athlete career2;

        SalaryCard salary1;
        SalaryCard salary2;

        Bank b;

        /* Player, CareerCard, SalaryCard, and Bank objects are created to
         *  test the FileALawsuit object methods. */
        p1 = new Player("Player One");
        career1 = new Accountant();
        salary1 = new SalaryCard();

        p2 = new Player("Player Two");
        career2 = new Athlete();
        salary2 = new SalaryCard();

        b = new Bank(3);

        /* Players are assigned careers and salaries (for testing purposes) by keeping the
         *  created career and salary cards. */
        p1.keepCareerCard(career1);
        p1.keepSalaryCard(salary1);

        p2.keepCareerCard(career2);
        p2.keepSalaryCard(salary2);

        /* Constructor: Lawsuit ()
         *  Three Lawsuit objects are created (to test the random generation of amounts). */
        c1 = new Lawsuit();
        c2 = new Lawsuit();
        c3 = new Lawsuit();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Player otherPlayer, Bank b)
         *  Test case 1: The effect of Lawsuit is executed on p1.
         *  Expected output: The cash of p1 will decrease by the randomly generated amount
         *  stored in c1, and the cash of p2 will increase by the same amount. */
        System.out.println("Test case 1: The effect of Lawsuit is executed on p1.");

        System.out.println("Stats before Lawsuit execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Number of Loans = " + p1.getCurrNumLoans());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("c1: Amount = " + c1.getAmount());

        c1.execute(p1, p2, b);

        System.out.println("Stats after Lawsuit execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Number of Loans = " + p1.getCurrNumLoans());
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: execute(Player currPlayer, Player otherPlayer, Bank b)
         *  Test case 2: The effect of Lawsuit is executed on p1.
         *  Expected output: The cash of p1 will decrease by the randomly generated amount
         *  stored in c2, and the cash of p2 will increase by the same amount. */
        System.out.println("Test case 2: The effect of Lawsuit is executed on p1.");

        System.out.println("Stats before Lawsuit execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Number of Loans = " + p1.getCurrNumLoans());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("c2: Amount = " + c2.getAmount());

        c2.execute(p1, p2, b);

        System.out.println("Stats after Lawsuit execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Number of Loans = " + p1.getCurrNumLoans());
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: execute(Player currPlayer, Player otherPlayer, Bank b)
         *  Test case 3: The effect of Lawsuit is executed on p1.
         *  Expected output: The cash of p1 will decrease by the randomly generated amount
         *  stored in c3, and the cash of p2 will increase by the same amount. */
        System.out.println("Test case 3: The effect of Lawsuit is executed on p1.");

        System.out.println("Stats before Lawsuit execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Number of Loans = " + p1.getCurrNumLoans());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("c3: Amount = " + c3.getAmount());

        c3.execute(p1, p2, b);

        System.out.println("Stats after Lawsuit execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Number of Loans = " + p1.getCurrNumLoans());
        System.out.println("p2: Cash = " + p2.getCash());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of c1 is called.
         *  Expected output: The string "You have lost a lawsuit. Pay "
         *  + getAmount() + " to a player of your choosing.", where getAmount()
         *  indicates the randomly generated amount (used to indicate the execution
         *  of the action card in the GameMaster class). */
        System.out.println ("Test case 1: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of c2 is called.
         *  Expected output: The string "You have lost a lawsuit. Pay "
         *  + getAmount() + " to a player of your choosing.", where getAmount()
         *  indicates the randomly generated amount (used to indicate the execution
         *  of the action card in the GameMaster class). */
        System.out.println ("Test case 2: The getInfo() method of c2 is called.");

        System.out.println (c2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of c3 is called.
         *  Expected output: The string "You have lost a lawsuit. Pay "
         *  + getAmount() + " to a player of your choosing.", where getAmount()
         *  indicates the randomly generated amount (used to indicate the execution
         *  of the action card in the GameMaster class). */
        System.out.println ("Test case 3: The getInfo() method of c3 is called.");

        System.out.println (c3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The Lawsuit object c1 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  currPlayer to otherPlayer. */
        System.out.println ("Test case 1: The Lawsuit object c1 is printed (using the toString() method).");

        System.out.println (c1);

        /* Method: Overridden toString()
         *  Test case 2: The Lawsuit object c2 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  currPlayer to otherPlayer. */
        System.out.println ("Test case 2: The Lawsuit object c2 is printed (using the toString() method).");

        System.out.println (c2);

        /* Method: Overridden toString()
         *  Test case 3: The Lawsuit object c3 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  currPlayer to otherPlayer. */
        System.out.println ("Test case 3: The Lawsuit object c3 is printed (using the toString() method).");

        System.out.println (c3);
    }
}


