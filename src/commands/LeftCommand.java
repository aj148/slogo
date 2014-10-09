package commands;

import model.Turtle;

public class LeftCommand extends OneInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		turtle.myHeading -= myParameterOne;
		return myParameterOne;
	}
}