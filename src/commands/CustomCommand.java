package commands;

import java.util.Map;

import model.Model;
import model.VariableManager;

public class CustomCommand extends OneInputCommand {
	
	private ListCommand myVariables;
	private ListCommand myCommands;
	
	public CustomCommand(ListCommand variables, ListCommand commands){
		myVariables = variables;
		myCommands = commands;
	}
	
	@Override
	public double executeCommand(Model model){
		
		VariableManager temp = model.getVariableManager();
    	temp.addVariableMap(myVariables);
		double value = myCommands.executeCommand(model);
		temp.reduceVariableScope();
		return value;
	}
}