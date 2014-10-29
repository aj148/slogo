package commands;

import model.Model;


public class XCoordinateCommand extends ZeroInputCommand {
	/**
	 * a command representing an x coordinate, used for numerical ease
	 *
	 */
    @Override
    public double executeCommand (Model model) {
        return getFirstTurtle(model).getNewLocation().getX();
    }
}
