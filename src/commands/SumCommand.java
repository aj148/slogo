package commands;

import model.Turtle;

public class SumCommand extends TwoInputCommand {

    @Override
    public double executeCommand(Turtle turtle) {
        return myParameterOne.executeCommand(turtle) + myParameterTwo.executeCommand(turtle);
    }
}