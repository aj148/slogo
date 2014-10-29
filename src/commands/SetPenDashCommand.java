package commands;

import model.Model;
import model.Turtle;

public class SetPenDashCommand extends OneInputCommand {
	/**
	 * sets the dash of the turtle for all active turtles, returns the value of
	 * whether it's dashed or not
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.setPenDash(myParameters[0].executeCommand(model));
	}
}
