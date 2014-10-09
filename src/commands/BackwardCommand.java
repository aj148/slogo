package commands;

import model.Turtle;

public class BackwardCommand extends OneInputCommand implements TurtleCommand {
    
    private double myParameterOne;
    
    @Override
    public void setParameters (double parameterOne) {
        parameterOne = myParameterOne;
    }

    @Override
    public void executeCommand (Turtle turtle) {
        // Still to be completed.
    }
}