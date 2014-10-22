package commands;

import model.Model;
import model.Turtle;

public class SetPositionCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Model model) {
		double toReturn = 0;
		for (Turtle a : model.getManager().getCurrentList()) {
			toReturn = a.setXAndY(myParameterOne.executeCommand(model),
					myParameterTwo.executeCommand(model));
		}
		return toReturn;
	}
}