package commands;

import model.Model;
import model.Turtle;

public class SetShapeCommand extends OneInputCommand {

    @Override
    public double updateTurtle (Model model, Turtle a) {
        return a.setShape(myParameters[0].executeCommand(model));
    }
}