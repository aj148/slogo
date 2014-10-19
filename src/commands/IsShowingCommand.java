package commands;

import model.Turtle;

public class IsShowingCommand extends ZeroInputCommand {
    
    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.changeVisibility(-1.0);
    }
}