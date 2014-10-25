package commands;

import model.Model;

public class NotEqualCommand extends TwoInputCommand {

<<<<<<< HEAD
    @Override
    public double executeCommand () {
        return (myParameterOne == myParameterTwo) ? 0 : 1;
    }
=======
	@Override
	public double executeCommand(Model model) {
		return (myParameterOne.executeCommand(model) == myParameterTwo.executeCommand(model)) ? 0 : 1;
	}
>>>>>>> origin/backend
}