package commands;

import model.Turtle;

public class MinusCommand extends OneInputCommand {
    
    @Override
    public double executeCommand(Turtle turtle) {
        return -myParameterOne.executeCommand(turtle);
    }
}