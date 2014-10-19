package commands;

import java.util.ArrayList;
import java.util.List;

import model.Turtle;

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
	public double executeCommand(Turtle turtle) {
		double finalEx = 0;
		for(Command parameter : myParameters){
			finalEx = parameter.executeCommand(turtle);
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