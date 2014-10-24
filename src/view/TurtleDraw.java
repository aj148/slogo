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
public class Draw {

	
	public Line path;
	public ImageView figure;
	public File image;
	private double imageWidth;
	private double imageHeight;
	

	public Draw(){
		Image myLogo = new Image(getClass().getResourceAsStream("/LogoTurtle2.png"));
		figure = new ImageView(myLogo);
		imageWidth = myLogo.getWidth();
		imageHeight = myLogo.getHeight();		
		figure.setX(Constants.DEFAULT_DIMENSION / 2 - (imageWidth / 2) );
		figure.setY(Constants.DEFAULT_DIMENSION / 2 - (imageHeight / 2) );
		

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
        path = new Line(cur.getX() + (Constants.DEFAULT_DIMENSION / 2),
                                            cur.getY() + (Constants.DEFAULT_DIMENSION / 2),
                                            next.getX() + (Constants.DEFAULT_DIMENSION / 2),
                                            next.getY() + (Constants.DEFAULT_DIMENSION / 2));
        
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
        figure.setX(next.getX() + (Constants.DEFAULT_DIMENSION / 2) - (imageWidth/2));
        figure.setY(next.getY() + (Constants.DEFAULT_DIMENSION / 2) - (imageHeight/2));                                     
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
