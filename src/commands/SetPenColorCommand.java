package commands;

import model.Model;
import model.Turtle;

public class SetPenColorCommand extends ThreeInputCommand {
	
	@Override
	public double updateTurtle(Model model, Turtle a) {
		double red = myParameters[0].executeCommand(model);
    	double green = myParameters[1].executeCommand(model);
    	double blue = myParameters[2].executeCommand(model);
    	return a.setPenColor(red, green, blue);
	}
}