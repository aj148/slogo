package commands;

public class QuotientCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand() {
    	try{
    		return myParameterOne.executeCommand() / myParameterTwo.executeCommand();
    	}
    	catch(ArithmeticException e){
    		System.out.println("Exception caught in QuotientCommand: DIVIDE BY ZERO");
    		return 0;
    	}
    }
}