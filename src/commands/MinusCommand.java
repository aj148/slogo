package commands;

import model.Model;


public class MinusCommand extends OneInputCommand {
	/**
	 * returns a negative of the execution of whatever type of command is put through
	 * 
	 * @author team14
	 *
	 */
    @Override
    public double executeCommand (Model model) {
        return -myParameters[0].executeCommand(model);
    }
}
