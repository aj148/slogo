package commands;

import model.Model;

public class NotCommand extends OneInputCommand {

	@Override
	public double executeCommand(Model model) {
		return (myParameters[0].executeCommand(model) != 0) ? 0 : 1;
	}
}