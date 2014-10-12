package commands;

public abstract class TwoInputCommand extends Command {
    
    public Command myParameterOne;
    public Command myParameterTwo;
    
    public void setParameters(Command parameterOne, Command parameterTwo){
        myParameterOne = parameterOne;
        myParameterTwo = parameterTwo;
    }
    
    @Override
    public int getNumParameters(){
        return 2;
    }
}