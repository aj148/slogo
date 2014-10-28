package commands;

import model.Model;
import model.Turtle;


/**
 * This class moves turtle forward in its current heading by pixels distance 
 * returns the value of pixels
 * 
 * @author minkwonlee
 *
 */
public class ForwardCommand extends OneInputCommand {

    @Override
    public double updateTurtle (Model model, Turtle a) {
        return a.updatePosition(myParameters[0].executeCommand(model));
    }
}
