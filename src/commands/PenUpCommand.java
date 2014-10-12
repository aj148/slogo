package commands;

import model.Turtle;

public class PenUpCommand extends ZeroInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.changePen(0.0);
	}
}