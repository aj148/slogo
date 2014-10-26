package commands;

import model.Model;

public class ClearStampsCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        return model.setStamp(-1.0);
    }
}