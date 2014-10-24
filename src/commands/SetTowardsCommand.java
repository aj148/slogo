package commands;

import javafx.geometry.Point2D;
import model.Turtle;

public class SetTowardsCommand extends TwoInputCommand implements TurtleCommand {

    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.towards(new Point2D(myParameterOne, myParameterTwo));
    }
}