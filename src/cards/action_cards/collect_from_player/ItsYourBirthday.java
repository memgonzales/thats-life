package cards.action_cards.collect_from_player;

import cards.action_cards.CollectFromPlayer;
import core.Bank;
import core.Player;

import java.util.ArrayList;

/**
 * Class implementing an <b>It's Your Birthday</b> action card, which asks the player
 * to collect money from all the other players, equivalent to the birthday gift
 * indicated in this card
 */
public class ItsYourBirthday extends CollectFromPlayer {
    /**
     * Creates an It's Your Birthday action card object
     *
     * <p>In particular, an It's Your Birthday card has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is "It's Your Birthday".</li>
     *     <li>The lower bound for the birthday gift is $5000.</li>
     *     <li>The upper bound for the birthday gift is $20000.</li>
     *     <li>The increment for the birthday gift is $1000.</li>
     * </ul>
     *
     * <p>The bounds and the increments were decided upon by the programmers.</p>
     *
     * <p>The constructor of the parent class takes care of the initialization of the
     * birthday gift.</p>
     */
    public ItsYourBirthday() {
        /* Invoke the constructor of the parent class. */
        super("It's Your Birthday", 5000, 20000, 1000);
    }

    /**
     * Executes the action specified in this card, that is, the player collects
     * money from all the other players, equivalent to the birthday gift
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
            players.get(i).payCashToPlayer(currPlayer, b, getAmount());
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "It's your birthday!
     * Collect [birthday gift] from every other player as a gift."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo () {
        return "It's your birthday! Collect $" + getAmount() + " from each player as a gift. \n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amount it instructs the player to collect from all the other players.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Action card)</li>
     *     <li>Name of the card (It's Your Birthday)</li>
     *     <li>The header "Amount Collected from Other Player" (which is a general
     *     description of the Collect from Player category of action cards)</li>
     *     <li>The birthday gift as the amount collected from every other player</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() + getAmount() + " (from every player) \n";
    }
}
