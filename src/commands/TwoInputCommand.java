package commands;

public abstract class TwoInputCommand extends Command {
    
    public Command myParameterOne;
    public Command myParameterTwo;
    
//    public TwoInputCommand(Command parameterOne, Command parameterTwo){
//    	myParameterOne = parameterOne;
//    	myParameterTwo = parameterTwo;
//    }
    
    public void setParameters(Command parameterOne, Command parameterTwo){
        myParameterOne = parameterOne;
        myParameterTwo = parameterTwo;
    }
    
    @Override
    public int getNumParameters(){
        return 2;
    }
    
    public Command getParameterOne(){
        return myParameterOne;
    }
    public Command getParameterTwo(){
        return myParameterTwo;
    }
}