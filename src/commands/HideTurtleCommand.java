package commands;

import model.Model;
import model.Turtle;


/**
 * This class makes turtle invisible
 * returns 0
 * 
 * @author team14
 *
 */
public class HideTurtleCommand extends ZeroInputCommand {

    @Override
    public double updateTurtle (Model model, Turtle a) {
        return a.changeVisibility(0.0);
    }
}
