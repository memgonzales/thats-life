

import cards.SalaryCard;
import cards.career_cards.Accountant;
import core.Bank;
import core.Player;
import spaces.green_spaces.PayRaise;

/**
 * Test script for <code>Pay Raise</code> class
 */
public class PayRaiseTestScript {
    public static void main(String[] args) {

        Player p1;
        Bank b;
        PayRaise space1;
        SalaryCard s1;
        Accountant c1;

        /* Constructor: PayRaise ()
        One PayRaise object is created. The indices for this test script are dummy
        values, as their values will not affect the tested methods in the script.
        */
        space1 = new PayRaise(-1, -1);

        /* Player, Bank, SalaryCard, and Accountant objects are created to
        test the methods of the PayRaise object.
        */
        p1 = new Player("Sample Name");
        b = new Bank(2);
        s1 = new SalaryCard();
        c1 = new Accountant();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Bank b)
       Test case 1: The execute() method of space1 is called, and p1 has
       the salary card s1.
       Expected output: p1 will get a pay raise and the cash of p1 will
       increase by their new salary. */
        System.out.println ("Test Case 1: The execute() method of space1 is called, and p1 has " +
                "the salary card s1.");

        p1.keepSalaryCard(s1);
        p1.keepCareerCard(c1);
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Salary = " + p1.getSalary());
        System.out.println("p1: Pay Raise Amount = " + p1.getBasePayRaise());
        space1.execute(p1, b);
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: New Salary = " + p1.getSalary());

        /* Method: execute(Player currPlayer, Bank b)
       Test case 2: The execute() method of space1 is called a second time
       Expected output: p1 will get a pay raise and the cash of p1 will
       increase by their new salary. */
        System.out.println ("Test case 2: The execute() method of space1 is called a second time.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Salary = " + p1.getSalary());
        System.out.println("p1: Pay Raise Amount = " + p1.getBasePayRaise());
        space1.execute(p1, b);
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: New Salary = " + p1.getSalary());

        /* Method: execute(Player currPlayer, Bank b)
       Test case 3: The execute() method of space1 is called a third time
       Expected output: p1 will get a pay raise and the cash of p1 will
       increase by their new salary. */
        System.out.println ("Test case 3: The execute() method of space1 is called a third time.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Salary = " + p1.getSalary());
        System.out.println("p1: Pay Raise Amount = " + p1.getBasePayRaise());
        space1.execute(p1, b);
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: New Salary = " + p1.getSalary());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo(Player currPlayer)
        Test case: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on a Pay Raise space.
        Receive a pay raise and your new salary from the bank."
        */
        System.out.println("Test case: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
