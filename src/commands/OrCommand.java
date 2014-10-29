package commands;

import model.Model;

public class OrCommand extends TwoInputCommand {
	/**
	 * returns 0 if either parameter one executes to not equaling zero or
	 * parameter two or both, otherwise it returns one
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double executeCommand(Model model) {
		return (myParameters[0].executeCommand(model) != 0 || myParameters[1]
				.executeCommand(model) != 0) ? 0 : 1;
	}
}
