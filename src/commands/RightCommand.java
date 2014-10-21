package commands;

import model.Model;

public class RightCommand extends OneInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		return model.updateHeading(myParameterOne.executeCommand(model));
	}
}