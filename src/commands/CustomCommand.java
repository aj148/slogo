package commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Model;
import model.VariableManager;


public class CustomCommand extends OneInputCommand {

    private List<String> myVariables;
    private ListCommand myCommands;

    public CustomCommand (List<String> variables, ListCommand commands) {
        myVariables = variables;
        myCommands = commands;
    }

    @Override
    public double executeCommand (Model model) {
        Map<String, Double> variableMap = new HashMap<String, Double>();
        if (!myParameters[0].getClassName().equals("commands.ListCommand")) { return 0; }
        ListCommand variableValues = (ListCommand) myParameters[0];
        for (int i = 0; i < variableValues.getNumParameters(); i++) {
            double value = variableValues.getParameter(i).executeCommand(model);
            if (i < myVariables.size()) {
                variableMap.put(myVariables.get(i), value);
            }
        }
        VariableManager temp = model.getVariableManager();
        temp.addVariableMap(variableMap);
        double value = myCommands.executeCommand(model);
        temp.reduceVariableScope();
        return value;
    }
}
