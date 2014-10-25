package commands;

import model.Model;

public class IfCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
		IfElseCommand condition = new IfElseCommand();
		condition.setParameters(myParameterOne, myParameterTwo, new ConstantCommand(0));
    	return condition.executeCommand(model);
    }
}