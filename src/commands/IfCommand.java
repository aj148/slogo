package commands;

import model.Model;


public class IfCommand extends TwoInputCommand {

    @Override
    public double executeCommand (Model model) {
        IfElseCommand condition = new IfElseCommand();
        Command[] parameters = { myParameters[0], myParameters[1], new ConstantCommand(0) };
        condition.setParameters(parameters);
        return condition.executeCommand(model);
    }
}
