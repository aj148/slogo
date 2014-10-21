package commands;

import model.Model;
import model.Turtle;

public class IsPenDownCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        double last = 0;
		for(Turtle a : model.getManager().getCurrentList()){
			last = a.changePen(-1.0);
		}
		return last;
    }
}