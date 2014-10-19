package commands;

import model.Turtle;

public class HideTurtleCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.changeVisibility(0.0);
	}
}