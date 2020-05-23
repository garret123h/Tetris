
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import model.Block;
import model.Board;
import model.Point;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * Tetris Graphics object class that is the panel for the game.
 * @author Garret Humphrey
 * @version 1.
 */
public class TetrisCanvas extends JPanel implements Observer {
    /** Maps the Point and a color for drawing the pieces. **/
    private static Map<Point, Color> gridData;
    /** ID for JPanel. **/
    private static final long serialVersionUID = 1L;
    /** Board object for the back-end controls. **/
    private Board myBoard;
    /** Boolean to check if the game is over. **/
    private boolean myGameOver;
    /** Used for checking the p button was pressed. **/
    private boolean myIsPaused;
    /** Variable to keep track of the score. **/
    private int myScore;

    /**
     * Default constructor that creates the game.
     */
    public TetrisCanvas() {
        // Set score to 0
        myScore = 0;
        this.myIsPaused = false;
        myGameOver = true;
        myBoard = new Board();
        // Add the panel as an observer.
        myBoard.addObserver(this);
    }

    /**
     * This method adds the NextPiece Graphics object as an observer of the
     * board.
     * 
     * @param theObject NextPieceCanvas.
     */
    public void addPieceObserver(final NextPieceCanvas theObject) {
        myBoard.addObserver(theObject);
    }

    /**
     * Gets the score for displaying.
     * 
     * @return Returns the score.
     */
    public int getScore() {
        return myScore;
    }

    /**
     * Initializes a new game.
     */
    public void initGame() {
        gridData = null;
        myBoard.newGame();
        // Plays the intro for the game.
        play("./Music/Pacman_Introduction_Music-KP-826387403.wav");
        myGameOver = false;
    }

    /**
     * Clears the game and resets all data.
     */
    public void clearGame() {
        removePieces();
        myBoard = new Board();
        myBoard.addObserver(this);
        myBoard.newGame();
        myGameOver = true;
        myScore = 0;
    }

    /**
     * Plays audio clip for the game.
     * 
     * @param theFileName Audio file to be played.
     */
    public void play(final String theFileName) {
        try {
            final Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(theFileName)));
            clip.start();
        }
        catch (Exception e) {
            System.out.println("File not found");
        }
    }

    /**
     * Check if the tetris game is paused.
     * 
     * @return Returns if it is paused.
     */
    public boolean checkPausedGame() {
        return this.myIsPaused;
    }

    /**
     * Pauses the tetris game.
     */
    public void pauseGame() {
        this.myIsPaused = !this.myIsPaused;
    }

    /**
     * Rotates the piece 90 degrees and also plays sound effect.
     */
    public void rotate() {

        play("./Music/Jump-SoundBible.com-1007297584.wav");
        myBoard.rotateCW();
    }

    /**
     * Moves the piece to the right and also plays sound effect.
     */
    public void right() {
        play("./Music/Mario_Jumping-Mike_Koenig-989896458.wav");
        myBoard.right();
    }

    /**
     * Moves the piece to the left and also plays sound effect.
     */
    public void left() {
        play("./Music/Mario_Jumping-Mike_Koenig-989896458.wav");
        myBoard.left();
    }

    /**
     * Drops the tetris piece to the bottom.
     */
    public void drop() {
        play("./Music/Swoosh 3-SoundBible.com-1573211927.wav");
        myBoard.drop();
    }

    /**
     * Moves the piece one space down.
     */
    public void down() {
        play("./Music/Mario_Jumping-Mike_Koenig-989896458.wav");
        myBoard.down();
    }

    /**
     * Iterate down on the game.
     */
    public void step() {
        myBoard.step();
    }

    /**
     * Checks if the game is over.
     * 
     * @return returns the boolean of gameOver.
     */
    public boolean getGameState() {
        return myGameOver;
    }

    /**
     * Paint method for drawing that will be called first.
     * 
     * @param theGraphics Graphics Object.
     */
    public void paint(final Graphics theGraphics) {
        final int scaleWidth = getWidth() / 10;
        final int scaleHeight = getHeight() / 20;

        super.paint(theGraphics);
        // Set the background for the canvas
        final Color c = new Color(0, 0, 0);
        theGraphics.setColor(c);
        theGraphics.fillRect(0, 0, getWidth(), getHeight());
        // Draw the background grid first.
        drawGrid(theGraphics, scaleWidth, scaleHeight);
    }

    /**
     * Draws the grid onto the panel.
     * 
     * @param theGraphics Graphics Object.
     * @param theScaleWidth Scale Width
     * @param theScaleHeight Scale Height
     */
    private void drawGrid(final Graphics theGraphics, final int theScaleWidth,
                          final int theScaleHeight) {

        // Next we can draw the visual grid
        theGraphics.setColor(Color.GRAY);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                theGraphics.drawRect(j * theScaleWidth, i * theScaleHeight, theScaleWidth,
                                     theScaleHeight);
            }
        }

    }

    /**
     * Removes the pieces on the board by drawing over them.
     */
    private void removePieces() {

        final int scaleWidth = getWidth() / 10;
        final int scaleHeight = getHeight() / 20;
        final Graphics g = getGraphics();

        if (gridData == null || g == null) {
            return;
        }
        // Iterate through the data and draw over the squares.
        for (Point point : gridData.keySet()) {
            final int diff = 19 - point.y();
            final Color c = new Color(0, 0, 0);
            g.setColor(c);
            g.fillRect(point.x() * scaleWidth, diff * scaleHeight, scaleWidth, scaleHeight);
            g.setColor(Color.GRAY);
            g.drawRect(point.x() * scaleWidth, diff * scaleHeight, scaleWidth, scaleHeight);
        }

    }

    /**
     * When the observer gets the new state of the board object then re draw the
     * pieces.
     */
    private void drawUpdatedBoard() {
        final int scaleWidth = getWidth() / 10;
        final int scaleHeight = getHeight() / 20;
        final Graphics g = getGraphics();

        if (gridData == null || g == null) {
            return;
        }
        for (Point point : gridData.keySet()) {
            // Get the color of the point
            final Color c = gridData.get(point);
            final int diff = 19 - point.y();
            g.setColor(c);
            g.fillRect(point.x() * scaleWidth, diff * scaleHeight, scaleWidth, scaleHeight);
            g.setColor(Color.GRAY);
            g.drawRect(point.x() * scaleWidth, diff * scaleHeight, scaleWidth, scaleHeight);
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == null) {
            return;
        }
        // Check what data is being sent through.
        if (o instanceof Board) {
            if (arg instanceof Block[][]) {
                final Block[][] data = (Block[][]) arg;
                removePieces();
                final Map<Point, Color> newGridData = translateData(data);
                gridData = newGridData;
                drawUpdatedBoard();
            } else if (arg instanceof Boolean) {
                myGameOver = true;
              //Indicate that the game is over.
                JOptionPane.showMessageDialog(null, 
                                              "Game Over! You Scored -> " 
                                                                  + getScore(), 
                                              "End Of Game", 
                                              JOptionPane.WARNING_MESSAGE);
                clearGame();
            } else if (arg instanceof Integer[]) {
                final Integer[] rowsCompleted = (Integer[]) arg;
                if (rowsCompleted.length != 0) {
                    myScore++;
                }
            }
        }

    }

    /**
     * Get the board data and iterate through and translate the data to the Map
     * data structure.
     * 
     * @param blockData Data being received by the Observer.
     * @return Returns the translated data.
     */
    private Map<Point, Color> translateData(Block[][] blockData) {
        // Translate data
        final Map<Point, Color> data = new HashMap<>();

        for (int i = 0; i < blockData.length; i++) {
            for (int j = 0; j < blockData[i].length; j++) {
                final Block currentBlock = blockData[i][j];
                // If we found a block we need to check which type.
                if (currentBlock != null) {
                    // We found a piece
                    // Now we need to map the Blocks type to a color and save it
                    switch (currentBlock) {
                        // O, I, T, L, J, S and Z
                        case T:
                            data.put(new Point(j, i), Color.PINK);
                            break;
                        case I:
                            data.put(new Point(j, i), Color.CYAN);
                            break;
                        case L:
                            data.put(new Point(j, i), Color.BLUE);
                            break;
                        case J:
                            data.put(new Point(j, i), Color.ORANGE);
                            break;
                        case S:
                            data.put(new Point(j, i), Color.GREEN);
                            break;
                        case Z:
                            data.put(new Point(j, i), Color.RED);
                            break;
                        case O:
                            data.put(new Point(j, i), Color.YELLOW);
                            break;
                        default:
                    }
                }

            }
        }
        return data;
    }

}
