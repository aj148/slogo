package commands;

import model.Model;
import controller.MasterController;

public class DoTimesCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
		String variable = ((VariableCommand) ((ListCommand) myParameterOne).getParameters().get(0)).getVariableName();
    	double limit = ((Command) ((ListCommand) myParameterOne).getParameters().get(1)).executeCommand(model);
    	double toReturn = 0;
    	for(double i = 0; i < limit; i += 1) {
    		MasterController.myVariableMap.put(variable, i);
    		toReturn = myParameterTwo.executeCommand(model);
    	}
    	MasterController.myVariableMap.remove(variable);
    	return toReturn;
    }
}