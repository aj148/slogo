package commands;

import model.Model;
import model.Turtle;


public class HideTurtleCommand extends ZeroInputCommand {
	
//	@Override
//	public double executeCommand(Model model) {
//		double last = 0;
//		for(Turtle a : model.getManager().getCurrentList()){
//			last = a.changeVisibility(0.0);
//		}
//		return last;
//	}
	
    public double updateTurtle(Model model, Turtle a) {
        return a.changeVisibility(0.0);
    }
}