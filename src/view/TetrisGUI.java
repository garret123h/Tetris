
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


/**
 * This is the GUI class that creates the initial JFrame.
 * 
 * @author Garret Humphrey
 * @version 1
 */
public class TetrisGUI extends JFrame {
    /** Delay for the timer. **/
    private static final int DELAY = 250;
    /** Object for formatting layout. **/
    private GridBagConstraints myGBC = new GridBagConstraints();
    /** Tetris Graphics Object. **/
    private TetrisCanvas myTetris;
    /** Next Piece Graphics Object. **/
    private NextPieceCanvas myPiece;

    /** JPanel for the buttons on the right. **/
    private JPanel myButtons;
    /** Start button to start the game. **/
    private JButton myStart;
    /** End button to end game. **/
    private JButton myEnd;
    /** Help button to see the game controls. **/
    private JButton myHelp;
    /** Step button to execute next frame. **/
    private JButton myStep;
    /** Auto step button to start regular tetris game. **/
    private JButton myAutoStep;
    /** A JLabel to display the score(Number of rows eliminated). **/
    private JLabel myScore;

    /**
     * Default Constructor for the GUI.
     */
    public TetrisGUI() {
        // Set up the JFrame first.
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Create the Tetris game and give it a size.
        myTetris = new TetrisCanvas();
        myTetris.setPreferredSize(new Dimension(12 * 26 + 10, 26 * 23 + 25));

        // Create the JLabel for displaying the score.
        myScore = new JLabel("Score -> " + myTetris.getScore());

        // Create the next piece Graphics Object with a size(Height will be half
        // the size of the game. )
        myPiece = new NextPieceCanvas();
        myPiece.setPreferredSize(new Dimension(12 * 26 + 10, (26 * 23 + 25) / 2));
        // Make the next piece an observer for the Board.
        myTetris.addPieceObserver(myPiece);

        // Create the panel for the buttons and give it a size..
        myButtons = new JPanel();
        myButtons.setFocusable(false);
        myButtons.setPreferredSize(new Dimension(12 * 26 + 10, (26 * 23 + 25) / 2));

        // Start button for starting the game with just the controls.
        myStart = new JButton("Start");
        myStart.addActionListener(new StartListener());

        // Stops the game and ends it eliminating all current game.
        myEnd = new JButton("End");
        myEnd.addActionListener(new EndListener());

        // Help panel that gives the user the control information
        myHelp = new JButton("Help!");
        myHelp.addActionListener(new HelpListener());
        // Step button.
        myStep = new JButton("Step");
        myStep.addActionListener(new StepListener());
        // Auto step button.
        myAutoStep = new JButton("Auto-Step");
        myAutoStep.addActionListener(new AutoStepListener());
        // This sets up the panel with all of the buttons added.
        myButtons.add(myStart);
        myButtons.add(myEnd);
        myButtons.add(myHelp);
        myButtons.add(myStep);
        myButtons.add(myAutoStep);
        myButtons.add(myScore);

        // Placement for the tetris game
        myGBC.gridx = 0;
        myGBC.gridy = 0;
        myGBC.gridheight = 2;
        myGBC.fill = GridBagConstraints.VERTICAL;
        add(myTetris, myGBC);

        // Placement for the next piece
        myGBC.gridx = 1;
        myGBC.gridy = 0;
        myGBC.gridheight = 1;
        myGBC.fill = GridBagConstraints.VERTICAL;
        add(myPiece, myGBC);

        // Placement for the buttons panel
        myGBC.gridx = 1;
        myGBC.gridy = 1;
        add(myButtons, myGBC);

        // Bind keys for all buttons so when the user hits the a button the
        // focus will change and we still control the game with keys.
        bindKeys(myAutoStep);
        bindKeys(myStart);
        bindKeys(myStep);
        bindKeys(myHelp);
        pack();

    }

    /**
     * This method binds all the keys for the games. It maps a input to a
     * action. It takes a JComponent, so component can be JPanel, JButton,...
     * 
     * @param theComponent JComponent that will have the key binding.
     */
    private void bindKeys(final JComponent theComponent) {
        final Action drop = new AbstractAction() {
            public void actionPerformed(final ActionEvent theEvent) {
                if (!myTetris.checkPausedGame()) {
                    myTetris.drop();
                }
            }
        };
        final Action pause = new AbstractAction() {
            public void actionPerformed(final ActionEvent theEvent) {
                myTetris.pauseGame();
            }
        };
        final Action rotate = new AbstractAction() {
            public void actionPerformed(final ActionEvent theEvent) {
                if (!myTetris.checkPausedGame()) {
                    myTetris.play("./Music/Jump-SoundBible.com-1007297584.wav");
                    myTetris.rotate();
                }
            }
        };
        final Action right = new AbstractAction() {
            public void actionPerformed(final ActionEvent theEvent) {
                if (!myTetris.checkPausedGame()) {
                    myTetris.right();
                }
            }
        };
        final Action left = new AbstractAction() {
            public void actionPerformed(final ActionEvent theEvent) {
                if (!myTetris.checkPausedGame()) {
                    myTetris.left();
                }
            }
        };
        final Action down = new AbstractAction() {
            public void actionPerformed(final ActionEvent theEvent) {
                if (!myTetris.checkPausedGame()) {
                    myTetris.down();
                }
            }
        };

        theComponent.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "drop");
        theComponent.getActionMap().put("drop", drop);
        theComponent.getInputMap().put(KeyStroke.getKeyStroke("P"), "pause");
        theComponent.getActionMap().put("pause", pause);
        theComponent.getInputMap().put(KeyStroke.getKeyStroke("W"), "rotate");
        theComponent.getActionMap().put("rotate", rotate);
        theComponent.getInputMap().put(KeyStroke.getKeyStroke("D"), "right");
        theComponent.getActionMap().put("right", right);
        theComponent.getInputMap().put(KeyStroke.getKeyStroke("A"), "left");
        theComponent.getActionMap().put("left", left);
        theComponent.getInputMap().put(KeyStroke.getKeyStroke("S"), "down");
        theComponent.getActionMap().put("down", down);

        theComponent.getInputMap().put(KeyStroke.getKeyStroke("UP"), "rotate piece");
        theComponent.getActionMap().put("rotate piece", rotate);
        theComponent.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right piece");
        theComponent.getActionMap().put("right piece", right);
        theComponent.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left piece");
        theComponent.getActionMap().put("left piece", left);
        theComponent.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down piece");
        theComponent.getActionMap().put("down piece", down);

    }

    /**
     * Inner class for the auto step button. It will check the games state and
     * start a thread that recreates tetris.
     */
    private class AutoStepListener implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            // Make sure the next piece is an observer.
            myTetris.addPieceObserver(myPiece);
            // Check if there is no game being played and start one if there is
            // none.
            if (myTetris.getGameState()) {
                myTetris.initGame();
            }
            final Runnable r = () -> {
                // Run thread while the gameOver boolean variable is false.
                while (!myTetris.getGameState()) {
                    // Make sure the user can not press autoStep(This created a
                    // lot of issues so I disabled it).
                    myAutoStep.setEnabled(false);
                    if (!myTetris.checkPausedGame()) {
                        // Each iteration in the thread make the current piece
                        // go down.
                        myTetris.step();
                        // Update the score
                        myScore.setText("Score -> " + myTetris.getScore());
                        try {
                            // Cause delay for the game.
                            Thread.sleep(DELAY);
                        }
                        catch (final InterruptedException ex) {
                            System.out.println("Thread interupted");
                        }
                    }
                    // Enable the auto-step when the game finishes.
                    myAutoStep.setEnabled(true);

                }
                // Indicate that the game is over.
                JOptionPane.showMessageDialog(null,
                                              "Game Over! You Scored -> "
                                                    + myTetris.getScore(),
                                              "End Of Game", JOptionPane.WARNING_MESSAGE);
                // Clear the game.
                myTetris.clearGame();

            };
            final Thread thread = new Thread(r);
            thread.start();

        }

    }

    /**
     * Inner class that creates the help pop up window for the user.
     */
    private class HelpListener implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            new HelpPopUpWindow().setVisible(true);
        }

    }

    /**
     * Inner class for ending the game.
     */
    private class EndListener implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            myTetris.clearGame();
        }

    }

    /**
     * Step button listener that justs makes the piece go down.
     */
    private class StepListener implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            myTetris.step();
        }

    }

    /**
     * Start and initialize the game.
     */
    private class StartListener implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            // Check if there is no game being played.
            if (myTetris.getGameState()) {
                myTetris.addPieceObserver(myPiece);
                myTetris.play("./Music/Pacman_Introduction_Music-KP-826387403.wav");
                myTetris.initGame();
            }

        }

    }

}
