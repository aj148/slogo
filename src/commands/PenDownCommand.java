package commands;

import model.Model;
import model.Turtle;

public class PenDownCommand extends ZeroInputCommand {
	/**
	 * sets the pen donw on a given turtle, returns 1.0; does this for all turtles
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.changePen(1.0);
	}
}
