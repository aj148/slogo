package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class VariableManager {

    private Map<String, Double> myGlobalVariables;
    private Stack<Map<String, Double>> myLocalVariables;

    public VariableManager () {
        myGlobalVariables = new HashMap<String, Double>();
        myLocalVariables = new Stack<Map<String, Double>>();
    }

    public void addVariableMap (Map<String, Double> newMap) {
        myLocalVariables.add(newMap);
    }

    public void reduceVariableScope () {
        if (!myLocalVariables.isEmpty()) {
            myLocalVariables.pop();
        }
    }

    public Map<String, Double> getGlobalVariables () {
        return myGlobalVariables;
    }

    public Map<String, Double> getLocalVariables () {
        return myLocalVariables.lastElement();
    }

    public void addGlobalVariable (String varName, double varValue) {
        myGlobalVariables.put(varName, varValue);
    }

    public void addLocalVariable (String varName, double varValue) {
        Map<String, Double> currentVariables = myLocalVariables.pop();
        currentVariables.put(varName, varValue);
        myLocalVariables.add(currentVariables);
    }

    public int getVariableScope () {
        return myLocalVariables.size();
    }
}
