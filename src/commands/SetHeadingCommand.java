package commands;

import model.Turtle;

public class SetHeadingCommand extends OneInputCommand {

	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.setHeading(myParameterOne.executeCommand(turtle));
	}
}