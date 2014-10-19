package commands;

import model.Turtle;

public class OrCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Turtle turtle) {
		return (myParameterOne.executeCommand(turtle) != 0 || myParameterTwo.executeCommand(turtle) != 0) ? 0 : 1;
	}
}