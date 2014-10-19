package commands;

import model.Turtle;
import controller.MasterController;

public class VariableCommand extends ZeroInputCommand {
	
	private String myParameter;
	
	public VariableCommand(String parameter){
		myParameter = parameter;
	}
	
	public String getVariableName(){
		return myParameter;
	}
	
	@Override
	public double executeCommand(Turtle turtle){
		if(MasterController.myVariableMap.containsKey(myParameter)){
			return MasterController.myVariableMap.get(myParameter);
		}
		System.out.println("Variable " + myParameter + " not yet initiated.");
		return 0;
	}
}