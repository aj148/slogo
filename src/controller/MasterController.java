// This entire file is part of my masterpiece.
// MARTIN TAMAYO

package controller;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

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
    private final String myResources = "resources.languages/";

    public MasterController (String lang) {
        myParser = new Parser();
        constructMasterController(lang);
    }

    public void constructMasterController (String lang) {
        Map<String, String> commandMap = new HashMap<String, String>();
        String[] regularExpressions = new String[8];
        ResourceBundle language = ResourceBundle.getBundle(myResources + lang);
        List<String> expressions = constructList();
        
        Enumeration<String> enumerator = language.getKeys();
        while (enumerator.hasMoreElements()) {
            String command = enumerator.nextElement();
            int index = expressions.indexOf(command);
            if (index != -1) {
                regularExpressions[index] = language.getString(command);
            }
            else {
                String[] inputs = language.getString(command).split(",");
                command = "commands." + command + "Command";
                for (String input : inputs) {
                    commandMap.put(input, command);
                }
            }
        }
        myParser.resetParser(commandMap, regularExpressions);
    }

    private List<String> constructList() {
    	String[] expressionArray = { "ListStart", "Constant", "Variable", "Command",
    			"Comment", "ListEnd", "GroupStart", "GroupEnd" };
    	List<String> expressionList = Arrays.asList(expressionArray);
        return expressionList;
    }
}