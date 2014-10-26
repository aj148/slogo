package view.panes;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Contains the Variables in the current simulation environment
 * 
 * @author Team 14
 *
 */
public class VariablesPane {
    private VBox myVBox = new VBox();

    public VariablesPane () {
        myVBox.getChildren().addAll(new Label("Variables"));
    }

    public VBox getVariables () {
        return myVBox;
    }
}
