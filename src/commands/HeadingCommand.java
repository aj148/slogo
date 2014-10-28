package commands;

import model.Model;


/**
 * This class returns the turtle's heading in degrees
 * 
 * @author team14
 *
 */
public class HeadingCommand extends Command {

    @Override
    public double executeCommand (Model model) {
        return getFirstTurtle(model).getHeading();
    }
}
