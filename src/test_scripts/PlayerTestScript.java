

import cards.action_cards.collect_from_bank.BonusPayday;
import cards.action_cards.collect_from_bank.SellAnItem;
import cards.action_cards.collect_from_bank.TaxRefund;
import cards.action_cards.collect_from_player.FileALawsuit;
import cards.action_cards.collect_from_player.ItsYourBirthday;
import cards.action_cards.pay_bank.BuyAnItem;
import cards.action_cards.pay_bank.TrafficViolation;
import cards.action_cards.pay_bank.WinACompetition;
import cards.action_cards.pay_player.ChristmasBonus;
import cards.action_cards.pay_player.Lawsuit;
import cards.blue_cards.*;
import core.*;
import decks.*;

import java.util.ArrayList;

/**
 * Test script for <code>Player</code> class
 */
public class PlayerTestScript {
    public static void main(String[] args) {

        Player p1;
        Player p2;
        Player p3;

        NumberWheel wheel;
        Board brd;

        CareerCardDeck careerDeck;
        SalaryCardDeck salaryDeck;
        ActionCardDeck actionDeck;
        HouseCardDeck houseDeck;
        BlueCardDeck blueDeck;

        DiscardPile pile;

        BonusPayday actionCard1;
        SellAnItem actionCard2;
        TaxRefund actionCard3;
        BuyAnItem actionCard4;
        TrafficViolation actionCard5;
        WinACompetition actionCard6;
        Lawsuit actionCard7;
        ChristmasBonus actionCard8;
        FileALawsuit actionCard9;
        ItsYourBirthday actionCard10;

        ComputerRepair blueCard1;
        F1Race blueCard2;
        LawsuitBlue blueCard3;
        SalaryTaxDue blueCard4;
        SkiAccident blueCard5;
        TipTheServer blueCard6;
        WorldCup blueCard7;

        ArrayList<Player> players;

        Bank b;

        /* Relevant objects are created for testing the Player methods. */
        wheel = new NumberWheel();
        brd = new Board();

        careerDeck = new CareerCardDeck();
        salaryDeck = new SalaryCardDeck();
        actionDeck = new ActionCardDeck();
        houseDeck = new HouseCardDeck();
        blueDeck = new BlueCardDeck();

        pile = new DiscardPile();

        actionCard1 = new BonusPayday();
        actionCard2 = new SellAnItem();
        actionCard3 = new TaxRefund();
        actionCard4 = new BuyAnItem();
        actionCard5 = new TrafficViolation();
        actionCard6 = new WinACompetition();
        actionCard7 = new Lawsuit();
        actionCard8 = new ChristmasBonus();
        actionCard9 = new FileALawsuit();
        actionCard10 = new ItsYourBirthday();

        blueCard1 = new ComputerRepair();
        blueCard2 = new F1Race();
        blueCard3 = new LawsuitBlue();
        blueCard4 = new SalaryTaxDue();
        blueCard5 = new SkiAccident();
        blueCard6 = new TipTheServer();
        blueCard7 = new WorldCup();

        b = new Bank(3);

        /* Constructor: Player ()
         *  A Player object is created with no parameters passed.
         *  Expected effect: The name of p1 will be set to the default name (i.e, Player 1). */
        p1 = new Player();
        System.out.println("p1: Name = " + p1.getName());

        /* Constructor: Player (String name)
         *  A Player object is created with name parameters passed.
         *  Expected effect: The names of p2 and p3 will reflect the passed parameters. */
        p2 = new Player("Mark");
        p3 = new Player("Hylene");
        System.out.println("p2: Name = " + p2.getName());
        System.out.println("p3: Name = " + p3.getName());

        System.out.println();
        System.out.println("spinWheel()");

        /* Method: spinWheel()
         *  Test case 1: The spinWheel() method of p1 is called.
         *  Expected output: A randomly generated number between 1 and 10 inclusive. */
        System.out.println("Test case 1: The spinWheel() method of p1 is called.");

        System.out.println("p1 Spin: " + p1.spinWheel(wheel));

        /* Method: spinWheel()
         *  Test case 2: The spinWheel() method of p2 is called.
         *  Expected output: A randomly generated number between 1 and 10 inclusive. */
        System.out.println("Test case 2: The spinWheel() method of p2 is called.");

        System.out.println("p2 Spin: " + p2.spinWheel(wheel));

        /* Method: spinWheel()
         *  Test case 3: The spinWheel() method of p3 is called.
         *  Expected output: A randomly generated number between 1 and 10 inclusive. */
        System.out.println("Test case 3: The spinWheel() method of p3 is called.");

        System.out.println("p3 Spin: " + p3.spinWheel(wheel));

        System.out.println();
        System.out.println("move()");

        /* Method: move()
         *  Test case 1: p1 moves three spaces from their previous space.
         *  Expected output: The index of p1 changes from 0 to 3. */
        System.out.println("Test case 1: p1 moves three spaces from their previous space.");

        System.out.println("p1: Board Index = " + p1.getPositionOnBoard());
        p1.move(3, brd);
        System.out.println("p1: Board Index = " + p1.getPositionOnBoard());

        /* Method: move()
         *  Test case 2: p1 moves ten spaces from their previous space.
         *  Expected output: The index of p1 changes from 3 to 4 (they stop at the magenta space). */
        System.out.println("Test case 2: p1 moves ten spaces from their previous space.");

        System.out.println("p1: Board Index = " + p1.getPositionOnBoard());
        p1.move(10, brd);
        System.out.println("p1: Board Index = " + p1.getPositionOnBoard());

        System.out.println();
        System.out.println("graduate()");

        /* Method: graduate()
         *  Test case 1: The graduate() method of p1 is called.
         *  Expected output: The hasDegree attribute of p1 will be changed to true. */
        System.out.println("Test case 1: The graduate() method of p1 is called.");

        System.out.println("p1: hasDegree = " + p1.getHasDegree());
        p1.graduate();
        System.out.println("p1: hasDegree = " + p1.getHasDegree());

        /* Method: graduate()
         *  Test case 2: The graduate() method of p2 is called.
         *  Expected output: The hasDegree attribute of p2 will be changed to true. */
        System.out.println("Test case 2: The graduate() method of p2 is called.");

        System.out.println("p2: hasDegree = " + p2.getHasDegree());
        p2.graduate();
        System.out.println("p2: hasDegree = " + p2.getHasDegree());

        /* Method: graduate()
         *  Test case 3: The graduate() method of p3 is called.
         *  Expected output: The hasDegree attribute of p3 will be changed to true. */
        System.out.println("Test case 3: The graduate() method of p3 is called.");

        System.out.println("p3: hasDegree = " + p3.getHasDegree());
        p3.graduate();
        System.out.println("p3: hasDegree = " + p3.getHasDegree());

        System.out.println();
        System.out.println("marry()");

        /* Method: marry()
         *  Test case 1: The marry() method of p1 is called.
         *  Expected output: The isMarried attribute of p1 will be changed to true. */
        System.out.println("Test case 1: The marry() method of p1 is called.");

        System.out.println("p1: isMarried = " + p1.getIsMarried());
        p1.marry();
        System.out.println("p1: isMarried = " + p1.getIsMarried());

        /* Method: marry()
         *  Test case 2: The marry() method of p1 is called again.
         *  Expected output: No change. */
        System.out.println("Test case 2: The marry() method of p1 is called again.");

        System.out.println("p1: isMarried = " + p1.getIsMarried());
        p1.marry();
        System.out.println("p1: isMarried = " + p1.getIsMarried());

        System.out.println();
        System.out.println("haveBaby()");

        /* Method: haveBaby()
         *  Test case: The haveBaby() method of p1 is called.
         *  Expected output: The numChildren attribute of p1 is increased by 1. */
        System.out.println("Test case: The haveBaby() method of p1 is called.");

        System.out.println("p1: Number of Children = " + p1.getNumChildren());
        p1.haveBaby();
        System.out.println("p1: Number of Children = " + p1.getNumChildren());

        System.out.println();
        System.out.println("haveTwins()");

        /* Method: haveTwins()
         *  Test case: The haveTwins() method of p2 is called.
         *  Expected output: The numChildren attribute of p2 is increased by 2. */
        System.out.println("Test case: The haveTwins() method of p2 is called.");

        System.out.println("p2: Number of Children = " + p2.getNumChildren());
        p2.haveTwins();
        System.out.println("p2: Number of Children = " + p2.getNumChildren());

        System.out.println();
        System.out.println("drawFromCareerDeck()");

        /* Method: drawFromCareerDeck(careerCardDeck d)
         *  Test case 1: The drawFromCareerDeck method of p1 is called.
         *  Expected output: A valid career card (following the MP specifications).
         *  careerDeck will have six elements. */
        System.out.println("Test case 1: The drawFromCareerDeck method of p1 is called.");

        System.out.println(p1.drawFromCareerDeck(careerDeck));
        System.out.println(careerDeck);

        /* Method: drawFromCareerDeck(careerCardDeck d)
         *  Test case 2: The drawFromCareerDeck method of p2 is called.
         *  Expected output: A valid and unique career card (following the MP specifications).
         *  careerDeck will have five elements. */
        System.out.println("Test case 2: The drawFromCareerDeck method of p2 is called.");

        System.out.println(p2.drawFromCareerDeck(careerDeck));
        System.out.println(careerDeck);

        /* Method: drawFromCareerDeck(careerCardDeck d)
         *  Test case 3: The drawFromCareerDeck method of p3 is called.
         *  Expected output: A valid and unique career card (following the MP specifications).
         *  careerDeck will have four elements. */
        System.out.println("Test case 3: The drawFromCareerDeck method of p3 is called.");

        System.out.println(p3.drawFromCareerDeck(careerDeck));
        System.out.println(careerDeck);

        System.out.println();
        System.out.println("drawFromSalaryDeck()");

        /* Method: drawFromSalaryDeck(salaryCardDeck d)
         *  Test case 1: The drawFromSalaryDeck method of p1 is called.
         *  Expected output: A valid salary card (following the MP specifications).
         *  salaryDeck will have nine elements. */
        System.out.println("Test case 1: The drawFromSalaryDeck method of p1 is called.");

        System.out.println(p1.drawFromSalaryDeck(salaryDeck));
        System.out.println(salaryDeck);

        /* Method: drawFromSalaryDeck(salaryCardDeck d)
         *  Test case 2: The drawFromSalaryDeck method of p2 is called.
         *  Expected output: A valid and unique salary card (following the MP specifications).
         *  salaryDeck will have eight elements. */
        System.out.println("Test case 2: The drawFromSalaryDeck method of p2 is called.");

        System.out.println(p2.drawFromSalaryDeck(salaryDeck));
        System.out.println(salaryDeck);

        /* Method: drawFromSalaryDeck(salaryCardDeck d)
         *  Test case 3: The drawFromSalaryDeck method of p3 is called.
         *  Expected output: A valid and unique salary card (following the MP specifications).
         *  salaryDeck will have seven elements. */
        System.out.println("Test case 3: The drawFromSalaryDeck method of p3 is called.");

        System.out.println(p3.drawFromSalaryDeck(salaryDeck));
        System.out.println(salaryDeck);

        System.out.println();
        System.out.println("drawFromActionDeck()");

        /* Method: drawFromActionDeck(actionCardDeck d)
         *  Test case 1: The drawFromActionDeck method of p1 is called.
         *  Expected output: A valid action card (following the MP specifications).
         *  actionDeck will have 49 elements. pile will have one element. */
        System.out.println("Test case 1: The drawFromActionDeck method of p1 is called.");

        System.out.println(p1.drawFromActionDeck(actionDeck, pile));
        System.out.println(actionDeck);
        System.out.println(pile);

        /* Method: drawFromActionDeck(actionCardDeck d)
         *  Test case 2: The drawFromActionDeck method of p2 is called.
         *  Expected output: A valid action card (following the MP specifications).
         *  actionDeck will have 48 elements. pile will have two elements. */
        System.out.println("Test case 2: The drawFromActionDeck method of p2 is called.");

        System.out.println(p2.drawFromActionDeck(actionDeck, pile));
        System.out.println(actionDeck);
        System.out.println(pile);

        /* Method: drawFromActionDeck(actionCardDeck d)
         *  Test case 3: The drawFromActionDeck method of p3 is called.
         *  Expected output: A valid action card (following the MP specifications).
         *  actionDeck will have 47 elements. pile will have three elements. */
        System.out.println("Test case 3: The drawFromActionDeck method of p3 is called.");

        System.out.println(p3.drawFromActionDeck(actionDeck, pile));
        System.out.println(actionDeck);
        System.out.println(pile);

        System.out.println();
        System.out.println("drawFromHouseDeck()");

        /* Method: drawFromHouseDeck(houseDeck d)
         *  Test case: The drawFromHouseDeck method of p1 is called.
         *  Expected output: A valid house card.
         *  houseDeck will have 9 remaining elements. */
        System.out.println("Test case: The drawFromHouseDeck method of p1 is called.");

        System.out.println(p1.drawFromHouseDeck(houseDeck, 0));
        System.out.println(houseDeck);

        /* Method: drawFromBlueDeck(blueDeck d)
         *  Test case: The drawFromBlueDeck method of p1 is called.
         *  Expected output: A valid blue card following the MP specifications.
         *  blueDeck will still have 7 elements. */
        System.out.println("Test case: The drawFromBlueDeck method of p1 is called.");

        System.out.println(p1.drawFromBlueDeck(blueDeck));
        System.out.println(blueDeck);

        System.out.println();
        System.out.println("keepCareerCard()");

        /* Method: keepCareerCard(CareerCard c)
         *  Test case 1: p1 keeps a career card from the CareerCard deck.
         *  Expected output: The career and number of pay raises of p1 will be initialized
         *  according to the drawn card. */
        System.out.println("Test case 1: p1 keeps a career card from the CareerCard deck.");

        p1.keepCareerCard(p1.drawFromCareerDeck(careerDeck));
        System.out.println("p1: Career = " + p1.getCareer());
        System.out.println("p1: Num Pay Raises = " + p1.getMaxNumPayRaises());
        System.out.println(p1.getCareerCard());

        /* Method: keepCareerCard(CareerCard c)
         *  Test case 2: p2 keeps a career card from the CareerCard deck.
         *  Expected output: The career and number of pay raises of p2 will be initialized
         *  according to the drawn card. */
        System.out.println("Test case 2: p2 keeps a career card from the CareerCard deck.");

        p2.keepCareerCard(p2.drawFromCareerDeck(careerDeck));
        System.out.println("p2: Career = " + p2.getCareer());
        System.out.println("p2: Num Pay Raises = " + p2.getMaxNumPayRaises());
        System.out.println(p2.getCareerCard());

        /* Method: keepCareerCard(CareerCard c)
         *  Test case 3: p3 keeps a career card from the CareerCard deck.
         *  Expected output: The career and number of pay raises of p3 will be initialized
         *  according to the drawn card. */
        System.out.println("Test case 3: p3 keeps a career card from the CareerCard deck.");

        p3.keepCareerCard(p3.drawFromCareerDeck(careerDeck));
        System.out.println("p3: Career = " + p3.getCareer());
        System.out.println("p3: Num Pay Raises = " + p3.getMaxNumPayRaises());
        System.out.println(p3.getCareerCard());

        System.out.println();
        System.out.println("keepSalaryCard()");

        /* Method: keepSalaryCard(SalaryCard c)
         *  Test case 1: p1 keeps a salary card from the SalaryCard deck.
         *  Expected output: The salary, tax due, and pay raise of p1 will be initialized
         *  according to the drawn card. */
        System.out.println("Test case 1: p1 keeps a salary card from the SalaryCard deck.");

        p1.keepSalaryCard(p1.drawFromSalaryDeck(salaryDeck));
        System.out.println("p1: Salary = " + p1.getSalary());
        System.out.println("p1: Tax Due = " + p1.getTaxDue());
        System.out.println("p1: Pay Raise = " + p1.getBasePayRaise());
        System.out.println(p1.getSalaryCard());

        /* Method: keepSalaryCard(SalaryCard c)
         *  Test case 2: p2 keeps a salary card from the SalaryCard deck.
         *  Expected output: The salary, tax due, and pay raise of p2 will be initialized
         *  according to the drawn card. */
        System.out.println("Test case 2: p2 keeps a salary card from the SalaryCard deck.");

        p2.keepSalaryCard(p2.drawFromSalaryDeck(salaryDeck));
        System.out.println("p2: Salary = " + p2.getSalary());
        System.out.println("p2: Tax Due = " + p2.getTaxDue());
        System.out.println("p2: Pay Raise = " + p2.getBasePayRaise());
        System.out.println(p2.getSalaryCard());

        /* Method: keepSalaryCard(SalaryCard c)
         *  Test case 3: p3 keeps a salary card from the SalaryCard deck.
         *  Expected output: The salary, tax due, and pay raise of p3 will be initialized
         *  according to the drawn card. */
        System.out.println("Test case 3: p3 keeps a salary card from the SalaryCard deck.");

        p3.keepSalaryCard(p3.drawFromSalaryDeck(salaryDeck));
        System.out.println("p3: Salary = " + p3.getSalary());
        System.out.println("p3: Tax Due = " + p3.getTaxDue());
        System.out.println("p3: Pay Raise = " + p3.getBasePayRaise());
        System.out.println(p3.getSalaryCard());

        System.out.println();
        System.out.println("keepHouseCard()");

        /* Method: keepHouseCard(HouseCard c, Bank b)
         *  Test case: p1 keeps a house card from the HouseCard deck.
         *  Expected output: The house details of p1 will be initialized and their cash
         *  will decrease by the specified buying price of the house. */
        System.out.println("Test case: p1 keeps a house card from the HouseCard deck.");

        System.out.println("p1: Cash = " + p1.getCash());
        p1.keepHouseCard(p1.drawFromHouseDeck(houseDeck, 0), b);
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: House = " + p1.getHouseName());

        System.out.println();
        System.out.println("returnCard()");

        /* Method: returnCard(Card c, Deck d)
         *  Test case: The career card of p2 is returned to the deck.
         *  Expected output: The returned card is added to the career card deck. */
        System.out.println("Test case: The career card of p2 is returned to the deck.");

        System.out.println(p2.getCareerCard());
        p2.returnCard(p2.getCareerCard(), careerDeck);
        System.out.println(careerDeck);

        System.out.println();
        System.out.println("returnCardToBottom()");

        /* Method: returnCardToBottom(Card c, Deck d)
         *  Test case: The career card of p3 is returned to the bottom of the deck.
         *  Expected output: The returned card is added to the bottom of the career card deck. */
        System.out.println("Test case: The career card of p3 is returned to the bottom of the deck.");

        System.out.println(p3.getCareerCard());
        p2.returnCardToBottom(p3.getCareerCard(), careerDeck);
        System.out.println(careerDeck);

        System.out.println();
        System.out.println("executeActionCard()");

        /* Method: executeActionCard(CollectFromTheBank c, Bank b)
         *  Test case 1: p1 executes a BonusPayday card.
         *  Expected output: The cash of p1 will be increased by their current salary. */
        System.out.println("Test case 1: p1 executes a BonusPayday card.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Salary = " + p1.getSalary());
        p1.executeActionCard(actionCard1, b);
        System.out.println(actionCard1.getInfo());
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: executeActionCard(CollectFromTheBank c, Bank b)
         *  Test case 2: p2 executes a SellAnItem card.
         *  Expected output: The cash of p2 will be increased by the randomly generated
         *  item price. */
        System.out.println("Test case 2: p2 executes a SellAnItem card.");

        System.out.println("p2: Cash = " + p1.getCash());
        p2.executeActionCard(actionCard2, b);
        System.out.println(actionCard2.getInfo());
        System.out.println("Item Price = " + actionCard2.getItemPrice());
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: executeActionCard(CollectFromTheBank c, Bank b)
         *  Test case 3: p3 executes a TaxRefund card.
         *  Expected output: The cash of p2 will be increased their current tax due. */
        System.out.println("Test case 3: p3 executes a TaxRefund card.");

        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Tax Due = " + p3.getTaxDue());
        p3.executeActionCard(actionCard3, b);
        System.out.println(actionCard3.getInfo());
        System.out.println("p3: Cash = " + p3.getCash());

        /* Method: executeActionCard(PayTheBank c, Bank b)
         *  Test case 4: p1 executes a BuyAnItem card.
         *  Expected output: The cash of p1 will be decreased by the randomly generated amount. */
        System.out.println("Test case 4: p1 executes a BuyAnItem card.");

        System.out.println("p1: Cash = " + p1.getCash());
        p1.executeActionCard(actionCard4, b);
        System.out.println(actionCard4.getInfo());
        System.out.println("Item Price = " + actionCard4.getAmount());
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: executeActionCard(PayTheBank c, Bank b)
         *  Test case 5: p2 executes a TrafficViolation card.
         *  Expected output: The cash of p2 will be decreased by the randomly generated amount. */
        System.out.println("Test case 5: p2 executes a TrafficViolation card.");

        System.out.println("p2: Cash = " + p2.getCash());
        p2.executeActionCard(actionCard5, b);
        System.out.println(actionCard5.getInfo());
        System.out.println("Fine = " + actionCard5.getAmount());
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: executeActionCard(PayTheBank c, Bank b)
         *  Test case 6: p3 executes a WinACompetition card.
         *  Expected output: The cash of p3 will be decreased by the randomly generated amount. */
        System.out.println("Test case 6: p3 executes a WinACompetition card.");

        System.out.println("p3: Cash = " + p3.getCash());
        p3.executeActionCard(actionCard6, b);
        System.out.println(actionCard6.getInfo());
        System.out.println("Competition Tax = " + actionCard6.getAmount());
        System.out.println("p3: Cash = " + p3.getCash());


        /* Method: executeActionCard(Lawsuit c, Player otherPlayer, bank b)
         *  Test case 7: p1 executes a Lawsuit card.
         *  Expected output: The cash of p1 will be decreased by the randomly generated amount,
         *  and the cash of p2 will be increased accordingly.
         *  NOTE: Further testing was documented in LawsuitTestScript.java.*/
        System.out.println("Test case 7: p1 executes a Lawsuit card.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());
        p1.executeActionCard(actionCard7, p2, b);
        System.out.println(actionCard7.getInfo());
        System.out.println("Amount = " + actionCard7.getAmount());
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: executeActionCard(ChristmasBonus c, ArrayList<Player> players, bank b)
         *  Test case 8: p2 executes a ChristmasBonus card.
         *  Expected output: The cash of p2 will be decreased by the randomly generated amount
         *  multiplied by the number of other players, and the cash of p1 and p3 will be
         *  increased accordingly.
         *  NOTE: Further testing was documented in ChristmasBonusTestScript.java.*/
        System.out.println("Test case 8: p2 executes a ChristmasBonus card.");

        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p3: Cash = " + p3.getCash());

        players = new ArrayList<>();
        players.add(p1);
        players.add(p3);

        p2.executeActionCard(actionCard8, players, b);
        System.out.println(actionCard8.getInfo());
        System.out.println("Amount = " + actionCard8.getAmount());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p3: Cash = " + p3.getCash());

        /* Method: executeActionCard(FileALawsuit c, otherPlayer p, Bank b)
         *  Test case 9: p3 executes a FileALawsuit card.
         *  Expected output: The cash of p3 will be increased by the randomly generated amount,
         *  and the cash of p1 will be decreased accordingly.
         * NOTE: Further testing was documented in FileALawsuitTestScript.java.*/
        System.out.println("Test case 9: p3 executes a FileALawsuit card.");

        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p1: Cash = " + p1.getCash());
        p3.executeActionCard(actionCard9, p1, b);
        System.out.println(actionCard9.getInfo());
        System.out.println("Amount = " + actionCard9.getAmount());
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: executeActionCard(ItsYourBirthday c, ArrayList<Player> players, bank b)
         *  Test case 10: p1 executes a ItsYourBirthday card.
         *  Expected output: The cash of p1 will be increased by the randomly generated amount
         *  multiplied by the number of other players, and the cash of p2 and p3 will be
         *  decreased accordingly.
         *  NOTE: Further testing was documented in ItsYourBirthdayTestScript.java.*/
        System.out.println("Test case 10: p1 executes a ItsYourBirthday card.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p3: Cash = " + p3.getCash());

        players = new ArrayList<>();
        players.add(p2);
        players.add(p3);

        p1.executeActionCard(actionCard10, players, b);
        System.out.println(actionCard10.getInfo());
        System.out.println("Amount = " + actionCard10.getAmount());
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p3: Cash = " + p3.getCash());

        System.out.println();
        System.out.println("executeBlueCard()");

        /* Method: executeBlueCard(LawsuitBlue c, Player playerWithCareer, Bank b)
         *  Test case 1: p1 executes a LawsuitBlue card with no player having a matching career.
         *  Expected output: The cash of p1 will be decreased by the specified amount on the card. */
        System.out.println("Test case 1: p1 executes a LawsuitBlue card.");

        p1.increaseCashBy(1000000);

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("Card Amount = " + blueCard3.getAmount());
        p1.executeBlueCard(blueCard3, null, b);
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: executeBlueCard(SalaryTaxDue c, Player playerWithCareer, Bank b)
         *  Test case 2: p1 executes a SalaryTaxDue card with no player having a matching career.
         *  Expected output: The cash of p1 will be increased by their current tax due. */
        System.out.println("Test case 2: p1 executes a SalaryTaxDue card.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Tax Due = " + p1.getTaxDue());
        p1.executeBlueCard(blueCard4, null, b);
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: executeBlueCard(TipTheServer c, Player playerWithCareer, Bank b, int randNUm)
         *  Test case 3: p1 executes a TipTheServer card with no player having a matching career.
         *  Expected output: The cash of p1 will be decreased by 1000 (as 1 is passed as the value
         *  of randNum) */
        System.out.println("Test case 3: p1 executes a TipTheServer card.");

        System.out.println("p1: Cash = " + p1.getCash());
        p1.executeBlueCard(blueCard6, null, b, 1);
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: executeBlueCard(SkiAccident c, Player playerWithCareer, Bank b, int randNUm)
         *  Test case 4: p1 executes a SkiAccident card with no player having a matching career.
         *  Expected output: The cash of p1 will be decreased by 10000 */
        System.out.println("Test case 4: p1 executes a SkiAccident card.");

        System.out.println("p1: Cash = " + p1.getCash());
        p1.executeBlueCard(blueCard5, null, b);
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: executeBlueCard(ComputerRepair c, Player playerWithCareer, Bank b, int randNUm)
         *  Test case 5: p1 executes a ComputerRepair card with no player having a matching career.
         *  Expected output: The cash of p1 will be decreased by 5000 (as 2 is passed as the value
         *  of randNum) */
        System.out.println("Test case 5: p1 executes a ComputerRepair card.");

        System.out.println("p1: Cash = " + p1.getCash());
        p1.executeBlueCard(blueCard1, null, b, 2);
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: executeBlueCard(WorldCup c, Player playerWithCareer, Bank b, int randNUm)
         *  Test case 6: p1 executes a WorldCup card with no player having a matching career.
         *  Expected output: The cash of p1 will be decreased by 15000 (as 3 is passed as the value
         *  of numPlayers) */
        System.out.println("Test case 6: p1 executes a WorldCup card.");

        System.out.println("p1: Cash = " + p1.getCash());
        p1.executeBlueCard(blueCard7, null, b, 3);
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: executeBlueCard(F1Race c, Player playerWithCareer, Bank b, int randNUm)
         *  Test case 7: p1 executes an F1Race card with no player having a matching career.
         *  Expected output: The cash of p1 will be decreased by 10% of their current salary */
        System.out.println("Test case 7: p1 executes an F1Race card.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Salary = " + p1.getSalary());
        p1.executeBlueCard(blueCard2, null, b);
        System.out.println("p1: Cash = " + p1.getCash());

        System.out.println();
        System.out.println("borrowLoan()");

        /* Method: borrowLoan(bank b, int numLoans)
         *  Test case 1: p1 takes out 3 loans.
         *  Expected output: The cash of p1 will be increased by 60000. The number of loans
         *  of p1 will be increased by 3. */
        System.out.println("Test case: p1 takes out 3 loans.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: NumLoans = " + p1.getCurrNumLoans());
        p1.borrowLoan(b, 3);
        System.out.println("p1 takes out 3 loans.");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: NumLoans = " + p1.getCurrNumLoans());

        /* Method: borrowLoan(bank b, int numLoans)
         *  Test case 2: p2 takes out 0 loans.
         *  Expected output: No change. */
        System.out.println("Test case: p2 takes out 0 loans.");

        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: NumLoans = " + p2.getCurrNumLoans());
        p2.borrowLoan(b, 0);
        System.out.println("p2 takes out 0 loans.");
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: NumLoans = " + p2.getCurrNumLoans());

        /* Method: borrowLoan(bank b, int numLoans)
         *  Test case 3: p3 takes out -5 loans.
         *  Expected output: No change. */
        System.out.println("Test case: p3 takes out -5 loans.");

        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: NumLoans = " + p3.getCurrNumLoans());
        p2.borrowLoan(b, -5);
        System.out.println("p3 takes out -5 loans.");
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: NumLoans = " + p3.getCurrNumLoans());

        System.out.println();
        System.out.println("payLoan()");

        /* Method: payLoan(bank b, int numPayments)
         *  Test case 1: p1 pays 3 loans.
         *  Expected output: The cash of p1 will be decreased by 60000. The number of loans
         *  of p1 will be decreased by 3. */
        System.out.println("Test case 1: p1 pays 3 loans.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: NumLoans = " + p1.getCurrNumLoans());
        p1.payLoan(b, 3);
        System.out.println("p1 pays 3 loans.");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: NumLoans = " + p1.getCurrNumLoans());

        /* Method: payLoan(bank b, int numPayments)
         *  Test case 2: p2 pays 0 loans.
         *  Expected output: No change. */
        System.out.println("Test case 2: p2 pays 0 loans.");

        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: NumLoans = " + p2.getCurrNumLoans());
        p2.payLoan(b, 0);
        System.out.println("p2 pays 0 loans.");
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p2: NumLoans = " + p2.getCurrNumLoans());

        /* Method: payLoan(bank b, int numPayments)
         *  Test case 3: p3 pays 1000000 loans.
         *  Expected output: No change. */
        System.out.println("Test case 3: p3 pays 1000000 loans.");

        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: NumLoans = " + p3.getCurrNumLoans());
        p3.payLoan(b, 1000000);
        System.out.println("p3 pays 1000000 loans.");
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: NumLoans = " + p3.getCurrNumLoans());

        System.out.println();
        System.out.println("receiveCash()");

        /* Method: receiveCash(int amount)
         *  Test case 1: p1 receives 1000.
         *  Expected output: The cash of p1 will be increased by 1000. */
        System.out.println("Test case 1: p1 receives 1000.");

        System.out.println("p1: Cash = " + p1.getCash());
        p1.receiveCash(1000);
        System.out.println("p1 receives 1000.");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: receiveCash(int amount)
         *  Test case 2: p2 receives 0.
         *  Expected output: No change */
        System.out.println("Test case 2: p2 receives 0.");

        System.out.println("p2: Cash = " + p2.getCash());
        p2.receiveCash(0);
        System.out.println("p2 receives 0.");
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: receiveCash(int amount)
         *  Test case 3: p3 receives -1000.
         *  Expected output: No change */
        System.out.println("Test case 3: p3 receives -1000.");

        System.out.println("p3: Cash = " + p3.getCash());
        p3.receiveCash(-1000);
        System.out.println("p3 receives -1000.");
        System.out.println("p3: Cash = " + p3.getCash());

        System.out.println();
        System.out.println("payCashToPlayer()");

        /* Method: payCashToPlayer(Player p, Bank b, int amount)
         *  Test case 1: p1 pays p2 1000.
         *  Expected output: The cash of p1 will be decreased by 1000. The cash of p2
         *  will be increased by 1000. */
        System.out.println("Test case 1: p1 pays p2 1000.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());
        p1.payCashToPlayer(p2, b, 1000);
        System.out.println("p1 pays p2 1000.");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: payCashToPlayer(Player p, Bank b, int amount)
         *  Test case 2: p2 pays p3 0.
         *  Expected output: No change. */
        System.out.println("Test case 2: p2 pays p3 0.");

        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p3: Cash = " + p3.getCash());
        p2.payCashToPlayer(p3, b, 0);
        System.out.println("p2 pays p3 0.");
        System.out.println("p2: Cash = " + p2.getCash());
        System.out.println("p3: Cash = " + p3.getCash());

        /* Method: payCashToPlayer(Player p, Bank b, int amount)
         *  Test case 3: p3 pays p1 double p3's cash on hand.
         *  Expected output: The cash of p1 is increased by p3's cash
         *  multiplied by 2. The number of loans of p3 will increase
         *  in accordance with the paid amount. */
        System.out.println("Test case 3: p3 pays p1 double p3's cash on hand");

        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Num Loans = " + p3.getCurrNumLoans());
        System.out.println("p1: Cash = " + p1.getCash());
        p3.payCashToPlayer(p1, b, p3.getCash() * 2);
        System.out.println("p3 pays p1 double p3's cash on hand");
        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Num Loans = " + p3.getCurrNumLoans());
        System.out.println("p1: Cash = " + p1.getCash());

        System.out.println();
        System.out.println("collectCashFromBank()");

        /* Method: collectCashFromBank(Bank b, int amount)
         *  Test case 1: p1 collects -1000.
         *  Expected output: No change. */
        System.out.println("Test case 1: p1 collects -1000.");

        System.out.println("p1: Cash = " + p1.getCash());
        p1.collectCashFromBank(b, -1000);
        System.out.println("p1 collects -1000.");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: collectCashFromBank(Bank b, int amount)
         *  Test case 2: p2 collects 0.
         *  Expected output: No change. */
        System.out.println("Test case 2: p2 collects 0.");

        System.out.println("p2: Cash = " + p2.getCash());
        p2.collectCashFromBank(b, 0);
        System.out.println("p2 collects 0.");
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: collectCashFromBank(Bank b, int amount)
         *  Test case 3: p3 collects 100000.
         *  Expected output: The cash of p3 will increase by 100000. */
        System.out.println("Test case 3: p3 collects 100000.");

        System.out.println("p3: Cash = " + p3.getCash());
        p3.collectCashFromBank(b, 100000);
        System.out.println("p3 collects 100000.");
        System.out.println("p3: Cash = " + p3.getCash());

        System.out.println();
        System.out.println("payCashToBank()");

        /* Method: payCashToBank(Bank b, int amount)
         *  Test case 1: p1 pays more than p1's cash on hand.
         *  Expected output: The number of loans of p1 will increase. The cash
         *  of p1 will decrease accordingly. */
        System.out.println("Test case 1: p1 pays more than p1's cash on hand.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Num Loans = " + p1.getCurrNumLoans());
        p1.payCashToBank(b, p1.getCash() + 20000);
        System.out.println("p1 pays more than p1's cash on hand.");
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Num Loans = " + p1.getCurrNumLoans());

        /* Method: payCashToBank(Bank b, int amount)
         *  Test case 2: p2 pays 0.
         *  Expected output: No change. */
        System.out.println("Test case 2: p2 pays 0.");

        System.out.println("p2: Cash = " + p2.getCash());
        p2.payCashToBank(b, 0);
        System.out.println("p2 pays 0.");
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: payCashToBank(Bank b, int amount)
         *  Test case 2: p3 pays -1000.
         *  Expected output: No change. */
        System.out.println("Test case 3: p3 pays -1000");

        System.out.println("p3: Cash = " + p3.getCash());
        p3.payCashToBank(b, -1000);
        System.out.println("p3 pays -1000.");
        System.out.println("p3: Cash = " + p3.getCash());


        System.out.println();
        System.out.println("increaseCashBy()");

        /* Method: increaseCashBy(int amount)
         *  Test case 1: p1 increases cash by 5000.
         *  Expected output: The cash of p1 will increase by 5000. */
        System.out.println("Test case 1: p1 increases cash by 5000.");

        System.out.println("p1: Cash = " + p1.getCash());
        p1.increaseCashBy(5000);
        System.out.println("p1 increases cash by 5000.");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: increaseCashBy(int amount)
         *  Test case 2: p2 increases cash by 0.
         *  Expected output: No change. */
        System.out.println("Test case 2: p2 increases cash by 0.");

        System.out.println("p2: Cash = " + p2.getCash());
        p2.increaseCashBy(0);
        System.out.println("p2 increases cash by 0.");
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: increaseCashBy(int amount)
         *  Test case 3: p3 increases cash by -1000.
         *  Expected output: No change. */
        System.out.println("Test case 3: p3 increases cash by -1000.");

        System.out.println("p3: Cash = " + p3.getCash());
        p3.increaseCashBy(-1000);
        System.out.println("p3 increases cash by -1000.");
        System.out.println("p3: Cash = " + p3.getCash());

        System.out.println();
        System.out.println("decreaseCashBy()");

        /* Method: decreaseCashBy(int amount)
         *  Test case 1: p1 decreases cash by 1000.
         *  Expected output: The cash of p1 will decrease by 1000. */
        System.out.println("p1 decreases cash by 1000.");

        System.out.println("p1: Cash = " + p1.getCash());
        p1.decreaseCashBy(1000);
        System.out.println("p1 decreases cash by 1000.");
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: decreaseCashBy(int amount)
         *  Test case 2: p2 decreases cash by -5000.
         *  Expected output: No change. */
        System.out.println("Test Case 2: p2 decreases cash by -5000.");

        System.out.println("p2: Cash = " + p2.getCash());
        p2.decreaseCashBy(-5000);
        System.out.println("p2 decreases cash by -5000.");
        System.out.println("p2: Cash = " + p2.getCash());

        /* Method: decreaseCashBy(int amount)
         *  Test case 3: p3 decreases cash by more than p3's cash on hand.
         *  Expected output: No change. */
        System.out.println("Test case 3: p3 decreases cash by more than p3's cash on hand.");

        System.out.println("p3: Cash = " + p3.getCash());
        System.out.println("p3: Num Loans = " + p3.getCurrNumLoans());
        p3.decreaseCashBy(p3.getCash() + 5000);
        System.out.println("p3 decreases cash by more than p3's cash on hand.");
        System.out.println("p3: Num Loans = " + p3.getCurrNumLoans());

        System.out.println();
        System.out.println("increaseNumLoansBy()");

        /* Method: increaseNumLoansBy(int numLoans)
         *  Test case 1: p1 increases their number of loans by 5.
         *  Expected output: The number of loans of p1 will increase by 5. */
        System.out.println("Test Case 1: p1 increases their number of loans by 5.");

        System.out.println("p1: Num Loans = " + p1.getCurrNumLoans());
        p1.increaseNumLoansBy(5);
        System.out.println("p1 increases their number of loans by 5.");
        System.out.println("p1: Num Loans = " + p1.getCurrNumLoans());

        /* Method: increaseNumLoansBy(int numLoans)
         *  Test case 2: p2 increases their number of loans by 0.
         *  Expected output: No change. */
        System.out.println("Test Case 2: p2 increases their number of loans by 0.");

        System.out.println("p2: Num Loans = " + p2.getCurrNumLoans());
        p2.increaseNumLoansBy(0);
        System.out.println("p2 increases their number of loans by 0.");
        System.out.println("p2: Num Loans = " + p2.getCurrNumLoans());

        /* Method: increaseNumLoansBy(int numLoans)
         *  Test case 3: p3 increases their number of loans by -1.
         *  Expected output: No change. */
        System.out.println("Test Case 3: p3 increases their number of loans by -1.");

        System.out.println("p3: Num Loans = " + p3.getCurrNumLoans());
        p3.increaseNumLoansBy(-1);
        System.out.println("p3 increases their number of loans by -1.");
        System.out.println("p3: Num Loans = " + p3.getCurrNumLoans());

        System.out.println();
        System.out.println("decreaseNumLoansBy()");

        /* Method: decreaseNumLoansBy(int numLoans)
         *  Test case 1: p1 decreases their number of loans by 5.
         *  Expected output: The number of loans of p1 will decrease by 5. */
        System.out.println("Test Case 1: p1 decreases their number of loans by 5.");

        System.out.println("p1: Num Loans = " + p1.getCurrNumLoans());
        p1.decreaseNumLoansBy(5);
        System.out.println("p1 decreases their number of loans by 5.");
        System.out.println("p1: Num Loans = " + p1.getCurrNumLoans());

        /* Method: decreaseNumLoansBy(int numLoans)
         *  Test case 2: p2 decreases their number of loans by 0.
         *  Expected output: No change. */
        System.out.println("Test Case 2: p2 decreases their number of loans by 0.");

        System.out.println("p2: Num Loans = " + p2.getCurrNumLoans());
        p2.decreaseNumLoansBy(0);
        System.out.println("p2 decreases their number of loans by 0.");
        System.out.println("p2: Num Loans = " + p2.getCurrNumLoans());

        /* Method: decreaseNumLoansBy(int numLoans)
         *  Test case 3: p3 decreases their number of loans by -1.
         *  Expected output: No change. */
        System.out.println("Test Case 3: p3 decreases their number of loans by -1.");

        System.out.println("p3: Num Loans = " + p3.getCurrNumLoans());
        p3.decreaseNumLoansBy(-1);
        System.out.println("p3 decreases their number of loans by -1.");
        System.out.println("p3: Num Loans = " + p3.getCurrNumLoans());

        System.out.println();
        System.out.println("sellHouseToBank()");

        /* Method: sellHouseToBank(Bank b)
         *  Test case 1: p1 sells their house to the bank.
         *  Expected output: The cash of p1 will be increased by the selling price of the house. */
        System.out.println("Test case 1: p1 sells their house to the bank.");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: House Selling Price = " + p1.getHouseSellingPrice());
        p1.sellHouseToBank(b);
        System.out.println("p1: Cash = " + p1.getCash());

        /* Method: sellHouseToBank(Bank b)
         *  Test case 2: p2 sells their house to the bank.
         *  Expected output: No change (p2 has no house). */
        System.out.println("Test case 2: p2 sells their house to the bank.");

        System.out.println("p2: Cash = " + p2.getCash());
        p1.sellHouseToBank(b);
        System.out.println("p2: Cash = " + p2.getCash());

        System.out.println();
        System.out.println("receivePayRaise()");

        /* Method: receivePayRaise()
         *  Test case 1: p1 receives a pay raise.
         *  Expected output: The salary of p1 will increase by the specified amount. */
        System.out.println("Test case 1: p1 receives a pay raise.");

        System.out.println("p1: Salary = " + p1.getSalary());
        System.out.println("p1: Pay Raise Amount = " + p1.getSalaryCard().getPayRaise());
        System.out.println("p1: Current Pay Raises = " + p1.getCurrNumPayRaises());
        System.out.println("p1: Maximum Pay Raises = " + p1.getMaxNumPayRaises());
        p1.receivePayRaise();
        System.out.println("p1: Salary = " + p1.getSalary());

        System.out.println();
        System.out.println("receivePayRaise()");

        /* Method: receivePayRaise()
         *  Test case 2: p1 receives a pay raise (p1 is already at the maximum number of
         *  pay raises).
         *  Expected output: No change. */
        System.out.println("Test case 2: p1 receives a pay raise (p1 is already at the maximum number of pay raises).");

        while (p1.getCurrNumPayRaises() < p1.getMaxNumPayRaises())
            p1.receivePayRaise();

        System.out.println("p1: Salary = " + p1.getSalary());
        System.out.println("p1: Pay Raise Amount = " + p1.getSalaryCard().getPayRaise());
        System.out.println("p1: Current Pay Raises = " + p1.getCurrNumPayRaises());
        System.out.println("p1: Maximum Pay Raises = " + p1.getMaxNumPayRaises());
        p1.receivePayRaise();
        System.out.println("p1: Salary = " + p1.getSalary());

        System.out.println();
        System.out.println("retire()");
        /* Method: retire(Bank b, int orderRetirement, CareerCardDeck careerDeck, SalaryCardDeck salaryDeck, HouseCardDeck houseDeck)
         *  Test case: p1 is retired (set as the first player to retire).
         *  Expected output: The cash of p1 is increased by 100000, their number of children multiplied by 10000, and the
         *  selling price of their house. Their loans are also settled */
        System.out.println("Test case: p1 is retired (set as the first player to retire).");

        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Loans = " + p1.getCurrNumLoans());
        System.out.println("p1: Children = " + p1.getNumChildren());
        System.out.println("p1: House Selling Price = " + p1.getHouseSellingPrice());
        p1.retire(b, 1, careerDeck, salaryDeck, houseDeck);
        System.out.println("p1: Cash = " + p1.getCash());
        System.out.println("p1: Loans = " + p1.getCurrNumLoans());

        System.out.println();
        System.out.println("isValidName()");
        /* Method: isValidName(String name)
         *  Test case 1: The string "Mark" is checked for validity by p1.
         *  Expected output: True. */
        System.out.println("Test case 1: The string \"Mark\" is checked for validity by p1.");

        System.out.println(p1.isValidName("Mark"));

        /* Method: isValidName(String name)
         *  Test case 2: The string " " is checked for validity by p1.
         *  Expected output: False. */
        System.out.println("Test case 2: The string \" \" is checked for validity by p1.");

        System.out.println(p1.isValidName(" "));

        /* Method: isValidName(String name)
         *  Test case 2: The string " Hello" is checked for validity by p1.
         *  Expected output: True. */
        System.out.println("Test case 3: The string \" Hello\" is checked for validity by p1.");

        System.out.println(p1.isValidName(" Hello"));

        System.out.println();
        System.out.println("toString()");

        /* Method: Overridden toString()
         *  Test case 1: The Player object p1 is printed (using the overridden toString() method).
         *  Expected output: The name, player ID, career, base and current salary, base and current
         *  tax due, base and current pay raise, current and maximum number of pay raises, and cash
         *  on hand and number of loans of p1. */
        System.out.println("Test case 1: The Player object p1 is printed (using the overridden toString() method).");

        System.out.println(p1);

        /* Method: Overridden toString()
         *  Test case 2: The Player object p2 is printed (using the overridden toString() method).
         *  Expected output: The name, player ID, career, base and current salary, base and current
         *  tax due, base and current pay raise, current and maximum number of pay raises, and cash
         *  on hand and number of loans of p2. */
        System.out.println("Test case 2: The Player object p2 is printed (using the overridden toString() method).");

        System.out.println(p2);

        /* Method: Overridden toString()
         *  Test case 3: The Player object p3 is printed (using the overridden toString() method).
         *  Expected output: The name, player ID, career, base and current salary, base and current
         *  tax due, base and current pay raise, current and maximum number of pay raises, and cash
         *  on hand and number of loans of p3. */
        System.out.println("Test case 3: The Player object p3 is printed (using the overridden toString() method).");

        System.out.println(p3);
        }
    }
