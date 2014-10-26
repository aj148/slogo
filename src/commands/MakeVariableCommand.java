package commands;

import model.Model;
import model.VariableManager;

public class MakeVariableCommand extends TwoInputCommand {

    @Override
    public double executeCommand (Model model) {
        double value = myParameters[1].executeCommand(model);
        try {
            VariableCommand variable = (VariableCommand) myParameters[0];
            String variableName = variable.getVariableName();
            VariableManager temp = model.getVariableManager();
            temp.addGlobalVariable(variableName, value);
        } catch (ClassCastException e) {
            System.out.println("Exception caught in MakeVariableCommand: CLASS CAST EXCEPTION");
            return 0;
        }
        return value;
    }
}