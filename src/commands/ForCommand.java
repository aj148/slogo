package commands;

import model.Model;
import controller.MasterController;

public class ForCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
		ListCommand command = (ListCommand) myParameters[0];
		String variable = ((VariableCommand) command.getParameters().get(0)).getVariableName();
    	double start = ((Command) command.getParameters().get(1)).executeCommand(model);
    	double end = ((Command) command.getParameters().get(2)).executeCommand(model);
    	double increment = ((Command) command.getParameters().get(3)).executeCommand(model);
    	double toReturn = 0;
    	for(double i = start; i < end; i += increment) {
    		MasterController.myVariableMap.put(variable, i);
    		toReturn = myParameters[1].executeCommand(model);
    	}
    	MasterController.myVariableMap.remove(variable);
    	return toReturn;
    }
}