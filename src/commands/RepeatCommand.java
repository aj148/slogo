package commands;

import model.Model;


public class RepeatCommand extends TwoInputCommand {

    @Override
    public double executeCommand (Model model) {
        int limit = (int) myParameters[0].executeCommand(model);
        double finalEx = 0;
        for (int i = 0; i < limit; i++) {
            finalEx = myParameters[1].executeCommand(model);
        }
        return finalEx;
    }
}
