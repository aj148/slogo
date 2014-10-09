package commands;

import model.Turtle;

public class HeadingCommand extends ZeroInputCommand implements TurtleCommand {

    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.myHeading;
    }
}