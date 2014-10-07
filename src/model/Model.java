package model;

import java.util.Collection;

import view.ViewPanel;
import commands.Command;

/**
 * Class that contains the basic information of what needs to be displayed in
 * the GUI, including data related to the turtle (current position, pen color,
 * pen up/down). The Model is always updated before the ViewPanel is updated.
 * 
 * @author Team 14
 */
public class Model {

	private ViewPanel myView;

	/**
	 * Constructor method called from ViewPanel.java
	 * 
	 * @param view
	 *            : The ViewPanel that called this constructor.
	 */
	public Model(ViewPanel view) {
		myView = view;
	}

	/**
	 * Method to update the model with the commands passed from the Controller.
	 * 
	 * @param commandsToExecute
	 *            : Collection of commands to execute.
	 */
	public void updateModel(Collection<Command> commandsToExecute) {
		myView.updateView();
	}
}