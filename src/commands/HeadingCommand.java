package commands;

import model.Turtle;

public class HeadingCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.getHeading();
    }
}