package parser;

import java.util.Stack;
import java.util.regex.Pattern;
import commands.Command;
import commands.ConstantCommand;
import commands.ForwardCommand;
import commands.ListCommand;
import commands.OneInputCommand;
import commands.SumCommand;
import commands.ThreeInputCommand;
import commands.TwoInputCommand;
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
                }
                catch (Exception e) {
                    return throwError(e);
                }
            }
            if (Pattern.matches("-??[0-9]+.??[0-9]*", input) | Pattern.matches(":[a-zA-Z]+", input)) {
                commandStack.add(input);
            }
        }
        while (!commandStack.isEmpty()) {
            String commandName = commandStack.pop();
            Command newCommand = getCommand(commandName, parameterStack);
            parameterStack.add(newCommand);
        }
        System.out.println("---");
        ForwardCommand temp = (ForwardCommand) parameterStack.pop();
        ListCommand temp2 = (ListCommand) temp.getParamerter();
        ForwardCommand temp3 = (ForwardCommand) temp2.getParameters().get(0);
        SumCommand temp4 = (SumCommand) temp3.getParamerter();
        System.out.println(temp);
        System.out.println(temp.getParamerter());
        System.out.println(temp2.getParameters());
        System.out.println(temp3);
        System.out.println(temp4);
        System.out.println(temp4.getParameterOne());
        System.out.println(temp4.getParameterTwo());
        System.out.println("---");
        return parameterStack;
    }
    
    private Command getCommand (String commandName, Stack<Command> parameterStack){
        if (Pattern.matches("-??[0-9]+.??[0-9]*", commandName)) {
            return new ConstantCommand(Double.parseDouble(commandName));
        }
        else if (Pattern.matches(":[a-zA-Z]+", commandName)) {
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
                    return command;
                }
                catch (Exception e) {
                	
                }
            }
            catch (ClassNotFoundException e) {
            	
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
            if(commandName.equals("commands.ListStartCommand")){
                inListCommand = false;
                continue;
            }
            Command newCommand = getCommand(commandName, tempParameterStack);
            tempParameterStack.add(newCommand);
        }
        while(!tempParameterStack.empty()){
            listCommand.addParameter(tempParameterStack.pop());
        }
        return listCommand;
    }
    
    private Stack<Command> throwError (Exception e) {
        Stack<Command> error = new Stack<Command>();
        return error;
    }
}