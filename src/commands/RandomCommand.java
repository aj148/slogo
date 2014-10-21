package commands;

import model.Model;
import controller.MasterController;

public class RandomCommand extends OneInputCommand {
    
    @Override
    public double executeCommand(Model model) {
    	try{
    		return (double)MasterController.myRandom.nextInt((int)myParameterOne.executeCommand(model));
    	}
    	catch(IllegalArgumentException e){
    		System.out.println("Exception caught in RandomCommand: ZERO OR LESS");
    		return 0;
    	}
    }
}