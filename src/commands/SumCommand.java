package commands;

import model.Model;

public class SumCommand extends TwoInputCommand {

    @Override
    public double executeCommand(Model model) {
        return myParameterOne.executeCommand(model) + myParameterTwo.executeCommand(model);
    }
}