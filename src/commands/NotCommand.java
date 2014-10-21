package commands;

import model.Model;

public class NotCommand extends OneInputCommand {

	@Override
	public double executeCommand(Model model) {
		return (myParameterOne.executeCommand(model) != 0) ? 0 : 1;
	}
}