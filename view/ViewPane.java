package view;

import javafx.scene.canvas.Canvas; 
import model.Model;
import commands.Command;
import controller.Controller;


/**
 * Responsible for drawing the graphical representation of the turtles movement as its state changes
 * using Observable. Calls on the Draw class to update the graphical representation stored in View
 * when the status of a turtle changes.
 *
 * @author Team 14
 *
 */
public class ViewPanel {
    private Controller myController;

    /**
     * Constructor method called from UserInterface.java
     */
    public ViewPanel () {
        myController = new Controller(this, new Model(this));
    }

    /**
     * This method should actually take a string typed into the view by the user.
     */
    @SuppressWarnings("unused")
    private void sendInput () {
        String input = "fd 50";
        myController.getInput(input);
    }

    /**
     * This method should display an error in the view based on the ErrorCommand.
     *
     * @param error : An ErrorCommand containing the specifics error.
     */
    public void showError (Command error) {
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
}
