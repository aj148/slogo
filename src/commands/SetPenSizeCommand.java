package commands;

import model.Turtle;

public class SetPenSizeCommand extends OneInputCommand {
	public double executeCommand(Turtle turtle)
	{
		return turtle.setPenSize(myParameterOne.executeCommand(turtle));
	}
}
