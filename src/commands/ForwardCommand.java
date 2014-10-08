package commands;

import model.Turtle;

public class ForwardCommand extends TurtleCommand implements OneInputCommand {
    
    private double myParameterOne;
    
    @Override
    public void setParameters (double parameterOne) {
        myParameterOne = parameterOne;
    }
    
    @Override
    public void executeCommand (Turtle turtle) {
        // This doesn't work yet. Apparently.
    }
    
    @Override
    public int getNumParameters () {
        return 1;
    }
}