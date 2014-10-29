package commands;

import model.Model;
import model.Turtle;


public class SetHeadingCommand extends OneInputCommand {
	/**
	 * sets the heading of the turtles, executecommand returns the value of oen of the turtle's execution
	 * 
	 * @author team14
	 *
	 */
    @Override
    public double updateTurtle (Model model, Turtle a) {
        return a.setHeading(myParameters[0].executeCommand(model));
    }
}
