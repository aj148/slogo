package commands;

import java.util.ArrayList;
import java.util.List;

public class ListCommand extends Command {
	
	private List<Command> myParameters;
	
	public ListCommand(){
		myParameters = new ArrayList<Command>();
	}
	
	public void setParameters(Command parameter){
		myParameters.add(parameter);
	}
	
	@Override
	public double executeCommand() {
		double finalEx = 0;
		for(Command parameter : myParameters){
			finalEx = parameter.executeCommand();
		}
		return finalEx;
	}

	@Override
	public int getNumParameters() {
		return myParameters.size();
	}
}