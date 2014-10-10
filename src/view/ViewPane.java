package view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
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
public class ViewPane extends Pane implements Observer {
    public static final int DEFAULT_DIMENSION = 500;
    private Canvas myCanvas = new Canvas(DEFAULT_DIMENSION, DEFAULT_DIMENSION);
    private Draw myDraw = new Draw();

    /**
     * Constructor method called from UserInterface.java
     */
    public ViewPane () {
        GraphicsContext gc = myCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        myDraw.drawBackground(myCanvas, Color.LIGHTBLUE);
        Image image = new Image(getClass().getResourceAsStream("LogoTurtle2.png"));
        myDraw.drawTurtle(myCanvas, image, 0, 0);
        myDraw.drawLine(myCanvas, 0, 0, 0, -50);
    }

    public void updateView () {

    }

    @Override
    public void update (Observable arg0, Object arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setCenter(myCanvas);
        return p;
    }
}
