package commands;

import model.Model;

public class IsPenDownCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
		return getFirstTurtle(model).getPenStatus();
    }
}