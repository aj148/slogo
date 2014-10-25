package commands;

import model.Model;

public class EqualCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Model model) {
		return (myParameters[0].executeCommand(model) == myParameters[1].executeCommand(model)) ? 1 : 0;
	}
}