package commands;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import controller.MasterController;


public class MakeUserInstructionCommand extends ThreeInputCommand {
	/**
	 * makes command based on instruction of user
	 * 
	 * @author team14
	 *
	 */
    private static String VARIABLE_COMMAND = "commands.VariableCommand";
    private static String LIST_COMMAND = "commands.ListCommand";

    @Override
    public double executeCommand (Model model) {
        List<String> variables = new ArrayList<String>();
        if (!myParameters[0].getClassName().equals(VARIABLE_COMMAND)
            || !myParameters[1].getClassName().equals(LIST_COMMAND)
            || !myParameters[2].getClassName().equals(LIST_COMMAND)) { return 0; }
        VariableCommand commandName = (VariableCommand)myParameters[0];
        ListCommand variableNames = (ListCommand)myParameters[1];
        for (int i = 0; i < variableNames.getNumParameters(); i++) {
            if (!variableNames.getParameter(i).getClassName().equals(VARIABLE_COMMAND)) { return 0; }
            variables.add(((VariableCommand)variableNames.getParameter(i)).getVariableName());
        }
        CustomCommand userCommand = new CustomCommand(variables, (ListCommand)myParameters[2]);
        MasterController.myParser.addUserInputCommand(commandName.getVariableName(), userCommand);
        return 1;
    }
}
