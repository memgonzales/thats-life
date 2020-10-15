

import cards.SalaryCard;
import cards.blue_cards.WorldCup;
import cards.career_cards.Accountant;
import cards.career_cards.Athlete;
import cards.career_cards.Server;
import core.Bank;
import core.Player;

/**
 * Test script for <code>WorldCup</code> class
 */
public class WorldCupTestScript {
    public static void main(String[] args) {

        WorldCup c1;

        Player p1;
        Player p2;

        Accountant career1;
        Athlete career2;
        Server career3;

        SalaryCard salary1;
        SalaryCard salary2;

        Bank b;

        /* Player, CareerCard, SalaryCard, and Bank objects are created to
         *  test the SkiAccident object methods. */
        p1 = new Player("Player One");
        p2 = new Player("Player Two");
        career1 = new Accountant();
        career2 = new Athlete();
        career3 = new Server();
        salary1 = new SalaryCard();
        salary2 = new SalaryCard();

        b = new Bank(2);

        /* Constructor: WorldCup ()
         *  One WorldCup object is created. */
        c1 = new WorldCup();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b, int numPlayers)
         *  Test case 1: The effect of WorldCup is executed on p1, and p2 is the player
         *  who has the Athlete career.
         *  Expected output: The cash of p1 will decrease by 10000 (5000 * 2 players)
         *  and the cash of p2 will increase by the same amount. */
        System.out.println("Test case 1: The effect of WorldCup is executed on p1, and p2 is the player who has the Athlete career.");

        p1.keepCareerCard(career1);
        p1.keepSalaryCard(salary1);
        p2.keepCareerCard(career2);
        p2.keepSalaryCard(salary2);

        System.out.println("Stats before WorldCup execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());

        c1.execute(p1, p2, b, 2);

        System.out.println("Stats after WorldCup execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b, int numPlayers)
         *  Test case 2: The effect of WorldCup is executed on p1, and p1 is the player
         *  who has the Athlete career.
         *  Expected output: The cash of p1 will increase by 15000. */
        System.out.println("Test case 2: The effect of WorldCup is executed on p1, and p1 is the player who has the Athlete career.");

        p1.keepCareerCard(career2);
        p2.keepCareerCard(career1);

        System.out.println("Stats before WorldCup execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        c1.execute(p1, p1, b, 2);

        System.out.println("Stats after WorldCup execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: execute(Player currPlayer, Player playerWithCareer, Bank b, int numPlayers)
         *  Test case 3: The effect of WorldCup is executed on p1, and no player has the
         *  Athlete career.
         *  Expected output: The cash of p1 will decrease by 10000 (5000 * 2 players). */
        System.out.println("Test case 3: The effect of WorldCup is executed on p1, and no player has the Athlete career.");

        p1.keepCareerCard(career3);

        System.out.println("Stats before WorldCup execution:");
        System.out.println("p1: Cash = " + p1.getCash());

        c1.execute(p1, null, b, 2);

        System.out.println("Stats after WorldCup execution:");
        System.out.println("p1: Cash = " + p1.getCash());


        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case: The getInfo() method of c1 is called.
         *  Expected output: The string "You drew a world cup card." */
        System.out.println ("Test case: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        System.out.println();
        System.out.println("getInfoBank()");

        /* Method: getInfoBank()
         *  Test case: The getInfoBank() method of c1 is called.
         *  Expected output: The string "You drew a world cup card.
         *  Pay 5000 for each player to the bank for training costs. */
        System.out.println ("Test case: The getInfoBank() method of c1 is called.");

        System.out.println (c1.getInfoBank());

        System.out.println();
        System.out.println("getInfoMatch()");

        /* Method: getInfoMatch()
         *  Test case: The getInfoMatch() method of c1 is called.
         *  Expected output: The string "You drew a world cup card.
         *  Receive 15000 as an athlete." */
        System.out.println ("Test case: The getInfoMatch() method of c1 is called.");

        System.out.println (c1.getInfoMatch());

        System.out.println();
        System.out.println("getInfoOtherPlayer()");

        /* Method: getInfoOtherPlayer()
         *  Test case: The getInfoOtherPlayer() method of c1 is called.
         *  Expected output: The string "You drew a world cup card.
         *  Pay 5000 for each player to the athlete for training costs." */
        System.out.println ("Test case: The getInfoOtherPlayer() method of c1 is called.");

        System.out.println (c1.getInfoOtherPlayer());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case: The WorldCup object c1 is printed (using the toString() method).
         *  Expected output: The name and career match of the card and the possible amounts
         *  to be paid or received by the player. */
        System.out.println ("Test case: The WorldCup object c1 is printed (using the toString() method).");

        System.out.println (c1);
    }
}

