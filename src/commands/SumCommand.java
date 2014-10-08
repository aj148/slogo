package commands;

public class SumCommand extends NonTurtleCommand implements TwoInputCommand {
    
    private double myParameterOne;
    private double myParameterTwo;
    
    @Override
    public void setParameters(double parameterOne, double parameterTwo) {
        myParameterOne = parameterOne;
        myParameterTwo = parameterTwo;
    }

    @Override
    public double executeCommand() {
        return myParameterOne + myParameterTwo;
    }

    @Override
    public int getNumParameters() {
        return 2;
    }
}