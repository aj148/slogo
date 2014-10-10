package view;

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
    private Canvas myCanvas = new Canvas(400, 400);
    private Draw myDraw = new Draw();

    /**
     * Constructor method called from UserInterface.java
     */
    public ViewPane () {
        GraphicsContext gc = myCanvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTBLUE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(0, 0, 400, 400);

        Image image = new Image(getClass().getResourceAsStream("LogoTurtle2.png"));
        myDraw.drawTurtle(myCanvas.getGraphicsContext2D(), image, 180, 90);
        myDraw.drawLine(gc, 200, 200, 200, 120);
        // myDraw.drawLine(gc, 0, -50, 50, -50);
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
