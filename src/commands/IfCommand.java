package commands;

import model.Model;

public class IfCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
    	if(myParameterOne.executeCommand(model) != 0){
    		return myParameterTwo.executeCommand(model);
    	}
    	return 0;
    }
}