package commands;

import model.Turtle;

public class SetTowardsCommand extends TwoInputCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.towards(myParameterOne.executeCommand(turtle), myParameterTwo.executeCommand(turtle));
	}
}