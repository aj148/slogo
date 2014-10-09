package commands;

import model.Turtle;

public class ForwardCommand extends OneInputCommand implements TurtleCommand {
    
    @Override
    public void executeCommand (Turtle turtle) {
        System.out.println(turtle.myPoint.getX());
        System.out.println(myParameterOne);
        turtle.myPoint = turtle.myPoint.add(myParameterOne, 0);
        System.out.println(turtle.myPoint.getX());
    }
}