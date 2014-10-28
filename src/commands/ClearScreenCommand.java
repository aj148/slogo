package commands;

import model.Model;


/**
 * Clear Screen command class - erases turtle's trails and sends it to the home position
 *                              returns the distance turtle moved
 * 
 * @author team14
 *
 */
public class ClearScreenCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {

        Command a = new HomeCommand();
        return a.executeCommand(model);
    }
}
