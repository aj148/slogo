package parser;

import java.util.Stack;
import java.util.regex.Pattern;

import commands.Command;
import commands.CommentCommand;
import commands.ConstantCommand;
import commands.FourInputCommand;
import commands.ListCommand;
import commands.OneInputCommand;
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
public class NeoParser {
	
	// "Index" somehow needs to be made global. Maybe the same goes for inputs.
	
	private ListCommand makeListCommand(ListCommand command, String[] inputs, int index){
		if(Pattern.matches("\\]", inputs[index])){
			// Base case: Return completed ListCommand.
			return command;
		}
		// Add a new command to the list, then make recursive call.
		command.addParameter(generateCommand(inputs, index));
		return makeListCommand(command, inputs, index+1);
	}
	
    private Command generateCommand(String[] inputs, int index) {
    	String input = inputs[index];
    	
    	if(Pattern.matches("\\[", input)){
    		// Return a ListCommand.
			return makeListCommand(new ListCommand(), inputs, index+1);
    	}
    	
    	if(Pattern.matches("-??[0-9]+.??[0-9]*", input)){
    		// Return a ConstantCommand.
			return new ConstantCommand(Double.parseDouble(input));
		}
    	
    	if(Pattern.matches(":[a-zA-Z]+", input)){
    		// Return a VariableCommand.
			return new VariableCommand(input.substring(1));
		}
    	
    	if(Pattern.matches("[a-zA-Z_]+(\\?)??", input)){
    		// Return a Command by the power of Reflection.
			return getCommandByReflection(inputs, index);
    	}
    	
    	// Return a Null Command.
		return new CommentCommand();
	}
    
	private Command getCommandByReflection(String[] inputs, int index) {
		Stack<Command> tempParameterStack = new Stack<Command>();
		Class<?> cl;
        Command command;
        try {
            cl = Class.forName(inputs[index]);
            try {
            	command = (Command) cl.getConstructor().newInstance();
            	
            	// Command takes one parameter.
                if (command.getNumParameters() == 1) {
                	tempParameterStack.add(generateCommand(inputs, index+1));
                    ((OneInputCommand) command).setParameters(tempParameterStack.pop());
                }
                
                // Command takes two parameters.
                if (command.getNumParameters() == 2) {
                	tempParameterStack.add(generateCommand(inputs, index+1));
                	tempParameterStack.add(generateCommand(inputs, index+1));
                    ((TwoInputCommand) command).setParameters(tempParameterStack.pop(),
                            tempParameterStack.pop());
                }
                
                // Command takes three parameters.
                if (command.getNumParameters() == 3) {
                	tempParameterStack.add(generateCommand(inputs, index+1));
                	tempParameterStack.add(generateCommand(inputs, index+1));
                	tempParameterStack.add(generateCommand(inputs, index+1));
                    ((ThreeInputCommand) command).setParameters(tempParameterStack.pop(),
                            tempParameterStack.pop(), tempParameterStack.pop());
                }
                
                // Command takes four parameters.
                if (command.getNumParameters() == 4) {
                	tempParameterStack.add(generateCommand(inputs, index+1));
                	tempParameterStack.add(generateCommand(inputs, index+1));
                	tempParameterStack.add(generateCommand(inputs, index+1));
                	tempParameterStack.add(generateCommand(inputs, index+1));
                    ((FourInputCommand) command).setParameters(tempParameterStack.pop(),
                            tempParameterStack.pop(), tempParameterStack.pop(),
                            tempParameterStack.pop());
                }
                return command;
            }
            catch (Exception e) {
                throwError(e);
            }
        }
        catch (ClassNotFoundException e) {
            throwError(e);
        }
		return null;
	}
	
	/**
     * Parses a string input and constructs a collection of executable commands.
     * 
     * @param input : String to parse.
     * @return Collection of commands to execute.
     */
    public Stack<Command> parseInput (String parseInput) {
    	Stack<Command> commandsToExecute = new Stack<Command>();
    	
    	String[] inputs = parseInput.trim().split(" ");
    	int index = 0;
    	
    	// This probably demands the use of recursion...
    	
    	while(index < inputs.length){
    		if(Pattern.matches("\\[", inputs[index])){
    			ListCommand lc = new ListCommand();
    			// Continue parsing until...
    			if(Pattern.matches("\\]", inputs[index])){
    				// Stop adding to ListCommand.
    			}
    		}
    		else if(Pattern.matches("-??[0-9]+.??[0-9]*", inputs[index])){
    			ConstantCommand cc = new ConstantCommand(Integer.parseInt(inputs[index]));
    		}
    		else if(Pattern.matches(":[a-zA-Z]+", inputs[index])){
    			VariableCommand vc = new VariableCommand(inputs[index].substring(1));
    		}
    		else if(Pattern.matches("[a-zA-Z_]+(\\?)??", inputs[index])){
    			// Use reflection.
    		}
    	}
    	
    	
    	
    	
    	
    	
        
        Stack<String> commandStack = new Stack<String>();
        Stack<Command> parameterStack = new Stack<Command>();
        Stack<Command> listCommandStack = new Stack<Command>();
        Stack<Command> tempParameterStack = new Stack<Command>();
        boolean isListCommand = false;
        for (String input : parseInput.split(" ")) {
            if (MasterController.myCommandMap.containsKey(input)) {
                try {
                    commandStack.add(MasterController.myCommandMap.get(input));
                }
                catch (Exception e) {
                    return throwError(e);
                }
            }
        }
        while (!commandStack.isEmpty()) {
            String commandName = commandStack.pop();
            if (commandName.equals("[")) {
                isListCommand = true;
                continue;
            }
            if (commandName.equals("]")) {
                ListCommand listCommand = new ListCommand();
                while(!tempParameterStack.empty()){
                    listCommand.addParameter(tempParameterStack.pop());
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
                    }
                    catch (Exception e) {
                        throwError(e);
                    }
                }
                catch (ClassNotFoundException e) {
                    return throwError(e);
                }
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
                        parameterStack.add(command);
                    }
                    catch (Exception e) {
                        return throwError(e);
                    }
                }
                catch (ClassNotFoundException e) {
                    return throwError(e);
                }

            }
        }
        return parameterStack;
    }

    private void getStack (String commandName, Stack<Command> parameterStack) {
    	return;
    }

    private Stack<Command> emptyStack (Stack<Command> commandStack) {
        while (!commandStack.empty()) {
            commandStack.pop();
        }
        return commandStack;
    }

    private Stack<Command> throwError (Exception e) {
        Stack<Command> error = new Stack<Command>();
        return error;
    }
}