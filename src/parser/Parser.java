package parser;

import java.util.Stack;
import java.util.regex.Pattern;

import commands.Command;
import commands.ConstantCommand;
import commands.ErrorCommand;
import commands.ListCommand;
import commands.VariableCommand;
import controller.MasterController;

/**
 * This class is used to convert a string to a collection of commands to
 * execute.
 *
 * @author Team 14
 */
public class Parser {

    /**
     * Parses a string input and constructs a collection of executable commands.
     * 
     * @param input
     *            : String to parse.
     * @return Collection of commands to execute.
     */
    private Stack<String> commandStack = new Stack<String>();

    public Stack<Command> parseInput (String parseInput) {
        Stack<Command> parameterStack = new Stack<Command>();
        for (String input : parseInput.split(" ")) {
            if (MasterController.myCommandMap.containsKey(input)) {
                try {
                    commandStack.add(MasterController.myCommandMap.get(input));
                } catch (Exception e) {
                }
            } else if (Pattern.matches("-??[0-9]+.??[0-9]*", input)
                    | Pattern.matches(":[a-zA-Z]+", input)) {
                commandStack.add(input);
            } else {
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
        if (Pattern.matches("-??[0-9]+.??[0-9]*", commandName)) {
            return new ConstantCommand(Double.parseDouble(commandName));
        } else if (Pattern.matches(":[a-zA-Z]+", commandName)) {
            return new VariableCommand(commandName.substring(1));
        } else if (commandName.equals("commands.ListEndCommand")) {
            return makeListCommand(commandStack);
        } else {
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
                } catch (Exception e) {

                }
            } catch (ClassNotFoundException e) {
                String errorMessage = String.format(
                        "[%s: Invalid Command] Command class for this command does not exist",
                        commandName);
                return new ErrorCommand(errorMessage);
            }
        }
        return null;
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