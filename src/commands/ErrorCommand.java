package commands;

public class ErrorCommand extends ZeroInputCommand {

    private String myErrorMessage;

    public ErrorCommand (String errorMessage) {
        myErrorMessage = errorMessage;
    }

    public String displayMessage () {
        return myErrorMessage;
    }
}