package commands;
import model.Model;


public class SetTowardsCommand extends TwoInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		return turtle.towards(myParameterOne.executeCommand(null), myParameterTwo.executeCommand(null));
	}
}