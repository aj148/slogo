package commands;

import model.Model;


public class TangentCommand extends OneInputCommand {

    @Override
    public double executeCommand (Model model) {
        try {
            return Math.tan(myParameters[0].executeCommand(model));
        }
        catch (ArithmeticException e) {
            System.out.println("Exception caught in TangentCommand: DIVIDE BY ZERO");
            return 0;
        }
    }
}
