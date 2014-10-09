package commands;

import javafx.geometry.Point2D;
import model.Turtle;

public class HomeCommand extends ZeroInputCommand implements TurtleCommand {
	
	@Override
	public double executeCommand(Turtle turtle) {
		// Still to be completed.
		turtle.myPoint = new Point2D(0, 0);
		return 0;
	}
}