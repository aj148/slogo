package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


/**
 * Superclass for Pane. Panes are modules that can be added to the BorderPane in the UserInterface.
 * Subclasses of Pane will define additional functionality and behavior for the given pane module.
 * 
 * @author Team 14
 *
 */
public abstract class Pane {

    /**
     * Adds Pane to BorderPane.
     * 
     * @param p BorderPane for the Pane to be added to.
     * @return BorderPane with the Pane added.
     */
    public abstract BorderPane addPane (BorderPane p);
    

}
