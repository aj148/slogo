package commands;

import model.Model;

public class AskCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Model model) {
		int currentStackLength = model.getTurtleManager().getStackLength();
		TellCommand a = new TellCommand();
		a.setParameters(myParameters);
		a.executeCommand(model);
		double toReturn = myParameters[1].executeCommand(model);
		// this gets rid of nested tell commands
		model.getTurtleManager().regulateTurtleDepth(currentStackLength);
		return toReturn;
	}
}