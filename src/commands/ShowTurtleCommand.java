package commands;

import model.Turtle;

public class ShowTurtleCommand extends ZeroInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		turtle.isShowing = 1;
		return 1;
	}
}