package commands;

public class PowerCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand() {
        return Math.pow(myParameterOne, myParameterTwo);
    }
}