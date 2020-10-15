

import cards.SalaryCard;

/**
 * Test script for <code>SalaryCard</code> class
 */
public class SalaryCardTestScript {
    public static void main(String[] args) {

        SalaryCard salary1;
        SalaryCard salary2;
        SalaryCard salary3;

        /* Constructor: SalaryCard ()
         *  Three SalaryCard objects are created (to test the random generation of salaries). */
        salary1 = new SalaryCard();
        salary2 = new SalaryCard();
        salary3 = new SalaryCard();

        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of salary1 is called.
         *  Expected output: The randomly generated salary and the tax due and pay
         *  raise increments (the tax due increment is 10% of the salary, and the pay raise
         *  increment is 20% of the salary). */
        System.out.println ("Test case 1: The getInfo() method of salary1 is called.");

        System.out.println (salary1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of salary2 is called.
         *  Expected output: The randomly generated salary and the tax due and pay
         *  raise increments (the tax due increment is 10% of the salary, and the pay raise
         *  increment is 20% of the salary). */
        System.out.println ("Test case 2: The getInfo() method of salary2 is called.");

        System.out.println (salary2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of salary3 is called.
         *  Expected output: The randomly generated salary and the tax due and pay
         *  raise increments (the tax due increment is 10% of the salary, and the pay raise
         *  increment is 20% of the salary). */
        System.out.println ("Test case 3: The getInfo() method of salary3 is called.");

        System.out.println (salary3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The SalaryCard object salary1 is printed (using the toString() method).
         *  Expected Output: The randomly generated salary and the tax due and pay
         *  raise increments (the tax due increment is 10% of the salary, and the pay raise
         *  increment is 20% of the salary). */
        System.out.println("Test case 1: The SalaryCard object salary1 is printed (using the toString() method).");

        System.out.println(salary1);

        /* Method: Overridden toString()
         *  Test case 2: The SalaryCard object salary2 is printed (using the toString() method).
         *  Expected Output: The randomly generated salary and the tax due and pay
         *  raise increments (the tax due increment is 10% of the salary, and the pay raise
         *  increment is 20% of the salary). */
        System.out.println("Test case 2: The SalaryCard object salary2 is printed (using the toString() method).");

        System.out.println(salary2);

        /* Method: Overridden toString()
         *  Test case 3: The SalaryCard object salary3 is printed (using the toString() method).
         *  Expected Output: The randomly generated salary and the tax due and pay
         *  raise increments (the tax due increment is 10% of the salary, and the pay raise
         *  increment is 20% of the salary). */
        System.out.println("Test case 3: The SalaryCard object salary3 is printed (using the toString() method).");

        System.out.println(salary3);
    }
}
