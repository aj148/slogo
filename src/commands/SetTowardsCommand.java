package commands;

import model.Turtle;

public class SetTowardsCommand extends TwoInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.towards(myParameterOne.executeCommand(), myParameterTwo.executeCommand());
	}
}