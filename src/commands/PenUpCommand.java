package commands;

import model.Model;

public class PenUpCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		return model.changePen(0.0);
	}
}