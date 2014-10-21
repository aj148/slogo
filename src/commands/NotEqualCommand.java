package commands;

import model.Model;

public class NotEqualCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Model model) {
		return (myParameterOne.executeCommand(model) == myParameterTwo.executeCommand(model)) ? 0 : 1;
	}
}