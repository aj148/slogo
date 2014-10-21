package commands;
import model.Model;


public class IfCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
    	if(myParameterOne.executeCommand(null) != 0){
    		return myParameterTwo.executeCommand(null);
    	}
    	return 0;
    }
}