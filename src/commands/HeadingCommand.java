package commands;

import model.Model;

public class HeadingCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand (Model model) {
		return getFirstTurtle(model).getHeading();
	}
}