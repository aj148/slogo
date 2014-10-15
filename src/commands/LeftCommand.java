package commands;

import model.Turtle;

public class LeftCommand extends OneInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.updateHeading(-myParameterOne.executeCommand());
	}
}