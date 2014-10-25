package commands;

import model.Model;
import model.Turtle;

public class SetPositionCommand extends TwoInputCommand {
	
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.setXAndY(myParameterOne.executeCommand(model), myParameterTwo.executeCommand(model));
	}
}