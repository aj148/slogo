package commands;

public class IfElseCommand extends ThreeInputCommand {
	
	@Override
    public double executeCommand() {
    	if(myParameterOne.executeCommand() != 0){
    		return myParameterTwo.executeCommand();
    	}
    	return myParameterThree.executeCommand();
    }
}