package commands;

import model.Model;

public class SetHeadingCommand extends OneInputCommand {

	@Override
	public double executeCommand(Model model) {
		return model.setHeading(myParameterOne.executeCommand(model));
	}
}