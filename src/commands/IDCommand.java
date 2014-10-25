package commands;

import model.Model;
import model.Turtle;

public class IDCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		double toReturn = 0;
		for(Turtle a : model.getManager().getCurrentList()){
			toReturn = a.getID();
			break;
		}
		return toReturn;
	}
}