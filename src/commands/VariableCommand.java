package commands;

import java.util.Map;
import model.Model;
import model.VariableManager;

public class VariableCommand extends ZeroInputCommand {
	/**
	 * used to create new variable commands
	 *
	 */
	private String myParameter;

	public VariableCommand(String parameter) {
		myParameter = parameter;
	}

	/**
	 * returns the naem of the variable, as in what string is used to represent
	 * the value
	 */
	public String getVariableName() {
		return myParameter;
	}

	/**
	 * returns 0, actually does the work of setting variables in the manager
	 * param@ model : Model that is the model of the entire project
	 *
	 */
	@Override
	public double executeCommand(Model model) {
		VariableManager temp = model.getVariableManager();
		Map<String, Double> variables;
		if (temp.getVariableScope() > 0) {
			variables = temp.getLocalVariables();
			if (variables.containsKey(myParameter)) {
				return variables.get(myParameter);
			}
		}
		variables = temp.getGlobalVariables();
		if (variables.containsKey(myParameter)) {
			return variables.get(myParameter);
		}
		System.out.println("Variable " + myParameter + " not yet initiated.");
		return 0;
	}
}
