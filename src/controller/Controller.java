package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.Model;
import view.controllers.PaneController;
import view.panes.ViewPaneModule;
import commands.Command;
import commands.ErrorCommand;

/**
 * Communicates between the View, the Parser, and the Model. The Controller
 * accepts a string from the ViewPanel, uses the Parser to parse it into a
 * collection of commands, and either returns an ErrorCommand to the ViewPanel
 * (if an error is detected) or runs the commands through the Model.
 *
 * @author Team 14
 */
public class Controller {

    ViewPaneModule myView;
    Model myModel;
    private PaneController myPane;

    /**
     * Constructor method called from ViewPanel.java
     *
     * @param view : The ViewPanel that called this constructor.
     * @param model : The Model constructed by said ViewPanel.
     */
    public Controller (ViewPaneModule view, PaneController pane) {
        myView = view;
        myModel = new Model(view);
        myPane = pane;
    }

    /**
     * Accepts a string from the ViewPanel, parses it using a static parser in
     * the MasterController class, and searches the returned collection of
     * commands for errors. If an error is found, it is displayed in the view,
     * and no commands are executed. Otherwise, all commands are run in
     * sequence.
     *
     * @param input : User input string from the ViewPanel.
     */
    public void getInput (String input) {
        Stack<Command> commands = MasterController.myParser.parseInput(input);
        if(!commands.isEmpty() && commands.peek().getClassName().equals("commands.ErrorCommand")){
        	ErrorCommand error = (ErrorCommand)commands.pop();
            myPane.showError(error.showError());
        	return;
        }
        List<Command> commandsToExecute = new ArrayList<Command>();
        while(!commands.isEmpty()){
        	commandsToExecute.add(commands.pop());
        }
        runCommand(commandsToExecute);
    }

    /**
     * Passes the commands to the Model to execute.
     *
     * @param commandsToExecute : The commands to execute.
     */
    private void runCommand (List<Command> commandsToExecute) {
        myModel.updateModel(commandsToExecute);
    }
}
