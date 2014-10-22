package controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

import commands.Command;
import commands.ForwardCommand;
import commands.ListCommand;
import commands.SumCommand;
import javafx.scene.paint.Color;
//import parser.NeoParser;
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
    public static Parser myParser;
    private final String resources = "resources.languages/";

    public MasterController (String lang) {
        myParser = new Parser();
        myColorMap = new HashMap<Integer, Color>();
        myCommandMap = new HashMap<String, String>();
        myVariableMap = new HashMap<String, Double>();
        myRegularExpressions = new HashMap<String, Pattern>();
        ResourceBundle language = ResourceBundle.getBundle(resources + lang);
//        Set<String> expressions = constructSet();
        Enumeration<String> enumerator = language.getKeys();
        while (enumerator.hasMoreElements()) {
            String command = (String) enumerator.nextElement();
            String[] inputs = language.getString(command).split(",");
//            if(expressions.contains(command)){
//            	myRegularExpressions.put(command, Pattern.compile(inputs[0]));
//            }
//            else{
            	command = "commands." + command + "Command";
            	for (String input : inputs) {
            		myCommandMap.put(input, command);
//            	}
            }
        }
    }
    
//    private Set<String> constructSet() {
//		Set<String> expressionSet = new HashSet<String>();
//		String[] expressionArray = {"Comment", "Constant", "Variable", "Command", "ListStart", "ListEnd", "GroupStart", "GroupEnd"};
//		for(String item : expressionArray){
//			expressionSet.add(item);
//		}
//		return expressionSet;
//	}
    
    public static void main(String[] args){
        MasterController doge = new MasterController("English");
        String test = "fd [ fd sum [ sum 10 10 ] 10 ]";
        Stack<Command> commands = MasterController.myParser.parseInput(test);
        ForwardCommand com = (ForwardCommand)commands.pop();
        List<Command> list = ((ListCommand)com.myParameterOne).getList();
        for(Command c : list){
        	System.out.println(c.getClass());
        	ForwardCommand aaaaa = (ForwardCommand) c;
        	System.out.println(aaaaa.myParameterOne.getClass());
        	SumCommand aaaaaahhhhh = (SumCommand) aaaaa.myParameterOne;
        	System.out.println(aaaaaahhhhh.myParameterOne.getClass());
        	System.out.println(aaaaaahhhhh.myParameterTwo.getClass());
        	ListCommand urgh = (ListCommand)aaaaaahhhhh.myParameterOne;
        	for(Command what : urgh.getList()){
        		System.out.println(what.getClass());
        		SumCommand ohmygod = (SumCommand)what;
        		System.out.println(ohmygod.myParameterOne.getClass());
        		System.out.println(ohmygod.myParameterTwo.getClass());
        	}
        }
    }
}