package commands;

import model.Model;
import model.Turtle;

public class SetShapeCommand extends OneInputCommand {
	/**
	 * sets shape for active turtles, returns index of shape that's being set to
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.setShape(myParameters[0].executeCommand(model));
	}
}
