package commands;

public class NaturalLogCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
    	Double value = Math.log(myParameterOne.executeCommand());
    	if(value.toString().equals("NaN") || value.toString().equals("-Infinity")){
    		System.out.println("Problem in NaturalLogCommand: " + value.toString());
    		return 0;
    	}
    	return value;
    }
}