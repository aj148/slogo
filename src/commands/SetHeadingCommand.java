package commands;

import model.Turtle;

public class SetHeadingCommand extends OneInputCommand implements TurtleCommand {

    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.setHeading(myParameterOne);
    }
}