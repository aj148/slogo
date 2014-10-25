package commands;

import model.Model;
import model.Turtle;

public class PenDownCommand extends ZeroInputCommand {
	
//	@Override
//	public double executeCommand(Model model) {
//		double toReturn = 0;
//		for(Turtle a : model.getManager().getCurrentList()){
//			toReturn = a.changePen(0.0);
//		}
//		return toReturn;
//	}
	
    public double updateTurtle(Model model, Turtle a) {
        return a.changePen(0.0);
    }
}