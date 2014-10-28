package commands;

import model.Model;


/**
 * if expr is not 0, runs the commands given in the list
 * returns the value of the final command executed
 * 
 * @author team14
 *
 */
public class IfCommand extends TwoInputCommand {

    @Override
    public double executeCommand (Model model) {
        IfElseCommand condition = new IfElseCommand();
        Command[] parameters = { myParameters[0], myParameters[1], new ConstantCommand(0) };
        condition.setParameters(parameters);
        return condition.executeCommand(model);
    }
}
