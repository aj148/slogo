package commands;

import model.Model;

public class NotEqualCommand extends TwoInputCommand {
	/**
	 * returns 0 if the two parameters are equal, otherwise it returns one
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double executeCommand(Model model) {
		return (myParameters[0].executeCommand(model) == myParameters[1]
				.executeCommand(model)) ? 0 : 1;
	}
}
