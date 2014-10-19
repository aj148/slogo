package commands;

import model.Turtle;

public class TangentCommand extends OneInputCommand {
    
    @Override
    public double executeCommand(Turtle turtle) {
    	try{
    		return Math.tan(myParameterOne.executeCommand(turtle));
    	}
    	catch(ArithmeticException e){
    		System.out.println("Exception caught in TangentCommand: DIVIDE BY ZERO");
    		return 0;
    	}
    }
}