package commands;

import model.Turtle;

public class ProductCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand(Turtle turtle) {
        return myParameterOne.executeCommand(turtle) * myParameterTwo.executeCommand(turtle);
    }
}