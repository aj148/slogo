package commands;

import model.Model;
import model.Turtle;

public class SetTowardsCommand extends TwoInputCommand {
	/**
	 * sets active turtles towards a given set of points, returns value of the
	 * turtle.towards for one of the turtles.
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.towards(myParameters[0].executeCommand(model),
				myParameters[1].executeCommand(model));
	}
}
