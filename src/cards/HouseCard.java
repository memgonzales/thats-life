package cards;

import core.MachineRandom;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing a <b>house card</b>, which includes a buying price and
 * selling price (or the amount the player receives upon retirement)
 *
 * <p> A house card is picked when the player lands on the magenta space
 * "Buy A House." </p>
 */
public class HouseCard extends Card implements MachineRandom {
    /* Buying price of the house */
    private int buyingPriceHouse;
    /* Selling price of the house*/
    private int sellingPriceHouse;

    /**
     * The programmers decided to implement the house prices in multiples of 1000.
     */
    public static final int MULTIPLIER = 1000;
    /**
     * The programmers decided to compute the selling prices as 80% of the buying
     * prices.
     */
    public static final double SELLING_MULTIPLIER = 0.8;

    /**
     * Creates a house card object
     *
     * <p>In particular, a house card has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is one of the ten names enumerated by the programmers in the
     *     HouseCardDeck class.</li>
     *     <li>The buying price is a multiple of 1000 between $75000 and $150000 inclusive,
     *     as randomly generated using the <code>getMachineRandNum()</code> method.</li>
     *     <li>The selling price is computed as 80% of the buying price.</li>
     * </ul>
     *
     * @param name of the house specified in the house card
     */
    public HouseCard(String name) {
        /* Invoke the constructor of the parent class, passing the parameter name
        as the name of this card.
         */
        super(name);

        /* The buying price is a randomly generated multiple of $1000 within the range $75000 to
        $150000 (inclusive).
         */
        buyingPriceHouse = MULTIPLIER * getMachineRandNum();

        /* The selling price is computed as 80% of the buying price using the constant
        SELLING_MULTIPLIER.

        The resulting amount is type-casted to int to maintain consistent display formats during
        the actual gameplay.
         */
        sellingPriceHouse = (int) (SELLING_MULTIPLIER * buyingPriceHouse);
    }

    /**
     * Returns the buying price of the house, as indicated in this card
     *
     * @return buying price of the house, as indicated in this card
     */
    public int getBuyingPriceHouse() {
        return buyingPriceHouse;
    }

    /**
     * Returns the selling price of the house, as indicated in this card
     *
     * @return selling price of the house, as indicated in this card
     */
    public int getSellingPriceHouse() {
        return sellingPriceHouse;
    }

    /**
     * Returns a randomly generated value within the range 75 to 159 (inclusive) using
     * the Java utility class <code>ThreadLocalRandom</code>
     *
     * <p>The constructor uses this returned randomly generated value to initialize
     * the buying and selling prices. </p>
     *
     * <p><b>Pre-condition:</b>
     * Assume that the range of the buying price is [75<i>k</i>, 150<i>k</i>], where <i>k</i>
     * is the multiplier (that is, the salary is a multiple of <i>k</i>). </p>
     *
     * <p>The range [75, 150] scales down the range of the salary: [75000, 150000]
     * to ensure that the randomly generated value returned by this method can then be
     * multiplied by the appropriate factor and can be used in setting the buying price.</p>
     *
     * <p>Technically, the number is generated in a pseudorandom fashion, which
     * is adequate for the purposes of the game.</p>
     *
     * @return randomly generated value within the range 75 to 150 (inclusive)
     */
    @Override
    public int getMachineRandNum() {
        /* The +1 in the upper bound is important since ThreadLocalRandom treats the
        lower bound as inclusive but the upper bound as exclusive.
         */
        return ThreadLocalRandom.current().nextInt(75, 151);
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "[house name] was bought for
     * [buying price]."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return getName() + " was bought for " + buyingPriceHouse + ".\n";
    }

    /**
     * Return a string representation of this house card, which includes its name and
     * associated prices
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (House Card)</li>
     *     <li>Name of the house card</li>
     *     <li>Buying price</li>
     *     <li>Selling price</li>
     * </ul>
     *
     * @return string representation of this house card, which includes its name and
     * associated prices
     */
    @Override
    public String toString() {
        return "HOUSE CARD\n" +
                "Name: " + getName() + "\n" +
                "Buying Price: " + buyingPriceHouse + "\n" +
                "Selling Price " + sellingPriceHouse + "\n";
    }

    /**
     * Returns <code>true</code> if the buying prices of two house cards are equal
     * and <code>false</code> otherwise
     *
     * <p>This method is used in the program to ensure that the generated house cards
     * in the house card deck have unique buying prices.</p>
     *
     * @return <code>true</code> if the buying prices of two house cards are equal;
     * <code>false</code>, otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        /* The buying prices of this HouseCard object and the object passed as the
        method parameter are compared.
        */
        return ((HouseCard) obj).getBuyingPriceHouse() == this.getBuyingPriceHouse();
    }
}
