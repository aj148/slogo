package commands;

import model.Model;

public class RemainderCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand(Model model) {
    	try{
    		return myParameterOne.executeCommand(model) % myParameterTwo.executeCommand(model);
    	}
        catch(ArithmeticException e){
        	System.out.println("Exception caught in RemainderCommand: DIVIDE BY ZERO");
    		return 0;
        }
    }
}