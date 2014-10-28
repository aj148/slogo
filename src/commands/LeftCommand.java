package commands;

import model.Model;
import model.Turtle;


public class LeftCommand extends OneInputCommand {

    @Override
    public double updateTurtle (Model model, Turtle a) {
        return -1 * a.updateHeading(-myParameters[0].executeCommand(model));
    }
}
