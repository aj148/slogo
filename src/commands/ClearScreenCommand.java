package commands;

import model.Model;

public class ClearScreenCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		
		Command a = new HomeCommand();
		return a.executeCommand(model);
	}
}