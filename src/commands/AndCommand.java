package commands;

import model.Model;

public class AndCommand extends TwoInputCommand {


	@Override
	public double executeCommand(Model model) {
		return (myParameterOne.executeCommand(model) == 0 && myParameterTwo.executeCommand(model) == 0) ? 1 : 0;
	}

}