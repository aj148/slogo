package commands;

import model.Model;


/**
 * This class returns cosine of degrees
 * 
 * @author team14
 *
 */
public class CosineCommand extends OneInputCommand {

    @Override
    public double executeCommand (Model model) {
        return Math.cos(myParameters[0].executeCommand(model));
    }
}
