package commands;

import model.Model;

public class GetPenColorCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		return getFirstTurtle(model).getPenColor();
	}
}