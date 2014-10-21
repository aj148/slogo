package commands;

import model.Model;

public class SetPenSizeCommand extends OneInputCommand {
	
	public double executeCommand(Model model) {
		return model.setPenSize(myParameterOne.executeCommand(model));
	}
}