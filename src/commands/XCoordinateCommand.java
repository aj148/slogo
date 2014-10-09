package commands;

import model.Turtle;

public class XCoordinateCommand extends ZeroInputCommand implements TurtleCommand {
    
    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.myPoint.getX();
    }
}