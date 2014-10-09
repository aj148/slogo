package commands;

import model.Turtle;

public class RightCommand extends OneInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		turtle.myHeading += myParameterOne;
		return myParameterOne;
	}
}