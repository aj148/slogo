package commands;

public class NumberCommand extends ZeroInputCommand {
	
	private double myParameter;
	
	public NumberCommand(double parameter){
		myParameter = parameter;
	}
	
	@Override
	public double executeCommand(){
		return myParameter;
	}
}