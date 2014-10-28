package commands;

import model.Model;


/**
 * Clear Stamps command class - remove all stamps that have been made
 *                              returns 1 if there were any stamps to clear, 0 otherwise
 * 
 * @author team14
 *
 */
public class ClearStampsCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        return model.setStamp(-1.0);
    }
}
