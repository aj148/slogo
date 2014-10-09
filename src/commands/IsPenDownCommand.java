package commands;

import model.Turtle;

public class IsPenDownCommand extends ZeroInputCommand implements TurtleCommand {

    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.isPenDown;
    }
}