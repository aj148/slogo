package commands;

public abstract class TwoInputCommand extends Command {
    public double myParameterOne;
    public double myParameterTwo;
    
    public TwoInputCommand(){
        
    }
    
    public int getNumParameter(){
        return 2;
    }
    
    public void setParameters(double parameterOne, double parameterTwo){
        myParameterOne = parameterOne;
        myParameterTwo = parameterTwo;
    }
}