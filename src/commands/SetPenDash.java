package commands;

import model.Model;
import model.Turtle;

public class SetPenDash extends OneInputCommand {
    @Override
    public double updateTurtle(Model model, Turtle a) {
        return a.setPenDash(myParameters[0].executeCommand(model));
    }
}
