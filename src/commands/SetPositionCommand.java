package commands;
import model.Model;


public class SetPositionCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand (Model model) {
       return turtle.setXAndY(myParameterOne.executeCommand(null), myParameterTwo.executeCommand(null));
    }
}