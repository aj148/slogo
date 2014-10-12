package commands;

import java.util.ArrayList;
import java.util.List;

public class ListCommand extends Command {
	
	private List<Command> myParameters = new ArrayList<Command>();
	
	public void setParameters(Command parameter){
		myParameters.add(parameter);
	}
	
	@Override
	public double executeCommand() {
		double total = 0;
		for(Command parameter : myParameters){
			total += parameter.executeCommand();
		}
		return total;
	}

	@Override
	public int getNumParameters() {
		return 0;
	}
}