package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.paint.Color;
import commands.Command;
import view.panes.ViewPaneModule;

/**
 * Class that contains the basic information of what needs to be displayed in
 * the GUI, including data related to the turtle (current position, pen color,
 * pen up/down). The Model is always updated before the ViewPanel is updated.
 *
 * @author Team 14
 */
public class Model {
    private ViewPaneModule myView;
    private Color myBackground;
    private Set<Turtle> myFullList;
    private TurtleListManager myManager;

    /**
     * Constructor method called from ViewPanel.java
     *
     * @param view
     *            : The ViewPanel that called this constructor.
     */
    public Model (ViewPaneModule view) {
        myFullList = new HashSet<Turtle>();
        myView = view;
        myManager = new TurtleListManager(myFullList);
        myBackground = Color.WHITE;
    }

    /**
     * Method to update the model with the commands passed from the Controller.
     *
     * @param commandsToExecute
     *            : Collection of commands to execute.
     */
    public void updateModel (Collection<Command> commandsToExecute) {
        for (Command command : commandsToExecute) {
            command.executeCommand(this);
            myView.updateView(this);
        }
    }

    public ViewPaneModule getView () {
        return myView;
    }

    public TurtleListManager getManager () {
        return myManager;
    }

    public void setBackgroundColor (Color color) {
        myBackground = color;
    }

    public Color getBackgroundColor () {
        return myBackground;
    }
}