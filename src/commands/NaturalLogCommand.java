package commands;

public class NaturalLogCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
    	//error with logs if 0 or less.
        return Math.log(myParameterOne);
    }
}