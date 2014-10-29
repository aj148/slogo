package commands;

import model.Model;


public class PiCommand extends ZeroInputCommand {
	/**
	 * command that evaluates to 3.141592...
	 * 
	 * @author team14
	 *
	 */
    @Override
    public double executeCommand (Model model) {
        return Math.PI;
    }
}
