package cards.action_cards;

import cards.ActionCard;
import core.*;

/**
 * Abstract class providing a skeletal implementation of an <b>action card that
 * asks the player to collect money from the Bank</b>
 *
 * <p>Unlike the other categories of action cards, Collect from the Bank action cards
 * include those with amounts that vary depending on the player who drew the card
 * (for example, tax due and salary). Therefore, they cannot be initialized inside
 * the constructor of this abstract class and must be handled individually
 * by its subclasses.</p>
 */
public abstract class CollectFromTheBank extends ActionCard {

    /**
     * Constructor with the specified name as parameter
     *
     * <p>The name of an action card that asks the player to collect money from the Bank
     * is indicative of the action if specifies: Tax Refund, Sell an Item, etc.</p>
     *
     * @param name name of this card
     */
    public CollectFromTheBank(String name) {
        /* Invoke the constructor of the parent class. */
        super(name);
    }

    /**
     * Abstract method for the execution of the action specified in the card
     *
     * @param currPlayer current player with turn
     * @param b Bank of the game
     */
    public abstract void execute(Player currPlayer, Bank b);

    /**
     * Returns a string representation of this card, which includes its name and its
     * description as an action card that asks a player to collect money from the Bank
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Action card)</li>
     *     <li>Name of the card (for example, Tax Refund, Sell an Item, etc.)</li>
     *     <li>The header "Amount Collected from Bank" (which is a general
     *     description of the Collect from the Bank category of action cards)</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() + "Collected from the Bank: ";
    }
}
