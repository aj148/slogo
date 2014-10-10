package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


/**
 * Draws a line between two points.
 *
 * @author Team 14
 *
 */
public class Draw {

    public void drawBackground (Canvas c, Color clr) {
        c.getGraphicsContext2D().setFill(clr);
        c.getGraphicsContext2D().fillRect(0, 0, c.getWidth(), c.getHeight());
    }

    public void drawTurtle (Canvas c, Image image, double x1, double y1) {
        // gc.drawImage(image, x1, y1);
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
    public void drawLine (Canvas c, double x1, double y1, double x2, double y2) {
        // gc.strokeLine(x1, y1, x2, y2);
    }
}
