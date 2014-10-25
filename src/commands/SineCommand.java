package commands;

import model.Model;

public class SineCommand extends OneInputCommand {

    @Override
    public double executeCommand(Model model) {
        return Math.sin(myParameterOne.executeCommand(model));
    }
}