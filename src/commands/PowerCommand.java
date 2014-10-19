package commands;

import model.Turtle;

public class PowerCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand(Turtle turtle) {
        return Math.pow(myParameterOne.executeCommand(turtle), myParameterTwo.executeCommand(turtle));
    }
}