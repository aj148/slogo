package commands;

public class EqualCommand extends TwoInputCommand {

    @Override
    public double executeCommand () {
        return (myParameterOne == myParameterTwo) ? 1 : 0;
    }
}