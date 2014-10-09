package commands;

import model.Turtle;

public class BackwardCommand extends OneInputCommand implements TurtleCommand {
    
	@Override
    public double executeCommand (Turtle turtle) {
        double x = -myParameterOne * Math.sin(turtle.myHeading);
        double y = -myParameterOne * Math.cos(turtle.myHeading);
        turtle.myPoint = turtle.myPoint.add(x, y);
        return myParameterOne;
    }
}