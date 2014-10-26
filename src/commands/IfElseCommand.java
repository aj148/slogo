package commands;

import model.Model;

public class IfElseCommand extends ThreeInputCommand {

    @Override
    public double executeCommand (Model model) {
        if (myParameters[0].executeCommand(model) != 0) {
            return myParameters[1].executeCommand(model);
        }
        return myParameters[2].executeCommand(model);
    }
}