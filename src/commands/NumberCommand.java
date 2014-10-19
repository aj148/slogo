package commands;

import model.Turtle;

public class NumberCommand extends ZeroInputCommand {
	
	private double myParameter;
	
	public NumberCommand(double parameter){
		myParameter = parameter;
	}
	
	@Override
	public double executeCommand(Turtle turtle){
		return myParameter;
	}
}