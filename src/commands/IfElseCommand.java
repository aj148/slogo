package commands;
import model.Model;


public class IfElseCommand extends ThreeInputCommand {
	
	@Override
    public double executeCommand(Model model) {
    	if(myParameterOne.executeCommand(null) != 0){
    		return myParameterTwo.executeCommand(null);
    	}
    	return myParameterThree.executeCommand(null);
    }
}