package commands;

import model.Model;


public class AndCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Model model) {
		return (myParameterOne.executeCommand(null) == 0 && myParameterTwo.executeCommand(null) == 0) ? 1 : 0;
	}
}