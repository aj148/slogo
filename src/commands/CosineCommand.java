package commands;

import model.Turtle;

public class CosineCommand extends OneInputCommand {
    
    @Override
    public double executeCommand(Turtle turtle) {
        return Math.cos(myParameterOne.executeCommand(turtle));
    }
}