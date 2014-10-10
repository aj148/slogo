package commands;

import model.Turtle;

public class YCoordinateCommand extends ZeroInputCommand implements TurtleCommand {
    
    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.getXOrY(1);
    }
}