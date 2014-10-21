package controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javafx.scene.paint.Color;

import parser.Parser;

/**
 * Class to contain the Parser and a set of executable commands.
 * This information is used by Controller subclasses.
 * 
 * @author Team 14
 */
public class MasterController {

    public static Random myRandom = new Random();
    public static Map<Integer, Color> myColorMap;
    public static Map<String, String> myCommandMap;
    public static Map<String, Double> myVariableMap;
    public static Map<String, Pattern> myRegularExpressions;
    protected static Parser myParser;
    private final String resources = "resources.languages/";

    public MasterController (String lang) {
        myParser = new Parser();
        myColorMap = new HashMap<Integer, Color>();
        myCommandMap = new HashMap<String, String>();
        myVariableMap = new HashMap<String, Double>();
        myRegularExpressions = new HashMap<String, Pattern>();
        ResourceBundle language = ResourceBundle.getBundle(resources + lang);
        Set<String> expressions = constructSet();
        Enumeration<String> enumerator = language.getKeys();
        while (enumerator.hasMoreElements()) {
            String command = (String) enumerator.nextElement();
            String[] inputs = language.getString(command).split(",");
            if(expressions.contains(command)){
            	myRegularExpressions.put(command, Pattern.compile(inputs[0]));
            }
            else{
            	command = "commands." + command + "Command";
            	for (String input : inputs) {
            		myCommandMap.put(input, command);
            	}
            }
        }
    }
    
    private Set<String> constructSet() {
		Set<String> expressionSet = new HashSet<String>();
		String[] expressionArray = {"Comment", "Constant", "Variable", "Command", "ListStart", "ListEnd", "GroupStart", "GroupEnd"};
		for(String item : expressionArray){
			expressionSet.add(item);
		}
		return expressionSet;
	}
}