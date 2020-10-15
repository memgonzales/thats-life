

import cards.Card;
import decks.CareerCardDeck;

import java.util.ArrayList;

/**
 * Test script for <code>CareerCardDeck</code> class
 */
public class CareerCardDeckTestScript {
    public static void main(String[] args) {

        CareerCardDeck careerDeck1;
        CareerCardDeck careerDeck2;
        CareerCardDeck careerDeck3;

        ArrayList<Card> careerCards1;
        ArrayList<Card> careerCards2;
        ArrayList<Card> careerCards3;

        /* Three Card array lists are created to store the details of the generated cards. */
        careerCards1 = new ArrayList<>();
        careerCards2 = new ArrayList<>();
        careerCards3 = new ArrayList<>();

        /* Constructor: CareerCardDeck ()
         *  Three CareerCardDeck objects are created to test the random generation of maximum pay raises. */
        careerDeck1 = new CareerCardDeck();
        careerDeck2 = new CareerCardDeck();
        careerDeck3 = new CareerCardDeck();

        System.out.println("generate()");

        /* Method: generate()
         *  Test case: The generate() method of careerDeck1 is called.
         *  Expected output: 7 cards generated using the following scheme: one each of the
         *  Lawyer, Accountant, ComputerConsultant, Doctor, Server, RacecarDriver, and Athlete
         *  career cards. */
        System.out.println("Test case 1: The generate() method of careerDeck1 is called.");

        careerCards1 = careerDeck1.generate();
        for (int i = 0; i < 7; i++)    //display all cards in the generated deck
            System.out.println(careerCards1.get(i));

        /* Method: generate()
         *  Test case: The generate() method of careerDeck2 is called.
         *  Expected output: 7 cards generated using the following scheme: one each of the
         *  Lawyer, Accountant, ComputerConsultant, Doctor, Server, RacecarDriver, and Athlete
         *  career cards. */
        System.out.println("Test case 2: The generate() method of careerDeck2 is called.");

        careerCards2 = careerDeck2.generate();
        for (int i = 0; i < 7; i++)    //display all cards in the generated deck
            System.out.println(careerCards2.get(i));

        /* Method: generate()
         *  Test case: The generate() method of careerDeck3 is called.
         *  Expected output: 7 cards generated using the following scheme: one each of the
         *  Lawyer, Accountant, ComputerConsultant, Doctor, Server, RacecarDriver, and Athlete
         *  career cards. */
        System.out.println("Test case 3: The generate() method of careerDeck3 is called.");

        careerCards3 = careerDeck3.generate();
        for (int i = 0; i < 7; i++)    //display all cards in the generated deck
            System.out.println(careerCards3.get(i));

        System.out.println();
        System.out.println("drawFromDeck()");

        /* Method: drawFromDeck()
         *  Test case 1: One card is drawn from careerDeck1 (originally containing 7 cards).
         *  Expected output: careerDeck1 will contain 6 elements. */
        System.out.println("Test case 1: One card is drawn from careerDeck1 (originally containing 7 cards).");

        careerDeck1.drawFromDeck();
        System.out.println(careerDeck1);

        /* The next 5 cards are drawn from careerDeck1 for the next test case. */
        for (int i = 0; i < 5; i++)
            careerDeck1.drawFromDeck();

        /* Method: drawFromDeck()
         *  Test case 2: One card is drawn from careerDeck1 (originally containing 1 card).
         *  Expected output: careerDeck1 will contain 0 elements. */
        System.out.println("Test case 2: One card is drawn from careerDeck1 (originally containing 1 card).");

        careerDeck1.drawFromDeck();
        System.out.println(careerDeck1);

        /* Method: drawFromDeck()
         *  Test case 3: One card is drawn from careerDeck1 (originally containing 0 cards).
         *  Expected output: careerDeck1 will contain 0 elements (no change).*/
        System.out.println("Test case 3: One card is drawn from careerDeck1 (originally containing 0 cards).");

        careerDeck1.drawFromDeck();
        System.out.println(careerDeck1);
    }
}
