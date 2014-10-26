package commands;

import model.Model;

public class PiCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        return Math.PI;
    }
}