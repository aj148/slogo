package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import commands.Command;
import commands.CommentCommand;
import commands.ConstantCommand;
import commands.ListCommand;
import commands.VariableCommand;
import controller.MasterController;

/**
 * This class is used to convert a string to a collection of commands to
 * execute.
 * 
 * @author Team 14
 */
public class NeoParser {
	
	private int myIndex;
	private Map<String, String> myCommandMap;
    private Map<String, String> myRegularExpressions;
    
    public NeoParser (Map<String, String> commandMap, Map<String, String> regularExpressions) {
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
    	List<Command> commandsToExecute = new ArrayList<Command>();
    	String[] inputs = parseInput.trim().split(" ");
    	while(myIndex < inputs.length){
    		commandsToExecute.add(generateCommand(inputs));
    	}
    	return commandsToExecute;
	}
	
    private Command generateCommand(String[] inputs) {
    	String input = inputs[myIndex];
    	Command command;
    	if(Pattern.matches("\\[", input)){
    		myIndex += 1;
			command = makeListCommand(new ListCommand(), inputs);
    	}
    	else if(Pattern.matches("-?[0-9]+\\.?[0-9]*", input)){
    		myIndex += 1;
			command = new ConstantCommand(Double.parseDouble(input));
		}
    	else if(Pattern.matches(":[a-zA-Z]+", input)){
    		myIndex += 1;
			command = new VariableCommand(input.substring(1));
		}
    	else if(Pattern.matches("[a-zA-Z_]+(\\?)?", input)){
    		command = getCommandByReflection(inputs);
    	}
    	else{
    		myIndex += 1;
    		command = new CommentCommand();
    	}
		return command;
	}
    
	private ListCommand makeListCommand(ListCommand command, String[] inputs) {
		String input = inputs[myIndex];
		if(Pattern.matches("\\]", input)){
			myIndex += 1;
			return command;
		}
		command.addParameter(generateCommand(inputs));
		return makeListCommand(command, inputs);
	}
    
	private Command getCommandByReflection(String[] inputs) {
		String input = inputs[myIndex];
    	myIndex += 1;
		Class<?> cl;
		Command command;
		try {
			cl = Class.forName(myCommandMap.get(input));
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found for some reason.");
			return null;
		}
		try {
			command = (Command) cl.getConstructor().newInstance();
			Command[] parameters = new Command[command.getNumParameters()];
			for(int i = 0; i < parameters.length; i++){
				parameters[i] = generateCommand(inputs);
			}
			command.setParameters(parameters);
		}
		catch(Exception e){
			System.out.println("Well, crap. Who knows what went wrong.");
			return null;
		}
		return command;
	}
}