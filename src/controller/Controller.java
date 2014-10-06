package controller;

import java.util.ArrayDeque;
import java.util.Collection;

import model.Model;
import view.ViewPanel;
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
    
    ViewPanel myView;
    Model myModel;
    
    /**
     * Constructor method called from ViewPanel.java
     * 
     * @param view : The ViewPanel that called this constructor.
     * @param model : The Model constructed by said ViewPanel.
     */
    public Controller(ViewPanel view, Model model){
        myView = view;
        myModel = model;
    }
    
    /**
     * Accepts a string from the ViewPanel, parses it using a static parser in the
     * MasterController class, and searches the returned collection of commands for
     * errors. If an error is found, it is displayed in the view, and no commands
     * are executed. Otherwise, all commands are run in sequence.
     * 
     * @param input : User input string from the ViewPanel.
     */
    @SuppressWarnings("static-access")
    public void getInput(String input){
        Collection<Command> commandsToExecute = new ArrayDeque<Command>();
        commandsToExecute.addAll(MasterController.myParser.parseInput(input));
        for(Command com : commandsToExecute){
            
            // This is hard-coded for now.
            boolean isErrorCommand = false;
            
            if(isErrorCommand){
                myView.showError(com);
                return;
            }
        }
        runCommand(commandsToExecute);
    }
    
    /**
     * Passes the commands to the Model to execute.
     * 
     * @param commandsToExecute : The commands to execute.
     */
    private void runCommand (Collection<Command> commandsToExecute) {
        myModel.updateModel(commandsToExecute);
    }
}