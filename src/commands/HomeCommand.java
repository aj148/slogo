package commands;

import model.Model;
import model.Turtle;


/**
 * This class moves turtle to the center of the screen (0 0)
 * returns the distance turtle moved
 * 
 * @author team14
 *
 */
public class HomeCommand extends ZeroInputCommand {

    @Override
    public double updateTurtle (Model model, Turtle a) {
        a.setHeading(0.0);
        return a.setXAndY(0.0, 0.0);
    }
}
