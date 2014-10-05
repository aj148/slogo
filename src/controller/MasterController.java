package controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Map;

import parser.Parser;

/**
 * Class to contain the Parser and a set of executable commands.
 * This information is used by Controller subclasses.
 * 
 * @author Team 14
 */
public class MasterController {
    
    protected static Parser myParser;
    public static Map<String, String> myCommandMap;
    private final String resources = "resources.languages/";
    
    public MasterController(String lang){
        myParser = new Parser();
        myCommandMap = new HashMap<String, String>();
        
        ResourceBundle language = ResourceBundle.getBundle(resources + lang);
        
        Enumeration<String> enumerator = language.getKeys();
        while(enumerator.hasMoreElements()){
            String command = (String) enumerator.nextElement();
            String[] inputs = language.getString(command).split(",");
            command = command + "Command";
            for(String input : inputs){
                myCommandMap.put(input, command);
            }
        }
        for(String key : myCommandMap.keySet()){
            System.out.println(key + " -> " + myCommandMap.get(key));
        }
    }
    
    public static void main(String[] args){
        new MasterController("English");
    }
}