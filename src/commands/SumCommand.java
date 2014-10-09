package commands;

public class SumCommand extends TwoInputCommand implements NonTurtleCommand {

    @Override
    public double executeCommand() {
        return myParameterOne + myParameterTwo;
    }
}