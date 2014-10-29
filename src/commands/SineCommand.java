package commands;

import model.Model;

public class SineCommand extends OneInputCommand {
	/**
	 * returns the value of sin(parameter)
	 *
	 */
	@Override
	public double executeCommand(Model model) {
		return Math.sin(myParameters[0].executeCommand(model));
	}
}
