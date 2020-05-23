
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import model.Board;
import model.TetrisPiece;

import javax.swing.JPanel;

/**
 * Next piece Graphics object that will be displayed in the right corner.
 * 
 * @author Garret Humphrey
 * @version 1.
 */
public final class NextPieceCanvas extends JPanel implements Observer {
    /** Serial Version UID. **/
    private static final long serialVersionUID = 1L;
    /** the Next piece from the Board object. **/
    private TetrisPiece myNextPiece;

    /**
     * Default Constructor.
     */
    public NextPieceCanvas() {
        this.myNextPiece = null;
    }

    /**
     * Paint method that will be created first. This method will draw the grid
     * for the next piece and set the background.
     * @param theGraphics Graphics Object
     */
    public void paint(final Graphics theGraphics) {
        final int scaleWidth = getWidth() / 10;
        final int scaleHeight = getHeight() / 10;

        // Set the background color for the canvas
        final Color c = new Color(51, 0, 0);
        theGraphics.setColor(c);
        theGraphics.fillRect(0, 0, getWidth(), getHeight());

        // Draw the grid for the next piece.
        drawGrid(theGraphics, scaleWidth, scaleHeight);

    }

    /**
     * Removes the old piece and draws over the piece and creates the grid
     * again.
     */
    private void removePiece() {
        final int scaleWidth = getWidth() / 10;
        final int scaleHeight = getHeight() / 10;
        final Graphics g = getGraphics();
        final Color c = new Color(51, 0, 0);
        g.setColor(c);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw the grid for the next piece.
        drawGrid(g, scaleWidth, scaleHeight);

    }

    /**
     * Draws the grid onto the Graphics Object.
     * 
     * @param theG Graphics object.
     * @param theScaleWidth Scale width
     * @param theScaleHeight Scale Height.
     */
    public void drawGrid(final Graphics theG, final int theScaleWidth,
                         final int theScaleHeight) {

        // Next we can draw the visual grid
        theG.setColor(Color.GRAY);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                theG.drawRect(j * theScaleWidth, i * theScaleHeight, theScaleWidth,
                              theScaleHeight);
            }
        }

    }

    /**
     * Draws the next block onto the Graphics object.
     */
    public void drawNextBlock() {
        final int scaleWidth = getWidth() / 10;
        final int scaleHeight = getHeight() / 10;
        // Adjusting where the piece will be.
        final int widthPlacement = scaleWidth * 2 + scaleWidth;
        final int heightPlacement = scaleHeight * 2 + scaleHeight;
        final Graphics g = getGraphics();
        switch (myNextPiece) {
            case I:
                g.setColor(Color.CYAN);
                g.fillRect(1 * scaleWidth + widthPlacement, 1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(2 * scaleWidth + widthPlacement, 1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(3 * scaleWidth + widthPlacement, 
                           1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(4 * scaleWidth + widthPlacement, 
                           1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                break;
            case O:
                g.setColor(Color.YELLOW);
                g.fillRect(1 * scaleWidth + widthPlacement, 1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(2 * scaleWidth + widthPlacement, 1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(1 * scaleWidth + widthPlacement, 2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(2 * scaleWidth + widthPlacement, 2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                break;
            case J:
                g.setColor(Color.ORANGE);
                g.fillRect(1 * scaleWidth + widthPlacement, 2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(2 * scaleWidth + widthPlacement, 2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(3 * scaleWidth + widthPlacement, 
                           2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(3 * scaleWidth + widthPlacement, 
                           1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                break;
            case L:
                g.setColor(Color.BLUE);
                g.fillRect(1 * scaleWidth + widthPlacement, 1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(1 * scaleWidth + widthPlacement, 2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(1 * scaleWidth + widthPlacement,
                           3 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(2 * scaleWidth + widthPlacement, 
                           3 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                break;
            case S:
                g.setColor(Color.GREEN);
                g.fillRect(3 * scaleWidth + widthPlacement,
                           1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(2 * scaleWidth + widthPlacement, 1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(2 * scaleWidth + widthPlacement, 2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(1 * scaleWidth + widthPlacement, 2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                break;
            case T:
                g.setColor(Color.PINK);
                g.fillRect(1 * scaleWidth + widthPlacement, 2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(2 * scaleWidth + widthPlacement, 2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(2 * scaleWidth + widthPlacement, 1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(3 * scaleWidth + widthPlacement, 
                           2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                break;
            case Z:
                g.setColor(Color.RED);
                g.fillRect(1 * scaleWidth + widthPlacement, 1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(2 * scaleWidth + widthPlacement, 1 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(2 * scaleWidth + widthPlacement, 2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                g.fillRect(3 * scaleWidth + widthPlacement,
                           2 * scaleHeight + heightPlacement,
                           scaleWidth, scaleHeight);
                break;
            default:
        }
        // Draw the grid outline for the piece.
        g.setColor(Color.GRAY);
        for (int i = 0; i < scaleHeight; i++) {
            for (int j = 0; j < scaleWidth; j++) {
                g.drawRect(j * scaleWidth, i * scaleHeight, scaleWidth, scaleHeight);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == null) {
            return;
        }
        if (o instanceof Board) {
            if (arg instanceof TetrisPiece) {
                this.myNextPiece = (TetrisPiece) arg;
                removePiece();
                drawNextBlock();
            }
        }

    }

}
