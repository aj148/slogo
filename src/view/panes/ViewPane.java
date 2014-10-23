package view.panes;

import java.util.Observable;
import java.util.Observer;

import view.Draw;
import model.Turtle;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 * Responsible for drawing the graphical representation of the turtles movement as its state changes
 * using Observable. Calls on the Draw class to update the graphical representation stored in View
 * when the status of a turtle changes.
 *
 * @author Team 14
 *
 */
public class ViewPane extends PaneModule {
    public static final int DEFAULT_DIMENSION = 500;
    private Pane myPane = new Pane();
    private Draw myDraw = new Draw();
    private Point2D myCurrentPoint = new Point2D(0, 0);

    /**
     * Constructor method called from UserInterface.java
     */
    public ViewPane () {
    	myPane.setStyle("-fx-background-color: white;");
    	myPane.setPrefSize(DEFAULT_DIMENSION,DEFAULT_DIMENSION);
//    	GraphicsContext gc = myCanvas.getGraphicsContext2D();
//        gc.setStroke(Color.BLACK);
//        myDraw.drawBackground(myCanvas, Color.LIGHTBLUE);
        // Image image = new Image(getClass().getResourceAsStream("LogoTurtle2.png"));
    }

    public void updateView (Turtle t) {
//        myDraw.drawLine(myPane, myCurrentPoint, t.getLocation());
//        myCurrentPoint = t.getLocation();
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setCenter(myPane);
        return p;
    }

	public void showError(String displayMessage) {
		System.out.println(displayMessage);
	}
}
