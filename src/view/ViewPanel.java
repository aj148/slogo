package view;

import model.Model;
import commands.Command;
import controller.Controller;

/**
 * Displayed as a single tab in the GUI. Each ViewPanel has its own Controller and its own Model.
 * 
 * @author Team 14
 */
public class ViewPanel {
    
    private Controller myController;
    
    /**
     * Constructor method called from UserInterface.java
     */
    public ViewPanel(){
        myController = new Controller(this, new Model(this));
    }
    
    /**
     * This method should actually take a string typed into the view by the user.
     */
    @SuppressWarnings("unused")
    private void sendInput() {
        String input = "fd 50";
        myController.getInput(input);
    }
    
    /**
     * This method should display an error in the view based on the ErrorCommand.
     * 
     * @param error : An ErrorCommand containing the specifics error.
     */
    public void showError(Command error){
        
    }
    
    /**
     * This method should alter the view according to the commands that were just executed
     * in the backend (specifically in the model associated with this particular view).
     */
    public void updateView(){
        
    }
}