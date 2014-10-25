package commands;

import model.Model;
import model.Turtle;

public class SetHeadingCommand extends OneInputCommand {
	
	@Override
	public double updateTurtle(Model model, Turtle a) {
        return a.setHeading(myParameterOne.executeCommand(model));
    }
}