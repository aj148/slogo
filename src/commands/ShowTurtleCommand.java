package commands;

import model.Model;
import model.Turtle;

public class ShowTurtleCommand extends ZeroInputCommand {
	/**
	 * makes all active turtles visible, returns 1.0
	 *
	 */
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.changeVisibility(1.0);
	}
}
