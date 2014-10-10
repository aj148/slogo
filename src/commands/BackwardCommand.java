package commands;

import model.Turtle;

public class BackwardCommand extends OneInputCommand implements TurtleCommand {
    
	@Override
    public double executeCommand (Turtle turtle) {
        return turtle.updatePosition(-myParameterOne);
    }
}