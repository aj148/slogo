package parser;

import java.util.Stack;

import commands.Command;
import commands.OneInputCommand;
import commands.ThreeInputCommand;
import commands.TwoInputCommand;
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
    String listStart = "[";
    String listEnd = "]";

    public Stack<Command> parseInput (String parseInput) {
        Stack<Command> commandsToExecute = new Stack<Command>();
        Stack<String> commandStack = new Stack<String>();
        Stack<Command> parameterStack = new Stack<Command>();
        for (String input : parseInput.split(" ")) {

            if (MasterController.myCommandMap.containsKey(input)) { 
                try {
                    commandStack.add(MasterController.myCommandMap.get(input));
                } catch (Exception e) {
                    return throwError(e);
                }
            }
        }
        while (!commandStack.isEmpty()) {
            String commandName = commandStack.pop();
            Class<?> cl;
            Command command;
            try {
                cl = Class.forName(commandName);
                try {
                    command = (Command) cl.getConstructor().newInstance();
                    if (command.getNumParameters() == 1) {
                        ((OneInputCommand) command).setParameters(parameterStack.pop());
                    }
                    if (command.getNumParameters() == 2) {
                        ((TwoInputCommand) command).setParameters(parameterStack.pop(),
                                parameterStack.pop());
                    }
                    if (command.getNumParameters() == 3) {
                        ((ThreeInputCommand) command).setParameters(parameterStack.pop(),
                                parameterStack.pop(), parameterStack.pop());
                    }
                    parameterStack.add(command);
                } catch (Exception e) {
                    return throwError(e);
                }
            } catch (ClassNotFoundException e) {
                return throwError(e);
            }

        }
        return parameterStack;
    }

    private Stack<Command> throwError (Exception e) {
        Stack<Command> error = new Stack<Command>();
        // error.add(new ErrorCommand("Error: Invalid input."));
        return error;
    }
}