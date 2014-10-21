package commands;
import model.Model;


public class LessThanCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Model model) {
		return (myParameterOne.executeCommand(null) < myParameterTwo.executeCommand(null)) ? 1 : 0;
	}
}