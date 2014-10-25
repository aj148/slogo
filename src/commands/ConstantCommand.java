package commands;

import model.Model;

public class ConstantCommand extends ZeroInputCommand {
	
	private double myParameter;
	
	public ConstantCommand(double parameter){
		myParameter = parameter;
	}
	
	@Override
	public double executeCommand(Model model){
		return myParameter;
	}
}