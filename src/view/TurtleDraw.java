package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import model.Turtle;
import view.Constants;
import view.controllers.ImagePalette;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Draws a line between two points.
 *
 * @author Team 14
 *
 */
public class TurtleDraw {

    public Line path;
    public File image;;
    private ImagePalette myImagePalette;
    public Color lineColor;

    public TurtleDraw (ImagePalette ip) {
        myImagePalette = ip;
    }

    public ImageView drawTurtle (Turtle t) {
        ImageView figure;
        int logoID = (int) t.getShape();
        Image myLogo = null;
        if (logoID < 4) {
            myLogo = new Image(getClass().getResourceAsStream(myImagePalette.getImage(logoID)));
        }
        else {
            try {
                myLogo = new Image(new FileInputStream(myImagePalette.getImage(logoID)));
            }
            catch (FileNotFoundException e) {
            }
        }
        figure = new ImageView(myLogo);
        figure.setPreserveRatio(true);
        figure.setFitHeight(50);
        figure.setFitWidth(50);
        figure.setX(Constants.VIEW_DEFAULT_DIMENSION / 2 - (Constants.IMAGE_WIDTH / 2));
        figure.setY(Constants.VIEW_DEFAULT_DIMENSION / 2 - (Constants.IMAGE_HEIGHT / 2));
        figure.toFront();
        return figure;
    }

    /**
     * Draws a line between two points onto the GraphicsContext from a canvas.
     * @param color 
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
        
     
    	path = new Line(cur.getX() + (Constants.VIEW_DEFAULT_DIMENSION / 2), cur.getY()
                + (Constants.VIEW_DEFAULT_DIMENSION / 2), next.getX()
                + (Constants.VIEW_DEFAULT_DIMENSION / 2), next.getY()
                + (Constants.VIEW_DEFAULT_DIMENSION / 2));

    }

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
    public void moveTurtle (ImageView figure, Point2D next) {
        figure.setX(next.getX() + (Constants.VIEW_DEFAULT_DIMENSION / 2)
                - (Constants.IMAGE_WIDTH / 2));
        figure.setY(next.getY() + (Constants.VIEW_DEFAULT_DIMENSION / 2)
                - (Constants.IMAGE_HEIGHT / 2));
        figure.toFront();
    }

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
    public void setAngle (ImageView figure, double angle) {
        figure.setRotate((angle));
    }

    public void showTurtle (Pane p, ImageView figure) {
        p.getChildren().add(figure);
    }

    public void hideTurtle (Pane p, ImageView figure) {
        p.getChildren().remove(figure);
    }
}
