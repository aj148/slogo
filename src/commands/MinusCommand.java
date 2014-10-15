package commands;

public class MinusCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
        return -myParameterOne.executeCommand();
    }
}