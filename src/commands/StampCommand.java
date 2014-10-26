package commands;

import model.Model;

public class StampCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        return model.setStamp(1.0);
    }
}