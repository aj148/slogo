package commands;

public class SumCommand extends TwoInputCommand {

    @Override
    public double executeCommand() {
        return myParameterOne.executeCommand() + myParameterTwo.executeCommand();
    }
}