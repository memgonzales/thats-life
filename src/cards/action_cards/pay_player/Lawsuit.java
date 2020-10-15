package cards.action_cards.pay_player;

import cards.action_cards.PayThePlayer;
import core.Bank;
import core.Player;

/**
 * Class implementing a <b>Lawsuit</b> action card, which asks the player
 * to pay money to another player of his/her choice, equivalent to the litigation
 * fee indicated in this card.
 */
public class Lawsuit extends PayThePlayer {
    /**
     * Creates a Lawsuit action card object
     *
     * <p>In particular, a Lawsuit action card has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is "Lawsuit".</li>
     *     <li>The lower bound for the litigation cost is $50000.</li>
     *     <li>The upper bound for the litigation cost is $150000.</li>
     *     <li>The increment for the litigation cost is $10000.</li>
     * </ul>
     *
     * <p>The bounds and the increments were decided upon by the programmers.</p>
     *
     * <p>The constructor of the parent class takes care of the initialization of the
     * litigation cost.</p>
     */
    public Lawsuit() {
        /* Invoke the constructor of the parent class. */
        super("Lawsuit", 50000, 150000, 10000);
    }

    /**
     * Executes the action specified in this card, that is, the player pays
     * money to another player of his/her choice, equivalent to the litigation cost
     * indicated in this card
     *
     * @param currPlayer current player with turn
     * @param otherPlayer player who will be paid by the current player with an amount
     *                    equivalent to the litigation cost indicated in this card
     * @param b Bank of the game
     */
    public void execute(Player currPlayer, Player otherPlayer, Bank b) {
        currPlayer.payCashToPlayer(otherPlayer, b, getAmount());
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You have lost a lawsuit.
     * Pay [litigation cost] to a player of your choosing."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo () {
        return "You have lost a lawsuit. Pay $" + getAmount() + " to a player of your choosing.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amount it instructs the player to pay the player of his/her choice.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Action card)</li>
     *     <li>Name of the card (Lawsuit)</li>
     *     <li>The header "Amount Paid to Other Player" (which is a general
     *     description of the Pay the Player category of action cards)</li>
     *     <li>The litigation cost as the amount paid to the other player</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() + getAmount() + " (to chosen player) \n";
    }
}
