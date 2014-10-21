package commands;

import model.Model;

public class GreaterThanCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Model model) {
		return (myParameterOne.executeCommand(model) > myParameterTwo.executeCommand(model)) ? 1 : 0;
	}
}