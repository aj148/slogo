package view;


import java.io.File;

import view.Constants;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 * Draws a line between two points.
 *
 * @author Team 14
 *
 */
public class TurtleDraw {

	
	public Line path;
	public ImageView figure;
	public File image;
	private double imageWidth;
	private double imageHeight;
	

	public TurtleDraw(){
		//Image myLogo = new Image(getClass().getResourceAsStream("/resources/images/LogoTurtle2.png"));
	    Image myLogo = new Image(getClass().getResourceAsStream("/resources/images/RCD.png"));
		figure = new ImageView(myLogo);
		figure.setPreserveRatio(true);
		figure.setFitHeight(50);
		figure.setFitWidth(50);
		figure.setX(Constants.VIEW_DEFAULT_DIMENSION / 2 - (Constants.IMAGE_WIDTH / 2) );
		figure.setY(Constants.VIEW_DEFAULT_DIMENSION / 2 - (Constants.IMAGE_HEIGHT / 2) );
		figure.toFront();

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
     * @param gc
     *            GraphicsContext from Canvas to be drawn to
     * @param x1
     *            Initial X Pixel Coordinate
     * @param y1
     *            Initial Y Pixel Coordinate
     * @param x2
     *            New X Pixel Coordinate
     * @param y2
     *            New Y Pixel Coordinate
     */
	public void drawLine (Point2D cur, Point2D next) {
        path = new Line(cur.getX() + (Constants.VIEW_DEFAULT_DIMENSION / 2),
                                            cur.getY() + (Constants.VIEW_DEFAULT_DIMENSION / 2),
                                            next.getX() + (Constants.VIEW_DEFAULT_DIMENSION / 2),
                                            next.getY() + (Constants.VIEW_DEFAULT_DIMENSION / 2));
        
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
	public void moveTurtle (Point2D next) {
        figure.setX(next.getX() + (Constants.VIEW_DEFAULT_DIMENSION / 2) - (Constants.IMAGE_WIDTH /2));
        figure.setY(next.getY() + (Constants.VIEW_DEFAULT_DIMENSION / 2) - (Constants.IMAGE_HEIGHT/2)); 
        figure.toFront();
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
	public void setAngle (double angle) {
		figure.setRotate((angle));
    }
	
	public void showTurtle(Pane p){
		p.getChildren().add(figure);
	}
	
	public void hideTurtle(Pane p){
		p.getChildren().remove(figure);
	}
}
