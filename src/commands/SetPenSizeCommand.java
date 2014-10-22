package commands;

import model.Model;
import model.Turtle;

public class SetPenSizeCommand extends OneInputCommand {
	
	public double executeCommand(Model model) {
		double toReturn = 0;
		for(Turtle a : model.getManager().getCurrentList()){
			toReturn = a.setPenSize(myParameterOne.executeCommand(model));
		}
		return toReturn;	}
}