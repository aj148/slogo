package commands;

import model.Model;


public class ArcTangentCommand extends OneInputCommand {

    @Override
    public double executeCommand (Model model) {
        return Math.atan(myParameters[0].executeCommand(model));
    }
}
