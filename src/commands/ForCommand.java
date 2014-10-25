package commands;

import java.util.HashMap;

import model.Model;
import model.VariableManager;

public class ForCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
		ListCommand command = (ListCommand) myParameters[0];
		String variable = ((VariableCommand) command.getParameters().get(0)).getVariableName();
    	double start = ((Command) command.getParameters().get(1)).executeCommand(model);
    	double end = ((Command) command.getParameters().get(2)).executeCommand(model);
    	double increment = ((Command) command.getParameters().get(3)).executeCommand(model);
    	double toReturn = 0;
    	VariableManager temp = model.getVariableManager();
    	temp.addVariableMap(new HashMap<String, Double>());
    	for(double i = start; i < end; i += increment) {
    		temp.addLocalVariable(variable, i);
    		toReturn = myParameters[1].executeCommand(model);
    	}
    	temp.reduceVariableScope();
    	return toReturn;
    }
}