package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Class implementing a <b>MainScreen window</b> as part of the GUI for
 * the game
 */
public class MainScreen extends JFrame {
    /**
     * Constant string indicating the peg color of the first player
     */
    public static final String PLAYER_ONE_COLOR = "Red";
    /**
     * Constant string indicating the peg color of the second player
     */
    public static final String PLAYER_TWO_COLOR = "Green";
    /**
     * Constant string indicating the peg color of the third player
     */
    public static final String PLAYER_THREE_COLOR = "Blue";

    /**
     * Panel storing the board
     */
    private JPanel pBoard;
    /**
     * Text area storing the game log
     */
    private JTextArea taGameLog;
    /**
     * Scroll pane storing the text area containing the game log
     */
    private JScrollPane scrollGameLog;

    /**
     * Two-dimensional array of panels used to represent the spaces on the board
     */
    private JPanel[][] pSpaces;

    /**
     * List of labels storing the player names
     */
    private ArrayList<JLabel> lblPlayerNames;
    /**
     * List of text areas storing the player details
     */
    private ArrayList<JTextArea> taPlayerDetails;
    /**
     * Scroll panes containing the details of each of the players (stored in the list of text areas)
     */
    private ArrayList<JScrollPane> scrollPlayerDetails;
    /**
     * Button for spinning the number wheel
     */
    private JButton btnSpin;
    /**
     * Button for drawing a card or executing the effect of a space
     */
    private JButton btnDraw;
    /**
     * Button for viewing a player's kept cards
     */
    private JButton btnCards;
    /**
     * Button for borrowing loans from the bank
     */
    private JButton btnBorrow;
    /**
     * Button for paying loans to the bank
     */
    private JButton btnPay;
    /**
     * Button for viewing the rules of the game
     */
    private JButton btnRules;

    /**
     * The previous x coordinate of the highlighted wheel number
     */
    private int prevWheelX;
    /**
     * The previous y coordinate of the highlighted wheel number
     */
    private int prevWheelY;
    /**
     * The current x coordinate of the highlighted wheel number
     */
    private int activeWheelX;
    /**
     * The current y coordinate of the highlighted wheel number
     */
    private int activeWheelY;
    /**
     * A static value used in the animation of the wheel spin
     */
    private static int compCounter;

    /**
     * The original image of the peg of the first player
     */
    private ImageIcon imageOrig1;
    /**
     * The scaled image of the peg of the first player
     */
    private Image imageScaled1;
    /**
     * The collection of images of the peg of the first player, stored in an <code>ArrayList</code>
     * of <code>JLabels</code>
     */
    private ArrayList<JLabel> lblPlayer1Pegs;

    /**
     * The original image of the peg of the second player
     */
    private ImageIcon imageOrig2;
    /**
     * The scaled image of the peg of the second player
     */
    private Image imageScaled2;
    /**
     * The collection of images of the peg of the second player, stored in an <code>ArrayList</code>
     * of <code>JLabels</code>
     */
    private ArrayList<JLabel> lblPlayer2Pegs;

    /**
     * The original image of the peg of the third player
     */
    private ImageIcon imageOrig3;
    /**
     * The scaled image of the peg of the third player
     */
    private Image imageScaled3;
    /**
     * The collection of images of the peg of the third player, stored in an <code>ArrayList</code>
     * of <code>JLabels</code>
     */
    private ArrayList<JLabel> lblPlayer3Pegs;

    /**
     * Ordered list of x coordinates of the spaces on the board
     */
    private int[] xCoords = {12, 12, 12, 12, 12, 11, 10, 9, 9, 9, 9,
            9, 10, 11, 12, 12, 12, 12, 12, 12, 12,
            12, 11, 10, 9, 8, 7, 10, 10, 10, 9,
            8, 7, 6, 6, 6, 6, 5, 4, 3, 2,
            1, 0, 0, 0, 0, 0, 0, 0, 1, 2,
            3, 3, 3, 3, 3, 2, 1, 0, 0, 0,
            0, 0, 1, 2, 3, 3};
    /**
     * Ordered list of y coordinates of the spaces on the board
     */
    private int[] yCoords = {0, 1, 2, 3, 4, 1, 1, 1, 2, 3, 4,
            5, 5, 5, 5, 6, 7, 8, 9, 10, 11,
            12, 12, 12, 12, 12, 12, 11, 10, 9, 9,
            9, 9, 9, 10, 11, 12, 12, 12, 12, 12,
            12, 12, 11, 10, 9, 8, 7, 6, 9, 9,
            9, 8, 7, 6, 5, 5, 5, 5, 4, 3,
            2, 1, 1, 1, 1, 0};

    /**
     * Constant for the amount of time a number on the number wheel is highlighted
     * as part of the wheel spin animation
     */
    public static final int ANIMATE_MILLISEC = 50;

    /**
     * Creates a MainScreen object
     *
     * <p>As part of the larger interface of the game, this window serves as the master window;
     * virtually all of the other windows in the interface are called from the main screen.</p>
     *
     * @param playerNames list of players in the game
     */
    public MainScreen(ArrayList<String> playerNames) {

        /* The string "That's Life!" is passed as the label for the title bar */
        super("That's Life!");

        /* Array lists for the player names, player details, and scroll panes containing the
        player details are created
        */
        lblPlayerNames = new ArrayList<>();
        taPlayerDetails = new ArrayList<>();
        scrollPlayerDetails = new ArrayList<>();

        setLayout(new BorderLayout());

        /* init() is called to initialize the elements of the window */
        init(playerNames);

        /* Additional formatting methods for the window are executed */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        /* The coordinates of the previous and current wheel number are instantiated for
        the wheel spin animation
        */
        activeWheelX = 5;
        activeWheelY = 3;

        prevWheelX = 5;
        prevWheelY = 3;
    }

    /**
     * Initializes the elements of the MainScreen object
     *
     * <p>The object contains the game board, game log, a panel containing the details of each player,
     * and the six buttons on the main screen (namely SPIN, GO, CARDS, BORROW, PAY LOAN, and RULES).</p>
     *
     * @param playerNames names of the players in the game
     */
    private void init (ArrayList<String> playerNames) {
        /* JPanels used to arrange the window elements */
        JPanel pCenter;
        JPanel pSouth;
        ArrayList <JPanel> pElements;

        /* Stores the name and associated peg color of a player */
        String nameAndColor;

        /* An array list of JPanels is created */
        pElements = new ArrayList<>();

        /* The pCenter panel is formatted */
        pCenter = new JPanel();
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.X_AXIS));

        /* pBoard is formatted as a JPanelWithBG object, displaying the background image of the board */
        pBoard = new JPanelWithBG(new ImageIcon(getClass().getResource("/assets/TRANSPARENT.png")),
                1000, 580);
        pBoard.setLayout(new GridBagLayout());
        pBoard.setBackground(new Color(142, 229, 238));

        /* The initBoard() method is called to initialize the contents of the board */
        initBoard(playerNames.size());

        /* The pBoard panel is added to the window */

        pCenter.add(pBoard);

        /* The game log is instantiated, formatted, stored within a scroll pane, and added to the window */
        taGameLog = new JTextArea("Welcome to That's Life!\n\n");
        taGameLog.setBorder(new EmptyBorder(10, 10, 10, 10));
        taGameLog.setEditable(false);
        taGameLog.setLineWrap(true);
        taGameLog.setWrapStyleWord(true);
        scrollGameLog = new JScrollPane(taGameLog);
        scrollGameLog.setPreferredSize(new Dimension (300, 100));
        pCenter.add(scrollGameLog);

        add(pCenter, BorderLayout.CENTER);

        /* The pSouth panel is formatted */
        pSouth = new JPanel();
        pSouth.setLayout(new BoxLayout(pSouth, BoxLayout.X_AXIS));
        pSouth.setPreferredSize(new Dimension(1200, 120));

        int i;
        for (i = 0; i < playerNames.size(); i++) {
            /* For each player, a new panel is added to pElements and subsequently formatted */
            pElements.add(new JPanel());
            pElements.get(i).setLayout(new BoxLayout(pElements.get(i), BoxLayout.Y_AXIS));

            /* The first player is represented by the red peg, the second player by the green
            peg, and the third by the blue peg; these colors are displayed along with their names
            in the player details section of the screen
            */
            if (i == 0)
                nameAndColor = playerNames.get(i) + " (" + PLAYER_ONE_COLOR + ") ";
            else if (i == 1)
                nameAndColor = playerNames.get(i) + " (" + PLAYER_TWO_COLOR + ") ";
            else
                nameAndColor = playerNames.get(i) + " (" + PLAYER_THREE_COLOR + ") ";

            /* The names of the players are added to the array list of JLabels and subsequently formatted */
            lblPlayerNames.add(new JLabel(nameAndColor, SwingConstants.CENTER));
            pElements.get(i).add(lblPlayerNames.get((i)));
            lblPlayerNames.get(i).setAlignmentX(JLabel.CENTER_ALIGNMENT);

            /* Text areas for storing the details of a player are created, formatted, stored in
            a scroll pane, and added to the window
            */
            taPlayerDetails.add(new JTextArea());
            taPlayerDetails.get(i).setEditable(false);
            taPlayerDetails.get(i).setLineWrap(true);
            taPlayerDetails.get(i).setWrapStyleWord(true);

            scrollPlayerDetails.add(new JScrollPane(taPlayerDetails.get(i)));
            pElements.get(i).add(scrollPlayerDetails.get(i));

            pSouth.add(pElements.get(i));
        }

        /* The last element of pElements is formatted using the grid layout to store the
        six game buttons
        */
        pElements.add(new JPanel());
        pElements.get(i).setLayout(new GridLayout(3,2));

        /* The buttons SPIN, BORROW, GO, PAY LOAN, CARDS, and RULES are added to the window */
        btnSpin = new JButton("SPIN");
        pElements.get(i).add(btnSpin);
        btnBorrow = new JButton("BORROW");
        pElements.get(i).add(btnBorrow);

        btnDraw = new JButton("GO");
        pElements.get(i).add(btnDraw);
        btnPay = new JButton("PAY LOAN");
        pElements.get(i).add(btnPay);

        btnCards = new JButton("CARDS");
        pElements.get(i).add(btnCards);
        btnRules = new JButton("RULES");
        pElements.get(i).add(btnRules);

        pSouth.add(pElements.get(i));
        add(pSouth, BorderLayout.SOUTH);
    }

    /**
     * Initializes the elements of the game board
     *
     * <p>The object contains an array of panels representing the traversible spaces on the board
     * and the number wheel.</p>
     *
     * @param numPlayers number of players in the game
     */
    private void initBoard(int numPlayers) {
        /* A GridBagConstraints object used to specify the layout of elements on the board */
        GridBagConstraints c;
        /* A Dimension object used to specify the size of the board spaces*/
        Dimension d;

        /* Lists of the x and y coordinates of the orange spaces */
        ArrayList<Integer> orangeSpacesXCoors;
        ArrayList<Integer> orangeSpacesYCoors;
        /* Lists of the x and y coordinates of the magenta spaces */
        ArrayList<Integer> magentaSpacesXCoors;
        ArrayList<Integer> magentaSpacesYCoors;
        /* Lists of the x and y coordinates of the blue spaces */
        ArrayList<Integer> blueSpacesXCoors;
        ArrayList<Integer> blueSpacesYCoors;
        /* Lists of the x and y coordinates of the green spaces */
        ArrayList<Integer> greenSpacesXCoors;
        ArrayList<Integer> greenSpacesYCoors;
        /* Lists of the x and y coordinates of the special spaces (the start and end spaces and the
        spaces occupied by the number wheel)
        */
        ArrayList<Integer> specialSpacesXCoors;
        ArrayList<Integer> specialSpacesYCoors;

        /* Counter variables for creating and formatting the board spaces */
        int i, j;
        /* Ten labels used to store the elements of the number wheel (i.e., the numbers 1 to 10) */
        JLabel lblOne;
        JLabel lblTwo;
        JLabel lblThree;
        JLabel lblFour;
        JLabel lblFive;
        JLabel lblSix;
        JLabel lblSeven;
        JLabel lblEight;
        JLabel lblNine;
        JLabel lblTen;

        /* The GridBagConstraints and Dimension objects are instantiated */
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        d = new Dimension (40, 40);
        /* pSpaces is instantiated as a two-dimensional array with 13 rows and 13 columns*/
        pSpaces = new JPanel[13][13];

        /* The ten JLabels are instantiated to display the ten elements of the number wheel */
        lblOne = new JLabel("1");
        lblTwo = new JLabel("2");
        lblThree = new JLabel("3");
        lblFour = new JLabel("4");
        lblFive = new JLabel("5");
        lblSix = new JLabel("6");
        lblSeven = new JLabel("7");
        lblEight = new JLabel("8");
        lblNine = new JLabel("9");
        lblTen = new JLabel("10");

        /* The array of spaces is instantiated and formatted. Further formatting according to the
        type of space of the panel is done further along the method
        */
        for (i = 0; i < pSpaces.length; i++) {
            for (j = 0; j < pSpaces[i].length; j++) {
                pSpaces[i][j] = new JPanel(new FlowLayout());
                pSpaces[i][j].setPreferredSize(d);

                pSpaces[i][j].setBackground(new Color(1, 1, 1, 1));

                pBoard.add(pSpaces[i][j], c);

                /* The gridx value of the GridBagConstraints object is incremented to advance
                the position of the next panel */
                c.gridx = c.gridx + 1;
            }

            /* The gridx and gridy values of the GridBagConstraints object is incremented to advance
            the position of the next panel (i.e., as the first panel of a new row) */
            c.gridx = 0;
            c.gridy = c.gridy + 1;
        }

        /* The lists storing the x and y coordinates of the orange spaces are instantiated */
        orangeSpacesXCoors = new ArrayList<>();
        orangeSpacesYCoors = new ArrayList<>();

        /* The coordinates of all orange spaces are added to their respective array lists */
        orangeSpacesXCoors.add(12);
        orangeSpacesYCoors.add(1);

        orangeSpacesXCoors.add(12);
        orangeSpacesYCoors.add(2);

        orangeSpacesXCoors.add(12);
        orangeSpacesYCoors.add(3);

        orangeSpacesXCoors.add(12);
        orangeSpacesYCoors.add(5);

        orangeSpacesXCoors.add(11);
        orangeSpacesYCoors.add(1);

        orangeSpacesXCoors.add(10);
        orangeSpacesYCoors.add(1);

        orangeSpacesXCoors.add(9);
        orangeSpacesYCoors.add(1);

        orangeSpacesXCoors.add(9);
        orangeSpacesYCoors.add(2);

        orangeSpacesXCoors.add(9);
        orangeSpacesYCoors.add(3);

        orangeSpacesXCoors.add(9);
        orangeSpacesYCoors.add(5);

        orangeSpacesXCoors.add(10);
        orangeSpacesYCoors.add(5);

        orangeSpacesXCoors.add(12);
        orangeSpacesYCoors.add(7);

        orangeSpacesXCoors.add(12);
        orangeSpacesYCoors.add(8);

        orangeSpacesXCoors.add(12);
        orangeSpacesYCoors.add(10);

        orangeSpacesXCoors.add(12);
        orangeSpacesYCoors.add(11);

        orangeSpacesXCoors.add(12);
        orangeSpacesYCoors.add(12);

        orangeSpacesXCoors.add(11);
        orangeSpacesYCoors.add(12);

        orangeSpacesXCoors.add(9);
        orangeSpacesYCoors.add(12);

        orangeSpacesXCoors.add(8);
        orangeSpacesYCoors.add(12);

        orangeSpacesXCoors.add(6);
        orangeSpacesYCoors.add(12);

        orangeSpacesXCoors.add(10);
        orangeSpacesYCoors.add(11);

        orangeSpacesXCoors.add(10);
        orangeSpacesYCoors.add(9);

        orangeSpacesXCoors.add(8);
        orangeSpacesYCoors.add(9);

        orangeSpacesXCoors.add(6);
        orangeSpacesYCoors.add(9);

        orangeSpacesXCoors.add(5);
        orangeSpacesYCoors.add(12);

        orangeSpacesXCoors.add(4);
        orangeSpacesYCoors.add(12);

        orangeSpacesXCoors.add(1);
        orangeSpacesYCoors.add(12);

        orangeSpacesXCoors.add(0);
        orangeSpacesYCoors.add(12);

        orangeSpacesXCoors.add(0);
        orangeSpacesYCoors.add(11);

        orangeSpacesXCoors.add(0);
        orangeSpacesYCoors.add(8);

        orangeSpacesXCoors.add(0);
        orangeSpacesYCoors.add(5);

        orangeSpacesXCoors.add(1);
        orangeSpacesYCoors.add(9);

        orangeSpacesXCoors.add(3);
        orangeSpacesYCoors.add(6);

        orangeSpacesXCoors.add(2);
        orangeSpacesYCoors.add(5);

        orangeSpacesXCoors.add(1);
        orangeSpacesYCoors.add(5);

        orangeSpacesXCoors.add(0);
        orangeSpacesYCoors.add(5);

        orangeSpacesXCoors.add(0);
        orangeSpacesYCoors.add(4);

        orangeSpacesXCoors.add(0);
        orangeSpacesYCoors.add(2);

        orangeSpacesXCoors.add(1);
        orangeSpacesYCoors.add(1);

        /* The background colors and borders of all orange spaces are set */
        for (i = 0; i < orangeSpacesXCoors.size(); i++) {
            pSpaces[orangeSpacesXCoors.get(i)][orangeSpacesYCoors.get(i)].setBackground(Color.orange);
            pSpaces[orangeSpacesXCoors.get(i)][orangeSpacesYCoors.get(i)].setBorder(BorderFactory.createLineBorder(new Color(255, 140, 0), 2));
        }

        /* The lists storing the x and y coordinates of the magenta spaces are instantiated */
        magentaSpacesXCoors = new ArrayList<>();
        magentaSpacesYCoors = new ArrayList<>();

        /* The coordinates of all magenta spaces are added to their respective array lists */
        magentaSpacesXCoors.add(12);
        magentaSpacesYCoors.add(4);
        
        magentaSpacesXCoors.add(9);
        magentaSpacesYCoors.add(4);

        magentaSpacesXCoors.add(11);
        magentaSpacesYCoors.add(5);

        magentaSpacesXCoors.add(10);
        magentaSpacesYCoors.add(12);

        magentaSpacesXCoors.add(10);
        magentaSpacesYCoors.add(10);

        magentaSpacesXCoors.add(0);
        magentaSpacesYCoors.add(9);

        magentaSpacesXCoors.add(2);
        magentaSpacesYCoors.add(9);

        magentaSpacesXCoors.add(3);
        magentaSpacesYCoors.add(7);

        magentaSpacesXCoors.add(3);
        magentaSpacesYCoors.add(5);

        /* The background colors and borders of all magenta spaces are set */
        for (i = 0; i < magentaSpacesXCoors.size(); i++) {
            pSpaces[magentaSpacesXCoors.get(i)][magentaSpacesYCoors.get(i)].setBackground(Color.magenta);
            pSpaces[magentaSpacesXCoors.get(i)][magentaSpacesYCoors.get(i)].setBorder(BorderFactory.createLineBorder(new Color(139, 0, 139), 2));
        }

        /* The lists storing the x and y coordinates of the blue spaces are instantiated */
        blueSpacesXCoors = new ArrayList<>();
        blueSpacesYCoors = new ArrayList<>();

        /* The coordinates of all blue spaces are added to their respective array lists */
        blueSpacesXCoors.add(12);
        blueSpacesYCoors.add(6);

        blueSpacesXCoors.add(9);
        blueSpacesYCoors.add(9);

        blueSpacesXCoors.add(6);
        blueSpacesYCoors.add(11);

        blueSpacesXCoors.add(3);
        blueSpacesYCoors.add(12);

        blueSpacesXCoors.add(0);
        blueSpacesYCoors.add(6);

        blueSpacesXCoors.add(3);
        blueSpacesYCoors.add(8);

        blueSpacesXCoors.add(2);
        blueSpacesYCoors.add(1);

        /* The background colors and borders of all blue spaces are set */
        for (i = 0; i < blueSpacesXCoors.size(); i++) {
            pSpaces[blueSpacesXCoors.get(i)][blueSpacesYCoors.get(i)].setBackground(Color.cyan);
            pSpaces[blueSpacesXCoors.get(i)][blueSpacesYCoors.get(i)].setBorder(BorderFactory.createLineBorder(new Color(127, 127, 255), 2));
        }

        /* The lists storing the x and y coordinates of the green spaces are instantiated */
        greenSpacesXCoors = new ArrayList<>();
        greenSpacesYCoors = new ArrayList<>();

        /* The coordinates of all green spaces are added to their respective array lists */
        greenSpacesXCoors.add(12);
        greenSpacesYCoors.add(9);

        greenSpacesXCoors.add(7);
        greenSpacesYCoors.add(12);

        greenSpacesXCoors.add(7);
        greenSpacesYCoors.add(9);

        greenSpacesXCoors.add(6);
        greenSpacesYCoors.add(10);

        greenSpacesXCoors.add(2);
        greenSpacesYCoors.add(12);

        greenSpacesXCoors.add(0);
        greenSpacesYCoors.add(10);

        greenSpacesXCoors.add(0);
        greenSpacesYCoors.add(7);

        greenSpacesXCoors.add(3);
        greenSpacesYCoors.add(9);

        greenSpacesXCoors.add(0);
        greenSpacesYCoors.add(3);

        greenSpacesXCoors.add(0);
        greenSpacesYCoors.add(1);

        greenSpacesXCoors.add(3);
        greenSpacesYCoors.add(1);

        /* The background colors and borders of all green spaces are set */
        for (i = 0; i < greenSpacesXCoors.size(); i++) {
            pSpaces[greenSpacesXCoors.get(i)][greenSpacesYCoors.get(i)].setBackground(new Color(144, 238, 144));
            pSpaces[greenSpacesXCoors.get(i)][greenSpacesYCoors.get(i)].setBorder(BorderFactory.createLineBorder(new Color(88, 167, 88), 2));
        }

        /* The lists storing the x and y coordinates of the special spaces are instantiated */
        specialSpacesXCoors = new ArrayList<>();
        specialSpacesYCoors = new ArrayList<>();

        /* The coordinates of the start, retirement, and number wheel spaces are added to the array lists of
        special spaces. However, the contents of the special spaces are formatted individually.
        */
        // start space
        specialSpacesXCoors.add(12);
        specialSpacesYCoors.add(0);
        pSpaces[12][0].setBackground(Color.pink);
        pSpaces[12][0].setBorder(BorderFactory.createLineBorder(new Color(153, 69, 84), 2));

        // retirement space
        specialSpacesXCoors.add(4);
        specialSpacesYCoors.add(4);
        pSpaces[3][0].setBackground(Color.pink);
        pSpaces[3][0].setBorder(BorderFactory.createLineBorder(new Color(153, 69, 84), 2));

        //  1 (number wheel)
        specialSpacesXCoors.add(5);
        specialSpacesYCoors.add(3);
        pSpaces[5][3].setBackground(Color.lightGray);
        pSpaces[5][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        pSpaces[5][3].add(lblOne);

        //  2 (number wheel)
        specialSpacesXCoors.add(5);
        specialSpacesYCoors.add(4);
        pSpaces[5][4].setBackground(Color.lightGray);
        pSpaces[5][4].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.black));
        pSpaces[5][4].add(lblTwo);

        //  3 (number wheel)
        specialSpacesXCoors.add(5);
        specialSpacesYCoors.add(5);
        pSpaces[5][5].setBackground(Color.lightGray);
        pSpaces[5][5].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
        pSpaces[5][5].add(lblThree);

        //  4 (number wheel)
        specialSpacesXCoors.add(5);
        specialSpacesYCoors.add(6);
        pSpaces[5][6].setBackground(Color.lightGray);
        pSpaces[5][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        pSpaces[5][6].add(lblFour);

        //  5 (number wheel)
        specialSpacesXCoors.add(6);
        specialSpacesYCoors.add(6);
        pSpaces[6][6].setBackground(Color.lightGray);
        pSpaces[6][6].setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.black));
        pSpaces[6][6].add(lblFive);

        //  6 (number wheel)
        specialSpacesXCoors.add(7);
        specialSpacesYCoors.add(6);
        pSpaces[7][6].setBackground(Color.lightGray);
        pSpaces[7][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        pSpaces[7][6].add(lblSix);

        //  7 (number wheel)
        specialSpacesXCoors.add(7);
        specialSpacesYCoors.add(5);
        pSpaces[7][5].setBackground(Color.lightGray);
        pSpaces[7][5].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
        pSpaces[7][5].add(lblSeven);

        //  8 (number wheel)
        specialSpacesXCoors.add(7);
        specialSpacesYCoors.add(4);
        pSpaces[7][4].setBackground(Color.lightGray);
        pSpaces[7][4].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.black));
        pSpaces[7][4].add(lblEight);

        //  9 (number wheel)
        specialSpacesXCoors.add(7);
        specialSpacesYCoors.add(3);
        pSpaces[7][3].setBackground(Color.lightGray);
        pSpaces[7][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        pSpaces[7][3].add(lblNine);

        //  10 (number wheel)
        specialSpacesXCoors.add(6);
        specialSpacesYCoors.add(3);
        pSpaces[6][3].setBackground(Color.lightGray);
        pSpaces[6][3].setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.black));
        pSpaces[6][3].add(lblTen);

        /* The initPlayerPegs() method is called to initialize the player pegs on the board */
        initPlayerPegs(numPlayers);
    }

    /**
     * Initializes the player pegs on the game board
     *
     * <p>Copies of the player pegs are placed on all traversable panels on the board;
     * only their visibilities are toggled to represent player movement.</p>
     *
     * @param numPlayers number of players in the game
     */
    private void initPlayerPegs (int numPlayers) {

        /* The list of pegs representing the possible positions of the first player is instantiated */
        lblPlayer1Pegs = new ArrayList<>();

        /* A scaled version of peg of the first player (a red circle) is created, and instances of this
        corresponding to the number of spaces on the board are added to the list of pegs
        */
        imageOrig1 = new ImageIcon(getClass().getResource("/assets/playerPeg1.png"));
        imageScaled1 = imageOrig1.getImage().getScaledInstance(13, 13, Image.SCALE_DEFAULT);
        for (int i = 0; i < xCoords.length; i++) {
            lblPlayer1Pegs.add(new JLabel(new ImageIcon(imageScaled1)));
        }
        for (int i = 0; i < xCoords.length; i++) {
            /* Copies of the peg are added to all the spaces on the board but are set as invisible */
            pSpaces[xCoords[i]][yCoords[i]].add(lblPlayer1Pegs.get(i));
            lblPlayer1Pegs.get(i).setVisible(false);
        }
        /* As all players start on the start space, the peg at this space is set as visible */
        lblPlayer1Pegs.get(0).setVisible(true);

        /* The list of pegs representing the possible positions of the first player is instantiated */
        lblPlayer2Pegs = new ArrayList<>();

        /* A scaled version of peg of the second player (a green circle) is created, and instances of this
        corresponding to the number of spaces on the board are added to the list of pegs
        */
        imageOrig2 = new ImageIcon(getClass().getResource("/assets/playerPeg2.png"));
        imageScaled2 = imageOrig2.getImage().getScaledInstance(13, 13, Image.SCALE_DEFAULT);
        for (int i = 0; i < xCoords.length; i++) {
            lblPlayer2Pegs.add(new JLabel(new ImageIcon(imageScaled2)));
        }
        for (int i = 0; i < xCoords.length; i++) {
            /* Copies of the peg are added to all the spaces on the board but are set as invisible */
            pSpaces[xCoords[i]][yCoords[i]].add(lblPlayer2Pegs.get(i));
            lblPlayer2Pegs.get(i).setVisible(false);
        }
        /* As all players start on the start space, the peg at this space is set as visible */
        lblPlayer2Pegs.get(0).setVisible(true);

        /* The third peg will only be used if there are three players in the game */
        if (numPlayers == 3) {
            /* The list of pegs representing the possible positions of the third player is instantiated */
            lblPlayer3Pegs = new ArrayList<>();

            /* A scaled version of peg of the third player (a blue circle) is created, and instances of this
            corresponding to the number of spaces on the board are added to the list of pegs
            */
            imageOrig3 = new ImageIcon(getClass().getResource("/assets/playerPeg3.png"));
            imageScaled3 = imageOrig3.getImage().getScaledInstance(13, 13, Image.SCALE_DEFAULT);
            for (int i = 0; i < xCoords.length; i++) {
                lblPlayer3Pegs.add(new JLabel(new ImageIcon(imageScaled3)));
            }
            for (int i = 0; i < xCoords.length; i++) {
                /* Copies of the peg are added to all the spaces on the board but are set as invisible */
                pSpaces[xCoords[i]][yCoords[i]].add(lblPlayer3Pegs.get(i));
                lblPlayer3Pegs.get(i).setVisible(false);
            }
            /* As all players start on the start space, the peg at this space is set as visible */
            lblPlayer3Pegs.get(0).setVisible(true);
        }
    }

    /**
     * Returns the x coordinate of an element of the number wheel
     *
     * @param number the number on the wheel whose x coordinate is retrieved
     * @return the x coordinate of an element of the number wheel
     */
    public int getWheelX(int number) {
        switch (number) {
            /* Switch cases are used to maximize the adjacency of the number wheel element positions */
            case 1:
            case 2:
            case 3:
            case 4:
                return 5;
            case 10:
            case 5:
                return 6;
            case 9:
            case 8:
            case 7:
            case 6:
                return 7;
        }

        return -1;
    }

    /**
     * Returns the y coordinate of an element of the number wheel
     *
     * @param number the number on the wheel whose y coordinate is retrieved
     * @return the y coordinate of an element of the number wheel
     */
    public int getWheelY(int number) {
        switch (number) {
            /* Switch cases are used to maximize the adjacency of the number wheel element positions */
            case 1:
            case 10:
            case 9:
                return 3;
            case 2:
            case 8:
                return 4;
            case 3:
            case 7:
                return 5;
            case 4:
            case 5:
            case 6:
                return 6;
        }

        return -1;
    }

    /**
     * Sets the highlighted x coordinate of the wheel
     *
     * @param number the number on the wheel that is to be highlighted
     */
    public void setActiveWheelX(int number) {
        /* The x coordinate of the number to be highlighted is retrieved using the getWheelX() method */
        activeWheelX = getWheelX(number);
    }

    /**
     * Sets the highlighted y coordinate of the wheel
     *
     * @param number the number on the wheel that is to be highlighted
     */
    public void setActiveWheelY(int number) {
        /* The y coordinate of the number to be highlighted is retrieved using the getWheelY() method */
        activeWheelY = getWheelY(number);
    }

    /**
     * Sets the previous x coordinate of the wheel
     *
     * @param number the number on the wheel that was previously highlighted
     */
    public void setPrevWheelX(int number) {
        /* The x coordinate of the number that was previously highlighted is retrieved using the getWheelX() method */
        prevWheelX = getWheelX(number);
    }

    /**
     * Sets the previous y coordinate of the wheel
     *
     * @param number the number on the wheel that was previously highlighted
     */
    public void setPrevWheelY(int number) {
        /* The y coordinate of the number that was previously highlighted is retrieved using the getWheelY() method */
        prevWheelY = getWheelY(number);
    }

    /**
     * Sets the compCounter of the MainScreen object
     *
     * @param number the number on the wheel that is first highlighted
     */
    public static void setCompCounter(int number) {
        compCounter = number;
    }

    /**
     * Returns the compCounter of the MainScreen object
     *
     * @return the compCounter of the MainScreen object
     */
    public static int getCompCounter() {
        return compCounter;
    }

    /**
     * Performs the animation of the number wheel by highlighting consecutive elements at
     * different intervals
     *
     * @param number the number to be first highlighted
     */
    public void highlightWheel(int number) {
        /* setCompCounter() is called, with the number parameter passed as its parameter */
        setCompCounter(number);

        /* Twelve timer objects are created with varying delay parameters to be used to highlight
        and remove the highlight on the number wheel elements. Highlighting is done by setting the
        background color of a panel to white, and highlighting is removed by setting the background
        color back to its original color (i.e., light gray).
        */

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer0
        is used to remove the highlight of the previously spun element. The animation then
        continues with timer1.
        */
        final Timer timer0;
        timer0 = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[prevWheelX][prevWheelY].setBackground(Color.lightGray);
                ((Timer)e.getSource()).stop();

                prevWheelX = activeWheelX;
                prevWheelY = activeWheelY;
            }
        });

        timer0.setRepeats(false);
        timer0.start();

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer1
        follows timer0 by highlighting the element specified by the compCounter variable.
        The animation then continues with timer2.
        */
        final Timer timer1 = new Timer(ANIMATE_MILLISEC, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.white);
                ((Timer)e.getSource()).stop();
            }
        });

        timer1.setRepeats(false);
        timer1.start();

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer2
        follows timer1 by removing the highlight of the element specified by the compCounter variable,
        incrementing compCounter within the range of the number wheel elements, and highlighting the
        subsequent value. The animation then continues with timer3.
        */
        final Timer timer2 = new Timer(ANIMATE_MILLISEC * 2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.lightGray);
                setCompCounter((getCompCounter()) % 10 + 1);
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.white);
                ((Timer)e.getSource()).stop();
            }
        });

        timer2.setRepeats(false);
        timer2.start();

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer3
        follows timer2 by removing the highlight of the element specified by the compCounter variable,
        incrementing compCounter within the range of the number wheel elements, and highlighting the
        subsequent value. The animation then continues with timer4.
        */
        final Timer timer3 = new Timer(ANIMATE_MILLISEC * 3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.lightGray);
                setCompCounter((getCompCounter()) % 10 + 1);
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.white);
                ((Timer)e.getSource()).stop();
            }
        });

        timer3.setRepeats(false);
        timer3.start();

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer4
        follows timer3 by removing the highlight of the element specified by the compCounter variable,
        incrementing compCounter within the range of the number wheel elements, and highlighting the
        subsequent value. The animation then continues with timer5.
        */
        final Timer timer4 = new Timer(ANIMATE_MILLISEC * 4, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.lightGray);
                setCompCounter((getCompCounter()) % 10 + 1);
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.white);
                ((Timer)e.getSource()).stop();
            }
        });

        timer4.setRepeats(false);
        timer4.start();

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer5
        follows timer4 by removing the highlight of the element specified by the compCounter variable,
        incrementing compCounter within the range of the number wheel elements, and highlighting the
        subsequent value. The animation then continues with timer6.
        */
        final Timer timer5 = new Timer(ANIMATE_MILLISEC * 5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.lightGray);
                setCompCounter((getCompCounter()) % 10 + 1);
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.white);
                ((Timer)e.getSource()).stop();
            }
        });

        timer5.setRepeats(false);
        timer5.start();

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer6
        follows timer5 by removing the highlight of the element specified by the compCounter variable,
        incrementing compCounter within the range of the number wheel elements, and highlighting the
        subsequent value. The animation then continues with timer7.
        */
        final Timer timer6 = new Timer(ANIMATE_MILLISEC * 6, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.lightGray);
                setCompCounter((getCompCounter()) % 10 + 1);
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.white);
                ((Timer)e.getSource()).stop();
            }
        });

        timer6.setRepeats(false);
        timer6.start();

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer7
        follows timer6 by removing the highlight of the element specified by the compCounter variable,
        incrementing compCounter within the range of the number wheel elements, and highlighting the
        subsequent value. The animation then continues with timer8.
        */
        final Timer timer7 = new Timer(ANIMATE_MILLISEC * 7, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.lightGray);
                setCompCounter((getCompCounter()) % 10 + 1);
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.white);
                ((Timer)e.getSource()).stop();
            }
        });

        timer7.setRepeats(false);
        timer7.start();

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer8
        follows timer7 by removing the highlight of the element specified by the compCounter variable,
        incrementing compCounter within the range of the number wheel elements, and highlighting the
        subsequent value. The animation then continues with timer9.
        */
        final Timer timer8 = new Timer(ANIMATE_MILLISEC * 8, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.lightGray);
                setCompCounter((getCompCounter()) % 10 + 1);
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.white);
                ((Timer)e.getSource()).stop();
            }
        });

        timer8.setRepeats(false);
        timer8.start();

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer9
        follows timer8 by removing the highlight of the element specified by the compCounter variable,
        incrementing compCounter within the range of the number wheel elements, and highlighting the
        subsequent value. The animation then continues with timer10.
        */
        final Timer timer9 = new Timer(ANIMATE_MILLISEC * 9, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.lightGray);
                setCompCounter((getCompCounter()) % 10 + 1);
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.white);
                ((Timer)e.getSource()).stop();
            }
        });

        timer9.setRepeats(false);
        timer9.start();

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer10
        follows timer9 by removing the highlight of the element specified by the compCounter variable,
        incrementing compCounter within the range of the number wheel elements, and highlighting the
        subsequent value. The animation then continues with timer11.
        */
        final Timer timer10 = new Timer(ANIMATE_MILLISEC * 10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.lightGray);
                setCompCounter((getCompCounter()) % 10 + 1);
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.white);
                ((Timer)e.getSource()).stop();
            }
        });

        timer10.setRepeats(false);
        timer10.start();

        /* When an action event is executed (i.e., the wheel is spun during gameplay), timer11
        follows timer10 by removing the highlight of the element specified by the compCounter variable,
        incrementing compCounter within the range of the number wheel elements, and highlighting the
        subsequent value.

        In effect, the final highlighted value (and the result of the wheel spin) is
        also the first highlighted value during the animation.
        */
        final Timer timer11 = new Timer(ANIMATE_MILLISEC * 11, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.lightGray);
                setCompCounter((getCompCounter()) % 10 + 1);
                pSpaces[getWheelX(getCompCounter())][getWheelY(getCompCounter())].setBackground(Color.white);
                ((Timer)e.getSource()).stop();
            }
        });

        timer11.setRepeats(false);
        timer11.start();
    }

    /**
     * Enables or disables the SPIN button
     *
     * @param isEnabled <code>true</code> if the button is to be enabled;
     *                  <code>false</code>, otherwise
     */
    public void setSpinEnabled(boolean isEnabled) {
        btnSpin.setEnabled(isEnabled);
    }

    /**
     * Enables or disables the GO button
     *
     * @param isEnabled <code>true</code> if the button is to be enabled;
     *                  <code>false</code>, otherwise
     */
    public void setDrawEnabled(boolean isEnabled) {
        btnDraw.setEnabled(isEnabled);
    }

    /**
     * Enables or disables the BUY and PAY LOANS buttons
     *
     * @param isEnabled <code>true</code> if the buttons are to be enabled;
     *                  <code>false</code>, otherwise
     */
    public void setLoanEnabled(boolean isEnabled) {
        btnBorrow.setEnabled(isEnabled);
        btnPay.setEnabled(isEnabled);
    }

    /**
     * Enables or disables the RULES and CARDS buttons
     *
     * @param isEnabled <code>true</code> if the buttons are to be enabled;
     *                  <code>false</code>, otherwise
     */
    public void setDisplayBtnsEnabled(boolean isEnabled) {
        btnRules.setEnabled(true);
        btnCards.setEnabled(true);
    }

    /**
     * Adds a given string to the game log
     *
     * @param text string to be added to the game log
     */
    public void addToLog(String text) {
        /* The string is added to the game log by calling the insert() method */
        taGameLog.insert(text, taGameLog.getText().length());
        /* The caret position is set to the end of the current log so that text can be
        displayed continuously.
        */
        taGameLog.setCaretPosition(taGameLog.getText().length());
    }

    /**
     * Updates the player details displayed on the screen
     *
     * @param text string to overwrite the current player details
     * @param index index of the player whose details are to be updated
     */
    public void updatePlayerDetails(String text, int index) {
        /* The contents of the player details at the specified index are replaced with the passed string */
        taPlayerDetails.get(index).setText(text);
        /* The caret position is set to the start of the text area in preparation for future updates */
        taPlayerDetails.get(index).setCaretPosition(0);
    }

    /**
     * Disables all the game buttons on the main screen
     *
     * <p>During gameplay, this is used when the main screen is open but must not yet be interacted
     * with (i.e., when the players are choosing their paths at the start space). </p>
     */
    public void disableAllButtons() {
        btnSpin.setEnabled(false);
        btnBorrow.setEnabled(false);
        btnCards.setEnabled(false);
        btnDraw.setEnabled(false);
        btnPay.setEnabled(false);
        btnRules.setEnabled(false);
    }

    /**
     * Enables all the game buttons on the main screen except the GO button
     *
     * <p>During gameplay, this is used at the start of a player's turn; as they have not yet
     * spun the wheel, they should not be able to execute the functions of the spaces. </p>
     */
    public void enableAllButtonsExceptGo() {
        btnSpin.setEnabled(true);
        btnBorrow.setEnabled(true);
        btnCards.setEnabled(true);
        btnDraw.setEnabled(false);
        btnPay.setEnabled(true);
        btnRules.setEnabled(true);
    }

    /**
     * Enables all the game buttons on the main screen
     */
    public void enableAllButtons() {
        btnSpin.setEnabled(true);
        btnBorrow.setEnabled(true);
        btnCards.setEnabled(true);
        btnDraw.setEnabled(true);
        btnPay.setEnabled(true);
        btnRules.setEnabled(true);
    }

    /**
     * Enables the PAY LOAN button on the main screen
     *
     * <p>During gameplay, PAY LOAN should only be enabled if the current player has
     * loans from the bank. </p>
     *
     * @param numLoans number of loans of the active player
     */
    public void setPayEnabled(int numLoans) {
        if (numLoans > 0)
            btnPay.setEnabled(true);
        else
            btnPay.setEnabled(false);
    }

    /**
     * Enables the BORROW button on the main screen
     *
     * <p>During gameplay, BORROW should only be enabled at the start of the player's turn
     * (i.e., before they press SPIN or GO). </p>
     *
     * @param isEnabled <code>true</code> if the button is to be enabled;
     *                  <code>false</code>, otherwise
     */
    public void setBorrowEnabled(boolean isEnabled) {
        btnBorrow.setEnabled(isEnabled);
    }

    /**
     * Enables the PAY LOAN button on the main screen
     *
     * @param isEnabled <code>true</code> if the button is to be enabled;
     *                  <code>false</code>, otherwise
     */
    public void setPayEnabled(boolean isEnabled) {
        btnPay.setEnabled(isEnabled);
    }

    /**
     * Sets action listeners for the window
     *
     * <p>One action listener is added for each of the buttons in the window.</p>
     *
     * @param listener action listener for the window buttons
     */
    public void setActionListener(ActionListener listener) {
        btnSpin.addActionListener(listener);
        btnDraw.addActionListener(listener);
        btnCards.addActionListener(listener);
        btnBorrow.addActionListener(listener);
        btnPay.addActionListener(listener);
        btnRules.addActionListener(listener);
    }

    /**
     * Sets window listeners for the window
     *
     * <p>One window listener is added for the window.</p>
     *
     * @param listener window listener for the window
     */
    public void setWindowListener(WindowListener listener) {
        addWindowListener(listener);
    }

    /**
     * Moves the player peg of the specified player
     *
     * <p>Player pegs are moved by setting the visibility of their pegs at the previous position
     * as <code>false</code>, and setting the visibility of their pegs at the new position as
     * <code>true</code>.</p>
     *
     * @param color color of the peg to be moved
     * @param prevIndex index of the previous position of the player on the board
     * @param index index of the new position of the player on the board
     */
    public void movePeg (String color, int prevIndex, int index) {
        if (color.equalsIgnoreCase(PLAYER_ONE_COLOR)) {
            /* If the red peg is to be moved, the elements of the array list lblPlayer1Pegs are manipulated */
            lblPlayer1Pegs.get(prevIndex).setVisible(false);
            lblPlayer1Pegs.get(index).setVisible(true);
        } else if (color.equalsIgnoreCase(PLAYER_TWO_COLOR)) {
            /* If the green peg is to be moved, the elements of the array list lblPlayer2Pegs are manipulated */
            lblPlayer2Pegs.get(prevIndex).setVisible(false);
            lblPlayer2Pegs.get(index).setVisible(true);
        } else if (color.equalsIgnoreCase(PLAYER_THREE_COLOR)) {
            /* If the blue peg is to be moved, the elements of the array list lblPlayer3Pegs are manipulated */
            lblPlayer3Pegs.get(prevIndex).setVisible(false);
            lblPlayer3Pegs.get(index).setVisible(true);
        }
    }
}

