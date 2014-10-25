package commands;

public abstract class ThreeInputCommand extends Command {

    
    public Command myParameterOne;
    public Command myParameterTwo;
    public Command myParameterThree;
    
//    public ThreeInputCommand(Command parameterOne, Command parameterTwo, Command parameterThree){
//    	myParameterOne = parameterOne;
//        myParameterTwo = parameterTwo;
//        myParameterThree = parameterThree;
//    }
    
    public void setParameters(Command parameterOne, Command parameterTwo, Command parameterThree){
        myParameterOne = parameterOne;
        myParameterTwo = parameterTwo;
        myParameterThree = parameterThree;
    }

    @Override
    public int getNumParameters () {
        return 3;
    }
}