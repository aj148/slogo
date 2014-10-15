package commands;

public class IfCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand() {
    	if(myParameterOne.executeCommand() != 0){
    		return myParameterTwo.executeCommand();
    	}
    	return 0;
    }
}