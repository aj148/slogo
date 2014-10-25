package commands;

import model.Model;

public class AskCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Model model) {
		int currentStackLength = model.getManager().getStackLength();
		TellCommand a = new TellCommand();
		a.setParameters(myParameterTwo);
		a.executeCommand(model);
		double toReturn = myParameterTwo.executeCommand(model);
		// this gets rid of nested tell commands
		model.getManager().regulateDepth(currentStackLength);
		return toReturn;
	}
}