

import core.Bank;
import core.Player;

/**
 * Test script for <code>Bank</code> class
 */
public class BankTestScript {
    public static void main(String[] args) {

        Player p1;
        Player p2;
        Player p3;

        Bank b;

        /* Three Player objects are created for testing the Bank object methods. */
        p1 = new Player("One");
        p2 = new Player("Two");
        p3 = new Player("Three");

        /* Constructor: Bank (int numPlayers)
         *  A new Bank object is created with three players. */
        b = new Bank(3);

        System.out.println("lendLoan()");

        /* Method: lendLoan(Player p, int numLoans)
         *  Test case 1: p1 takes out one bank loan.
         *  Expected output: p1 will have a cash amount of 220000 and one bank loan. */
        System.out.println("Test case 1: p1 takes out one bank loan.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Number of Loans = " + p1.getCurrNumLoans());
        b.lendLoan(p1, 1);
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Number of Loans = " + p1.getCurrNumLoans());

        /* Method: lendLoan(Player p, int numLoans)
         *  Test case 2: p2 takes out a negative number of bank loans.
         *  Expected output: p2 will have a cash amount of 200000 and no bank loans. */
        System.out.println("Test case 2: p2 takes out a negative number of bank loans.");

        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Number of Loans = " + p2.getCurrNumLoans());
        b.lendLoan(p2, -5);
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Number of Loans = " + p2.getCurrNumLoans());

        /* Method: lendLoan(Player p, int numLoans)
         *  Test case 3: p3 takes out fifty bank loans.
         *  Expected output: p3 will have a cash amount of 1200000 and fifty bank loans. */
        System.out.println("Test case 3: p3 takes out fifty bank loans.");

        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Number of Loans = " + p3.getCurrNumLoans());
        b.lendLoan(p3, 50);
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Number of Loans = " + p3.getCurrNumLoans());

        System.out.println();
        System.out.println("receivePayment()");

        /* Method: receivePayment(Player p, int numPayments)
         *  Test case 1: p1 pays off all their loans (one loan).
         *  Expected output: p1 will have a cash amount of 195000 and zero bank loans. */
        System.out.println("Test case 1: p1 pays off all their loans (one loan).");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Number of Loans = " + p1.getCurrNumLoans());
        b.receivePayment(p1, 1);
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Number of Loans = " + p1.getCurrNumLoans());

        /* Method: receivePayment(Player p, int numPayments)
         *  Test case 2: p2 pays off all more loans than they have (zero loans).
         *  Expected output: p2 will have a cash amount of 200000 and zero bank loans (no change). */
        System.out.println("Test case 2: p2 pays off all more loans than they have (zero loans).");

        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Number of Loans = " + p2.getCurrNumLoans());
        b.receivePayment(p2, 1);
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Number of Loans = " + p2.getCurrNumLoans());

        /* Method: receivePayment(Player p, int numPayments)
         *  Test case 3: p3 attempts to pay off more loans than they have enough cash for (50 loans).
         *  Expected output: p3 will have a cash amount of 1200000 and fifty bank loans (no change). */
        System.out.println("Test case 3: p3 pays off more loans than they have enough cash for (50 loans).");

        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Number of Loans = " + p3.getCurrNumLoans());
        b.receivePayment(p3, 50);
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Number of Loans = " + p3.getCurrNumLoans());

        System.out.println();
        System.out.println("giveCash()");

        /* Method: giveCash(Player p, int amount)
         *  Test case 1: 1000 is given to p1.
         *  Expected output: p1 will have a cash amount of 196000. */
        System.out.println("Test case 1: 1000 is given to p1.");

        System.out.println("p1: Cash = " + p1.getCash());
        b.giveCash(p1, 1000);
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: giveCash(Player p, int amount)
         *  Test case 2: 0 is given to p2.
         *  Expected output: p2 will have a cash amount of 200000 (no change). */
        System.out.println("Test case 2: 0 is given to p2.");

        System.out.println("p2: Cash = " + p2.getCash());
        b.giveCash(p2, 0);
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: giveCash(Player p, int amount)
         *  Test case 3: -10000 is given to p3.
         *  Expected output: p3 will have a cash amount of 1200000 (no change). */
        System.out.println("Test case 3: -10000 is given to p3.");

        System.out.println("p3: Cash = " + p3.getCash());
        b.giveCash(p3, -10000);
        System.out.println("p3: Cash = " + p3.getCash());

        System.out.println();
        System.out.println("receiveCash()");

        /* Method: receiveCash(Player p, int amount)
         *  Test case 1: 4000 is received from p1.
         *  Expected output: p1 will have a cash amount of 192000. */
        System.out.println("Test case 1: 4000 is received from p1.");

        System.out.println("p1: Cash = " + p1.getCash());
        b.receiveCash(p1, 4000);
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: receiveCash(Player p, int amount)
         *  Test case 2: 0 is received from p2.
         *  Expected output: p2 will have a cash amount of 200000 (no change). */
        System.out.println("Test case 2: 0 is received from p2.");

        System.out.println("p2: Cash = " + p2.getCash());
        b.giveCash(p2, 0);
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: receiveCash(Player p, int amount)
         *  Test case 3: -14000 is received from p3.
         *  Expected output: p3 will have a cash amount of 1200000 (no change). */
        System.out.println("Test case 3: -14000 is received from p3.");

        System.out.println("p3: Cash = " + p3.getCash());
        b.giveCash(p3, -14000);
        System.out.println("p3: Cash = " + p3.getCash());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case: The Bank object is printed (using the overridden toString() method).
         *  Expected output: 0, 0, 50 (corresponding to the number of loans of each of the players). */
        System.out.println("Test case: The Bank object is printed (using the overridden toString() method).");

        System.out.println(b);
    }
}
