package commands;

import model.Turtle;

public class RightCommand extends OneInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.updateHeading(myParameterOne);
	}
}