package commands;

import model.Model;


public class QuotientCommand extends TwoInputCommand {
	/**
	 * returns the quotient of the values assigned to the two parameters
	 * 
	 * @author team14
	 *
	 */
    @Override
    public double executeCommand (Model model) {
        try {
            return myParameters[0].executeCommand(model) / myParameters[1].executeCommand(model);
        }
        catch (ArithmeticException e) {
            System.out.println("Exception caught in QuotientCommand: DIVIDE BY ZERO");
            return 0;
        }
    }
}
