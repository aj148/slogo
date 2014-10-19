package commands;

import model.Turtle;

public class SineCommand extends OneInputCommand {
    
    @Override
    public double executeCommand(Turtle turtle) {
        return Math.sin(myParameterOne.executeCommand(turtle));
    }
}