package commands;

import model.Model;

public class SetTowardsCommand extends TwoInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		return model.towards(myParameterOne.executeCommand(model), myParameterTwo.executeCommand(model));
	}
}