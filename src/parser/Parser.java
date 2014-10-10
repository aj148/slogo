package parser;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Stack;
import model.Turtle;
import commands.Command;
import commands.ErrorCommand;
import commands.OneInputCommand;
import commands.ThreeInputCommand;
import commands.TurtleCommand;
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
     * @param input : String to parse.
     * @return Collection of commands to execute.
     */
    public Collection<Command> parseInput (String parseInput) {
        Collection<Command> commandsToExecute = new Stack<Command>();
        Stack<String> commandStack = new Stack<String>();
        Stack<Double> parameterStack = new Stack<Double>();
        for (String input : parseInput.split(" ")) {
            if (MasterController.myCommandMap.containsKey(input)) {
                try {
                    commandStack.add(MasterController.myCommandMap.get(input));
                }
                catch (Exception e) {
                    return throwError(e);
                }
            }
            else {
                try {
                    double parameter = Double.parseDouble(input);
                    parameterStack.add(parameter);
                }
                catch (Exception e) {
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
                                                                    parameterStack.pop(),
                                                                    parameterStack.pop());
                    }
                    if (cl.getInterfaces().length > 0
                        && cl.getInterfaces()[0].getName().equals("commands.TurtleCommand")) {
                        commandsToExecute.add(command);
                    }
                    else {
                        parameterStack.add(command.executeCommand());
                    }
                }
                catch (Exception e) {
                    return throwError(e);
                }
            }
            catch (ClassNotFoundException e) {
                return throwError(e);
            }

        }
        // I need to throw an error for this case
        // "fd sum 5 sum 5 3 3"
        if (parameterStack.size() > 0) {
            System.out.println("whatwhatwhat");
        }
        // for (Command command : commandsToExecute) {
        // System.out.println(command.getClass().toString());
        // Turtle turtle = new Turtle(0, 0, new ViewPanel());
        // turtle.updateTurtle((TurtleCommand) command);
        // }
        return commandsToExecute;
    }

    private Collection<Command> throwError (Exception e) {

        Collection<Command> error = new ArrayDeque<Command>();
        error.add(new ErrorCommand());
        return error;
    }
}
