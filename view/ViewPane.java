package view;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.canvas.Canvas;
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
    private Canvas myCanvas = new Canvas(100, 100);
    private Draw myDraw = new Draw();

    /**
     * Constructor method called from UserInterface.java
     */
    public ViewPane () {
        Image image = new Image(getClass().getResourceAsStream("LogoTurtle2.png"));
        myDraw.drawTurtle(myCanvas.getGraphicsContext2D(), image, 0, 0);
    }

    /**
     * Called upon when the state of a turtle changes using Observable. Utilizes the Draw class to
     * draw an new line
     * and then to update the graphical representation stored in the canvas to reflect the turtles
     * updated state. Then pushes the updated canvas to the User Interface to update the output
     * displayed to the user.
     *
     * @param c Canvas containing the graphical representation
     */
    public void updateView (Canvas c) {

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
