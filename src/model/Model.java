package model;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import javafx.scene.paint.Color;
import view.panes.ViewPaneModule;
import commands.Command;

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
	private Set<Turtle> myFullSet;
	private TurtleSetManager myTurtleManager;
	private VariableManager myVariableManager;
	private double isStamp;

	/**
	 * Constructor method called from ViewPanel.java
	 *
	 * @param view
	 *            : The ViewPanel that called this constructor.
	 */
	public Model(ViewPaneModule view) {
		myFullSet = new TreeSet<Turtle>();
		myView = view;
		myTurtleManager = new TurtleSetManager(myFullSet);
		myVariableManager = new VariableManager();
		myBackground = Color.WHITE;
		isStamp = 0.0;
	}

	/**
	 * Method to update the model with the commands passed from the Controller.
	 *
	 * @param commandsToExecute
	 *            : Collection of commands to execute.
	 */
	public void updateModel(Collection<Command> commandsToExecute) {
		for (Command command : commandsToExecute) {
			command.executeCommand(this);
			notifyView();
		}
	}

	/**
	 * Method to notify the view when things change in the model
	 */
	public void notifyView() {
		myView.updateView(this);
	}

	/**
	 * Method to return the view (as a viewpanemodule) after it's updatedd.
	 */
	public ViewPaneModule getView() {
		return myView;
	}

	/**
	 * Method to return the manager that holds the collections of active turtles
	 * and the full list of turtles to the front end
	 */
	public TurtleSetManager getTurtleManager() {
		return myTurtleManager;
	}

	/**
	 * Method to return the manager that holds the collections of variables,
	 * both global and local
	 */
	public VariableManager getVariableManager() {
		return myVariableManager;
	}

	/**
	 * Method to update the background color
	 *
	 * @param red
	 *            : how much red blue: how much blue green: how much green
	 * 
	 */
	public double setBackgroundColor(double red, double green, double blue) {
		int r = (int) (255 * red);
		int g = (int) (255 * green);
		int b = (int) (255 * blue);
		myBackground = Color.rgb(r, g, b);
		return red + (1000 * green) + (1000000 * blue);
	}

	/**
	 * Method to return the background color to the view.
	 *
	 */
	public Color getBackgroundColor() {
		return myBackground;
	}
	/**
	 * Method to tell the view if the active turtles should stamp or not
	 */
	public double getStamp() {
		return isStamp;
	}
	/**
	 * Method to change whether or not active turtles stamp.
	 */
	public double setStamp(double stamp) {
		isStamp = stamp;
		return stamp;
	}

}
