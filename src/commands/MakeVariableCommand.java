package commands;

import controller.MasterController;

public class MakeVariableCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand() {
		double value = myParameterTwo.executeCommand();
		try{
			VariableCommand variable = (VariableCommand)myParameterOne;
			String variableName = variable.getVariableName();
			MasterController.myVariableMap.put(variableName, value);
		}
		catch(ClassCastException e){
			System.out.println("Exception caught in MakeVariableCommand: CLASS CAST EXCEPTION");
			return 0;
		}
		return value;
    }
}