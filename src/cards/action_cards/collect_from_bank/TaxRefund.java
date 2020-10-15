package cards.action_cards.collect_from_bank;

import cards.action_cards.CollectFromTheBank;
import core.*;

/**
 * Class implementing a <b>Tax Refund</b> action card, which asks the player
 * to collect money from the Bank, equivalent to his/her current tax due
 *
 * <p>The tax due of a player incorporates the re-computation after pay raises. </p>
 */
public class TaxRefund extends CollectFromTheBank {
    /**
     * Creates a Tax Refund action card object
     *
     * <p>In particular, a Tax Refund  action card is initialized with the
     * name "Tax Refund".</p>
     */
    public TaxRefund() {
        super("Tax Refund");
    }

    /**
     * Executes the action specified in this card, that is, the player collects
     * money from the bank, equivalent to his/her current tax due
     *
     * <p>The current tax due of a player incorporates the re-computation after
     * pay raises. </p>
     *
     * @param currPlayer current player with turn
     * @param b Bank of the game
     */
    @Override
    public void execute(Player currPlayer, Bank b) {
        if (currPlayer.getSalaryCard() != null)
            currPlayer.collectCashFromBank(b, currPlayer.getTaxDue());
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You have received a tax refund!
     * Collect your tax due from the Bank."
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo () {
        return "You received a tax refund! Collect your tax due from the Bank.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amount it instructs the player to collect from the Bank
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Action card)</li>
     *     <li>Name of the card (Tax Refund)</li>
     *     <li>The header "Amount Collected from the Bank" (which is a general
     *     description of the Collect from the Bank category of action cards)</li>
     *     <li>The phrase "Player's tax" as the amount collected from the Bank</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() + "Player's tax\n";
    }
}
