package commands;

import model.Turtle;

public class RepeatCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Turtle turtle) {
    	int limit = (int)myParameterOne.executeCommand(turtle);
    	double finalEx = 0;
    	for(int i = 0; i < limit; i++){
    		finalEx = myParameterTwo.executeCommand(turtle);
    	}
    	return finalEx;
    }
}