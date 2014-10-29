package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class VariableManager {
	/**
	 * Class used to manage variables and scope
	 */
    private Map<String, Double> myGlobalVariables;
    private Stack<Map<String, Double>> myLocalVariables;

    public VariableManager () {
        myGlobalVariables = new HashMap<String, Double>();
        myLocalVariables = new Stack<Map<String, Double>>();
    }
    /**
	 * Method to add a map to the stack.
	 *
	 * @param newMap
	 *            : map to be added to the stack.
	 */
    public void addVariableMap (Map<String, Double> newMap) {
        myLocalVariables.add(newMap);
    }
    /**
	 * Method to reduce the length of the stack by one to reduce scope
	 */
    public void reduceVariableScope () {
        if (!myLocalVariables.isEmpty()) {
            myLocalVariables.pop();
        }
    }
    /**
	 * Method to get the global variables.
	 */
    public Map<String, Double> getGlobalVariables () {
        return myGlobalVariables;
    }
    /**
	 * Method to get the local variables only.
	 */
    public Map<String, Double> getLocalVariables () {
        return myLocalVariables.lastElement();
    }
    /**
	 * Method to add a global variable.
	 *
	 * @param varName, varValue
	 *            : String and double corresponding to variable and its value.
	 */
    public void addGlobalVariable (String varName, double varValue) {
        myGlobalVariables.put(varName, varValue);
    }
    /**
	 * same as above, but for local variables
	 */
    public void addLocalVariable (String varName, double varValue) {
        Map<String, Double> currentVariables = myLocalVariables.pop();
        currentVariables.put(varName, varValue);
        myLocalVariables.add(currentVariables);
    }

    public int getVariableScope () {
        return myLocalVariables.size();
    }
}
