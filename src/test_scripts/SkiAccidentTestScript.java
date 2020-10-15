

import cards.SalaryCard;
import cards.blue_cards.SkiAccident;
import cards.career_cards.Accountant;
import cards.career_cards.Athlete;
import cards.career_cards.Doctor;
import core.Bank;
import core.Player;

/**
 * Test script for <code>SkiAccident</code> class
 */
public class SkiAccidentTestScript {
    public static void main(String[] args) {

        SkiAccident c1;

        Player p1;
        Player p2;

        Accountant career1;
        Doctor career2;
        Athlete career3;

        SalaryCard salary1;
        SalaryCard salary2;

        Bank b;

        /* Player, CareerCard, SalaryCard, and Bank objects are created to
         *  test the SkiAccident object methods. */
        p1 = new Player("Player One");
        p2 = new Player("Player Two");
        career1 = new Accountant();
        career2 = new Doctor();
        career3 = new Athlete();
        salary1 = new SalaryCard();
        salary2 = new SalaryCard();

        b = new Bank(2);

        /* Constructor: SkiAccident ()
         *  One SkiAccident object is created. */
        c1 = new SkiAccident();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b)
         *  Test case 1: The effect of SkiAccident is executed on p1, and p2 is the player
         *  who has the Doctor career.
         *  Expected output: The cash of p1 will decrease by 10000
         *  and the cash of p2 will increase by the same amount. */
        System.out.println("Test case 1: The effect of SkiAccident is executed on p1, and p2 is the player who has the Doctor career.");

        p1.keepCareerCard(career1);
        p1.keepSalaryCard(salary1);
        p2.keepCareerCard(career2);
        p2.keepSalaryCard(salary2);

        System.out.println("Stats before SkiAccident execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());

        c1.execute(p1, p2, b);

        System.out.println("Stats after SkiAccident execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b)
         *  Test case 2: The effect of SkiAccident is executed on p1, and p1 is the player
         *  who has the Doctor career.
         *  Expected output: The cash of p1 will increase by 15000. */
        System.out.println("Test case 2: The effect of SkiAccident is executed on p1, and p1 is the player who has the Doctor career.");

        p1.keepCareerCard(career2);
        p2.keepCareerCard(career1);

        System.out.println("Stats before SkiAccident execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        c1.execute(p1, p1, b);

        System.out.println("Stats after SkiAccident execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b)
         *  Test case 3: The effect of SkiAccident is executed on p1, and no player has the
         *  Doctor career.
         *  Expected output: The cash of p1 will decrease by 10000. */
        System.out.println("Test case 3: The effect of SkiAccident is executed on p1, and no player has the Doctor career.");

        p1.keepCareerCard(career3);

        System.out.println("Stats before SkiAccident execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        c1.execute(p1, null, b);

        System.out.println("Stats after SkiAccident execution:");
        System.out.println("p1: Cash = " + p1.getCash());


        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case: The getInfo() method of c1 is called.
         *  Expected output: The string "You drew a ski accident card." */
        System.out.println ("Test case: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        System.out.println();
        System.out.println("getInfoBank()");

        /* Method: getInfoBank()
         *  Test case: The getInfoBank() method of c1 is called.
         *  Expected output: The string "You drew a ski accident card.
         *  Pay 10000 to the bank for treatment fees. */
        System.out.println ("Test case: The getInfoBank() method of c1 is called.");

        System.out.println (c1.getInfoBank());

        System.out.println();
        System.out.println("getInfoMatch()");

        /* Method: getInfoMatch()
         *  Test case: The getInfoMatch() method of c1 is called.
         *  Expected output: The string "You drew a ski accident card.
         *  Receive 15000 as a doctor." */
        System.out.println ("Test case: The getInfoMatch() method of c1 is called.");

        System.out.println (c1.getInfoMatch());

        System.out.println();
        System.out.println("getInfoOtherPlayer()");

        /* Method: getInfoOtherPlayer()
         *  Test case: The getInfoOtherPlayer() method of c1 is called.
         *  Expected output: The string "You drew a ski accident card.
         *  Pay 10000 to the doctor for treatment fees." */
        System.out.println ("Test case: The getInfoOtherPlayer() method of c1 is called.");

        System.out.println (c1.getInfoOtherPlayer());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case: The SkiAccident object c1 is printed (using the toString() method).
         *  Expected output: The name and career match of the card and the possible amounts
         *  to be paid or received by the player. */
        System.out.println ("Test case: The SkiAccident object c1 is printed (using the toString() method).");

        System.out.println (c1);
    }
}

