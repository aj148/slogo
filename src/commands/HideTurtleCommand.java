package commands;

import model.Turtle;

public class HideTurtleCommand extends ZeroInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		turtle.isShowing = 0;
		return 0;
	}
}