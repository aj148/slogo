package view;

import java.util.Observable;
import java.util.Observer;

import model.Turtle;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


/**
 * Responsible for drawing the graphical representation of the turtles movement as its state changes
 * using Observable. Calls on the Draw class to update the graphical representation stored in View
 * when the status of a turtle changes.
 *
 * @author Team 14
 *
 */
public class ViewPane extends Pane {
    public static final int DEFAULT_DIMENSION = 500;
    private Canvas myCanvas = new Canvas(DEFAULT_DIMENSION, DEFAULT_DIMENSION);
    private Draw myDraw = new Draw();
    private Point2D myCurrentPoint = new Point2D(0, 0);

    /**
     * Constructor method called from UserInterface.java
     */
    public ViewPane () {
        GraphicsContext gc = myCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        myDraw.drawBackground(myCanvas, Color.LIGHTBLUE);
        // Image image = new Image(getClass().getResourceAsStream("LogoTurtle2.png"));
    }

    public void updateView (Turtle t) {
        myDraw.drawLine(myCanvas, myCurrentPoint, t.getLocation());
        myCurrentPoint = t.getLocation();
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setCenter(myCanvas);
        return p;
    }

	public void showError(String displayMessage) {
		System.out.println(displayMessage);
	}
}
