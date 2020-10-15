package cards.action_cards.collect_from_bank;

import cards.action_cards.CollectFromTheBank;
import core.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing a <b>Write a Book</b> action card, which asks the player
 * to collect money from the Bank, equivalent to the payment for writing a book
 */
public class WriteABook extends CollectFromTheBank implements MachineRandom {
    /* Payment for writing a book (amount of money to be collected from the Bank) */
    private int bookPayment;

    /**
     * Minimum possible payment for writing a book (decided upon by the programmers to be $5000)
     */
    public static final int MIN_BOOK_PAYMENT = 5000;
    /**
     * Maximum possible payment for writing a book (decided upon by the programmers to be $20000)
     */
    public static final int MAX_BOOK_PAYMENT = 20000;
    /**
     * Increment possible payment for writing a book (decided upon by the programmers to be $1000)
     */
    public static final int INCREMENT = 1000;

    /**
     * Creates a Write a Book action card object
     *
     * <p>In particular, a Write a Book school action card object is initialized with the name
     * "Write a Book".</p>
     */
    public WriteABook() {
        super("Write a Book");

        setBookPayment();
    }

    /**
     * Returns the payment for writing a book, as specified in this card
     * @return payment for writing a book, as specified in this card
     */
    public int getBookPayment() {
        return bookPayment;
    }

    /**
     * Executes the action specified in this card, that is, the player collects
     * money from the bank, equivalent to the payment for writing a book, as
     * indicated in this card
     *
     * @param currPlayer current player with turn
     * @param b Bank of the game
     */
    @Override
    public void execute(Player currPlayer, Bank b) {
        currPlayer.collectCashFromBank(b, bookPayment);
    }

    /**
     * Sets the payment for writing a book to a randomly generated value within the
     * upper and lower bounds and following the specified increment
     * (used in the constructor)
     */
    private void setBookPayment() {
        bookPayment = getMachineRandNum();
    }

    /**
     * Returns a randomly generated value within the lower and upper bounds of the possible
     * payment for writing a book (inclusive) and following the specified increment
     * using the Java <code>ThreadLocalRandom</code> utility class
     *
     * <p>A separate (private) function sets the book payment to the returned randomly
     * generated value. </p>
     *
     * <p>Technically, the number is generated in a pseudorandom fashion, which
     * is adequate for the purposes of the game.</p>
     *
     * @return Randomly generated value within the lower and upper bounds of the possible
     * amount (inclusive) and following the specified increment
     */
    @Override
    public int getMachineRandNum() {
        /* Dividing the minimum and maximum possible book payment by the increment, setting
        these as the bounds, and multiplying the randomly generated value by the increment are
        necessary to ensure that the return value is a multiple of the increment within the
        originally specified bounds.

        The +1 in the upper bound is important since ThreadLocalRandom treats the
        lower bound as inclusive but the upper bound as exclusive.
         */
        return INCREMENT * ThreadLocalRandom.current().nextInt(MIN_BOOK_PAYMENT / INCREMENT, MAX_BOOK_PAYMENT / INCREMENT + 1);
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "Your book turned out to be a bestseller!
     * Collect [book payment] from the Bank."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo () {
        return "Your book turned out to be a bestseller! Collect $" + bookPayment + " from the Bank.\n";
    }


    /**
     * Returns a string representation of this card, which includes its name and the
     * amount it instructs the player to collect from the Bank
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Action card)</li>
     *     <li>Name of the card (Write a Book)</li>
     *     <li>The header "Amount Collected from the Bank" (which is a general
     *     description of the Collect from the Bank category of action cards)</li>
     *     <li>The book payment as the amount collected from the Bank</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() + bookPayment + "\n";
    }
}
