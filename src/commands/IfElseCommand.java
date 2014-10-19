package commands;

import model.Turtle;

public class IfElseCommand extends ThreeInputCommand {
	
	@Override
    public double executeCommand(Turtle turtle) {
    	if(myParameterOne.executeCommand(turtle) != 0){
    		return myParameterTwo.executeCommand(turtle);
    	}
    	return myParameterThree.executeCommand(turtle);
    }
}