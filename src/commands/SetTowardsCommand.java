package commands;

import model.Model;
import model.Turtle;

public class SetTowardsCommand extends TwoInputCommand {

    @Override
    public double updateTurtle (Model model, Turtle a) {
        return a.towards(myParameters[0].executeCommand(model),
                myParameters[1].executeCommand(model));
    }
}