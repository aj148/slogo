package commands;

import model.Model;


/**
 * This class returns a string that indicates the type of error in the user input.
 * 
 * @author team14
 *
 */
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
