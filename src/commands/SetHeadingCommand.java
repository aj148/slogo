package commands;

import model.Turtle;

public class SetHeadingCommand extends OneInputCommand implements TurtleCommand {

	@Override
	public double executeCommand(Turtle turtle) {
		double headingChange = myParameterOne - turtle.myHeading;
		turtle.myHeading = myParameterOne;
		return headingChange;
	}
}