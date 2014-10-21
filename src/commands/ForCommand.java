package commands;
import model.Model;

import controller.MasterController;

public class ForCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
		String variable = ((VariableCommand) ((ListCommand) myParameterOne).getParameters().get(0)).getVariableName();
    	int start = (int)((Command) ((ListCommand) myParameterOne).getParameters().get(1)).executeCommand(null);
    	int end = (int)((Command) ((ListCommand) myParameterOne).getParameters().get(2)).executeCommand(null);
    	int increment = (int)((Command) ((ListCommand) myParameterOne).getParameters().get(3)).executeCommand(null);
    	double toReturn = 0;
    	for(double i = start; i < end; i += increment) {
    		MasterController.myVariableMap.put(variable, i);
    		toReturn = myParameterTwo.executeCommand(null);
    	}
    	MasterController.myVariableMap.remove(variable);
    	return toReturn;
    }
}