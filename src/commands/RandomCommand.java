package commands;

import controller.MasterController;

public class RandomCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
        return (double)MasterController.myRandom.nextInt((int)myParameterOne);
    }
}