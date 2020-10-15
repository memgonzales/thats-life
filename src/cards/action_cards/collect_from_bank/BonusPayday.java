package cards.action_cards.collect_from_bank;

import cards.action_cards.CollectFromTheBank;
import core.*;

/**
 * Class implementing a <b>Bonus Payday</b> action card, which asks the player
 * to collect money from the Bank, equivalent to his/her current salary
 *
 * <p>The current salary of a player is equal to his/her base salary along
 * with the pay raise/s.</p>
 */
public class BonusPayday extends CollectFromTheBank {
    /**
     * Creates a Bonus Payday action card object
     *
     * <p>In particular, a Bonus Payday action card is initialized with the
     * name "Bonus Payday".</p>
     */
    public BonusPayday() {
        /* Invoke the constructor of the parent class, passing the string "Bonus Payday" */
        super("Bonus Payday");
    }

    /**
     * Executes the action specified in this card, that is, the player collects
     * money from the bank, equivalent to his/her current salary
     *
     * <p>The current salary of a player is equal to his/her base salary along
     * with the pay raise/s.</p>
     *
     * @param currPlayer current player with turn
     * @param b Bank of the game
     */
    @Override
    public void execute(Player currPlayer, Bank b) {
        if (currPlayer.getSalaryCard() != null)
            currPlayer.collectCashFromBank(b, currPlayer.getSalary());
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You have received a bonus equal
     * to your current salary! Collect a paycheck from the Bank."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo () {
        return "You have received a bonus equal to your current salary! Collect a paycheck from the Bank.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amount it instructs the player to collect from the Bank
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Action card)</li>
     *     <li>Name of the card (Bonus Payday)</li>
     *     <li>The header "Amount Collected from the Bank" (which is a general
     *     description of the Collect from the Bank category of action cards)</li>
     *     <li>The phrase "Player's salary" as the amount collected from the Bank</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() + "Player's salary\n";
    }
}
