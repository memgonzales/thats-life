package cards;

/**
 * Abstract class providing a skeletal implementation of an <b>action card</b>,
 * which asks the player to either pay to or collect money from another player or the Bank
 *
 * <p> An action card is picked whenever the player ends up on an orange space. </p>
 */
public abstract class ActionCard extends Card {
    /**
     * Constructor with the specified name of this card as parameter
     *
     * <p>The name of an action card is indicative of the action it specifies
     * (for example, Tax Refund, Sell an Item, etc.). </p>
     *
     * @param name name of this card
     */
    public ActionCard(String name) {
        /* Invoke the constructor of the parent class. */
        super(name);
    }

    /**
     * Abstract method for returning the card description to be displayed on the console
     * during the actual gameplay
     *
     * @return card description to be displayed on the console during the actual gameplay
     */
    @Override
    public abstract String getInfo();

    /**
     * Returns a string representation of this action card, which includes its name
     *
     * <p>In particular, the representation contains the following details:</p>
     * <ul>
     *     <li>Type of card (Action Card)</li>
     *     <li>Name of the card (for example, Tax Refund, Sell an Item, etc.)</li>
     *     <li>The header "Amount" (the specifics/values are supplied in the <code>toString()</code>
     *     methods of the subclasses)</li>
     * </ul>
     *
     * @return string representation of this action card, which includes its name
     */
    @Override
    public String toString() {
        return "ACTION CARD\n" +
                "Name: " + getName() + "\n" +
                "Amount ";
    }
}
