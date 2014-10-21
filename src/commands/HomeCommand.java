package commands;

import model.Model;
import model.Turtle;

public class HomeCommand extends ZeroInputCommand {

	@Override
	public double executeCommand(Model model) {
		double last = 0;
		for(Turtle a : model.getManager().getCurrentList()){
			last = a.setXAndY(0.0, 0.0);
		}
		return last;
	}
}