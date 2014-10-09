package commands;

import model.Turtle;

public class PenUpCommand extends ZeroInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		turtle.isPenDown = 0;
		return 0;
	}
}