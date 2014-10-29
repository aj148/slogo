package commands;

import model.Model;

public class SetBackgroundCommand extends ThreeInputCommand {
	/**
	 * sets background based on three input values, returns the value of setting
	 * it in the model
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double executeCommand(Model model) {
		double red = myParameters[0].executeCommand(model);
		double green = myParameters[1].executeCommand(model);
		double blue = myParameters[2].executeCommand(model);
		return model.setBackgroundColor(red, green, blue);
	}
}
