package parser;

import java.util.ArrayDeque;
import java.util.Collection;

import commands.Command;
import commands.ErrorCommand;
import commands.ForwardCommand;
import commands.HomeCommand;

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
    public Collection<Command> parseInput(String input) {
        Collection<Command> commandsToExecute = new ArrayDeque<Command>();
        
        // The following is hard-coded.
        boolean inputValid = true;
        if(inputValid){
            commandsToExecute.add(new HomeCommand());
            commandsToExecute.add(new ForwardCommand());
        }
        else{
            commandsToExecute.add(new ErrorCommand());
        }
        return commandsToExecute;
    }
}