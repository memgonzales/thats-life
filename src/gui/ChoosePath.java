package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class implementing a <b>ChoosePath window</b> as part of the GUI for
 * choosing a life path
 */
public class ChoosePath extends JFrame {
    /* Text area and button for the first path */
    private JTextArea taOne;
    private JButton btnOne;

    /* Text area and button for the second path */
    private JTextArea taTwo;
    private JButton btnTwo;

    /**
     * Creates a ChoosePath object
     *
     * <p>As part of the larger interface of the game, this window cannot be closed without proper player input;
     * it remains visible until the player presses one of the buttons.</p>
     *
     * @param pathOne name of the first path
     * @param pathTwo name of the second path
     * @param messageOne description of the first path
     * @param messageTwo description of the second path
     * @param imgOnePath relative path of the first image added to the window
     * @param imgTwoPath relative path of the second image added to the window
     */
    public ChoosePath (String pathOne, String pathTwo, String messageOne, String messageTwo, String imgOnePath, String imgTwoPath) {

        /* The string "Choose a Path" is passed as the label for the title bar */
        super("Choose A Path");

        /* Additional formatting methods for the window are executed */
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(139, 0, 139), 8));
        setLayout(new BorderLayout());

        /* init() is called to initialize the elements of the window */
        init(pathOne, pathTwo, messageOne, messageTwo, imgOnePath, imgTwoPath);

        /* Additional formatting methods for the window are executed */
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Initializes the elements of the ChoosePath object
     *
     * <p>The object contains the details and buttons for two life paths.</p>
     *
     * @param pathOne name of the first path
     * @param pathTwo name of the second path
     * @param messageOne description of the first path
     * @param messageTwo description of the second path
     * @param imgOnePath relative path of the first image to be displayed in the window
     * @param imgTwoPath relative path of the second image to be displayed in the window
     */
    private void init(String pathOne, String pathTwo, String messageOne, String messageTwo, String imgOnePath, String imgTwoPath) {
        /* JPanels used to arrange the window elements */
        JPanel pLeft;
        JPanel pRight;
        JPanel pBox;
        JPanel pSouth;

        /* The pBox panel is formatted */
        pBox = new JPanel();
        pBox.setLayout(new BoxLayout(pBox, BoxLayout.X_AXIS));
        pBox.setBackground(new Color(142, 229, 238));

        /* The pLeft panel is formatted */
        pLeft = new JPanel();
        pLeft.setLayout(new BoxLayout(pLeft, BoxLayout.Y_AXIS));
        pLeft.setBorder(new EmptyBorder(10, 5, 5, 5));
        pLeft.setOpaque(false);

        /* The description and image for the first path are formatted and added to the window */
        taOne = new JTextArea(messageOne);
        taOne.setLineWrap(true);
        taOne.setWrapStyleWord(true);
        taOne.setEditable(false);
        taOne.setOpaque(false);
        pLeft.add(taOne);
        pLeft.add(setImage(imgOnePath));
        pBox.add(pLeft);

        /* The pRight panel is formatted */
        pRight = new JPanel();
        pRight.setLayout(new BoxLayout(pRight, BoxLayout.Y_AXIS));
        pRight.setBorder(new EmptyBorder(10, 5, 5, 5));
        pRight.setOpaque(false);

        /* The description and image for the second path are formatted and added to the window */
        taTwo = new JTextArea(messageTwo);
        taTwo.setLineWrap(true);
        taTwo.setWrapStyleWord(true);
        taTwo.setEditable(false);
        taTwo.setOpaque(false);
        pRight.add(taTwo);
        pRight.add(setImage(imgTwoPath));
        pBox.add(pRight);

        add(pBox, BorderLayout.CENTER);

        /* The pSouth panel is formatted */
        pSouth = new JPanel();
        pSouth.setLayout(new GridLayout(1, 2));

        /* The buttons for the first and second paths are added to the window */
        btnOne = new JButton(pathOne);
        pSouth.add(btnOne);

        btnTwo = new JButton(pathTwo);
        pSouth.add(btnTwo);

        add(pSouth, BorderLayout.SOUTH);
    }

    /**
     * Helper method that adds images to the window
     *
     * @param imagePath relative path of the image to be added
     * @return formatted version of the image
     */
     private JLabel setImage (String imagePath) {
         /* Stores the original image */
         ImageIcon imageOrig;
         /* Stores a scaled version of the image */
         Image imageScaled;
         /* Stores a formatted version of the image to be displayed on the window */
         JLabel lblImage;

         /* The original image is retrieved and scaled */
         imageOrig = new ImageIcon(getClass().getResource(imagePath));
         imageScaled = imageOrig.getImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT);

         /* The scaled image is converted to a JLabel, further formatted, and returned */
         lblImage = new JLabel(new ImageIcon(imageScaled));
         lblImage.setBackground(Color.white);
         lblImage.setAlignmentX(JLabel.CENTER_ALIGNMENT);
         lblImage.setBorder(new EmptyBorder(5, 5, 5, 5));
         return lblImage;
    }

    /**
     * Sets action listeners for the window
     *
     * <p>Two action listeners are added for the buttons in the window.</p>
     *
     * @param listener action listener for the window buttons
     */
    public void setActionListener(ActionListener listener) {
        btnOne.addActionListener(listener);
        btnTwo.addActionListener(listener);
    }
}
