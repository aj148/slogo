package commands;

public abstract class OneInputCommand extends Command {

    public double myParameterOne;

    public void setParameters (double parameterOne) {
        myParameterOne = parameterOne;
    }

    @Override
    public int getNumParameters () {
        return 1;
    }
}