package view;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Main Method for the SLogo Project
 *
 * @author Team 14
 *
 */
public class Main extends Application {
    @Override
    public void start (Stage stage) {
        UserInterface ui = new UserInterface(stage);
    }

    /**
     * Main method to launch the application.
     *
     * @param args : Standard arguments
     */
    public static void main (String[] args) {
        launch(args);
    }
}
