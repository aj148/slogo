package commands;

import model.Model;
import model.Turtle;

public class PenDownCommand extends ZeroInputCommand {
	
	@Override
    public double updateTurtle(Model model, Turtle a) {
        return a.changePen(0.0);
    }
}