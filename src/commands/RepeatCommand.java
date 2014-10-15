package commands;

public class RepeatCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand() {
    	int limit = (int)myParameterOne.executeCommand();
    	double finalEx = 0;
    	for(int i = 0; i < limit; i++){
    		finalEx = myParameterTwo.executeCommand();
    	}
    	return finalEx;
    }
}