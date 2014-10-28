package commands;

import model.Model;


/**
 * Ask command class - tell turtles given in first list to run commands given in the second list 
 *                     returns result of last command run
 * 
 * @author team 14
 *
 */
public class AskCommand extends TwoInputCommand {

    @Override
    public double executeCommand (Model model) {
        int currentStackLength = model.getTurtleManager().getStackLength();
        TellCommand a = new TellCommand();
        a.setParameters(myParameters);
        a.executeCommand(model);
        double toReturn = myParameters[1].executeCommand(model);
        model.getTurtleManager().regulateTurtleDepth(currentStackLength);
        // same call on variables?
        return toReturn;
    }
}
