package commands;
import model.Model;


public class NumberCommand extends ZeroInputCommand {
	
	private double myParameter;
	
	public NumberCommand(double parameter){
		myParameter = parameter;
	}
	
	@Override
	public double executeCommand(Model model){
		return myParameter;
	}
}