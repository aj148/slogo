package commands;

import model.Model;

public class SumCommand extends TwoInputCommand {

    @Override
    public double executeCommand (Model model) {
        return myParameters[0].executeCommand(model) + myParameters[1].executeCommand(model);
    }
}