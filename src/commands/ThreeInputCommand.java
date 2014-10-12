package commands;

public abstract class ThreeInputCommand extends Command {
    
    public Command myParameterOne;
    public Command myParameterTwo;
    public Command myParameterThree;
    
    public void setParameters(Command parameterOne, Command parameterTwo, Command parameterThree){
        myParameterOne = parameterOne;
        myParameterTwo = parameterTwo;
        myParameterThree = parameterThree;
    }
    
    @Override
    public int getNumParameters(){
        return 3;
    }
}