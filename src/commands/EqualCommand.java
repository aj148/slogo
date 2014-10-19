package commands;

import model.Turtle;

public class EqualCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Turtle turtle) {
		return (myParameterOne.executeCommand(turtle) == myParameterTwo.executeCommand(turtle)) ? 1 : 0;
	}
}