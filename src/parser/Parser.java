package parser;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

import commands.Command;
import commands.ListCommand;
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
        Stack<Command> listCommandStack = new Stack<Command>();
        Stack<Command> tempParameterStack = new Stack<Command>();
        boolean isListCommand = false;
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
            if (commandName.equals(listStart)) {
                isListCommand = true;
                continue;
            }
            if (commandName.equals(listEnd)) {
                ListCommand listCommand = new ListCommand();
                while(!tempParameterStack.empty()){
                    listCommand.setParameters(tempParameterStack.pop());
                }
                parameterStack.add(listCommand);
                isListCommand = false;
                listCommandStack = emptyStack(listCommandStack);
                tempParameterStack = emptyStack(tempParameterStack);
                continue;
            }
            if (isListCommand) {
                Class<?> cl;
                Command command;
                try {
                    cl = Class.forName(commandName);
                    try {
                        command = (Command) cl.getConstructor().newInstance();
                        if (command.getNumParameters() == 1) {
                            ((OneInputCommand) command).setParameters(tempParameterStack.pop());
                        }
                        if (command.getNumParameters() == 2) {
                            ((TwoInputCommand) command).setParameters(tempParameterStack.pop(),
                                    tempParameterStack.pop());
                        }
                        if (command.getNumParameters() == 3) {
                            ((ThreeInputCommand) command).setParameters(tempParameterStack.pop(),
                                    tempParameterStack.pop(), tempParameterStack.pop());
                        }
                        tempParameterStack.add(command);
                    } catch (Exception e) {
                        throwError(e);
                    }

                } catch (ClassNotFoundException e) {
                    return throwError(e);
                }

            } else {
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
        }
        return parameterStack;
    }

    private void getStack (String commandName, Stack<Command> parameterStack) {

    }

    private Stack<Command> emptyStack (Stack<Command> commandStack) {
        while (!commandStack.empty()) {
            commandStack.pop();
        }
        return commandStack;
    }

    private Stack<Command> throwError (Exception e) {
        Stack<Command> error = new Stack<Command>();
        // error.add(new ErrorCommand("Error: Invalid input."));
        return error;
    }
}