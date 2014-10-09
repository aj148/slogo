package commands;

import javafx.geometry.Point2D;
import model.Turtle;

public class SetPositionCommand extends TwoInputCommand implements TurtleCommand {
	
	@Override
    public double executeCommand (Turtle turtle) {
        double x = turtle.myPoint.getX();
        double y = turtle.myPoint.getY();
        turtle.myPoint = new Point2D(myParameterOne, myParameterTwo);
        return Math.sqrt((x*x) + (y*y));
    }
}