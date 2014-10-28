package commands;

import model.Model;


public class IDCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        return getFirstTurtle(model).getID();
    }
}
