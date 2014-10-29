package commands;

import model.Model;

public class PowerCommand extends TwoInputCommand {
	/**
	 * raises the first parameter.execute to the second parameter.execute,
	 * returns the value
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double executeCommand(Model model) {
		return Math.pow(myParameters[0].executeCommand(model),
				myParameters[1].executeCommand(model));
	}
}
