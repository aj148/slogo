package commands;

import model.Model;

public class LeftCommand extends OneInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		System.out.println("Executing LeftCommand.");
		return model.updateHeading(-myParameterOne.executeCommand(model));
	}
}