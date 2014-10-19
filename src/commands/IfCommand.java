package commands;

import model.Turtle;

public class IfCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Turtle turtle) {
    	if(myParameterOne.executeCommand(turtle) != 0){
    		return myParameterTwo.executeCommand(turtle);
    	}
    	return 0;
    }
}