package commands;

import model.Model;
import model.Turtle;

public class RightCommand extends OneInputCommand {
	/**
	 * returns the amount the turtle should move, updates the heading for all
	 * turtles by calling executeCommand in super
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.updateHeading(myParameters[0].executeCommand(model));
	}
}
