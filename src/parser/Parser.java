package parser;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Stack;

import commands.Command;
import commands.ErrorCommand;
import commands.HomeCommand;
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
    public Collection<Command> parseInput(String parseInput) {
        Collection<Command> commandsToExecute = new ArrayDeque<Command>();
        
        Stack<Command> commandStack = new Stack<Command>();
        Stack<Double> parameterStack = new Stack<Double>();
        for(String input : parseInput.split(" ")){
            if(MasterController.myCommandMap.containsKey(input)){
                try{
                    String commandName = MasterController.myCommandMap.get(input);
                    // Use reflection to create the command. For example, let commandName = "HomeCommand":
                    commandStack.add(new HomeCommand());
                    
                    // Since HomeCommand takes no parameters, immediately pop it from the stack and add it to the queue.
                    commandsToExecute.add(commandStack.pop());
                }
                catch(Exception e){
                    return throwError(e);
                }
            }
            else{
                try{
                    double parameter = Double.parseDouble(input);
                    parameterStack.add(parameter);
                    parameterStack.peek();
                }
                catch(Exception e){
                    return throwError(e);
                }
            }
        }
        return commandsToExecute;
    }
    
    private Collection<Command> throwError(Exception e){
        Collection<Command> error = new ArrayDeque<Command>();
        error.add(new ErrorCommand());
        return error;
    }
}