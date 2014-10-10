package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


/**
 * Draws a line between two points.
 *
 * @author Team 14
 *
 */
public class Draw {

    public void drawTurtle (GraphicsContext gc, Image image, double x1, double y1) {
        gc.drawImage(image, x1, y1);
    }

    /**
     * Draws a line between two points onto the GraphicsContext from a canvas.
     *
     * @param gc GraphicsContext from Canvas to be drawn to
     * @param x1 Initial X Pixel Coordinate
     * @param y1 Initial Y Pixel Coordinate
     * @param x2 New X Pixel Coordinate
     * @param y2 New Y Pixel Coordinate
     */
    public void drawLine (GraphicsContext gc, int x1, int y1, int x2, int y2) {
    }
}
