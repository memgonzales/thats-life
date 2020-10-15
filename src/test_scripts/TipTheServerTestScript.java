

import cards.SalaryCard;
import cards.blue_cards.TipTheServer;
import cards.career_cards.Accountant;
import cards.career_cards.Athlete;
import cards.career_cards.Server;
import core.Bank;
import core.NumberWheel;
import core.Player;

/**
 * Test script for <code>TipTheServer</code> class
 */
public class TipTheServerTestScript {
    public static void main(String[] args) {

        TipTheServer c1;

        Player p1;
        Player p2;

        Accountant career1;
        Server career2;
        Athlete career3;

        SalaryCard salary1;
        SalaryCard salary2;

        Bank b;
        NumberWheel wheel;

        /* Player, CareerCard, SalaryCard, Bank, and NumberWheel objects are created to
         *  test the SkiAccident object methods. */
        p1 = new Player("Player One");
        p2 = new Player("Player Two");
        career1 = new Accountant();
        career2 = new Server();
        career3 = new Athlete();
        salary1 = new SalaryCard();
        salary2 = new SalaryCard();

        b = new Bank(2);
        wheel = new NumberWheel();

        /* Constructor: TipTheServer ()
         *  One TipTheServer object is created. */
        c1 = new TipTheServer();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b, NumberWheel w)
         *  Test case 1: The effect of TipTheServer is executed on p1, and p2 is the player
         *  who has the Server career.
         *  Expected output: The cash of p1 will decrease by the random amount determined
         *  using the number wheel and the cash of p2 will increase by the same amount. */
        System.out.println("Test case 1: The effect of TipTheServer is executed on p1, and p2 is the player who has the Server career.");

        p1.keepCareerCard(career1);
        p1.keepSalaryCard(salary1);
        p2.keepCareerCard(career2);
        p2.keepSalaryCard(salary2);

        System.out.println("Stats before TipTheServer execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());

        c1.execute(p1, p2, b, 3);

        System.out.println("Stats after TipTheServer execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b, NumberWheel w)
         *  Test case 2: The effect of TipTheServer is executed on p1, and p1 is the player
         *  who has the Server career.
         *  Expected output: The cash of p1 will increase by 15000. */
        System.out.println("Test case 2: The effect of TipTheServer is executed on p1, and p1 is the player who has the Server career.");

        p1.keepCareerCard(career2);
        p2.keepCareerCard(career1);

        System.out.println("Stats before TipTheServer execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        c1.execute(p1, p1, b, 4);

        System.out.println("Stats after TipTheServer execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b, NumberWheel wheel)
         *  Test case 3: The effect of TipTheServer is executed on p1, and no player has the
         *  Server career.
         *  Expected output: The cash of p1 will decrease by the random amount determined
         *  using the number wheel. */
        System.out.println("Test case 3: The effect of TipTheServer is executed on p1, and no player has the Server career.");

        p1.keepCareerCard(career3);

        System.out.println("Stats before TipTheServer execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        c1.execute(p1, null, b, 5);

        System.out.println("Stats after TipTheServer execution:");
        System.out.println("p1: Cash = " + p1.getCash());


        System.out.println();
        System.out.println("spinWheel()");

        /* Method: spinWheel(NumberWheel w, Player currPlayer)
         *  Test case 1: The spinWheel() method of c1 is called.
         *  Expected output: A randomly determined number between 1 and 10. */
        System.out.println("Test case 1: The spinWheel() method of c1 is called.");
        System.out.println(c1.spinWheel(wheel, p1));

        /* Method: spinWheel(NumberWheel w, Player currPlayer)
         *  Test case 2: The spinWheel() method of c1 is called a second time.
         *  Expected output: A randomly determined number between 1 and 10. */
        System.out.println("Test case 2: The spinWheel() method of c1 is called a second time.");
        System.out.println(c1.spinWheel(wheel, p1));

        /* Method: spinWheel(NumberWheel w, Player currPlayer)
         *  Test case 3: The spinWheel() method of c1 is called a third time.
         *  Expected output: A randomly determined number between 1 and 10. */
        System.out.println("Test case 3: The spinWheel() method of c1 is called a third time.");
        System.out.println(c1.spinWheel(wheel, p1));


        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case: The getInfo() method of c1 is called.
         *  Expected output: The string "You drew a tip the server card." */
        System.out.println ("Test case: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        System.out.println();
        System.out.println("getInfoBank()");

        /* Method: getInfoBank()
         *  Test case: The getInfoBank() method of c1 is called.
         *  Expected output: The string "You drew a tip the server card.
         *  Spin the wheel to determine the tip to be paid to the bank. */
        System.out.println ("Test case: The getInfoBank() method of c1 is called.");

        System.out.println (c1.getInfoBank());

        System.out.println();
        System.out.println("getInfoMatch()");

        /* Method: getInfoMatch()
         *  Test case: The getInfoMatch() method of c1 is called.
         *  Expected output: The string "You drew a tip the server card.
         *  Receive 15000 as a server." */
        System.out.println ("Test case: The getInfoMatch() method of c1 is called.");

        System.out.println (c1.getInfoMatch());

        System.out.println();
        System.out.println("getInfoOtherPlayer()");

        /* Method: getInfoOtherPlayer()
         *  Test case: The getInfoOtherPlayer() method of c1 is called.
         *  Expected output: The string "You drew a tip the server card.
         *  Spin the wheel to determine the tip to be paid to the server." */
        System.out.println ("Test case: The getInfoOtherPlayer() method of c1 is called.");

        System.out.println (c1.getInfoOtherPlayer());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case: The TipTheServer object c1 is printed (using the toString() method).
         *  Expected output: The name and career match of the card and the possible amounts
         *  to be paid or received by the player. */
        System.out.println ("Test case: The TipTheServer object c1 is printed (using the toString() method).");

        System.out.println (c1);
    }
}

