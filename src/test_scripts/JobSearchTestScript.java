

import cards.CareerCard;
import cards.SalaryCard;
import cards.career_cards.Accountant;
import core.Player;
import decks.CareerCardDeck;
import decks.SalaryCardDeck;
import spaces.magenta_spaces.JobSearch;

import java.util.ArrayList;

/**
 * Test script for <code>Job Search</code> class
 */
public class JobSearchTestScript {
    public static void main(String[] args) {

        Player p1;
        JobSearch space1;
        CareerCardDeck c;
        SalaryCardDeck s;
        Accountant career;
        SalaryCard salary;

        /* Constructor: JobSearchChoice ()
        One JobSearch object is created. The indices for this test script are dummy
        values, as their values will not affect the tested methods in the script.
        */
        space1 = new JobSearch(-1, -1);

        /* Player, CareerCardDeck, and SalaryCardDeck objects are created to test the
        methods of the JobSearch object.
        */
        p1 = new Player("Sample Name");
        c = new CareerCardDeck();
        s = new SalaryCardDeck();
        career = new Accountant();
        salary = new SalaryCard();

        System.out.println("drawCareerCard()");

        /* Method: drawCareerCard(Player currPlayer, CareerCardDeck d)
       Test case: The drawCareerCard() method of space1 is called.
       Expected output: A career card drawn from the career card deck and the player's
       current career card. */
        System.out.println ("Test case: The drawCareerCard() method of space1 is called.");

        p1.keepCareerCard(career);
        p1.keepSalaryCard(salary);

        System.out.println("p1: Current career card");
        System.out.println(p1.getCareerCard());
        ArrayList<CareerCard> careers;
        careers = space1.drawCareerCard(p1, c);

        System.out.println("Drawn career cards:");
        for (int i = 0; i < careers.size(); i++)
            System.out.println(careers.get(i));

        System.out.println();
        System.out.println("drawSalaryCard()");

        /* Method: drawSalaryCard(Player currPlayer, SalaryCardDeck d)
       Test case: The drawSalaryCard() method of space1 is called.
       Expected output: A salary card drawn from the salary card deck and the player's
       current salary card. */
        System.out.println ("Test case: The drawSalaryCard() method of space1 is called.");

        System.out.println("p1: Current salary card");
        System.out.println(p1.getSalaryCard());
        ArrayList<SalaryCard> salaries;
        salaries = space1.drawSalaryCard(p1, s);

        System.out.println("Drawn salary cards:");
        for (int i = 0; i < salaries.size(); i++)
            System.out.println(salaries.get(i));

        System.out.println();
        System.out.println("executeCareer()");

        /* Method: executeCareer(Player currPlayer, ArrayList<CareerCard> careerCards, CareerCardDeck d, int index)
       Test case: The executeCareer() method of space1 is called, and p1 chooses to keep the
       first career card in the list.
       Expected output: p1 keeps their current career card. */
        System.out.println ("Test case: The executeCareer() method of space1 is called, and p1 chooses to keep the first career card in the list.");

        System.out.println("p1: Current career card");
        System.out.println(p1.getCareerCard());

        space1.executeCareer(p1, careers, c, 0);
        System.out.println("p1: New Career = " + p1.getCareer());

        /* Method: executeSalary(Player currPlayer, ArrayList<SalaryCard> salaryCards, SalaryCardDeck d, int index)
       Test case: The executeSalary() method of space1 is called, and p1 chooses to keep the
       second salary card in the list.
       Expected output: p1 keeps their new salary card. */
        System.out.println ("Test case: The executeSalary() method of space1 is called, and p1 chooses to keep the second salary card in the list.");

        System.out.println("p1: Current salary card");
        System.out.println(p1.getSalaryCard());

        space1.executeSalary(p1, salaries, s, 1);
        System.out.println("p1: New Salary = " + p1.getSalary());

        /* Method: getInfo(Player currPlayer)
        Test case: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on a Job Search space.
        Choose a career and salary card from the available options."
        */
        System.out.println("Test case: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
