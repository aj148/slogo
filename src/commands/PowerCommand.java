package commands;

import model.Model;


public class PowerCommand extends TwoInputCommand {

    @Override
    public double executeCommand (Model model) {
        return Math.pow(myParameters[0].executeCommand(model),
                        myParameters[1].executeCommand(model));
    }
}
