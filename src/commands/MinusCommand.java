package commands;
import model.Model;


public class MinusCommand extends OneInputCommand {
    
    @Override
    public double executeCommand(Model model) {
        return -myParameterOne.executeCommand(null);
    }
}