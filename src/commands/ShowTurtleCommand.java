package commands;
import model.Model;


public class ShowTurtleCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		return turtle.changeVisibility(1.0);
	}
}