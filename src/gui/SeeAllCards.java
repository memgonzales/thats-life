package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Class implementing a <b>SeeAllCards window</b> as part of the GUI for
 * displaying all the players' cards at the beginning of the game
 */
public class SeeAllCards extends JFrame {
    /**
     * <code>ArrayList</code> of text areas containing the details of all kept career cards
     */
    private ArrayList<JTextArea> taCareerContent;
    /**
     * <code>ArrayList</code> of text areas containing the details of all kept salary cards
     */
    private ArrayList<JTextArea> taSalaryContent;
    /**
     * <code>ArrayList</code> of labels containing the names of the players in the game
     */
    private ArrayList<JLabel> lblPlayerNames;

    /**
     * Scroll pane storing the card details
     */
    private JScrollPane scroll;
    /**
     * Confirm button for proceeding to the next part of the game
     */
    private JButton btnConfirm;
    /**
     * Label storing an informative prompt for the players
     */
    private JLabel lblHeader;

    /**
     * Creates a SeeAllCards object
     *
     * <p>As part of the larger interface of the game, this window is not visible persistently;
     * it is hidden when not in use and rendered visible upon appropriate player input.</p>
     *
     * @param playerNames names of the players in the game
     * @param careerDetails details of the drawn career cards of the players
     * @param salaryDetails details of the drawn salary cards of the players
     */
    public SeeAllCards (ArrayList<String> playerNames, ArrayList<String> careerDetails, ArrayList<String> salaryDetails) {

        /* The string "Drawn Cards" is passed as the label for the title bar */
        super("Drawn Cards");

        /* Array lists storing the career card and salary card details and the player names are created */
        taCareerContent = new ArrayList<>();
        taSalaryContent = new ArrayList<>();
        lblPlayerNames = new ArrayList<>();

        /* init() is called to initialize the elements of the window */
        init(playerNames, careerDetails, salaryDetails);

        /* Additional formatting methods for the window are executed */
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Initializes the elements of the SeeAllCards object
     *
     * <p>The object contains the drawn career and salary cards of all players.</p>
     *
     * @param playerNames names of the players in the game
     * @param careerDetails details of the drawn career cards of the players
     * @param salaryDetails details of the drawn salary cards of the players
     */
    private void init(ArrayList<String> playerNames, ArrayList<String> careerDetails, ArrayList<String> salaryDetails) {
        /* JPanels used to arrange the window elements */
        JPanel pMain;
        JPanel pCenter;
        ArrayList<JPanel> pDetails;

        /* An array list of panels for storing the cards of each player is created */
        pDetails = new ArrayList<>();

        /* The pMain panel is formatted */
        pMain = new JPanel();
        pMain.setLayout(new BorderLayout());
        pMain.setBackground(new Color(142, 229, 238));

        /* An informative header is formatted and added to the window */
        lblHeader = new JLabel("<html><center>Here are the cards you drew:</center></html>");
        lblHeader.setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
        lblHeader.setBorder(new EmptyBorder(10, 10, 10, 10));
        pMain.add(lblHeader, BorderLayout.NORTH);

        /* The pCenter panel is formatted */
        pCenter = new JPanel();
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.X_AXIS));
        pCenter.setOpaque(false);

        /* One of the pDetails panels is formatted */
        pDetails.add(new JPanel());
        pDetails.get(0).setLayout(new BoxLayout(pDetails.get(0), BoxLayout.Y_AXIS));
        pDetails.get(0).setBorder(new EmptyBorder(5, 5, 5, 5));
        pDetails.get(0).setOpaque(false);

        /* An empty label is added as the first element of the array list; this was done
        to preserve the arrangement of the elements in the window, as BoxLayout was used
        for the panel
        */
        lblPlayerNames.add(new JLabel("<html><center></html></center>"));
        lblPlayerNames.get(0).setBorder(new EmptyBorder(5, 0, 5, 0));
        pDetails.get(0).add(lblPlayerNames.get(0));

        /* Two images (the career and salary icons used in the game) are added to the panel */
        pDetails.get(0).add(setImage("/assets/careerIcon.png"));
        pDetails.get(0).add(setImage("/assets/salaryIcon.png"));

        pCenter.add(pDetails.get(0));

        for (int i = 0; i < playerNames.size(); i++) {
            /* A new panel is created and formatted for each player; i+1 is used for the array list
            indices to account for the images in the first column
            */
            pDetails.add(new JPanel());
            pDetails.get(i + 1).setLayout(new BoxLayout(pDetails.get(i + 1), BoxLayout.Y_AXIS));
            pDetails.get(i + 1).setBorder(new EmptyBorder(5, 5, 5, 5));
            pDetails.get(i + 1).setOpaque(false);

            /* The name of the player is added to the panel */
            lblPlayerNames.add(new JLabel("<html><center>" + playerNames.get(i) + "</html></center>"));
            lblPlayerNames.get(i + 1).setBorder(new EmptyBorder(5, 0, 5, 0));
            pDetails.get(i + 1).add(lblPlayerNames.get(i + 1));

            /* The details of the career card of the player are stored in a text area, formatted, and
            added to the panel
            */
            taCareerContent.add(new JTextArea(careerDetails.get(i)));
            taCareerContent.get(i).setLineWrap(true);
            taCareerContent.get(i).setWrapStyleWord(true);
            taCareerContent.get(i).setEditable(false);
            taCareerContent.get(i).setBorder(new EmptyBorder(5, 5, 5, 5));
            taCareerContent.get(i).setOpaque(false);
            pDetails.get(i + 1).add(taCareerContent.get(i));

            /* The details of the salary card of the player are stored in a text area, formatted, and
            added to the panel
            */
            taSalaryContent.add(new JTextArea(salaryDetails.get(i)));
            taSalaryContent.get(i).setLineWrap(true);
            taSalaryContent.get(i).setWrapStyleWord(true);
            taSalaryContent.get(i).setEditable(false);
            taSalaryContent.get(i).setBorder(new EmptyBorder(5, 5, 5, 5));
            taSalaryContent.get(i).setOpaque(false);
            pDetails.get(i + 1).add(taSalaryContent.get(i));

            pCenter.add(pDetails.get(i + 1));
        }

        /* The compiled card details are stored in a scroll pane, which is in turn formatted and
        added to the window
        */
        scroll = new JScrollPane(pCenter);
        scroll.getViewport().setBackground(new Color(142, 229, 238));
        scroll.setBorder(null);
        pMain.add(scroll, BorderLayout.CENTER);

        /* A confirm button is added to the window */
        btnConfirm = new JButton("OK");
        pMain.add(btnConfirm, BorderLayout.SOUTH);

        add(pMain, BorderLayout.CENTER);
    }

    /**
     * Helper method that adds images to the window
     *
     * @param imgPath relative path of the image to be added
     * @return formatted version of the image
     */
    private JLabel setImage (String imgPath) {
        /* Stores the original image */
        ImageIcon imageOrig;
        /* Stores a scaled version of the image */
        Image imageScaled;
        /* Stores a formatted version of the image to be displayed on the window */
        JLabel lblImage;

        /* The original image is retrieved and scaled */
        imageOrig = new ImageIcon(getClass().getResource(imgPath));
        imageScaled = imageOrig.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);

        /* The scaled image is converted to a JLabel, further formatted, and returned */
        lblImage = new JLabel(new ImageIcon(imageScaled));
        lblImage.setBackground(Color.white);
        lblImage.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        lblImage.setBorder(new EmptyBorder(10, 10, 10, 10));

        return lblImage;
    }

    /**
     * Sets action listeners for the window
     *
     * <p>One action listener is added to the window.</p>
     *
     * @param listener action listener for the window buttons
     */
    public void setActionListener(ActionListener listener) {
        btnConfirm.addActionListener(listener);
    }

    /**
     * Sets window listeners for the window
     *
     * <p>One window listener is added to the window.</p>
     *
     * @param listener window listener for the window
     */
    public void setWindowListener(WindowListener listener) {
        addWindowListener(listener);
    }
}
