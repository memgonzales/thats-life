package cards.action_cards.pay_player;

import cards.action_cards.PayThePlayer;
import core.Bank;
import core.Player;

import java.util.ArrayList;

/**
 * Class implementing an <b>Christmas Bonus</b> action card, which asks the player
 * to pay money to all the other players, equivalent to the Christmas bonus
 * indicated in this card
 */
public class ChristmasBonus extends PayThePlayer {
    /**
     * Creates a Christmas Bonus action card object
     *
     * <p>In particular, a Christmas Bonus card has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is "Christmas Bonus".</li>
     *     <li>The lower bound for the Christmas bonus is $5000.</li>
     *     <li>The upper bound for the Christmas bonus is $20000.</li>
     *     <li>The increment for the Christmas bonus is $1000.</li>
     * </ul>
     *
     * <p>The bounds and the increments were decided upon by the programmers.</p>
     *
     * <p>The constructor of the parent class takes care of the initialization of the
     * Christmas bonus.</p>
     */
    public ChristmasBonus() {
        super("Christmas Bonus", 5000, 20000, 1000);
    }

    /**
     * Executes the action specified in this card, that is, the player pays
     * money to all the other players, equivalent to the Christmas bonus
     * indicated in this card
     *
     * @param currPlayer current player with turn
     * @param players <code>ArrayList</code> containing all the players in the game
     * @param b Bank of the game
     */
    public void execute(Player currPlayer, ArrayList<Player> players, Bank b) {
        /* The current player is not excluded from this iterative construct
        since the player paying cash to himself/herself results in a zero
        net effect to his/her cash anyway.
         */
        for (int i = 0; i < players.size(); i++)
            currPlayer.payCashToPlayer(players.get(i), b, getAmount());
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "Happy holidays! Pay
     * [Christmas bonus] to every other player as a Christmas gift."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo () {
        return "Happy holidays! Pay $" + getAmount() + " to each player as a Christmas gift.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amount it instructs the player to pay to all the other players.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Action card)</li>
     *     <li>Name of the card (Christmas Bonus)</li>
     *     <li>The header "Amount Paid to Other Player" (which is a general
     *     description of the Pay the Player category of action cards)</li>
     *     <li>The Christmas bonus as the amount paid to every other player</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() + getAmount() + " (to every player) \n";
    }
}
