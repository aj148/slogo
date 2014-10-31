// This entire file is part of my masterpiece.
// Minkwon Lee
package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;
import commands.Command;
import commands.ConstantCommand;
import commands.CustomCommand;
import commands.ErrorCommand;
import commands.ListCommand;
import commands.VariableCommand;


/**
 * This class is used to convert a string to a collection of commands to
 * execute.
 *
 * @author Team 14
 */
public class Parser {

    private static String EMPTY_SPACE = "";
    private static String CONSTANT_PATTERN = "-?[0-9]+\\.?[0-9]*";
    private static String VARIABLE_PATTERN = ":[a-zA-Z]+";
    private static String COMMAND_PATTERN = "[a-zA-z_]+(\\?)?";
    private static String LIST_START = "[";
    private static String LIST_END = "]";
    private Stack<String> myCommandStack = new Stack<String>();
    private Map<String, String> myCommandMap;
    private Map<String, String> myRegularExpressions;
    private List<String> myPattern = new ArrayList<String>();
    private Map<String, CustomCommand> myUserInputCommands;

    public void resetParser (Map<String, String> commandMap, Map<String, String> regularExpressions) {
        myCommandMap = commandMap;
        myRegularExpressions = regularExpressions;
        myUserInputCommands = new HashMap<String, CustomCommand>();
    }

    public void addUserInputCommand (String name, CustomCommand command) {
        myUserInputCommands.put(name, command);
    }

    private void createPatternList () {
        myPattern.add(CONSTANT_PATTERN);
        myPattern.add(VARIABLE_PATTERN);
        myPattern.add(LIST_END);
        myPattern.add(COMMAND_PATTERN);
    }

    /**
     * Parses a string input and constructs a collection of executable commands.
     *
     * @param input
     *        : String to parse.
     * @return Collection of commands to execute.
     */
    public Stack<Command> parseInput (String parseInput) {
        createPatternList();
        Stack<Command> parameterStack = new Stack<Command>();
        Stack<Command> commandsToExecute = new Stack<Command>();
        for (String input : parseInput.split(" ")) {
            if (input.equals(EMPTY_SPACE)) {
                continue;
            }
            myCommandStack.add(input);
        }

        while (!myCommandStack.isEmpty()) {
            String commandName = myCommandStack.pop();
            Command newCommand = getCommand(commandName, parameterStack);
            parameterStack.add(newCommand);
            if (newCommand.getClassName().equals("commands.ErrorCommand")) { return parameterStack; }
        }
        while (!parameterStack.isEmpty()) {
            commandsToExecute.add(parameterStack.pop());
        }
        return commandsToExecute;
    }

    private Command getCommand (String commandName, Stack<Command> parameterStack) {
        for (String pattern : myPattern) {
            if (Pattern.matches(pattern, commandName)) { 
                return commandFactory(commandName, parameterStack,pattern); }
        }
        return null;
    }

    public Command commandFactory (String commandName, Stack<Command> parameterStack, String commandType) {
        switch (commandType) {
            case "-?[0-9]+\\.?[0-9]*": //CONSTANT_PATTERN
                return new ConstantCommand(Double.parseDouble(commandName));
            case ":[a-zA-Z]+":  //VARIABLE_PATTERN
                return new VariableCommand(commandName.substring(1));
            case "]": //LIST_END
                return makeListCommand(myCommandStack);
            case "[a-zA-z_]+(\\?)?": //COMMAND_PATTERN
                return getRegularCommand(commandName, parameterStack);
        }
        return null;
    }
    
    /**
     * returns a command that uses reflection
     * 
     * @return command
     */
    private Command getRegularCommand (String commandName, Stack<Command> parameterStack) {
        if (myCommandMap.containsKey(commandName)) {
            commandName = myCommandMap.get(commandName);
        }
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
                e.printStackTrace();
                String errorMessage =
                        "[" + commandName + " : Invalid Input] ";
                return new ErrorCommand(errorMessage);
            }
        }
        catch (ClassNotFoundException e) {
            String errorMessage =
                    "[" + commandName + " : Invalid Command]";
            return new ErrorCommand(errorMessage);
        }
    }
    
    /**
     * When encountering "]", this method is used to create a ListCommand
     * 
     * @param commandStack
     * @return ListCommand
     */
    private Command makeListCommand (Stack<String> commandStack) {
        Stack<Command> tempParameterStack = new Stack<Command>();
        ListCommand listCommand = new ListCommand();
        boolean inListCommand = true;
        while (!commandStack.isEmpty() & inListCommand) {
            String commandName = commandStack.pop();
            if (commandName.equals(LIST_START)) {
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
}
