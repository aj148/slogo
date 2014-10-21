package commands;
import model.Model;


public class IsPenDownCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        return turtle.changePen(-1.0);
    }
}