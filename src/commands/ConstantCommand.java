package commands;

import model.Model;

public class ConstantCommand extends ZeroInputCommand {
	
	private double myConstant;
	
	public ConstantCommand(double parameter){
		myConstant = parameter;
	}
	
	@Override
	public double executeCommand(Model model){
		return myConstant;
	}
}