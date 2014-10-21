package commands;

import model.Model;

public class SetPositionCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
       return model.setXAndY(myParameterOne.executeCommand(model), myParameterTwo.executeCommand(model));
    }
}