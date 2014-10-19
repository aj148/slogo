package commands;

import model.Turtle;

public class RightCommand extends OneInputCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.updateHeading(myParameterOne.executeCommand(turtle));
	}
}