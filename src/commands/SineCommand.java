package commands;

public class SineCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
        return Math.sin(myParameterOne);
    }
}