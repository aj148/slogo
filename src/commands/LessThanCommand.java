package commands;

public class LessThanCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand() {
        if(myParameterOne < myParameterTwo){
            return 1;
        }
        return 0;
    }
}