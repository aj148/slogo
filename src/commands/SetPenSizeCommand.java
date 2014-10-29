package commands;

import model.Model;
import model.Turtle;

public class SetPenSizeCommand extends OneInputCommand {
	/**
	 * sets the size of the pen for active turtles, returns value of whether
	 * it's setting turtles pens as active or not
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.setPenSize(myParameters[0].executeCommand(model));
	}
}
