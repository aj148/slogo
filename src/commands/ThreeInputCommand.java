package commands;

public abstract class ThreeInputCommand extends Command {

    public double myParameterOne;
    public double myParameterTwo;
    public double myParameterThree;

    public void setParameters (double parameterOne, double parameterTwo, double parameterThree) {
        myParameterOne = parameterOne;
        myParameterTwo = parameterTwo;
        myParameterThree = parameterThree;
    }

    @Override
    public int getNumParameters () {
        return 3;
    }
}