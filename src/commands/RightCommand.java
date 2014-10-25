package commands;

import model.Model;
import model.Turtle;

public class RightCommand extends OneInputCommand {
	
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.updateHeading(myParameterOne.executeCommand(model));
	}
}