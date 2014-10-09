package commands;

public class QuotientCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand() {
        return myParameterOne / myParameterTwo;
        // Beware of DIVIDE BY ZERO errors.
        // That's an ArithmeticException.
    }
}