package commands;

public class RemainderCommand extends TwoInputCommand {

    @Override
    public double executeCommand () {
        return myParameterOne % myParameterTwo;
        // Beware of DIVIDE BY ZERO errors. if parametertwo is zero you'll get
        // an error
    }
}