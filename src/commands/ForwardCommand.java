package commands;

import model.Model;
import model.Turtle;

public class ForwardCommand extends OneInputCommand {
    
    @Override
    public double updateTurtle(Model model, Turtle a) {
		return a.updatePosition(myParameterOne.executeCommand(model));
	}
}