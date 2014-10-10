package view;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main GUI class that instantiates the stage. It can instantiate multiple ViewPanels,
 * with each ViewPanel having its own Controller and Model.
 * 
 * @author Team 14
 */
public class UserInterface extends Application {
    
    private List<ViewPanel> myViews = new ArrayList<ViewPanel>();

    @Override
    public void start (Stage stage) {
        ViewPanel newView = new ViewPanel();
        myViews.add(newView);
    }
    
    /**
     * Main method to launch the application.
     * 
     * @param args : Standard arguments
     */
    public static void main(String[] args){
        launch(args);
    }
}