package commands;
import model.Model;


public class RightCommand extends OneInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		return turtle.updateHeading(myParameterOne.executeCommand(null));
	}
}