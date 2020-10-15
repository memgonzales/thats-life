

import cards.SalaryCard;
import cards.action_cards.collect_from_player.ItsYourBirthday;
import cards.career_cards.Accountant;
import cards.career_cards.Athlete;
import cards.career_cards.ComputerConsultant;
import core.Bank;
import core.Player;
import java.util.*;

/**
 * Test script for <code>ItsYourBirthday</code> class
 */
public class ItsYourBirthdayTestScript {
    public static void main(String[] args) {

        ItsYourBirthday c1;
        ItsYourBirthday c2;
        ItsYourBirthday c3;

        Player p1;
        Player p2;
        Player p3;

        Accountant career1;
        Athlete career2;
        ComputerConsultant career3;

        SalaryCard salary1;
        SalaryCard salary2;
        SalaryCard salary3;

        Bank b;

        ArrayList<Player> players;

        /* Player, CareerCard, SalaryCard, and Bank objects, as well as an arraylist of
         * Player objects, are created to test the ItsYourBirthday object methods. */
        p1 = new Player("Player One");
        career1 = new Accountant();
        salary1 = new SalaryCard();

        p2 = new Player("Player Two");
        career2 = new Athlete();
        salary2 = new SalaryCard();

        p3 = new Player("Player Three");
        career3 = new ComputerConsultant();
        salary3 = new SalaryCard();

        b = new Bank(3);

        players = new ArrayList<>();

        /* Players are assigned careers and salaries (for testing purposes) by keeping the
         *  created career and salary cards. p2 and p3 are added to the arraylist players. */
        p1.keepCareerCard(career1);
        p1.keepSalaryCard(salary1);

        p2.keepCareerCard(career2);
        p2.keepSalaryCard(salary2);

        p3.keepCareerCard(career3);
        p3.keepSalaryCard(salary3);

        players.add(p2);
        players.add(p3);

        /* Constructor: ItsYourBirthday ()
         *  Three ItsYourBirthday objects are created (to test the random generation of amounts). */
        c1 = new ItsYourBirthday();
        c2 = new ItsYourBirthday();
        c3 = new ItsYourBirthday();

        System.out.println("execute()");

        /* Method: execute(Player currPlayer, ArrayList<Player> players, Bank b)
         *  Test case 1: The effect of ItsYourBirthday is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated amount
         *  stored in c1 multiplied by the number of other players, and the cash of the remaining
         *  players will decrease by the same amount. */
        System.out.println("Test case 1: The effect of ItsYourBirthday is executed on p1.");

        System.out.println("Stats before ItsYourBirthday execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Number of Loans = " + p2.getCurrNumLoans());
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Number of Loans = " + p3.getCurrNumLoans());
        System.out.println("c1: Amount = " + c1.getAmount());

        c1.execute(p1, players, b);

        System.out.println("Stats after ItsYourBirthday execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Number of Loans = " + p2.getCurrNumLoans());
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Number of Loans = " + p3.getCurrNumLoans());

        /* Method: execute(Player currPlayer, ArrayList<Player> players, Bank b)
         *  Test case 2: The effect of ItsYourBirthday is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated amount
         *  stored in c2 multiplied by the number of other players, and the cash of the remaining
         *  players will decrease by the same amount. */
        System.out.println("Test case 2: The effect of ItsYourBirthday is executed on p1.");

        System.out.println("Stats before ItsYourBirthday execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Number of Loans = " + p2.getCurrNumLoans());
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Number of Loans = " + p3.getCurrNumLoans());
        System.out.println("c2: Amount = " + c2.getAmount());

        c2.execute(p1, players, b);

        System.out.println("Stats after ItsYourBirthday execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Number of Loans = " + p2.getCurrNumLoans());
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Number of Loans = " + p3.getCurrNumLoans());

        /* Method: execute(Player currPlayer, ArrayList<Player> players, Bank b)
         *  Test case 3: The effect of ItsYourBirthday is executed on p1.
         *  Expected output: The cash of p1 will increase by the randomly generated amount
         *  stored in c3 multiplied by the number of other players, and the cash of the remaining
         *  players will decrease by the same amount. */
        System.out.println("Test case 3: The effect of ItsYourBirthday is executed on p1.");

        System.out.println("Stats before ItsYourBirthday execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Number of Loans = " + p2.getCurrNumLoans());
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Number of Loans = " + p3.getCurrNumLoans());
        System.out.println("c3: Amount = " + c3.getAmount());

        c3.execute(p1, players, b);

        System.out.println("Stats after ItsYourBirthday execution:");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: Number of Loans = " + p2.getCurrNumLoans());
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Number of Loans = " + p3.getCurrNumLoans());

        System.out.println();
        System.out.println("getInfo()");

        /* Method: getInfo()
         *  Test case 1: The getInfo() method of c1 is called.
         *  Expected output: The string "It's your birthday! Collect " + getAmount() +
         *  " from every other player as a gift.", where getAmount() indicates the randomly
         *  generated amount (used to indicate the execution of the action card in the
         *  GameMaster class). */
        System.out.println ("Test case 1: The getInfo() method of c1 is called.");

        System.out.println (c1.getInfo());

        /* Method: getInfo()
         *  Test case 2: The getInfo() method of c2 is called.
         *  Expected output: The string "It's your birthday! Collect " + getAmount() +
         *  " from every other player as a gift.", where getAmount() indicates the randomly
         *  generated amount (used to indicate the execution of the action card in the
         *  GameMaster class). */
        System.out.println ("Test case 2: The getInfo() method of c2 is called.");

        System.out.println (c2.getInfo());

        /* Method: getInfo()
         *  Test case 3: The getInfo() method of c3 is called.
         *  Expected output: The string "It's your birthday! Collect " + getAmount() +
         *  " from every other player as a gift.", where getAmount() indicates the randomly
         *  generated amount (used to indicate the execution of the action card in the
         *  GameMaster class). */
        System.out.println ("Test case 3: The getInfo() method of c3 is called.");

        System.out.println (c3.getInfo());

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The ItsYourBirthday object c1 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  the other players to currPlayer. */
        System.out.println ("Test case 1: The ItsYourBirthday object c1 is printed (using the toString() method).");

        System.out.println (c1);

        /* Method: Overridden toString()
         *  Test case 2: The ItsYourBirthday object c2 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  the other players to currPlayer. */
        System.out.println ("Test case 2: The ItsYourBirthday object c2 is printed (using the toString() method).");

        System.out.println (c2);

        /* Method: Overridden toString()
         *  Test case 3: The ItsYourBirthday object c3 is printed (using the toString() method).
         *  Expected output: The name of the card and the amount to be paid by
         *  the other players to currPlayer. */
        System.out.println ("Test case 3: The ItsYourBirthday object c3 is printed (using the toString() method).");

        System.out.println (c3);
    }
}


