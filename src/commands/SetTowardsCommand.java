package commands;

import model.Model;
import model.Turtle;

public class SetTowardsCommand extends TwoInputCommand {
	
	@Override
	public double updateTurtle(Model model, Turtle a) {
		return a.towards(myParameterOne.executeCommand(model), myParameterTwo.executeCommand(model));
	}
}