package parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

import commands.Command;
import commands.ConstantCommand;
import commands.ErrorCommand;
import commands.ListCommand;
import commands.VariableCommand;

/**
 * This class is used to convert a string to a collection of commands to execute.
 *
 * @author Team 14
 */
public class Parser {
	
	private Stack<String> commandStack;
	private Map<String, String> myCommandMap;
	private Map<String, String> myRegularExpressions;
	
	public Parser(Map<String, String> commandMap, Map<String, String> regularExpressions){
		commandStack = new Stack<String>();
		myCommandMap = new HashMap<String, String>();
		myRegularExpressions = new HashMap<String, String>();
	}

    /**
     * Parses a string input and constructs a collection of executable commands.
     * 
     * @param input : String to parse.
     * @return Collection of commands to execute.
     */
    public Stack<Command> parseInput (String parseInput) {
        Stack<Command> parameterStack = new Stack<Command>();
        for (String input : parseInput.split(" ")) {
            if (myCommandMap.containsKey(input)) {
                commandStack.add(myCommandMap.get(input));
            }
            else if (Pattern.matches(myRegularExpressions.get("Constant"), input)
                    | Pattern.matches(myRegularExpressions.get("Variable"), input)) {
                commandStack.add(input);
            }
            else {
                String errorMessage = String.format(
                        "[%: Invalid Input] This input does not exist in our library of commands, contants, and variables", input);
                return throwError(errorMessage);
            }
        }
        while (!commandStack.isEmpty()) {
            String commandName = commandStack.pop();
            Command newCommand = getCommand(commandName, parameterStack);
            parameterStack.add(newCommand);
            if(newCommand.getClassName().equals("commands.ErrorCommand")){
                return parameterStack;
            }
        }
        return parameterStack;
    }

    private Command getCommand (String commandName, Stack<Command> parameterStack) {
        if (Pattern.matches(myRegularExpressions.get("Constant"), commandName)) {
            return new ConstantCommand(Double.parseDouble(commandName));
        }
        else if (Pattern.matches(myRegularExpressions.get("Variable"), commandName)) {
            return new VariableCommand(commandName.substring(1));
        }
        else if (commandName.equals("commands.ListEndCommand")) {
            return makeListCommand(commandStack);
        }
        else {
            Class<?> cl;
            Command command;
            try {
                cl = Class.forName(commandName);
                try {
                    command = (Command) cl.getConstructor().newInstance();
                    Command[] parameters = new Command[command.getNumParameters()];
                    for (int i = 0; i < parameters.length; i++) {
                        parameters[i] = parameterStack.pop();
                    }
                    command.setParameters(parameters);
                    return command;
                }
                catch (Exception e) {
                	String errorMessage = String.format(
                            "[%s: Invalid Input] Command class for this command could not be"
                            + " constructed properly.",
                            commandName);
                    return new ErrorCommand(errorMessage);
                }
            }
            catch (ClassNotFoundException e) {
            	String errorMessage = String.format(
                        "[%s: Invalid Command] Command class for this command does not exist",
                        commandName);
                return new ErrorCommand(errorMessage);
            }
        }
    }

    private Command makeListCommand (Stack<String> commandStack) {
        Stack<Command> tempParameterStack = new Stack<Command>();
        ListCommand listCommand = new ListCommand();
        boolean inListCommand = true;
        while (!commandStack.isEmpty() & inListCommand) {
            String commandName = commandStack.pop();
            if (commandName.equals("commands.ListStartCommand")) {
                inListCommand = false;
                continue;
            }
            Command newCommand = getCommand(commandName, tempParameterStack);
            tempParameterStack.add(newCommand);
        }
        while (!tempParameterStack.empty()) {
            listCommand.addParameter(tempParameterStack.pop());
        }
        return listCommand;
    }
    
    private Stack<Command> throwError (String errorMessage) {
        Stack<Command> errorStack = new Stack<Command>();
        ErrorCommand error = new ErrorCommand(errorMessage);
        errorStack.add(error);
        return errorStack;
    }
}