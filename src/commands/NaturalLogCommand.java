package commands;

import model.Turtle;

public class NaturalLogCommand extends OneInputCommand {
    
    @Override
    public double executeCommand(Turtle turtle) {
    	Double value = Math.log(myParameterOne.executeCommand(turtle));
    	if(value.toString().equals("NaN") || value.toString().equals("-Infinity")){
    		System.out.println("Problem in NaturalLogCommand: " + value.toString());
    		return 0;
    	}
    	return value;
    }
}