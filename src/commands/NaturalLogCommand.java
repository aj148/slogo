package commands;
import model.Model;


public class NaturalLogCommand extends OneInputCommand {
    
    @Override
    public double executeCommand(Model model) {
    	Double value = Math.log(myParameterOne.executeCommand(null));
    	if(value.toString().equals("NaN") || value.toString().equals("-Infinity")){
    		System.out.println("Problem in NaturalLogCommand: " + value.toString());
    		return 0;
    	}
    	return value;
    }
}