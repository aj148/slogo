package commands;

import model.Model;
import model.Turtle;

public class PenUpCommand extends ZeroInputCommand {
	/**
	 * moves the pen up for the given turtle returns 0.0, does this for all
	 * turtles
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.changePen(0.0);
	}
}
