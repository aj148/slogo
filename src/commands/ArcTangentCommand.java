package commands;

import model.Model;


/**
 * Arc Tangent command class - executing returns arc tangent of degrees
 * 
 * @author team14
 */
public class ArcTangentCommand extends OneInputCommand {

    @Override
    public double executeCommand (Model model) {
        return Math.atan(myParameters[0].executeCommand(model));
    }
}
