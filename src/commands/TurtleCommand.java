package commands;

import model.Turtle;

public abstract interface TurtleCommand {
    
    public abstract void executeCommand(Turtle turtle);
}