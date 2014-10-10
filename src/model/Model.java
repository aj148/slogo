package model;

import java.util.Collection;
import commands.Command;
import commands.TurtleCommand;
import view.ViewPane;


/**
 * Class that contains the basic information of what needs to be displayed in
 * the GUI, including data related to the turtle (current position, pen color,
 * pen up/down). The Model is always updated before the ViewPanel is updated.
 * 
 * @author Team 14
 */
public class Model {

    private ViewPane myView;
    private Turtle myTurtle;

    /**
     * Constructor method called from ViewPanel.java
     * 
     * @param view : The ViewPanel that called this constructor.
     */
    public Model (ViewPane view) {
        myView = view;
        myTurtle = new Turtle(0, 0, myView);
    }

    /**
     * Method to update the model with the commands passed from the Controller.
     * 
     * @param commandsToExecute : Collection of commands to execute.
     */
    public void updateModel (Collection<Command> commandsToExecute) {
        for (Command command : commandsToExecute) {
            myTurtle.updateTurtle((TurtleCommand) command);
        }
    }
}
