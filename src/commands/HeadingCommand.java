package commands;

import model.Model;

public class HeadingCommand extends Command {
	
	@Override
	public double executeCommand (Model model) {
		return getFirstTurtle(model).getHeading();
	}
}