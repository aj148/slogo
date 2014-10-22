package commands;

import model.Model;
import model.Turtle;

public class IsShowingCommand extends ZeroInputCommand {
    
    @Override
    public double executeCommand(Model model) {
    	double toReturn = 0;
		for(Turtle a : model.getManager().getCurrentList()){
			//-1.0 makes it return current visibilty status
			toReturn = a.changeVisibility(-1.0);
			break;
		}
		return toReturn;
    }
}