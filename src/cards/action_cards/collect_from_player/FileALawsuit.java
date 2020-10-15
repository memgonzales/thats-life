package cards.action_cards.collect_from_player;

import cards.action_cards.CollectFromPlayer;
import core.Bank;
import core.Player;

/**
 * Class implementing a <b>File a Lawsuit</b> action card, which asks the player
 * to collect money from another player of his/her choice, equivalent to the lawsuit
 * compensation indicated in this card.
 */
public class FileALawsuit extends CollectFromPlayer {
    /**
     * Creates a File a Lawsuit action card object
     *
     * <p>In particular, a File a Lawsuit action card has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is "File a Lawsuit".</li>
     *     <li>The lower bound for the lawsuit compensation is $50000.</li>
     *     <li>The upper bound for the lawsuit compensation is $150000.</li>
     *     <li>The increment for the lawsuit compensation is $10000.</li>
     * </ul>
     *
     * <p>The bounds and the increments were decided upon by the programmers.</p>
     *
     * <p>The constructor of the parent class takes care of the initialization of the
     * lawsuit compensation.</p>
     */
    public FileALawsuit() {
        /* Invoke the constructor of the parent class. */
        super("File a Lawsuit", 50000, 150000, 10000);
    }

    /**
     * Executes the action specified in this card, that is, the player collects
     * money from another player of his/her choice, equivalent to the lawsuit compensation
     * indicated in this card
     *
     * @param currPlayer current player with turn
     * @param otherPlayer player who will pay the current player an amount equivalent
     *                    to the lawsuit compensation indicated in this card
     * @param b Bank of the game
     */
    public void execute(Player currPlayer, Player otherPlayer, Bank b) {
        otherPlayer.payCashToPlayer(currPlayer, b, getAmount());
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You have won a lawsuit.
     * Collect [lawsuit compensation] from a player of your choosing."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo () {
        return "You have won a lawsuit. Collect $" + getAmount() + " from a player of your choosing.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amount it instructs the player to collect from the player of his/her choice.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Action card)</li>
     *     <li>Name of the card (File a Lawsuit)</li>
     *     <li>The header "Amount Collected from Other Player" (which is a general
     *     description of the Collect from Player category of action cards)</li>
     *     <li>The lawsuit compensation as the amount collected from the other player</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() + getAmount() + " (from chosen player) \n";
    }
}
