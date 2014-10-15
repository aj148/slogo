package commands;

public class TangentCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
    	try{
    		return Math.tan(myParameterOne.executeCommand());
    	}
    	catch(ArithmeticException e){
    		System.out.println("Exception caught in TangentCommand: DIVIDE BY ZERO");
    		return 0;
    	}
    }
}