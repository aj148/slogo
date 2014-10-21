package commands;

import model.Model;

public class IsShowingCommand extends ZeroInputCommand {
    
    @Override
    public double executeCommand(Model model) {
        return model.changeVisibility(-1.0);
    }
}