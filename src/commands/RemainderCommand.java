package commands;

import model.Model;

public class RemainderCommand extends TwoInputCommand {

    @Override
    public double executeCommand(Model model) {
    	try{
    		return myParameters[0].executeCommand(model) % myParameters[1].executeCommand(model);
    	}
        catch(ArithmeticException e){
        	System.out.println("Exception caught in RemainderCommand: DIVIDE BY ZERO");
    		return 0;
        }
    }
}