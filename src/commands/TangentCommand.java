package commands;

public class TangentCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
        return Math.tan(myParameterOne);
        // Beware of DIVIDE BY ZERO errors.
    }
}