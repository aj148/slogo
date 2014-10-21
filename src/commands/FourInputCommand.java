package commands;

public abstract class FourInputCommand extends Command {
    
    public Command myParameterOne;
    public Command myParameterTwo;
    public Command myParameterThree;
    public Command myParameterFour;
    
//    public FourInputCommand(Command parameterOne, Command parameterTwo, Command parameterThree, Command parameterFour){
//    	myParameterOne = parameterOne;
//        myParameterTwo = parameterTwo;
//        myParameterThree = parameterThree;
//        myParameterFour = parameterFour;
//    }
    
    public void setParameters(Command parameterOne, Command parameterTwo, Command parameterThree, Command parameterFour){
        myParameterOne = parameterOne;
        myParameterTwo = parameterTwo;
        myParameterThree = parameterThree;
        myParameterFour = parameterFour;
    }
    
    @Override
    public int getNumParameters(){
        return 4;
    }
}