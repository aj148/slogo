package commands;
import model.Model;


public class QuotientCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand(Model model) {
    	try{
    		return myParameterOne.executeCommand(null) / myParameterTwo.executeCommand(null);
    	}
    	catch(ArithmeticException e){
    		System.out.println("Exception caught in QuotientCommand: DIVIDE BY ZERO");
    		return 0;
    	}
    }
}