package commands;

public class TangentCommand extends OneInputCommand {

    @Override
    public double executeCommand () {
        return Math.tan(myParameterOne);
        // Beware of DIVIDE BY ZERO errors. impossible to divide by 0 in this
        // class so... False! It is!
    }
}