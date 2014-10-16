package controller;

import java.util.Stack;

import model.Model;
import view.ViewPane;
import commands.Command;


/**
 * Communicates between the View, the Parser, and the Model. The Controller accepts
 * a string from the ViewPanel, uses the Parser to parse it into a collection of
 * commands, and either returns an ErrorCommand to the ViewPanel (if an error is
 * detected) or runs the commands through the Model.
 * 
 * @author Team 14
 */
public class Controller {

    ViewPane myView;
    Model myModel;

    /**
     * Constructor method called from ViewPanel.java
     * 
     * @param view : The ViewPanel that called this constructor.
     * @param model : The Model constructed by said ViewPanel.
     */
    public Controller (ViewPane view) {
        myView = view;
        myModel = new Model(view);
    }

    /**
     * Accepts a string from the ViewPanel, parses it using a static parser in the
     * MasterController class, and searches the returned collection of commands for
     * errors. If an error is found, it is displayed in the view, and no commands
     * are executed. Otherwise, all commands are run in sequence.
     * 
     * @param input : User input string from the ViewPanel.
     */
    public void getInput(String input){
    	MasterController master = new MasterController("English");
        Stack<Command> commandsToExecute = master.myParser.parseInput(input);
        if(!commandsToExecute.isEmpty() && commandsToExecute.peek().getClassName().equals("commands.ErrorCommand")){
        	ErrorCommand error = (ErrorCommand)commandsToExecute.pop();
        	myView.showError(error.displayMessage());
        	return;
        }
        runCommand(commandsToExecute);
    }

    /**
     * Passes the commands to the Model to execute.
     * 
     * @param commandsToExecute : The commands to execute.
     */
    private void runCommand (Stack<Command> commandsToExecute) {
        myModel.updateModel(commandsToExecute);
    }
}
