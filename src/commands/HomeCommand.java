package commands;

import javafx.geometry.Point2D;
import model.Turtle;

public class HomeCommand extends ZeroInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		double x = turtle.myPoint.getX();
        double y = turtle.myPoint.getY();
		turtle.myPoint = new Point2D(0, 0);
		return Math.sqrt((x*x) + (y*y));
	}
}