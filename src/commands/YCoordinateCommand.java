package commands;

import model.Model;

public class YCoordinateCommand extends ZeroInputCommand {
    
    @Override
    public double executeCommand (Model model) {
        return model.getXOrY(1);
    }
}