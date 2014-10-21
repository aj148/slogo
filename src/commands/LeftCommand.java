package commands;

import model.Model;

public class LeftCommand extends OneInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		return model.updateHeading(-myParameterOne.executeCommand(model));
	}
}