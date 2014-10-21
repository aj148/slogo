package commands;
import model.Model;


public class PowerCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand(Model model) {
        return Math.pow(myParameterOne.executeCommand(null), myParameterTwo.executeCommand(null));
    }
}