package commands;

public abstract class OneInputCommand extends Command {
    public double myParameterOne;
    
    public OneInputCommand(){
        
    }
    
    public int getNumParameter(){
        return 1;
    }
    
    public void setParameters(double parameterOne){
        myParameterOne = parameterOne;
    }
}