package commands;

public class ArcTangentCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
        return Math.atan(myParameterOne);
    }
}