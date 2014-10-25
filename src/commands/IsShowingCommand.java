package commands;

import model.Model;
import model.Turtle;

public class IsShowingCommand extends ZeroInputCommand {
    
    @Override
    public double executeCommand(Model model) {
		Turtle turtle = model.getManager().getCurrentList().iterator().next();
		return turtle.changeVisibility(-1.0);
    }
}