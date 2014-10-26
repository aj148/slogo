package commands;

import model.Model;

public class ErrorCommand extends ZeroInputCommand {

    private String myError;

    public ErrorCommand (String error) {
        myError = error;
    }

    @Override
    public double executeCommand (Model model) {
        return 0;
    }

    public String showError () {
        return myError;
    }
}