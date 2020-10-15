

import cards.SalaryCard;
import core.Bank;
import core.Player;
import spaces.green_spaces.PayDay;

/**
 * Test script for <code>Pay Day</code> class
 */
public class PayDayTestScript {
    public static void main(String[] args) {

        Player p1;
        Bank b;
        PayDay space1;
        SalaryCard s1;
        SalaryCard s2;
        SalaryCard s3;

        /* Constructor: PayDay ()
        One PayDay object is created. The indices for this test script are dummy
        values, as their values will not affect the tested methods in the script.
        */
        space1 = new PayDay(-1, -1);

        /* A Player and Bank object and three SalaryCard objects are created to
        test the methods of the PayDay object.
        */
        p1 = new Player("Sample Name");
        b = new Bank(2);
        s1 = new SalaryCard();
        s2 = new SalaryCard();
        s3 = new SalaryCard();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Bank b)
       Test case 1: The execute() method of space1 is called, and p1 has
       the salary card s1.
       Expected output: The cash of p1 will increase by their salary. */
        System.out.println ("Test Case 1: The execute() method of space1 is called, and p1 has " +
                "the salary card s1.");

        p1.keepSalaryCard(s1);
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Salary = " + p1.getSalary());
        space1.execute(p1, b);
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
       Test case 2: The execute() method of space1 is called, and p1 has
       the salary card s2.
       Expected output: The cash of p1 will increase by their salary. */
        System.out.println ("Test Case 2: The execute() method of space1 is called, and p1 has " +
                "the salary card s2.");

        p1.keepSalaryCard(s2);
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Salary = " + p1.getSalary());
        space1.execute(p1, b);
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Bank b)
       Test case 3: The execute() method of space1 is called, and p1 has
       the salary card s3.
       Expected output: The cash of p1 will increase by their salary. */
        System.out.println ("Test Case 3: The execute() method of space1 is called, and p1 has " +
                "the salary card s3.");

        p1.keepSalaryCard(s3);
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Salary = " + p1.getSalary());
        space1.execute(p1, b);
        System.out.println("p1: Cash = " + p1.getCash());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo(Player currPlayer)
        Test case: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on a Pay Day space.
        Receive your current salary from the bank."
        */
        System.out.println("Test case: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
