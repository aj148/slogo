package commands;

import model.Model;

public class XCoordinateCommand extends ZeroInputCommand {
	
    @Override
    public double executeCommand(Model model) {
		return getFirstTurtle(model).getNewLocation().getX();
	}
}