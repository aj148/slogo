package commands;

public class GreaterThanCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand() {
        if(myParameterOne > myParameterTwo){
            return 1;
        }
        return 0;
    }
}