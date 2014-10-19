package commands;

import model.Turtle;

public class IsPenDownCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.changePen(-1.0);
    }
}