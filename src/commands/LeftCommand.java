package commands;

import model.Model;

public class LeftCommand extends OneInputCommand {

	@Override
	public double executeCommand(Model model) {
		RightCommand a = new RightCommand();
		a.setParameters(new ConstantCommand(-1.0 * myParameterOne.executeCommand(model)));
		return a.executeCommand(model);
	}
}