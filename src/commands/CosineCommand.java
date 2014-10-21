package commands;

import model.Model;

public class CosineCommand extends OneInputCommand {
    
    @Override
    public double executeCommand(Model model) {
        return Math.cos(myParameterOne.executeCommand(model));
    }
}