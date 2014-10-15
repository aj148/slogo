package commands;

public class RemainderCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand() {
    	try{
    		return myParameterOne.executeCommand() % myParameterTwo.executeCommand();
    	}
        catch(ArithmeticException e){
        	System.out.println("Exception caught in RemainderCommand: DIVIDE BY ZERO");
    		return 0;
        }
    }
}