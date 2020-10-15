package core;

import java.util.ArrayList;

/**
 * Class implementing the <b>Bank</b> of the game
 *
 * <p>The player can interact with the Bank in the following manner:</p>
 *
 * <ul>
 *     <li>Loan money at any point in the game or when his/her cash becomes deficit</li>
 *     <li>Pay unpaid loan/s</li>
 *     <li>Receive money from the bank due to the effect of a card drawn (that is, the
 *     received money is not counted as a loan)</li>
 *     <li>Pay money to the bank due to the effect of a card drawn (that is, the
 *     paid money is not counted as loan repayment)</li>
 * </ul>
 *
 * <p>The Bank is assumed to have an unlimited supply of cash.</p>
 */
public class Bank {
    /* List to keep track of the number of unpaid loans of all the players */
    private ArrayList<Integer> playerNumLoans;

    /**
     * Per the machine project specifications, a bank loan is equivalent
     * to $20000.
     */
    public static final int LEND_MULTIPLE = 20000;
    /**
     * Per the machine project specifications, a loan payment is charged
     * with $5000 interest; therefore, every payment totals to $25000.
     */
    public static final int PAYMENT_MULTIPLE = 25000;

    /**
     * Creates a Bank object with the number of players as parameter
     *
     * In particular, the values in the list used to keep track of the number of unpaid
     * loans of all the players are initialized to $0.
     *
     * @param numPlayers is the number of players
     */
    public Bank(int numPlayers) {
        playerNumLoans = new ArrayList<Integer>(numPlayers);

        /* At the beginning of the game, no player has any loan. */
        for (int i = 0; i < numPlayers; i++)
            playerNumLoans.add(0);
    }

    /**
     * Returns a copy of the <code>ArrayList</code> containing the number of unpaid loans
     * of all the players
     *
     * <p>Only a copy is returned to avoid unintended modification of the list kept by
     * this Bank.</p>
     *
     * @return copy of the <code>ArrayList</code> containing the number of unpaid loans of
     * all the players
     */
    public ArrayList<Integer> getPlayerNumLoans() {
        ArrayList<Integer> copyPlayerNumLoans;
        copyPlayerNumLoans = new ArrayList<Integer>(playerNumLoans.size());

        /* Create the copy to avoid unintended modification of the original. */
        for (int i = 0; i < playerNumLoans.size(); i++)
            copyPlayerNumLoans.add(Integer.valueOf(playerNumLoans.get(i)));

        return copyPlayerNumLoans;
    }

    /**
     * Lends the specified number of loans to a player
     *
     * <p>In particular, lending loans to a player involves the following processes: </p>
     *
     * <ul>
     *     <li>Increases the cash of the player by the corresponding amount.</li>
     *     <li>Update the number of unpaid loans of the player.</li>
     *     <li>Keep track of the lent loans in the Bank's internal records as part of the
     *     player's unpaid loans.</li>
     * </ul>
     *
     * <p>If the number of loans requested by the player is not positive, then
     * nothing happens. </p>
     *
     * @param p player to whom this Bank will lend the specified number of loans
     * @param numLoans number of loans this Bank will lend the player
     */
    public void lendLoan(Player p, int numLoans) {
        /* Index of the player to whom this Bank will lend the specified number of loans */
        int idxPlayerNumLoan;
        idxPlayerNumLoan = getIndexOfNumLoansOf(p);

        /* Do nothing if the number of loans requested is not positive */
        if (isNumPositive(numLoans)) {
            /* Increase the player's cash. */
            p.increaseCashBy(LEND_MULTIPLE * numLoans);
            /* Update the number of unpaid loans of the player. */
            p.increaseNumLoansBy(numLoans);
            /* Keep track of the lent loans in the Bank's internal records as part
            of the player's unpaid loans.
             */
            playerNumLoans.set(idxPlayerNumLoan, playerNumLoans.get(idxPlayerNumLoan) + numLoans);
        }
    }

    /**
     * Receives the specified number of loan payments of a player
     *
     * <p>In particular, receiving the loan payments of a player involves the following processes:</p>
     *
     * <ul>
     *     <li>Decrease the cash of the player by the corresponding amount.</li>
     *     <li>Update the number of unpaid loans of the player.</li>
     *     <li>Discard the paid loans from this Bank's internal records. </li>
     * </ul>
     *
     * <p>If the number of payments specified by the player is not positive or
     * will cause him/her to have a cash deficit, then nothing happens. </p>
     *
     * @param p player whose loan payments will be received by this Bank
     * @param numPayments number of loan payments specified by the player
     */
    public void receivePayment(Player p, int numPayments) {
        /* Index of the player to whose loan payments will be received by this Bank */
        int idxPlayerNumLoan;
        idxPlayerNumLoan = getIndexOfNumLoansOf(p);

        /* Do nothing if the number of payments is not positive or will cause the player
        to have a cash deficit.
         */
        if (isNumPositive(numPayments) && canPayCash(p, numPayments * PAYMENT_MULTIPLE) && numPayments <= p.getCurrNumLoans()) {
            /* Decrease the player's cash. */
            p.decreaseCashBy(PAYMENT_MULTIPLE * numPayments);
            /* Update the number of unpaid loans of the player. */
            p.decreaseNumLoansBy(numPayments);
            /* Discard the paid loans from this Bank's internal records. */
            playerNumLoans.set(idxPlayerNumLoan, playerNumLoans.get(idxPlayerNumLoan) - numPayments);
        }
    }

    /**
     * Gives the specified amount of cash to a player (not counted as a loan)
     *
     * <p>This method is invoked as the effect of the execution of specific types of cards
     * (for example, Collect from the Bank action cards).</p>
     *
     * <p>If the amount specified is not positive, then nothing happens.</p>
     *
     * @param p player to whom this Bank will give the specified amount of cash
     * @param amount amount to be given to the player
     */
    public void giveCash(Player p, int amount) {
        /* Do nothing if the amount specified is not positive. */
        if (isNumPositive(amount))
            p.increaseCashBy(amount);
    }

    /**
     * Receives the specified amount of cash from a player (not counted as a loan payment)
     *
     * <p>This method is invoked as the effect of the execution of specific types of cards
     * (for example, Pay the Bank action cards).</p>
     *
     * <p>If the amount specified is not positive or will cause the player to have a cash deficit,
     * then nothing happens. </p>
     *
     * @param p player from whom this Bank will receive the specified amount of cash
     * @param amount amount to be received by this Bank
     */
    public void receiveCash(Player p, int amount) {
        if (isNumPositive(amount) && canPayCash(p, amount))
            p.decreaseCashBy(amount);
    }

    /**
     * Returns the index in the Bank's internal records of the number of unpaid loans
     * of the specified player
     *
     * @param p player whose index in the Bank's internal records of the number of
     *          his/her unpaid loans will be returned
     * @return index in the Bank's internal records of the number of the unpaid loans
     * of the specified player
     */
    private int getIndexOfNumLoansOf(Player p) {
        /* The ID of the first generated player is 1, corresponding to index 0 in the
        Bank's internal records (following the convention used in Java to refer to the
        first element of a list).

        In general, if the ID is n, then the index is n - 1.
         */
        return p.getID() - 1;
    }

    /**
     * Returns <code>true</code> if the given number is positive; <code>false</code>, otherwise
     *
     * @param num is the given number to be tested for positivity
     * @return <code>true</code> if the given number is positive; <code>false</code>, otherwise
     */
    private boolean isNumPositive(int num) { return num > 0; }

    /**
     * Returns <code>true</code> if the player can pay the specified amount without having
     * a cash deficit; <code>false</code>, otherwise
     *
     * @param p player whose capacity to pay the specified amount without having a cash deficit
     *          will be checked
     * @param amount specified amount to be paid by the player
     * @return <code>true</code> if the
     */
    private boolean canPayCash(Player p, int amount) {
        return p.getCash() >= amount;
    }

    /**
     * Returns a string representation of this Bank, which includes the number
     * of unpaid loans of all the players
     *
     * <p>In particular, the representation includes the following details: </p>
     *
     * <ul>
     *     <li>Type of game component (Bank)</li>
     *     <li>Number of unpaid loans of all the players (arranged starting
     *     with the first player to input his/her username)</li>
     * </ul>
     *
     * @return string representation of this Bank, which includes the number
     * of unpaid loans of all the players
     */
    @Override
    public String toString() {
        String retStr;
        retStr = "BANK\n";

        for (int i = 0; i < playerNumLoans.size(); i++) {
            retStr += playerNumLoans.get(i) + "\t";
        }

        return retStr;
    }
}
