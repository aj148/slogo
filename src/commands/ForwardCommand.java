package commands;

import model.Turtle;

public class ForwardCommand extends OneInputCommand {
	
    @Override
    public double executeCommand (Turtle turtle) {
    	System.out.println("Executing ForwardCommand.");
        return turtle.updatePosition(myParameterOne.executeCommand(turtle));
    }
}