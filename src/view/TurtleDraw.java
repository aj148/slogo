package view;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.Turtle;
import view.controllers.ImagePalette;

/**
 * Handles the drawing of the simulation. Draws and moves turtles accordingly.
 * Draws lines accorrdingly.
 *
 * @author Team 14
 *
 */
public class TurtleDraw {

    public Line myPath;
    public File myImage;
    private ImagePalette myImagePalette;
    public Color myLineColor;

    /**
     * Constructor for TurtleDraw
     * 
     * @param ip
     *            ImagePalette containing the turtle images
     */
    public TurtleDraw (ImagePalette ip) {
        myImagePalette = ip;
    }

    /**
     * Draws a new turtle
     * 
     * @param t
     *            Turtle to be drawn to the front end
     * @param b
     *            True is turtle is to be highlighted as active
     * @return ImageView representing drawn turtle
     */
    public ImageView drawTurtle (Turtle t, boolean b) {
        ImageView figure;
        int logoID = (int)t.getShape();
        Image myLogo = null;
        if (logoID < 4) {
            myLogo = new Image(getClass().getResourceAsStream(myImagePalette.getImage(logoID)));
        } else {
            try {
                myLogo = new Image(new FileInputStream(myImagePalette.getImage(logoID)));
            } catch (FileNotFoundException e) {
                System.out.println("Image Not in Palette");
            }
        }

        figure = new ImageView(myLogo);
        figure.setPreserveRatio(true);
        figure.setFitHeight(50);
        figure.setFitWidth(50);
        figure.setX(Constants.VIEW_DEFAULT_DIMENSION / 2 - (Constants.IMAGE_WIDTH / 2));
        figure.setY(Constants.VIEW_DEFAULT_DIMENSION / 2 - (Constants.IMAGE_HEIGHT / 2));
        figure.toFront();
        if (b) {
            figure.setEffect(new SepiaTone());
        }
        return figure;
    }

    /**
     * Draws a line between two points
     * 
     * @param cur
     *            Point2D representing Current Point
     * @param next
     *            Point2D representing Next Point
     */
    public void drawLine (Point2D cur, Point2D next) {

        myPath = new Line(cur.getX() + (Constants.VIEW_DEFAULT_DIMENSION / 2), cur.getY()
                + (Constants.VIEW_DEFAULT_DIMENSION / 2), next.getX()
                + (Constants.VIEW_DEFAULT_DIMENSION / 2), next.getY()
                + (Constants.VIEW_DEFAULT_DIMENSION / 2));

    }

    /**
     * Moves the ImageView representing a given turtle
     * 
     * @param figure
     *            ImageView representing a given turtle
     * @param next
     *            Point2D representing Next Point
     */
    public void moveTurtle (ImageView figure, Point2D next) {
        figure.setX(next.getX() + (Constants.VIEW_DEFAULT_DIMENSION / 2)
                - (Constants.IMAGE_WIDTH / 2));
        figure.setY(next.getY() + (Constants.VIEW_DEFAULT_DIMENSION / 2)
                - (Constants.IMAGE_HEIGHT / 2));
        figure.toFront();
    }

    /**
     * Rotates the ImageView to a given angle
     * 
     * @param figure
     *            ImageView to be rotated
     * @param angle
     *            Double representing angle to be rotated to
     */
    public void setAngle (ImageView figure, double angle) {
        figure.setRotate(angle);
    }

    /**
     * Shows a given turtle
     * 
     * @param p
     *            Pane showing simulation
     * @param figure
     *            ImageView representing a given turtle
     */
    public void showTurtle (Pane p, ImageView figure) {
        p.getChildren().add(figure);
    }

    /**
     * Hides a given turtle
     * 
     * @param p
     *            Pane showing simulation
     * @param figure
     *            ImageView representing a given turtle
     */
    public void hideTurtle (Pane p, ImageView figure) {
        p.getChildren().remove(figure);
    }
}
