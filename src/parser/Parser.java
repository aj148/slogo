package parser;

import java.lang.reflect.Constructor;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Stack;

import commands.Command;
import commands.ErrorCommand;
import commands.HomeCommand;
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
    public Collection<Command> parseInput (String parseInput) {
        Collection<Command> commandsToExecute = new Stack<Command>();
        Stack<String> commandStack = new Stack<String>();
        Stack<Double> parameterStack = new Stack<Double>();
        for (String input : parseInput.split(" ")) {
            if (MasterController.myCommandMap.containsKey(input)) {
                try {
                    commandStack.add(MasterController.myCommandMap.get(input));
                } catch (Exception e) {
                    return throwError(e);
                }
            } else {
                try {
                    double parameter = Double.parseDouble(input);
                    parameterStack.add(parameter);
                } catch (Exception e) {
                    return throwError(e);
                }
            }
        }
        
        while(!commandStack.isEmpty()){
            //if we do sum a b
            String commandName = commandStack.pop();
            Class cl;
            Constructor cons;
            Command command;
            try {
                cl = Class.forName(commandName);
                try {
                    cons = cl.getConstructor(Integer.TYPE, Integer.TYPE);
                    command = (Command) cons.newInstance(parameterStack.pop(), parameterStack.pop());
                    //execute sum and stores int result to a variable
                    //put the result in to parameter stack
                    
                    
                } catch (Exception e) {
                    return throwError(e);
                } 
            } catch (ClassNotFoundException e) {
                return throwError(e);
            }
            
            
            
            if(commandStack.size() == 1){ //or command that is popped out of commandStack extends NoInputCommand class
                commandsToExecute.add(command);
            }
            
        }
        
        
        return commandsToExecute;
    }

    private Collection<Command> throwError (Exception e) {
        Collection<Command> error = new ArrayDeque<Command>();
        error.add(new ErrorCommand());
        return error;
    }
}