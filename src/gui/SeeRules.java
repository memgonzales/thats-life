package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Class implementing a <b>SeeRules window</b> as part of the GUI for
 * displaying the rules of the game
 */
public class SeeRules extends JFrame {
    /**
     * Text area containing the rules of the game
     */
    private JTextArea taRules;
    /**
     * Scroll pane containing the rules stored in the text area
     */
    private JScrollPane scroll;
    /**
     * Confirm button for proceeding with the game
     */
    private JButton btnConfirm;

    /**
     * Creates a SeeRules object
     *
     * <p>As part of the larger interface of the game, this window is not visible persistently;
     * it is hidden when not in use and rendered visible upon appropriate player input.</p>
     */
    public SeeRules () {
        /* The string "That's Life Rules" is passed as the label for the title bar */
        super("That's Life Rules");

        /* init() is called to initialize the elements of the window */
        init();

        /* Additional formatting methods for the window are executed */
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Initializes the elements of the SeeCards object
     *
     * <p>The object displays the rules of the game and contains a confirm button.</p>
     */
    private void init() {
        /* JPanels used to arrange the window elements */
        JPanel pNorth;
        JPanel pMain;

        /* The pNorth panel is formatted */
        pNorth = new JPanel();
        pNorth.setLayout(new BorderLayout());
        pNorth.setBackground(Color.pink);

        /* An image (the provided game logo) is added to the window */
        pNorth.add(setImage());
        add(pNorth, BorderLayout.NORTH);

        /* The pMain panel is formatted */
        pMain = new JPanel();
        pMain.setLayout(new BorderLayout());

        /* A buffered reader and string are declared in order to read the contents of a text
        file and transfer them to a text area
        */
        BufferedReader br;
        String strLine;

        /* A blank text area is created and formatted */
        taRules = new JTextArea("");
        taRules.setEditable(false);
        taRules.setLineWrap(true);
        taRules.setWrapStyleWord(true);
        taRules.setOpaque(false);
        taRules.setBorder(new EmptyBorder(20, 15, 10, 15));

        try {
            /* If no exceptions occur (indicating that the source file was opened successfully
            and file processing can proceed), the contents of the file are read line by line, stored
            in the string, and appended to the text area.
            */
            br = new BufferedReader(new FileReader("./src/assets/rules.txt"));
            while ((strLine = br.readLine()) != null) {
                taRules.append(strLine + "\n");
            }
            /* After the text file is read, the buffered reader object is closed. */
            br.close();
        } catch (Exception e) {
            /* If exceptions occur, the string "Unable to retrieve rules" is appended instead. */
            taRules.append("Unable to retrieve rules.\n");
        }

        /* A scroll pane is created containing the rules, and it is subsequently formatted and
        added to the window
        */
        scroll = new JScrollPane(taRules);
        scroll.setBorder(null);
        scroll.setOpaque(false);
        taRules.setCaretPosition(0);
        pMain.add(scroll);
        add (pMain, BorderLayout.CENTER);

        /* A confirm button is added to the window */
        btnConfirm = new JButton("OK");
        add (btnConfirm, BorderLayout.SOUTH);
    }

    /**
     * Helper method that adds images to the window
     *
     * @return formatted version of the image
     */
    private JLabel setImage () {
        /* Stores the original image */
        ImageIcon imageOrig;
        /* Stores a scaled version of the image */
        Image imageScaled;
        /* Stores a formatted version of the image to be displayed on the window */
        JLabel lblImage;

        /* The original image (the provided game logo) is retrieved and scaled */
        imageOrig = new ImageIcon(getClass().getResource("/assets/logo.png"));
        imageScaled = imageOrig.getImage().getScaledInstance(130, 60, Image.SCALE_DEFAULT);

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
