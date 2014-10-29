package commands;

import model.Model;

public class StampCommand extends ZeroInputCommand {
	/**
	 * makes it so stamp is active for active turtles,returns 1.0
	 *
	 */
	@Override
	public double executeCommand(Model model) {
		return model.setStamp(1.0);
	}
}
