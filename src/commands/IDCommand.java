package commands;

import model.Model;


/**
 * This class returns tutle's id
 * 
 * @author team14
 *
 */
public class IDCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        return getFirstTurtle(model).getID();
    }
}
