package commands;


import model.Model;

public class ClearScreenCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		// Need signal to clear screen still.
		Command a = new HomeCommand();
		return a.executeCommand(model);
	}

}