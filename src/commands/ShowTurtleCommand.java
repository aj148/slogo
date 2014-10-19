package commands;

import model.Turtle;

public class ShowTurtleCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.changeVisibility(1.0);
	}
}