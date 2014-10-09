package commands;

import model.Turtle;

public abstract interface TurtleCommand {
    
    public abstract double executeCommand(Turtle turtle);
}