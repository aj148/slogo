package commands;

import model.Model;
import model.Turtle;

public class HeadingCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand (Model model) {
		double last = 0;
		for(Turtle a : model.getManager().getCurrentList()){
			last = a.getHeading();
		}
		return last;
	}
}