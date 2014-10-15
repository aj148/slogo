package commands;

import controller.MasterController;

public class RandomCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
    	try{
    		return (double)MasterController.myRandom.nextInt((int)myParameterOne.executeCommand());
    	}
    	catch(IllegalArgumentException e){
    		System.out.println("Exception caught in RandomCommand: ZERO OR LESS");
    		return 0;
    	}
    }
}