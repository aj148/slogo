package commands;

import model.Model;


public class ProductCommand extends TwoInputCommand {
	/**
	 * returns the product of the execution of the two commands
	 * 
	 * @author team14
	 *
	 */
    @Override
    public double executeCommand (Model model) {
        return myParameters[0].executeCommand(model) * myParameters[1].executeCommand(model);
    }
}
