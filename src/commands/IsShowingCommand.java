package commands;

import model.Model;


/**
 * This class returns 1 if turtle is showing, 0 if it is hiding
 * 
 * @author team14
 *
 */
public class IsShowingCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        return getFirstTurtle(model).changeVisibility(-1.0);
    }
}
