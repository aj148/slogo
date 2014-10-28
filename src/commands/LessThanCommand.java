package commands;

import model.Model;


/**
 * returns 1 if the value of expr1 is strictly less than the value of expr2, otherwise 0
 * 
 * @author team14
 */
public class LessThanCommand extends TwoInputCommand {

    @Override
    public double executeCommand (Model model) {
        return (myParameters[0].executeCommand(model) < myParameters[1].executeCommand(model)) ? 1
                                                                                              : 0;
    }
}
