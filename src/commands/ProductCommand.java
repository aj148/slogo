package commands;

public class ProductCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand() {
        return myParameterOne * myParameterTwo;
    }
}