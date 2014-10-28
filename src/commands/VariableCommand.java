package commands;

import java.util.Map;
import model.Model;
import model.VariableManager;


public class VariableCommand extends ZeroInputCommand {

    private String myParameter;

    public VariableCommand (String parameter) {
        myParameter = parameter;
    }

    public String getVariableName () {
        return myParameter;
    }

    @Override
    public double executeCommand (Model model) {
        VariableManager temp = model.getVariableManager();
        Map<String, Double> variables;
        if (temp.getVariableScope() > 0) {
            variables = temp.getLocalVariables();
            if (variables.containsKey(myParameter)) { return variables.get(myParameter); }
        }
        variables = temp.getGlobalVariables();
        if (variables.containsKey(myParameter)) { return variables.get(myParameter); }
        System.out.println("Variable " + myParameter + " not yet initiated.");
        return 0;
    }
}
