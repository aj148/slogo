package commands;

import javafx.geometry.Point2D;
import model.Turtle;

public class HomeCommand extends ZeroInputCommand implements TurtleCommand {

	@Override
	public double executeCommand(Turtle turtle) {
		return turtle.setXAndY(0.0, 0.0);
	}
}