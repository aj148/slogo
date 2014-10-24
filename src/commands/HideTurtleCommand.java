package commands;

import model.Turtle;

public class HideTurtleCommand extends ZeroInputCommand implements TurtleCommand {

    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.changeVisibility(0.0);
    }
}