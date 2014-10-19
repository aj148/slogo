package commands;

import model.Turtle;

public class NotCommand extends OneInputCommand {

	@Override
	public double executeCommand(Turtle turtle) {
		return (myParameterOne.executeCommand(turtle) != 0) ? 0 : 1;
	}
}