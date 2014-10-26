package commands;

import model.Model;
import model.Turtle;

public class StampCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		return model.setStamp(1.0);
	}
}