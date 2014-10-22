package commands;

import model.Model;
import model.Turtle;

public class RightCommand extends OneInputCommand {

	@Override
	public double executeCommand(Model model) {
		double toReturn = 0;
		for (Turtle a : model.getManager().getCurrentList()) {
			toReturn = a.updateHeading(
					myParameterOne.executeCommand(model));
		}
		return toReturn;
	}
}