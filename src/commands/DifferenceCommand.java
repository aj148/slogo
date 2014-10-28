package commands;

import model.Model;


/**
 * This class returns difference of the values of expr1 and expr2
 * 
 * @author team14
 *
 */
public class DifferenceCommand extends TwoInputCommand {

    @Override
    public double executeCommand (Model model) {
        return myParameters[0].executeCommand(model) - myParameters[1].executeCommand(model);
    }
}
