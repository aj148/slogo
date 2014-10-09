package commands;

public class NaturalLogCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
        return Math.log(myParameterOne);
    }
}