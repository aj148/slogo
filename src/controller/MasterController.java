package controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Map;
import java.util.Stack;
// import java.util.regex.Pattern;

import javafx.scene.paint.Color;
import model.Turtle;
import commands.Command;
import parser.Parser;
import view.ViewPane;

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
    public static Map<String, String> myRegularExpressions;
    protected static Parser myParser;
    private final String resources = "resources.languages/";

    public MasterController (String lang) {
        myParser = new Parser();
        myColorMap = new HashMap<Integer, Color>();
        myCommandMap = new HashMap<String, String>();
        myVariableMap = new HashMap<String, Double>();
        myRegularExpressions = new HashMap<String, String>();
        ResourceBundle language = ResourceBundle.getBundle(resources + lang);
        // String[] expressions = {"Comment", "Constant", "Variable", "Command", "ListStart", "ListEnd", "GroupStart", "GroupEnd"};
        
        Enumeration<String> enumerator = language.getKeys();
        while (enumerator.hasMoreElements()) {
            String command = (String) enumerator.nextElement();
            // Pattern p = Pattern.compile(" ");
            
            String[] inputs = language.getString(command).split(",");
            command = "commands." + command + "Command";
            for (String input : inputs) {
                myCommandMap.put(input, command);
            }
        }
    }
    
    public static void main(String[] args){
        MasterController doge = new MasterController("English");
        String test = "fd [ fd sum [ sum 10 10 ] 10 ]";
        MasterController.myParser.parseInput(test);
    }
}