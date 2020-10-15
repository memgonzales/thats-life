package spaces.magenta_spaces;

import cards.HouseCard;
import core.Bank;
import core.Player;
import decks.HouseCardDeck;
import spaces.MagentaSpace;

import java.util.ArrayList;

/**
 * Class implementing a <b>buy a house space</b>.
 *
 * <p>Players on a buy a house space choose a house card from the cards
 * available in the house card deck.</p>
 */
public class BuyAHouse extends MagentaSpace {
    /**
     * Creates a buy a house space object
     *
     * <p>In particular, a buy a house space has its attributes initialized as follows: </p>
     *
     * <ul>
     *     <li>Its name is assigned as "Buy A House".</li>
     *     <li>Its index on the board is assigned the passed parameter index.</li>
     *     <li>Its next index is assigned the passed parameter nextIndex.</li>
     * </ul>
     *
     * @param index the index of the space on the board
     * @param nextIndex the index of the next space the player can move to from
     * this space
     */
    public BuyAHouse(int index, int nextIndex) {
        /* Invoke the constructor of the parent class, passing the string "Buy a House"
        and the appropriate index values. The same index is used for both next index values
        of the space, as there is only one other space a player can move to from a
        buy a house space.
        */
        super("Buy a House", index, nextIndex, nextIndex);
    }

    /**
     * Returns the house cards a player can choose from
     *
     * <p>On a buy a house space, a player chooses a house to purchase from the
     * remaining house cards in the deck.</p>
     *
     * @param currPlayer current player with turn
     * @param d HouseCardDeck object of the game
     * @return the house cards a player can choose from
     */
    public ArrayList<HouseCard> getHouseCards(Player currPlayer, HouseCardDeck d) {
        ArrayList<HouseCard> houseCards;
        /* An array list of house cards is created to store all the house cards
        currently in the deck
        */
        houseCards = new ArrayList<HouseCard>(d.getCurrNumCards());
        int num = d.getCurrNumCards();
        /* The cards in the house card deck are drawn and returned for the
        player to choose from
        */
        for (int i = 0; i < num; i++)
            houseCards.add(currPlayer.drawFromHouseDeck(d, 0));

        return houseCards;
    }

    /**
     * Executes the action associated with this space; that is, the player
     * chooses a house card from the house card deck
     *
     * <p>On a buy a house space, the player chooses a house to buy among the
     * available house cards in the deck.</p>
     *
     * @param currPlayer current player with turn
     * @param houseCards list of house cards the player can choose from
     * @param d HouseCardDeck object of the game
     * @param index index of the chosen house card in the passed array list
     * @param b Bank object of the game
     */
    public void execute(Player currPlayer, ArrayList<HouseCard> houseCards, HouseCardDeck d, int index, Bank b) {
        /* The player keeps their chosen house card and takes out loans from the bank
        as needed to purchase the house.
        */
        currPlayer.keepHouseCard(houseCards.get(index), b);

        /* The other cards that were not chosen are returned to the house card deck */
        for (int i = 0; i < houseCards.size(); i++)
            if (i != index)
                currPlayer.returnCard(houseCards.get(i), d);
    }

    /**
     * Returns the string to be used as a prompt in the actual gameplay when the player
     * is on a buy a house space
     *
     * <p>In particular, the returned string reads as follows: "[Player name], you are
     * on a Buy A House space. Choose a house to buy from the available options." </p>
     *
     * @param currPlayer current player with turn
     * @return string to be used as a prompt in the actual gameplay when the player is
     * on a buy a house space
     */
    @Override
    public String getInfo(Player currPlayer) {
        return currPlayer.getName() + ", you are on a Buy A House space.\n" +
                "Choose a house to buy from the available options.\n" +
                "You are entitled to ANOTHER TURN right after this.\n";
    }
}
