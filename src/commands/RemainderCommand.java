package commands;

import model.Model;

public class RemainderCommand extends TwoInputCommand {
	/**
	 * returns the remainder of paramOne divided by Parameter two
	 * 
	 * @author team14
	 *
	 */
	@Override
	public double executeCommand(Model model) {
		try {
			return myParameters[0].executeCommand(model)
					% myParameters[1].executeCommand(model);
		} catch (ArithmeticException e) {
			System.out
					.println("Exception caught in RemainderCommand: DIVIDE BY ZERO");
			return 0;
		}
	}
}
