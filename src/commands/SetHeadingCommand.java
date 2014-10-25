package commands;

import model.Model;
import model.Turtle;

public class SetHeadingCommand extends OneInputCommand {


//	@Override
//	public double executeCommand(Model model) {
//		double toReturn = 0;
//		for(Turtle a : model.getManager().getCurrentList()){
//			toReturn = a.setHeading(myParameterOne.executeCommand(model));
//		}
//		return toReturn;
//	}
	
	public double updateTurtle(Model model, Turtle a) {
        return a.setHeading(myParameterOne.executeCommand(model));
    }
}