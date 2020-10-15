package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

/**
 * Class implementing a <b>SeeCards window</b> as part of the GUI for
 * displaying all the cards kept by a player
 */
public class SeeCards extends JFrame {
    /**
     * Text area containing the details of a player's kept career card
     */
    private JTextArea taCareerContent;
    /**
     * Text area containing the details of a player's kept salary card
     */
    private JTextArea taSalaryContent;
    /**
     * Text area containing the details of a player's kept house card
     */
    private JTextArea taHouseContent;

    /**
     * Scroll pane storing the card details
     */
    private JScrollPane scroll;
    /**
     * Confirm button for proceeding with the game
     */
    private JButton btnConfirm;

    /**
     * Creates a SeeCards object
     *
     * <p>As part of the larger interface of the game, this window is not visible persistently;
     * it is hidden when not in use and rendered visible upon appropriate player input.</p>
     *
     * @param playerName name of the player whose cards are displayed
     * @param careerDetails details of the drawn career card of the player
     * @param salaryDetails details of the drawn salary card of the player
     * @param houseDetails details of the drawn house card of the player
     */
    public SeeCards (String playerName, String careerDetails, String salaryDetails, String houseDetails) {

        /* The string "[Player]'s Cards" is passed as the label for the title bar */
        super(playerName + "'s Cards");

        /* init() is called to initialize the elements of the window */
        init(careerDetails, salaryDetails, houseDetails);

        /* Additional formatting methods for the window are executed */
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Initializes the elements of the SeeCards object
     *
     * <p>The object contains the drawn career, salary, and house card of a player.</p>
     *
     * @param careerDetails details of the drawn career card of the player
     * @param salaryDetails details of the drawn salary card of the player
     * @param houseDetails details of the drawn house card of the player
     */
    private void init(String careerDetails, String salaryDetails, String houseDetails) {
        /* JPanels used to arrange the window elements */
        JPanel pMain;
        JPanel pCareer;
        JPanel pSalary;
        JPanel pHouse;

        /* The pMain panel is formatted */
        pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));
        pMain.setBackground(new Color(142, 229, 238));

        /* The pCareer panel is formatted */
        pCareer = new JPanel();
        pCareer.setLayout(new BoxLayout(pCareer, BoxLayout.X_AXIS));

        /* The details of the player's career card are stored in a text area and formatted */
        taCareerContent = new JTextArea(careerDetails);
        taCareerContent.setLineWrap(true);
        taCareerContent.setWrapStyleWord(true);
        taCareerContent.setEditable(false);
        taCareerContent.setBorder(new EmptyBorder(5, 5, 5, 5));
        taCareerContent.setOpaque(false);

        /* A career icon and the career card details are added to the panel */
        pCareer.add(setImage("/assets/careerIcon.png"));
        pCareer.add(taCareerContent);
        pCareer.setOpaque(false);

        pMain.add(pCareer);

        /* The pSalary panel is formatted */
        pSalary = new JPanel();
        pSalary.setLayout(new BoxLayout(pSalary, BoxLayout.X_AXIS));

        /* The details of the player's salary card are stored in a text area and formatted */
        taSalaryContent = new JTextArea(salaryDetails);
        taSalaryContent.setLineWrap(true);
        taSalaryContent.setWrapStyleWord(true);
        taSalaryContent.setEditable(false);
        taSalaryContent.setBorder(new EmptyBorder(5, 5, 5, 5));
        taSalaryContent.setOpaque(false);

        /* A salary icon and the salary card details are added to the panel */
        pSalary.add(setImage("/assets/salaryIcon.png"));
        pSalary.add(taSalaryContent);
        pSalary.setOpaque(false);

        pMain.add(pSalary);

        /* The pHouse panel is formatted */
        pHouse = new JPanel();
        pHouse.setLayout(new BoxLayout(pHouse, BoxLayout.X_AXIS));

        /* The details of the player's house card are stored in a text area and formatted */
        taHouseContent = new JTextArea(houseDetails);
        taHouseContent.setLineWrap(true);
        taHouseContent.setWrapStyleWord(true);
        taHouseContent.setEditable(false);
        taHouseContent.setBorder(new EmptyBorder(5, 5, 5, 5));
        taHouseContent.setOpaque(false);

        /* A house icon and the house card details are added to the panel */
        pHouse.add(setImage("/assets/houseIcon.png"));
        pHouse.add(taHouseContent);
        pHouse.setOpaque(false);

        pMain.add(pHouse);

        /* The compiled details are stored in a scroll pane, which is in turn formatted and added
        to the window
        */
        scroll = new JScrollPane(pMain);
        scroll.setOpaque(false);
        add (scroll, BorderLayout.CENTER);

        /* A confirmation button is added to the window */
        btnConfirm = new JButton("OK");
        add (btnConfirm, BorderLayout.SOUTH);
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
        imageScaled = imageOrig.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);

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
