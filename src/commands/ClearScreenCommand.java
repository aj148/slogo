package commands;

import model.Model;

public class ClearScreenCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		// STILL need signal to clear screen.
		Command a = new HomeCommand();
		return a.executeCommand(model);
	}
}