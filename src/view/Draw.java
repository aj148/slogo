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
        c.getGraphicsContext2D().drawImage(image, x1 + (c.getWidth() / 2) - 21,
                                           y1 + (c.getWidth() / 2) - 21);
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
        c.getGraphicsContext2D().strokeLine(x1 + (c.getWidth() / 2), y1 + (c.getWidth() / 2),
                                            x2 + (c.getWidth() / 2), y2 + (c.getWidth() / 2));
    }
}
