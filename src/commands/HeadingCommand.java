package commands;

import model.Model;
import model.Turtle;

public class HeadingCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand (Model model) {
		double toReturn = 0;
		for(Turtle a : model.getManager().getCurrentList()){
			toReturn = a.getHeading();
			break;
		}
		return toReturn;
	}
}