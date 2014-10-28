package commands;

import model.Model;
import model.Turtle;


/**
 * Backward command class - moves turtle backward in its current heading by pixels distance
 *                          returns the value of pixels
 * 
 * @author team14
 *
 */
public class BackwardCommand extends OneInputCommand {

    @Override
    public double updateTurtle (Model model, Turtle a) {
        return a.updatePosition(-myParameters[0].executeCommand(model));
    }
}
