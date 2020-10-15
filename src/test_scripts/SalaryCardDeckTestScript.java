

import cards.Card;
import decks.SalaryCardDeck;

import java.util.ArrayList;

/**
 * Test script for <code>SalaryCardDeck</code> class
 */
public class SalaryCardDeckTestScript {
    public static void main(String[] args) {

        SalaryCardDeck salaryDeck1;
        SalaryCardDeck salaryDeck2;
        SalaryCardDeck salaryDeck3;

        ArrayList<Card> salaryCards1;
        ArrayList<Card> salaryCards2;
        ArrayList<Card> salaryCards3;

        /* Three Card array lists are created to store the details of the generated cards. */
        salaryCards1 = new ArrayList<>();
        salaryCards2 = new ArrayList<>();
        salaryCards3 = new ArrayList<>();

        /* Constructor: SalaryCardDeck ()
         *  Three SalaryCardDeck objects are created to test the random generation of salaries. */
        salaryDeck1 = new SalaryCardDeck();
        salaryDeck2 = new SalaryCardDeck();
        salaryDeck3 = new SalaryCardDeck();

        System.out.println("generate()");

        /* Method: generate()
         *  Test case: The generate() method of salaryDeck1 is called.
         *  Expected output: 10 cards with varying salary amounts. The tax dues are 10% of the
         *  salaries, and the pay raise increments are 20% of the salaries. */
        System.out.println("Test case 1: The generate() method of salaryDeck1 is called.");

        salaryCards1 = salaryDeck1.generate();
        for (int i = 0; i < 10; i++)    //display all cards in the generated deck
            System.out.println(salaryCards1.get(i));

        /* Method: generate()
         *  Test case: The generate() method of salaryDeck2 is called.
         *  Expected output: 10 cards with varying salary amounts. The tax dues are 10% of the
         *  salaries, and the pay raise increments are 20% of the salaries. */
        System.out.println("Test case 2: The generate() method of salaryDeck2 is called.");

        salaryCards2 = salaryDeck2.generate();
        for (int i = 0; i < 10; i++)    //display all cards in the generated deck
            System.out.println(salaryCards2.get(i));

        /* Method: generate()
         *  Test case: The generate() method of salaryDeck3 is called.
         *  Expected output: 10 cards with varying salary amounts. The tax dues are 10% of the
         *  salaries, and the pay raise increments are 20% of the salaries. */
        System.out.println("Test case 3: The generate() method of salaryDeck3 is called.");

        salaryCards3 = salaryDeck3.generate();
        for (int i = 0; i < 10; i++)    //display all cards in the generated deck
            System.out.println(salaryCards3.get(i));

        System.out.println();
        System.out.println("drawFromDeck()");

        /* Method: drawFromDeck()
         *  Test case 1: One card is drawn from salaryDeck1 (originally containing 10 cards).
         *  Expected output: salaryDeck1 will contain 9 elements. */
        System.out.println("Test case 1: One card is drawn from salaryDeck1 (originally containing 10 cards).");

        salaryDeck1.drawFromDeck();
        System.out.println(salaryDeck1);

        /* The next 8 cards are drawn from careerDeck1 for the next test case. */
        for (int i = 0; i < 8; i++)
            salaryDeck1.drawFromDeck();

        /* Method: drawFromDeck()
         *  Test case 2: One card is drawn from salaryDeck1 (originally containing 1 card).
         *  Expected output: salaryDeck1 will contain 0 elements. */
        System.out.println("Test case 2: One card is drawn from salaryDeck1 (originally containing 1 card).");

        salaryDeck1.drawFromDeck();
        System.out.println(salaryDeck1);

        /* Method: drawFromDeck()
         *  Test case 3: One card is drawn from salaryDeck1 (originally containing 0 cards).
         *  Expected output: salaryDeck1 will contain 0 elements (no change). */
        System.out.println("Test case 3: One card is drawn from salaryDeck1 (originally containing 0 cards).");

        salaryDeck1.drawFromDeck();
        System.out.println(salaryDeck1);
    }
}
