package cards;

/**
 * Abstract class providing a skeletal implementation of a <b>card</b>
 */
public abstract class Card {
    /* Name of this card */
    private String name;

    /**
     * Constructor with the specified name of this card as parameter
     *
     * <p>The name is the most specific identifier of the card. </p>
     *
     * <ul>
     *     <li>Career cards have names indicative of the career they specify:
     *     Lawyer, Accountant, etc.</li>
     *     <li>Blue cards have names indicative of the action or event they specify:
     *     Ski Accident, Tip the Server, etc.</li>
     *     <li>Action cards have names indicative of the action they specify:
     *     Tax Refund, Sell an Item, etc.</li>
     *     <li>Salary cards have the name "Salary Card" since they have no
     *     specific subtypes and are only differentiated based on the value
     *     indicated on them</li>
     *     <li>House cards have one of the ten names enumerated in the
     *     HouseCardDeck class; however, these names are not indicative of the
     *     other properties of the house cards and were only included by the
     *     programmers for smoother gameplay</li>
     * </ul>
     *
     * @param name name of this card
     */
    public Card(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this card
     *
     * <p>The name is the most specific identifier of the card. </p>
     *
     * <ul>
     *     <li>Career cards have names indicative of the career they specify:
     *     Lawyer, Accountant, etc.</li>
     *     <li>Blue cards have names indicative of the action or event they specify:
     *     Ski Accident, Tip the Server, etc.</li>
     *     <li>Action cards have names indicative of the action they specify:
     *     Tax Refund, Sell an Item, etc.</li>
     *     <li>Salary cards have the name "Salary Card" since they have no
     *     specific subtypes and are only differentiated based on the value
     *     indicated on them</li>
     *     <li>House cards have one of the ten names enumerated in the
     *     HouseCardDeck class; however, these names are not indicative of the
     *     other properties of the house cards and were only included by the
     *     programmers for smoother gameplay</li>
     * </ul>
     *
     * @return name of this card
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract method for returning the card description to be displayed as a prompt
     * during the actual gameplay
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    public abstract String getInfo();

    /**
     * Returns a string representation of this card, which includes its name
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of game component (Card)</li>
     *     <li>Name of the card (for example, Tax Refund, Sell an Item, etc.)</li>
     * </ul>
     *
     * @return string representation of this card, which includes its name
     */
    @Override
    public String toString() {
        return "CARD\n" +
                "Name : " + name + "\n";
    }
}
