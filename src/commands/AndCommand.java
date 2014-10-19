package commands;

import model.Turtle;

public class AndCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Turtle turtle) {
		return (myParameterOne.executeCommand(turtle) == 0 && myParameterTwo.executeCommand(turtle) == 0) ? 1 : 0;
	}
}