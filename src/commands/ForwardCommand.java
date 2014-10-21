package commands;

import model.Model;
import model.Turtle;

public class ForwardCommand extends OneInputCommand {
	
    @Override
    public double executeCommand (Model model) {
    	double last = 0;
    	for(Turtle a : model.getManager().getCurrentList()){
    		last = a.updatePosition(myParameterOne.executeCommand(model));
    	}
        return last;
    }
}