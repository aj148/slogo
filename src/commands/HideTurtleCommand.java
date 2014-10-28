package commands;

import model.Model;
import model.Turtle;


public class HideTurtleCommand extends ZeroInputCommand {

    @Override
    public double updateTurtle (Model model, Turtle a) {
        return a.changeVisibility(0.0);
    }
}
