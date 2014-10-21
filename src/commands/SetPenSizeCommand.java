package commands;
import model.Model;


public class SetPenSizeCommand extends OneInputCommand {
	public double executeCommand(Model model)
	{
		return turtle.setPenSize(myParameterOne.executeCommand(null));
	}
}
