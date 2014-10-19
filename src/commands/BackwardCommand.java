package commands;

import model.Turtle;

public class BackwardCommand extends OneInputCommand {
    
	@Override
    public double executeCommand (Turtle turtle) {
        return turtle.updatePosition(-myParameterOne.executeCommand(turtle));
    }
}