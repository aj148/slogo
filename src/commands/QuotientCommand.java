package commands;

import model.Turtle;

public class QuotientCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand(Turtle turtle) {
    	try{
    		return myParameterOne.executeCommand(turtle) / myParameterTwo.executeCommand(turtle);
    	}
    	catch(ArithmeticException e){
    		System.out.println("Exception caught in QuotientCommand: DIVIDE BY ZERO");
    		return 0;
    	}
    }
}