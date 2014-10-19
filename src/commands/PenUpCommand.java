package commands;

import model.Turtle;

public class PenUpCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.changePen(0.0);
	}
}