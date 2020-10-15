package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class implementing a <b>ChooseHouse window</b> as part of the GUI for
 * choosing a house
 */
public class ChooseHouse extends JFrame {
    /* List of buttons for choosing the houses available */
    private ArrayList<JButton> btnChoices;
    /* List of text areas for displaying details about the available houses */
    private ArrayList<JTextArea> taDetails;
    /* Prompt indicating instructions for the player */
    private JLabel lblHeader;

    /**
     * Creates a ChooseHouse object
     *
     * <p>As part of the larger interface of the game, this window cannot be closed without proper player input;
     * it remains visible until the player presses one of the buttons.</p>
     *
     * @param houseNames names of the available houses
     * @param houseDetails details of the available houses
     * @param imagePaths relative paths of the images added to the window
     */
    public ChooseHouse (ArrayList<String> houseNames, ArrayList<String> houseDetails, ArrayList<String> imagePaths) {

        /* The string "Choose a House" is passed as the label for the title bar */
        super("Choose A House");
        setLayout(new BorderLayout());

        /* init() is called to initialize the elements of the window */
        init(houseNames, houseDetails, imagePaths);

        /* Additional formatting methods for the window are executed */
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(139, 0, 139), 8));

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(1000, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Initializes the elements of the ChooseHouse object
     *
     * <p>The object contains a text prompt for the player and lists of text areas and
     * buttons for choosing one of the available houses.</p>
     *
     * @param houseNames names of the house cards to be added to the window
     * @param houseDetails pertinent details of the house cards to be added to the window
     * @param imagePaths relative paths of the images to be added to the window
     */
    private void init(ArrayList<String> houseNames, ArrayList<String> houseDetails, ArrayList<String> imagePaths) {
        /* JPanels used to arrange the window elements */
        JPanel pNorth;
        JPanel pMain;
        ArrayList<JPanel> pHouses;
        ArrayList<JPanel> pHouseDisplays;

        /* The array list objects are created */
        btnChoices = new ArrayList<>();
        taDetails = new ArrayList<>();
        pHouses = new ArrayList<>();
        pHouseDisplays = new ArrayList<>();

        /* The pNorth panel is formatted */
        pNorth = new JPanel();
        pNorth.setLayout(new BorderLayout());
        pNorth.setBackground(new Color(142, 229, 238));

        /* A player prompt is added to the panel */
        lblHeader = new JLabel("<html><center>Choose a house to purchase:</html></center>");
        lblHeader.setBorder(new EmptyBorder(5, 10, 5, 10));
        pNorth.add(lblHeader);
        add(pNorth, BorderLayout.NORTH);

        /* The pMain panel is formatted. Specifically, this panel can hold a maximum of 10 sets of
        details and buttons (the maximum number of cards in the house card deck)
        */
        pMain = new JPanel();
        pMain.setLayout(new GridLayout(2, 5));
        pMain.setBackground(new Color(142, 229, 238));


        for (int i = 0; i < houseNames.size(); i++) {
            /* For each of the elements of the house card deck, a new panel is created and formatted */
            pHouses.add(new JPanel());
            pHouses.get(i).setLayout(new BorderLayout());
            pHouses.get(i).setBorder(new EmptyBorder(5, 10, 5, 10));
            pHouses.get(i).setOpaque(false);

            pHouseDisplays.add(new JPanel());
            pHouseDisplays.get(i).setLayout(new BoxLayout(pHouseDisplays.get(i), BoxLayout.X_AXIS));
            pHouseDisplays.get(i).setOpaque(false);

            /* The details of the house card object are formatted */
            taDetails.add(new JTextArea(houseDetails.get(i)));
            taDetails.get(i).setBorder(new EmptyBorder(5, 5, 5, 5));
            taDetails.get(i).setEditable(false);
            taDetails.get(i).setLineWrap(true);
            taDetails.get(i).setWrapStyleWord(true);
            taDetails.get(i).setOpaque(false);

            /* A button is created for choosing the house cardd */
            btnChoices.add(new JButton(houseNames.get(i)));
            btnChoices.get(i).setBorder(new EmptyBorder(5, 5, 5, 5));

            /* An image corresponding to the house card is added using the setHouseImage() method */
            pHouseDisplays.get(i).add(setHouseImage(imagePaths.get(i)));

            /* The card details and buttons are subsequently added to the display */
            pHouseDisplays.get(i).add(taDetails.get(i));
            pHouses.get(i).add(pHouseDisplays.get(i), BorderLayout.CENTER);
            pHouses.get(i).add(btnChoices.get(i), BorderLayout.SOUTH);

            /* The window elements of one of the house cards is added to pMain */
            pMain.add(pHouses.get(i));
        }

        /* pMain, containing the details of all available house cards, is added to the window */
        add(pMain, BorderLayout.CENTER);
    }

    /**
     * Helper method that adds images to the window
     *
     * @param imagePath relative path of the image to be added
     * @return formatted version of the image
     */
    private JLabel setHouseImage(String imagePath) {
        /* Stores the original image */
        ImageIcon imageOrig;
        /* Stores a scaled version of the image */
        Image imageScaled;
        /* Stores a formatted version of the image to be displayed on the window */
        JLabel lblImage;

        /* The original image is retrieved and scaled */
        imageOrig = new ImageIcon(getClass().getResource(imagePath));
        imageScaled = imageOrig.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);

        /* The scaled image is converted to a JLabel, further formatted, and returned */
        lblImage = new JLabel(new ImageIcon(imageScaled));
        lblImage.setBackground(Color.white);
        lblImage.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        lblImage.setBorder(new EmptyBorder(2, 2, 2, 2));
        return lblImage;
    }

    /**
     * Sets action listeners for the window
     *
     * <p>One action listener is added for each of the buttons in the window.</p>
     *
     * @param listener action listener for the window buttons
     */
    public void setActionListener(ActionListener listener) {
        for (int i = 0; i < btnChoices.size(); i++)
            btnChoices.get(i).addActionListener(listener);
    }
}
