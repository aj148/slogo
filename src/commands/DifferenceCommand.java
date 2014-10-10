package commands;

public class DifferenceCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand() {
        return myParameterOne - myParameterTwo;
    }
}