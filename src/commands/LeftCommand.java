package commands;

import model.Turtle;

public class LeftCommand extends OneInputCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		System.out.println("Executing LeftCommand.");
		return turtle.updateHeading(-myParameterOne.executeCommand(turtle));
	}
}