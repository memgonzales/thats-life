package cards.blue_cards;

import cards.BlueCard;
import core.Bank;
import core.Player;

/**
 * Class implementing a <b>Salary Tax Due</b> blue card, which asks the player
 * to pay their current tax due to either the bank or the player with the
 * Accountant career
 *
 * <p>The player pays an amount equivalent to their current tax due.</p>
 */
public class SalaryTaxDue extends BlueCard {
    /**
     * Creates a Salary Tax Due blue card object
     *
     * <p>In particular, a Salary Tax Due blue card is initialized with the
     * name "Salary Tax Due" and the career match "Accountant".</p>
     */
    public SalaryTaxDue() {
        /* Invoke the constructor of the parent class, passing the strings "Salary Tax Due"
        and "Accountant"
        */
        super("Salary Tax Due", "Accountant");
    }

    /**
     * Executes the action specified in this card.
     *
     * <p> In particular, the player executes one of the following
     * three actions: </p>
     *
     * <ul>
     *     <li> If the player matches the career match of the card, they receive 15000
     *     from the bank</li>
     *     <li> If no player matches the career match of the card, the player will pay
     *     their current tax due to the bank</li>
     *     <li>If a different player matches the career match of the card, the player
     *     will pay their current tax due to the other player</li>
     *</ul>
     *
     * @param currPlayer current player with turn
     * @param playerWithCareer player whose career matches the career specified in the card
     * @param b Bank of the game
     * @return flag indicative of the executed scenario
     */
    public int execute(Player currPlayer, Player playerWithCareer, Bank b) {
        if (currPlayer.getSalaryCard() != null) {
            if (currPlayer.getCareer().equalsIgnoreCase(getCareerMatch())) {
                /* If the player matches the career match of the card, they receive 15000
                from the bank
                */
                executeMatchedCareer(currPlayer, b);
                return MATCHED_CAREER;

            } else if (playerWithCareer == null) {
                /* If no player matches the career match of the card, the player will pay
                their current tax due to the bank
                */
                currPlayer.payCashToBank(b, currPlayer.getTaxDue());
                return NO_MATCH;
            } else {
                /* If a different player matches the career match of the card, the player
                will pay their current tax due to the other player
                */
                currPlayer.payCashToPlayer(playerWithCareer, b, currPlayer.getTaxDue());
                return OTHER_MATCH;
            }
        }

        return NO_MATCH;
    }

    /**
     * Returns the base card description to be displayed as a prompt during the actual gameplay
     *
     * <p>In particular, the card description reads as follows: "You drew a salary tax due card."</p>
     *
     * @return base card description to be displayed as a prompt during the actual gameplay
     */
    @Override
    public String getInfo() {
        return "You drew a salary tax due card.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     *
     * <p>In particular, the card description reads as follows: "You drew a salary tax due card.
     * Pay your current tax due to the bank."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to the bank
     */
    @Override
    public String getInfoBank() {
        return getInfo() + "Pay your current tax due to the bank.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     *
     * <p>In particular, the card description reads as follows: "You drew a salary tax due card.
     * Receive 15000 as an accountant."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will receive money
     */
    @Override
    public String getInfoMatch() {
        return getInfo() + "Receive $15000 as an accountant.\n";
    }

    /**
     * Returns the card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     *
     * <p>In particular, the card description reads as follows: "You drew a salary tax due card.
     * Pay your current tax due to the accountant."</p>
     *
     * @return card description to be displayed as a prompt during the actual gameplay
     * if the player will pay money to another player
     */
    @Override
    public String getInfoOtherPlayer() {
        return getInfo() + "Pay your current tax due to the accountant.\n";
    }

    /**
     * Returns a string representation of this card, which includes its name and the
     * amounts the player will pay depending on the scenario.
     *
     * <p>In particular, the representation contains the following details:</p>
     *
     * <ul>
     *     <li>Type of card (Blue card)</li>
     *     <li>Name of the card (Salary Tax Due)</li>
     *     <li>Career match of the card (Accountant)</li>
     *     <li>The header "Received if Career Match" (which is a general
     *     description of the blue cards)</li>
     *     <li>The amount 15000 (which is the same for all blue cards)</li>
     *     <li>The header "Paid to Other Player (or Bank)" (which is a general
     *     description of the blue cards)</li>
     *     <li>The string "Tax Due"</li>
     * </ul>
     *
     * @return string representation of this card
     */
    @Override
    public String toString() {
        return super.toString() +
                "Paid to Other Player (or Bank): Tax Due \n";
    }
}
