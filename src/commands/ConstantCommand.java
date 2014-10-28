package commands;

import model.Model;


/**
 * This class turns a number(constant) into a command object
 * 
 * @author team14
 *
 */
public class ConstantCommand extends ZeroInputCommand {

    private double myConstant;

    public ConstantCommand (double parameter) {
        myConstant = parameter;
    }

    @Override
    public double executeCommand (Model model) {
        return myConstant;
    }
}
