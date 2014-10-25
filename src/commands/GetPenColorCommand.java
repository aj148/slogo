package commands;

import java.util.ArrayList;
import java.util.List;

import model.Model;
import model.Turtle;

public class GetPenColorCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		Turtle turtle = model.getManager().getCurrentList().iterator().next();
		return turtle.getPenColor();
	}
}