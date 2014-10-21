package commands;
import model.Model;


public class HideTurtleCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		return turtle.changeVisibility(0.0);
	}
}