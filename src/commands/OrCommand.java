package commands;
import model.Model;


public class OrCommand extends TwoInputCommand {

	@Override
	public double executeCommand(Model model) {
		return (myParameterOne.executeCommand(null) != 0 || myParameterTwo.executeCommand(null) != 0) ? 0 : 1;
	}
}