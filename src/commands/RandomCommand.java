package commands;

import model.Turtle;
import controller.MasterController;

public class RandomCommand extends OneInputCommand {
    
    @Override
    public double executeCommand(Turtle turtle) {
    	try{
    		return (double)MasterController.myRandom.nextInt((int)myParameterOne.executeCommand(turtle));
    	}
    	catch(IllegalArgumentException e){
    		System.out.println("Exception caught in RandomCommand: ZERO OR LESS");
    		return 0;
    	}
    }
}