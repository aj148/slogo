package commands;

import model.Model;


/**
 * if expr is not 0, runs the trueCommands given in the first list, 
 * otherwise runs the falseCommands given in the second list
 * returns the value of the final command executed
 * 
 * @author team14
 *
 */
public class IfElseCommand extends ThreeInputCommand {

    @Override
    public double executeCommand (Model model) {
        if (myParameters[0].executeCommand(model) != 0) { return myParameters[1]
                .executeCommand(model); 
        }
        return myParameters[2].executeCommand(model);
    }
}
