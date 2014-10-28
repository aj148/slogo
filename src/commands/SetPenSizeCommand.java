package commands;

import model.Model;
import model.Turtle;


public class SetPenSizeCommand extends OneInputCommand {

    @Override
    public double updateTurtle (Model model, Turtle a) {
        return a.setPenSize(myParameters[0].executeCommand(model));
    }
}
