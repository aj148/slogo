package commands;

import model.Model;


/**
 * And command class - returns 1 if test1 and test2 are non-zero, otherwise 0
 * 
 * @author team14
 */
public class AndCommand extends TwoInputCommand {

    @Override
    public double executeCommand (Model model) {
        return (myParameters[0].executeCommand(model) == 0 && myParameters[1].executeCommand(model) == 0) ? 1
                                                                                                         : 0;
    }
}
