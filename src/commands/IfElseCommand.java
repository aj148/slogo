package commands;

import model.Model;

public class IfElseCommand extends ThreeInputCommand {
	
	@Override
    public double executeCommand(Model model) {
    	if(myParameterOne.executeCommand(model) != 0){
    		return myParameterTwo.executeCommand(model);
    	}
    	return myParameterThree.executeCommand(model);
    }
}