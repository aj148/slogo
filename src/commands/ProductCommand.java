package commands;

import model.Model;

public class ProductCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand(Model model) {
        return myParameterOne.executeCommand(model) * myParameterTwo.executeCommand(model);
    }
}