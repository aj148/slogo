package commands;

import model.Model;

public class SetBackgroundCommand extends ThreeInputCommand {

    @Override
    public double executeCommand (Model model) {
        double red = myParameters[0].executeCommand(model);
        double green = myParameters[1].executeCommand(model);
        double blue = myParameters[2].executeCommand(model);
        return model.setBackgroundColor(red, green, blue);
    }
}