package commands;

import model.Turtle;

public abstract class TurtleCommand extends Command {
    
    public abstract void executeCommand(Turtle turtle);
}