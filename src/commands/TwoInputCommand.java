package commands;

public abstract class TwoInputCommand extends Command {
    
    public double myParameterOne;
    public double myParameterTwo;
    
    public void setParameters(double parameterOne, double parameterTwo){
        myParameterOne = parameterOne;
        myParameterTwo = parameterTwo;
    }
    
    @Override
    public int getNumParameters(){
        return 2;
    }
}