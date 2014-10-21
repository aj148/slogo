package commands;
import model.Model;

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
	
	public List<Command> getParameters(){
		return myParameters;
	}
	
	@Override
	public double executeCommand(Model model) {
		double finalEx = 0;
		for(Command parameter : myParameters){
			finalEx = parameter.executeCommand(null);
		}
		return finalEx;
	}

	@Override
	public int getNumParameters() {
		return myParameters.size();
	}
	
	public List getList()
	{
		return myParameters;
	}
}