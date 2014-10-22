package commands;

import model.Model;
import model.Turtle;

public class SetTowardsCommand extends TwoInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		double toReturn = 0;
		for(Turtle a : model.getManager().getCurrentList()){
			toReturn = a.towards(myParameterOne.executeCommand(model), myParameterTwo.executeCommand(model));
		}
		return toReturn;
	}
}