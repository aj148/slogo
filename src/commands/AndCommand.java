package commands;

public class AndCommand extends TwoInputCommand {

    @Override
    public double executeCommand () {
        return (myParameterOne == 0 && myParameterTwo == 0) ? 1 : 0;
    }
}