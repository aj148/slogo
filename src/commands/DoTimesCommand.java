package commands;

import model.Model;
import controller.MasterController;

public class DoTimesCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
		String variable = ((VariableCommand) ((ListCommand) myParameters[0]).getParameters().get(0)).getVariableName();
    	double limit = ((Command) ((ListCommand) myParameters[0]).getParameters().get(1)).executeCommand(model);
    	double toReturn = 0;
    	for(double i = 0; i < limit; i += 1) {
    		MasterController.myVariableMap.put(variable, i);
    		toReturn = myParameters[1].executeCommand(model);
    	}
    	MasterController.myVariableMap.remove(variable);
    	return toReturn;
    }
}