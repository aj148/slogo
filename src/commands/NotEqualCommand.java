package commands;

import model.Turtle;

public class NotEqualCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Turtle turtle) {
		return (myParameterOne.executeCommand(turtle) == myParameterTwo.executeCommand(turtle)) ? 0 : 1;
	}
}