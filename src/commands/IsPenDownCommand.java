package commands;

import model.Model;


/**
 * This class returns 1 if turtle's pen is down, 0 if it is up
 * 
 * @author team14
 *
 */
public class IsPenDownCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        return getFirstTurtle(model).getPenStatus();
    }
}
