package commands;

import model.Model;

public class OrCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Model model) {
		return (myParameterOne.executeCommand(model) != 0 || myParameterTwo.executeCommand(model) != 0) ? 0 : 1;
	}
}