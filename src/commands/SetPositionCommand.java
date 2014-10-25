package commands;

import model.Model;
import model.Turtle;

public class SetPositionCommand extends TwoInputCommand {
	
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.setXAndY(myParameters[0].executeCommand(model), myParameters[1].executeCommand(model));
	}
}