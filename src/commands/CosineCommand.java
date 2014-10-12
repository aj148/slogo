package commands;

public class CosineCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
        return Math.cos(myParameterOne);
    }
}