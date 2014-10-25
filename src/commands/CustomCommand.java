package commands;

import java.util.Map;

import model.Model;
import model.VariableManager;

public class CustomCommand extends ZeroInputCommand {
	
	private Map<String, Double> myVariables;
	private ListCommand myCommands;
	
	public CustomCommand(Map<String, Double> variables, ListCommand commands){
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