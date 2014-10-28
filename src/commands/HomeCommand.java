package commands;

import model.Model;
import model.Turtle;


public class HomeCommand extends ZeroInputCommand {

    @Override
    public double updateTurtle (Model model, Turtle a) {
        a.setHeading(0.0);
        return a.setXAndY(0.0, 0.0);
    }
}
