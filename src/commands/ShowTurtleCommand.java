package commands;

import model.Model;
import model.Turtle;

public class ShowTurtleCommand extends ZeroInputCommand {
	
	@Override
    public double updateTurtle(Model model, Turtle a) {
        return a.changeVisibility(1.0);
    }
}