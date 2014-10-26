package commands;

import model.Model;

public class IsShowingCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        return getFirstTurtle(model).changeVisibility(-1.0);
    }
}