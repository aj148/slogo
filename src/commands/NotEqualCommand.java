package commands;
import model.Model;


public class NotEqualCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Model model) {
		return (myParameterOne.executeCommand(null) == myParameterTwo.executeCommand(null)) ? 0 : 1;
	}
}