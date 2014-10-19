package commands;

import model.Turtle;

public class HomeCommand extends ZeroInputCommand {

	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.setXAndY(0.0, 0.0);
	}
}