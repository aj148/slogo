package commands;

import model.Turtle;

public class RemainderCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand(Turtle turtle) {
    	try{
    		return myParameterOne.executeCommand(turtle) % myParameterTwo.executeCommand(turtle);
    	}
        catch(ArithmeticException e){
        	System.out.println("Exception caught in RemainderCommand: DIVIDE BY ZERO");
    		return 0;
        }
    }
}