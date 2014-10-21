package commands;
import model.Model;


public class RepeatCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
    	int limit = (int)myParameterOne.executeCommand(null);
    	double finalEx = 0;
    	for(int i = 0; i < limit; i++){
    		finalEx = myParameterTwo.executeCommand(null);
    	}
    	return finalEx;
    }
}