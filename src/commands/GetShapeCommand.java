package commands;

import model.Model;


/**
 * This class returns turtle's current shape index
 * 
 * @author team14
 *
 */
public class GetShapeCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        return getFirstTurtle(model).getShape();
    }
}
