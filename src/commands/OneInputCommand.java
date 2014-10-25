package commands;

public abstract class OneInputCommand extends Command {

	
    public Command myParameterOne;
    
//    public OneInputCommand(Command parameterOne){
//    	myParameterOne = parameterOne;
//    }
    
    public void setParameters(Command parameterOne){
        myParameterOne = parameterOne;
    }

    @Override
    public int getNumParameters () {
        return 1;
    }
    
    public Command getParamerter(){
        return myParameterOne;
    }
}