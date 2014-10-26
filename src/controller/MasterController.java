package controller;

import java.util.Enumeration; 
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Map;
import java.util.Set;

import parser.NeoParser;
import parser.Parser;

/**
 * Class to contain the Parser and a set of executable commands. This
 * information is used by Controller subclasses.
 *
 * @author Team 14
 */
public class MasterController {
	
	public static Parser myParser;
    public static Random myRandom = new Random();
    private final String resources = "resources.languages/";

    public MasterController (String lang) {
    	myParser = new Parser();
    	constructMasterController(lang);
    }
    
    public void constructMasterController(String lang){
        Map<String, String> commandMap = new HashMap<String, String>();
        Map<String, String> regularExpressions = new HashMap<String, String>();
        ResourceBundle language = ResourceBundle.getBundle(resources + lang);
        Set<String> expressions = constructSet();
        
        Enumeration<String> enumerator = language.getKeys();
        while(enumerator.hasMoreElements()){
            String command = (String) enumerator.nextElement();
            if(expressions.contains(command)){
            	regularExpressions.put(command, language.getString(command));
            }
            else{
            	String[] inputs = language.getString(command).split(",");
            	command = "commands." + command + "Command";
            	for (String input : inputs) {
            		commandMap.put(input, command);
            	}
            }
        }
        myParser.resetParser(commandMap, regularExpressions);
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