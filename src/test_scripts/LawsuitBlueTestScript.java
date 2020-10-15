

import cards.SalaryCard;
import cards.blue_cards.LawsuitBlue;
import cards.career_cards.Accountant;
import cards.career_cards.Athlete;
import cards.career_cards.Lawyer;
import core.Bank;
import core.Player;

/**
 * Test script for <code>LawsuitBlue</code> class
 */
public class LawsuitBlueTestScript {
    public static void main(String[] args) {

        LawsuitBlue c1;
        LawsuitBlue c2;
        LawsuitBlue c3;

        Player p1;
        Player p2;

        Accountant career1;
        Lawyer career2;
        Athlete career3;

        SalaryCard salary1;
        SalaryCard salary2;

        Bank b;

        /* Player, CareerCard, SalaryCard, and Bank objects are created to
         *  test the LawsuitBlue object methods. */
        p1 = new Player("Player One");
        p2 = new Player("Player Two");
        career1 = new Accountant();
        career2 = new Lawyer();
        career3 = new Athlete();
        salary1 = new SalaryCard();
        salary2 = new SalaryCard();

        b = new Bank(2);

        /* Constructor: LawsuitBlue ()
         *  Three LawsuitBlue objects are created (to test the random generation of amounts). */
        c1 = new LawsuitBlue();
        c2 = new LawsuitBlue();
        c3 = new LawsuitBlue();

        System.out.println("getMachineRandNum()");

        /* Method: getMachineRandNum()
         *  Test case 1: The getMachineRandNum() method of c1 is called.
         *  Expected output: A randomly generated multiple of 10000 between 50000 and 150000 inclusive. */
        System.out.println("Test case 1: The getMachineRandNum() method of c1 is called.");
        System.out.println(c1.getMachineRandNum());

        /* Method: getMachineRandNum()
         *  Test case 2: The getMachineRandNum() method of c2 is called.
         *  Expected output: A randomly generated multiple of 10000 between 50000 and 150000 inclusive. */
        System.out.println("Test case 2: The getMachineRandNum() method of c2 is called.");
        System.out.println(c2.getMachineRandNum());

        /* Method: getMachineRandNum()
         *  Test case 3: The getMachineRandNum() method of c3 is called.
         *  Expected output: A randomly generated multiple of 10000 between 50000 and 150000 inclusive. */
        System.out.println("Test case 3: The getMachineRandNum() method of c3 is called.");
        System.out.println(c3.getMachineRandNum());

        System.out.println();
        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b)
         *  Test case 1: The effect of LawsuitBlue is executed on p1, and p2 is the player
         *  who has the Lawyer career.
         *  Expected output: The cash of p1 will decrease by the randomly generated amount
         *  and the cash of p2 will increase by the same amount. */
        System.out.println("Test case 1: The effect of LawsuitBlue is executed on p1, and p2 is the player who has the Lawyer career.");

        p1.keepCareerCard(career1);
        p1.keepSalaryCard(salary1);
        p2.keepCareerCard(career2);
        p2.keepSalaryCard(salary2);

        System.out.println("Stats before LawsuitBlue execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("Amount = " + c1.getAmount());

        c1.execute(p1, p2, b);

        System.out.println("Stats after LawsuitBlue execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b)
         *  Test case 2: The effect of LawsuitBlue is executed on p1, and p1 is the player
         *  who has the Lawyer career.
         *  Expected output: The cash of p1 will increase by 15000. */
        System.out.println("Test case 2: The effect of LawsuitBlue is executed on p1, and p1 is the player who has the Lawyer career.");

        p1.keepCareerCard(career2);
        p2.keepCareerCard(career1);

        System.out.println("Stats before LawsuitBlue execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        c1.execute(p1, p1, b);

        System.out.println("Stats after LawsuitBlue execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b)
         *  Test case 3: The effect of LawsuitBlue is executed on p1, and no player has the
         *  Lawyer career.
         *  Expected output: The cash of p1 will decrease by the randomly generated amount. */
        System.out.println("Test case 3: The effect of LawsuitBlue is executed on p1, and no player has the Lawyer career.");

        p1.keepCareerCard(career3);

        System.out.println("Stats before LawsuitBlue execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("Amount = " + c1.getAmount());

        c1.execute(p1, null, b);

        System.out.println("Stats after LawsuitBlue execution:");
        System.out.println("p1: Cash = " + p1.getCash());


        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case: The getInfo() method of c1 is called.
         *  Expected output: The string "You drew a Lawsuit (Blue) card." */
        System.out.println ("Test case: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        System.out.println();
        System.out.println("getInfoBank()");

        /* Method: getInfoBank()
         *  Test case: The getInfoBank() method of c1 is called.
         *  Expected output: The string "You drew a Lawsuit (Blue) card.
         *  Pay " + getAmount() + " to the bank for legal fees.", where getAmount()
         *  returns the randomly generated amount. */
        System.out.println ("Test case: The getInfoBank() method of c1 is called.");

        System.out.println (c1.getInfoBank());

        System.out.println();
        System.out.println("getInfoMatch()");

        /* Method: getInfoMatch()
         *  Test case: The getInfoMatch() method of c1 is called.
         *  Expected output: The string "You drew a Lawsuit (Blue) card.
         *  Receive 15000 as a lawyer." */
        System.out.println ("Test case: The getInfoMatch() method of c1 is called.");

        System.out.println (c1.getInfoMatch());

        System.out.println();
        System.out.println("getInfoOtherPlayer()");

        /* Method: getInfoOtherPlayer()
         *  Test case: The getInfoOtherPlayer() method of c1 is called.
         *  Expected output: The string "You drew a Lawsuit (Blue) card.
         *  Pay " + getAmount() + " to the lawyer for legal fees.", where getAmount()
         *  returns the randomly generated amount." */
        System.out.println ("Test case: The getInfoOtherPlayer() method of c1 is called.");

        System.out.println (c1.getInfoOtherPlayer());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case: The LawsuitBlue object c1 is printed (using the toString() method).
         *  Expected output: The name and career match of the card and the possible amounts
         *  to be paid or received by the player. */
        System.out.println ("Test case: The LawsuitBlue object c1 is printed (using the toString() method).");

        System.out.println (c1);
    }
}

