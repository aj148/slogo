package view;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


/**
 * Draws a line between two points.
 *
 * @author Team 14
 *
 */
public class Draw {
	
	public Line figure;

	public Draw(){
		
	}
    
//    public void drawBackground (Canvas c, Color clr) {
//        c.getGraphicsContext2D().setFill(clr);
//        c.getGraphicsContext2D().fillRect(0, 0, c.getWidth(), c.getHeight());
//    }
//
//    public void drawTurtle (Canvas c, Image image, double x1, double y1) {
//        c.getGraphicsContext2D().drawImage(image, x1 + (c.getWidth() / 2) - 21,
//                                           y1 + (c.getWidth() / 2) - 21);
//    }

    /**
     * Draws a line between two points onto the GraphicsContext from a canvas.
     *
     * @param gc GraphicsContext from Canvas to be drawn to
     * @param x1 Initial X Pixel Coordinate
     * @param y1 Initial Y Pixel Coordinate
     * @param x2 New X Pixel Coordinate
     * @param y2 New Y Pixel Coordinate
     */
	public void drawLine (Pane c, Point2D cur, Point2D next) {
        figure = new Line(cur.getX() + (c.getWidth() / 2),
                                            cur.getY() + (c.getWidth() / 2),
                                            next.getX() + (c.getWidth() / 2),
                                            next.getY() + (c.getWidth() / 2));
        
    }
}
