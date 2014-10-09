package commands;

public class NotCommand extends OneInputCommand {
    
    @Override
    public double executeCommand() {
        if(myParameterOne != 0){
            return 0;
        }
        return 1;
    }
}