package commands;

public class AndCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand() {
        if(myParameterOne == 0 || myParameterTwo == 0){
            return 0;
        }
        return 1;
    }
}