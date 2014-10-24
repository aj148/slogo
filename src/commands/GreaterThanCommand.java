package commands;

public class GreaterThanCommand extends TwoInputCommand {

    @Override
    public double executeCommand () {
        return (myParameterOne > myParameterTwo) ? 1 : 0;
    }
}