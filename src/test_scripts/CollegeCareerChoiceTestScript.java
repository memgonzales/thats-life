

import cards.CareerCard;
import cards.SalaryCard;
import core.Player;
import decks.CareerCardDeck;
import decks.SalaryCardDeck;
import spaces.magenta_spaces.CollegeCareerChoice;

import java.util.ArrayList;

/**
 * Test script for <code>College Career Choice</code> class
 */
public class CollegeCareerChoiceTestScript {
    public static void main(String[] args) {

        Player p1;
        CollegeCareerChoice space1;
        CareerCardDeck c;
        SalaryCardDeck s;

        /* Constructor: CollegeCareerChoice ()
        One CollegeCareerChoice object is created. The indices for this test script are dummy
        values, as their values will not affect the tested methods in the script.
        */
        space1 = new CollegeCareerChoice(-1, -1);

        /* Player, CareerCardDeck, and SalaryCardDeck objects are created to test the
        methods of the CollegeCareerChoice object.
        */
        p1 = new Player("Sample Name");
        c = new CareerCardDeck();
        s = new SalaryCardDeck();

        System.out.println("drawCareerCards()");

        /* Method: drawCareerCards(Player currPlayer, CareerCardDeck d)
       Test case: The drawCareerCards() method of space1 is called.
       Expected output: Two career cards drawn from the career card deck. */
        System.out.println ("Test case: The drawCareerCards() method of space1 is called.");

        ArrayList<CareerCard> careers;
        careers = space1.drawCareerCards(p1, c);

        for (int i = 0; i < careers.size(); i++)
            System.out.println(careers.get(i));

        System.out.println();
        System.out.println("drawSalaryCards()");

        /* Method: drawSalaryCards(Player currPlayer, SalaryCardDeck d)
       Test case: The drawSalaryCards() method of space1 is called.
       Expected output: Two salary cards drawn from the salary card deck. */
        System.out.println ("Test case: The drawSalaryCards() method of space1 is called.");

        ArrayList<SalaryCard> salaries;
        salaries = space1.drawSalaryCards(p1, s);

        for (int i = 0; i < salaries.size(); i++)
            System.out.println(salaries.get(i));

        System.out.println();
        System.out.println("executeCareer()");

        /* Method: executeCareer(Player currPlayer, ArrayList<CareerCard> careerCards, CareerCardDeck d, int index)
       Test case: The executeCareer() method of space1 is called, and p1 chooses to keep the
       first career card in the list.
       Expected output: p1 keeps the first career card. */
        System.out.println ("Test case: The executeCareer() method of space1 is called, and p1 chooses to keep the first career card in the list.");

        space1.executeCareer(p1, careers, c, 0);
        System.out.println("p1: New Career = " + p1.getCareer());

        /* Method: executeSalary(Player currPlayer, ArrayList<SalaryCard> salaryCards, SalaryCardDeck d, int index)
       Test case: The executeSalary() method of space1 is called, and p1 chooses to keep the
       first salary card in the list.
       Expected output: p1 keeps the first career card. */
        System.out.println ("Test case: The executeSalary() method of space1 is called, and p1 chooses to keep the first career card in the list.");

        space1.executeSalary(p1, salaries, s, 0);
        System.out.println("p1: New Salary = " + p1.getSalary());

        /* Method: getInfo(Player currPlayer)
        Test case: The getInfo() method of space1 is called with p1 passed as
        the parameter.
        Expected output: The string "[Player name], you are on a College Career
        Choice space. Choose a career and salary card from the available options."
        */
        System.out.println("Test case: The getInfo() method of space1 is called with p1 passed as the parameter.");

        System.out.println(space1.getInfo(p1));
    }
}
