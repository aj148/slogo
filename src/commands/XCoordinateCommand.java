package commands;

import model.Turtle;

public class XCoordinateCommand extends ZeroInputCommand {
    
    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.getXOrY(0);
    }
}