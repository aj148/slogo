package commands;

import java.util.HashMap;

import model.Model;
import model.VariableManager;

public class DoTimesCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
		String variable = ((VariableCommand) ((ListCommand) myParameters[0]).getParameters().get(0)).getVariableName();
    	double limit = ((Command) ((ListCommand) myParameters[0]).getParameters().get(1)).executeCommand(model);
    	double toReturn = 0;
    	VariableManager temp = model.getVariableManager();
    	temp.addVariableMap(new HashMap<String, Double>());
    	for(double i = 0; i < limit; i += 1) {
    		temp.addLocalVariable(variable, i);
    		toReturn = myParameters[1].executeCommand(model);
    	}
    	temp.reduceVariableScope();
    	return toReturn;
    }
}