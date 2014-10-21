package commands;
import model.Model;


public class BackwardCommand extends OneInputCommand {
    
	@Override
    public double executeCommand (Model model) {
        return turtle.updatePosition(-myParameterOne.executeCommand(null));
    }
}