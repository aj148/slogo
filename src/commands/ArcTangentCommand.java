package commands;

import model.Turtle;

public class ArcTangentCommand extends OneInputCommand {
    
    @Override
    public double executeCommand(Turtle turtle) {
        return Math.atan(myParameterOne.executeCommand(turtle));
    }
}