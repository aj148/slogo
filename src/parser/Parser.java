// This entire file is part of my masterpiece.
// MARTIN TAMAYO

package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import commands.Command;
import commands.CommentCommand;
import commands.ConstantCommand;
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
	
    private int myIndex;
    private boolean myError;
    private String[] myInputs;
    private String[] myRegularExpressions;
	private Map<String, String> myCommandMap;

    public void resetParser (Map<String, String> commandMap, String[] regularExpressions) {
        myCommandMap = commandMap;
        myRegularExpressions = regularExpressions;
    }
	
	/**
     * Parses a string input and constructs a collection of executable commands.
     * 
     * @param input : String to parse.
     * @return Collection of commands to execute.
     */
    public List<Command> parseInput (String parseInput) {
    	myIndex = 0;
    	myError = false;
    	List<Command> commandsToExecute = new ArrayList<Command>();
    	myInputs = parseInput.trim().split(" ");
    	while(myIndex < myInputs.length){
    		commandsToExecute.add(generateCommand());
    		if(myError){
    			commandsToExecute.clear();
    			commandsToExecute.add(new ErrorCommand("Error: Invalid Input"));
    			return commandsToExecute;
    		}
    	}
    	return commandsToExecute;
	}
    
    private Command generateCommand() {
    	String input = myInputs[myIndex];
    	myIndex += 1;
    	for(int i = 0; i < myRegularExpressions.length; i++){
    		if(Pattern.matches(myRegularExpressions[i], input)){
    			return createCommand(i, input);
    		}
    	}
    	return throwError();
	}

    interface CommandFactory {
        Command create(String input);
    }
    
    private Command createCommand(int choice, String input) {
        return myCommandClasses[choice].create(input);
    }

    private CommandFactory[] myCommandClasses = new CommandFactory[] {
    	new CommandFactory() { public Command create(String input) { return makeListCommand(new ListCommand(), input); } },
        new CommandFactory() { public Command create(String input) { return makeConstantCommand(input); } },
        new CommandFactory() { public Command create(String input) { return makeVariableCommand(input); } },
        new CommandFactory() { public Command create(String input) { return getCommandByReflection(input); } },
        new CommandFactory() { public Command create(String input) { return makeCommentCommand(); } },
        new CommandFactory() { public Command create(String input) { return throwError(); } },
        new CommandFactory() { public Command create(String input) { return throwError(); } },
        new CommandFactory() { public Command create(String input) { return throwError(); } }
        // Since "GroupStart" and "GroupEnd" are currently not supported, an error will be thrown instead.
    };
    
	private ListCommand makeListCommand(ListCommand command, String input) {
		if(Pattern.matches(myRegularExpressions[5], input)){
			myIndex += 1;
			return command;
		}
		command.addParameter(generateCommand());
		return makeListCommand(command, myInputs[myIndex]);
	}
	
	private ConstantCommand makeConstantCommand(String input){
		return new ConstantCommand(Double.parseDouble(input));
	}
	
	private VariableCommand makeVariableCommand(String input){
		return new VariableCommand(input.substring(1));
	}
    
	private Command getCommandByReflection(String input) {
		Class<?> cl;
		Command command;
		try {
			cl = Class.forName(myCommandMap.get(input));
			command = (Command) cl.getConstructor().newInstance();
			Command[] parameters = new Command[command.getNumParameters()];
			for(int i = 0; i < parameters.length; i++){
				parameters[i] = generateCommand();
			}
			command.setParameters(parameters);
		}
		catch(Exception e){
			return throwError();
		}
		return command;
	}
	
	private CommentCommand makeCommentCommand(){
		return new CommentCommand();
	}
	
	private Command throwError(){
		myError = true;
		return null;
	}
}