package commands;

import model.Turtle;

public class PenDownCommand extends ZeroInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		turtle.isPenDown = 1;
		return 1;
	}
}