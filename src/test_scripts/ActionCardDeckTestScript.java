import cards.Card;
import core.DiscardPile;
import decks.ActionCardDeck;

import java.util.ArrayList;

/**
 * Test script for <code>ActionCardDeck</code> class
 */
public class ActionCardDeckTestScript {
    public static void main(String[] args) {

        ActionCardDeck actionDeck1;
        ActionCardDeck actionDeck2;
        ActionCardDeck actionDeck3;

        DiscardPile pile;

        ArrayList<Card> actionCards1;
        ArrayList<Card> actionCards2;
        ArrayList<Card> actionCards3;

        /* A DiscardPile object is created to store the details of the drawn cards. */
        pile = new DiscardPile();

        /* Three Card array lists are created to store the details of the generated cards. */
        actionCards1 = new ArrayList<>();
        actionCards2 = new ArrayList<>();
        actionCards3 = new ArrayList<>();

        /* Constructor: ActionCardDeck ()
         *  Three ActionCardDeck objects are created to test the random generation of cards. */
        actionDeck1 = new ActionCardDeck();
        actionDeck2 = new ActionCardDeck();
        actionDeck3 = new ActionCardDeck();

        System.out.println("generate()");

        /* Method: generate()
         *  Test case 1: The generate() method of actionDeck2 is called.
         *  Expected output: 50 cards generated using the following scheme: 20 "Collect
         *  From the Bank" cards, 20 "Pay the Bank" cards, 5 "Pay the Player" cards, and
         *  5 "Collect From the Player" cards. The individual card types under these
         *  classifications are randomly generated. */
        System.out.println("Test case 1: The generate() method of actionDeck1 is called.");

        actionCards1 = actionDeck1.generate();
        for (int i = 0; i < 50; i++)    //display all cards in the generated deck
            System.out.println(actionCards1.get(i));

        /* Method: generate()
         *  Test case 2: The generate() method of actionDeck2 is called.
         *  Expected output: 50 cards generated using the following scheme: 20 "Collect
         *  From the Bank" cards, 20 "Pay the Bank" cards, 5 "Pay the Player" cards, and
         *  5 "Collect From the Player" cards. The individual card types under these
         *  classifications are randomly generated. */
        System.out.println("Test case 2: The generate() method of actionDeck2 is called.");

        actionCards2 = actionDeck2.generate();
        for (int i = 0; i < 50; i++)    //display all cards in the generated deck
            System.out.println(actionCards2.get(i));

        /* Method: generate()
         *  Test case 3: The generate() method of actionDeck3 is called.
         *  Expected output: 50 cards generated using the following scheme: 20 "Collect
         *  From the Bank" cards, 20 "Pay the Bank" cards, 5 "Pay the Player" cards, and
         *  5 "Collect From the Player" cards. The individual card types under these
         *  classifications are randomly generated. */
        System.out.println("Test case 3: The generate() method of actionDeck3 is called.");

        actionCards3 = actionDeck3.generate();
        for (int i = 0; i < 50; i++)    //display all cards in the generated deck
            System.out.println(actionCards3.get(i));

        System.out.println();
        System.out.println("drawFromDeck()");

        /* Method: drawFromDeck()
         *  Test case 1: One card is drawn from actionDeck1 (originally containing 50 cards).
         *  Expected output: actionDeck1 will contain 49 elements, and pile will contain one element. */
        System.out.println("Test case 1: One card is drawn from actionDeck1 (originally containing 50 cards).");

        actionDeck1.drawFromDeck(pile);
        System.out.println(actionDeck1);
        System.out.println(pile);

        /* The next 48 cards are drawn from actionDeck1 for the next test case. */
        for (int i = 0; i < 48; i++)
            actionDeck1.drawFromDeck(pile);

        /* Method: drawFromDeck()
         *  Test case 2: One card is drawn from actionDeck1 (originally containing 1 card).
         *  Expected output: actionDeck1 will contain 0 elements, and pile will contain 50 elements. */
        System.out.println("Test case 2: One card is drawn from actionDeck1 (originally containing 1 card).");

        actionDeck1.drawFromDeck(pile);
        System.out.println(actionDeck1);
        System.out.println(pile);

        /* Method: drawFromDeck()
         *  Test case 3: One card is drawn from actionDeck1 (originally containing 0 cards).
         *  Expected output: actionDeck1 will contain 49 elements, and pile will contain 1 element.*/
        System.out.println("Test case 3: One card is drawn from actionDeck1 (originally containing 0 cards).");

        actionDeck1.drawFromDeck(pile);
        System.out.println(actionDeck1);
        System.out.println(pile);

        System.out.println();
        System.out.println("getMachineRandNum()");

        /* Method: getMachineRandNum()
         *  Test case 1: getMachineRandNum() is called.
         *  Expected output: A randomly generated non-negative integer (used for generating the action cards).*/
        System.out.println("Test case 1: getMachineRandNum() is called.");

        System.out.println(actionDeck1.getMachineRandNum());

        /* Method: getMachineRandNum()
         *  Test case 2: getMachineRandNum() is called.
         *  Expected output: A randomly generated non-negative integer (used for generating the action cards).*/
        System.out.println("Test case 2: getMachineRandNum() is called.");

        System.out.println(actionDeck1.getMachineRandNum());

        /* Method: getMachineRandNum()
         *  Test case 3: getMachineRandNum() is called.
         *  Expected output: A randomly generated non-negative integer (used for generating the action cards).*/
        System.out.println("Test case 3: getMachineRandNum() is called.");

        System.out.println(actionDeck1.getMachineRandNum());
    }
}
