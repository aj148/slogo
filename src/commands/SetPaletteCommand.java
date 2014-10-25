package commands;

import model.Model;

public class SetPaletteCommand extends ZeroInputCommand {
	
	// We do not support this command.
	
	@Override
	public double executeCommand(Model model) {
		return 0;
	}
}