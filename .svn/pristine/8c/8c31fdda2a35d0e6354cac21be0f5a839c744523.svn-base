
package view;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Pop up window that will display the basic controls of the game.
 * @author Garret Humphrey
 * @version 1
 *
 */
public class HelpPopUpWindow extends JFrame {
    /**Default Width of screen.**/
    private static final int DEFAULT_WIDTH = 400;
    /**Default Height of the screen.**/
    private static final int DEFAULT_HEIGHT = 400;
    /**Text for the down controls.**/
    private JLabel myDown;
    /**Text for the right controls.**/
    private JLabel myRight;
    /**Text for the left controls.**/
    private JLabel myLeft;
    /**Text for the drop controls.**/
    private JLabel myDrop;
    /**Text for the rotate controls.**/
    private JLabel myRotate;
    /**Text for the pause controls.**/
    private JLabel myPause;
    /**
     * Default Constructor for the window.
     */
    public HelpPopUpWindow() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setVisible(true);
        setLayout(new GridLayout(6, 1));

        myRotate = new JLabel("Rotate Piece -> 'w'/'W' ");
        myDown = new JLabel("Move Down -> Down arrow/'s'/'S'");
        myLeft = new JLabel("Move Left -> Left arrow/'a'/'A' ");
        myRight = new JLabel("Move Right -> Right Arrow/'d'/'D' ");
        myDrop = new JLabel("Drop Piece -> Space");
        myPause = new JLabel("Pause Game -> 'p'/'P' ");

        add(myDown);
        add(myLeft);
        add(myRight);
        add(myRotate);
        add(myDrop);
        add(myPause);

    }

}
