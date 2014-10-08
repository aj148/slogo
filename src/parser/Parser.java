package parser;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Stack;

import view.ViewPanel;
import model.Turtle;
import commands.Command;
import commands.ErrorCommand;
import commands.OneInputCommand;
import commands.ThreeInputCommand;
import commands.TurtleCommand;
import commands.TwoInputCommand;
import controller.MasterController;

/**
 * This class is used to convert a string to a collection of commands to execute.
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
                if (cl.getSuperclass().getName() == "commands.TurtleCommand") {
                    try {
                        command = (Command) cl.getConstructor().newInstance();
                        System.out.println(command.getNumParameters());
                        if (command.getNumParameters() == 0) {
                            commandsToExecute.add(command);
                        }
                        if (command.getNumParameters() == 1) {
                            ((OneInputCommand) command).setParameters(parameterStack.pop());
                            commandsToExecute.add(command);
                        }
                        if (command.getNumParameters() == 2) {
                            ((TwoInputCommand) command).setParameters(parameterStack.pop(), parameterStack.pop());
                            commandsToExecute.add(command);
                        }
                        if (command.getNumParameters() == 3) {
                            ((ThreeInputCommand) command).setParameters(parameterStack.pop(), parameterStack.pop(), parameterStack.pop());
                            commandsToExecute.add(command);
                        }
                    }
                    catch (Exception e) {
                        System.out.println("OH YEAH");
                        return throwError(e);
                    }
                }
                else if (cl.getSuperclass().getName() != "commands.TurtleCommand") {
                    try {
                        command = (Command) cl.getConstructor().newInstance();
                        if (command.getNumParameters() == 1) {
                            ((OneInputCommand) command).setParameters(parameterStack.pop());
                            parameterStack.add(command.executeCommand());
                        }
                        if (command.getNumParameters() == 2) {
                            ((TwoInputCommand) command).setParameters(parameterStack.pop(), parameterStack.pop());
                            parameterStack.add(command.executeCommand());
                        }
                        if (command.getNumParameters() == 3) {
                            ((ThreeInputCommand) command).setParameters(parameterStack.pop(), parameterStack.pop(), parameterStack.pop());
                            parameterStack.add(command.executeCommand());
                        }
                    }
                    catch (Exception e) {
                        System.out.println("OH NO");
                        return throwError(e);
                    }
                }
            }
            catch (ClassNotFoundException e) {
                System.out.println("OH");
                return throwError(e);
            }
        }
        for(Command command : commandsToExecute){
            System.out.println(command.getClass().toString());
            Turtle turtle = new Turtle(0, 0, new ViewPanel());
            turtle.updateTurtle((TurtleCommand)command);
        }
        return commandsToExecute;
    }

    private Collection<Command> throwError (Exception e) {

        Collection<Command> error = new ArrayDeque<Command>();
        error.add(new ErrorCommand());
        return error;
    }
}