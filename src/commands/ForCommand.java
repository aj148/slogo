package commands;

import model.Turtle;
import controller.MasterController;

public class ForCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Turtle turtle) {
		String variable = ((VariableCommand) ((ListCommand) myParameterOne).getParameters().get(0)).getVariableName();
    	int start = (int)((Command) ((ListCommand) myParameterOne).getParameters().get(1)).executeCommand(turtle);
    	int end = (int)((Command) ((ListCommand) myParameterOne).getParameters().get(2)).executeCommand(turtle);
    	int increment = (int)((Command) ((ListCommand) myParameterOne).getParameters().get(3)).executeCommand(turtle);
    	double toReturn = 0;
    	for(double i = start; i < end; i += increment) {
    		MasterController.myVariableMap.put(variable, i);
    		toReturn = myParameterTwo.executeCommand(turtle);
    	}
    	MasterController.myVariableMap.remove(variable);
    	return toReturn;
    }
}