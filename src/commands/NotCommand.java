package commands;

import model.Model;

public class NotCommand extends OneInputCommand {
	/**
	 * used for logic, if executing the command is not zero, return zero,
	 * otherwise return one
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double executeCommand(Model model) {
		return (myParameters[0].executeCommand(model) != 0) ? 0 : 1;
	}
}
