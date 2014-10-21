package commands;

import java.util.ArrayList;
import java.util.List;

import model.Model;

public class ListCommand extends Command {
	
	private List<Command> myParameters;
	
	public ListCommand(){
		myParameters = new ArrayList<Command>();
	}
	
	
	public void addParameter(Command parameter){
		myParameters.add(parameter);
	}
	
	public List<Command> getParameters(){
		return myParameters;
	}
	
	@Override
	public double executeCommand(Model model) {
		double finalEx = 0;
		for(Command parameter : myParameters){
			finalEx = parameter.executeCommand(model);
		}
		return finalEx;
	}

	@Override
	public int getNumParameters() {
		return myParameters.size();
	}
	
	public List<Command> getList(){
		return myParameters;
	}
}