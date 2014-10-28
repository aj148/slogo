package commands;

import model.Model;


public class OrCommand extends TwoInputCommand {

    @Override
    public double executeCommand (Model model) {
        return (myParameters[0].executeCommand(model) != 0 || myParameters[1].executeCommand(model) != 0) ? 0
                                                                                                         : 1;
    }
}
